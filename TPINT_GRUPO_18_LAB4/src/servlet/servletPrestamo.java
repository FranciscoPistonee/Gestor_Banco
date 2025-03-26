package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrestamoDao;
import daoImpl.PrestamoDaoImpl;
import entidad.Movimiento;
import entidad.Prestamo;
import entidad.TipoMovimiento;
import negocio.CuentaNegocio;
import negocio.MovimientoNegocio;
import negocio.PrestamoNegocio;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;


@WebServlet("/servletPrestamo")
public class servletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletPrestamo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnSolicitarPrestamo") != null) 
		{
			Prestamo p = new Prestamo();
			PrestamoNegocio pDao = new PrestamoNegocioImpl();
			String mensaje = "";
			
			//aca buscamos y asignamos la fecha actual.
			LocalDate fechaActual = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fecha = fechaActual.format(formatter);
			
			//asignamos los valores:
			String usuario = request.getSession().getAttribute("nombreUsuario").toString();      	
			String cbu = request.getParameter("txtCbuSolicitar");
			
			float mSolicitado = Float.parseFloat(request.getParameter("txtMontoSolicitar"));
			float mIntereses = (float) (mSolicitado * 1.1);
			
			String montoSolicitado = request.getParameter("txtMontoSolicitar");
			String montoIntereses = String.valueOf(mIntereses) ;
			String cuotasSeleccionadas = request.getParameter("cuotas");
			
			int cuotas = Integer.parseInt(cuotasSeleccionadas);
			float montoXcuota = (float)(mIntereses/cuotas);
		
			String montoCuota = String.valueOf(montoXcuota);
			String estado = "pendiente";
			
			//vemos si coinciden el cbu con el usuario
			if(pDao.coincideCbu(cbu, usuario) == true) 
			{
				String dni = pDao.buscarDni(usuario);
				p.setDniClienteAsignado(dni);
				p.setCbu(cbu);
				p.setImportePedido(montoSolicitado);
				p.setImporteConIntereses(montoIntereses);
				p.setCuotas(cuotasSeleccionadas);
				p.setFecha(fecha);
				p.setEstado(estado);
				p.setMontoXMes(montoCuota);
				
				boolean agrego = pDao.agregar(p);
				
				if(agrego == true)  { mensaje = "prestamo solicitado con exito"; }
				if(agrego == false) { mensaje = "no se pudo solicitar el prestamo"; }
			}
			if(pDao.coincideCbu(cbu, usuario) == false) 
			{ 
				mensaje = "el cbu no pertenece a una cuenta suya"; 
			}
			
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/ClienteSolicitarPrestamo.jsp");
			rd.forward(request, response);
			
		}
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		if(request.getParameter("btnAutorizar") != null) 
		{
			int id = Integer.parseInt(request.getParameter("HiddenIdPrestamo").toString());
			String cbu = request.getParameter("HiddenCbu").toString();
			float importe = Integer.parseInt(request.getParameter("HiddenImportePedido"));
			float saldoNuevo = 0;
			String autorizacion = "autorizado";
			PrestamoNegocio pDao = new PrestamoNegocioImpl();
			CuentaNegocio cNeg = new CuentaNegocioImpl();
			Prestamo p = new Prestamo();
			
			boolean seAutorizo = false;
			PrestamoNegocio pNeg = new PrestamoNegocioImpl();
			float saldo;
			
			Movimiento m = new Movimiento();
			MovimientoNegocio mNeg = new MovimientoNegocioImpl();
			
			seAutorizo = pNeg.Autorizar(autorizacion, id);
			if(seAutorizo == true) 
			{
				
				saldo = cNeg.buscarSaldo(cbu);
				saldoNuevo = saldo + importe;
				String newSaldo = String.valueOf(saldoNuevo); 
				
				cNeg.actualizarSaldo(newSaldo, cbu);
				p = pDao.get(id);
				
				int Cuotas = Integer.parseInt(p.getCuotas());
				for(int i = 1; i <= Cuotas; i++) 
				{
					//aca agregamos a la tabla cuotas las cuotas dependiendo de cuantas sean.
					boolean cuotas = pDao.agregarCuotas(p);
				}
				
				//AGREGAR EL MOVIMIENTO
				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String fecha = fechaActual.format(formatter);
				
				//movimiento negativo para quien transfiere
				m.setFecha(fecha);
				m.setDetalle("Alta Prestamo");
				m.setImporte(String.valueOf(importe));
				TipoMovimiento tm = new TipoMovimiento(1, "Ingreso");
				m.setTipoMovimiento(tm);
				m.setCbu(cbu);
				mNeg.agregar(m);
				
				ArrayList<Prestamo> listaPostAutorizar = (ArrayList)pNeg.leerTodos();
				request.setAttribute("ListaPrestamos", listaPostAutorizar);
				RequestDispatcher rd = request.getRequestDispatcher("/AdminAutorizacionPrestamo.jsp");
				rd.forward(request, response);
			}
		}
		
		if(request.getParameter("btnNoAutorizar") != null) 
		{
			int id = Integer.parseInt(request.getParameter("HiddenIdPrestamo").toString());
			String autorizacion = "rechazado";
			
			boolean seAutorizo = false;
			
			PrestamoNegocio pNeg = new PrestamoNegocioImpl();
			
			seAutorizo = pNeg.Autorizar(autorizacion, id);
			if(seAutorizo == true) 
			{
				
				ArrayList<Prestamo> listaPostAutorizar = (ArrayList)pNeg.leerTodos();
				request.setAttribute("ListaPrestamos", listaPostAutorizar);
				RequestDispatcher rd = request.getRequestDispatcher("/AdminAutorizacionPrestamo.jsp");
				rd.forward(request, response);
				
			}
		}
		
		//---------------------------------------------------------------------------------------------------------------------
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnListarPrestamos")!=null) 
		{
			//entra si apretamos el boton para ver el listado de cuentas
			PrestamoNegocio pNeg = new PrestamoNegocioImpl();
			ArrayList<Prestamo> lista = (ArrayList)pNeg.leerTodos();
					
			request.setAttribute("ListaPrestamos", lista);
					
			RequestDispatcher rd = request.getRequestDispatcher("/AdminAutorizacionPrestamo.jsp");
			rd.forward(request, response);
					
		}
		
	}

}
