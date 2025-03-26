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

import entidad.Cuota;
import entidad.Movimiento;
import entidad.TipoMovimiento;
import negocio.CuentaNegocio;
import negocio.CuotaNegocio;
import negocio.MovimientoNegocio;
import negocio.PrestamoNegocio;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.CuotaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;


@WebServlet("/servletCuota")
public class servletCuota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletCuota() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnPagarCuota") != null)
		{
			CuotaNegocio cNeg = new CuotaNegocioImpl();
			CuentaNegocio cuNeg = new CuentaNegocioImpl();
			PrestamoNegocio pNeg = new PrestamoNegocioImpl();
			Movimiento m = new Movimiento();
			MovimientoNegocio mNeg = new MovimientoNegocioImpl();
			
			String usuario = request.getSession().getAttribute("nombreUsuario").toString();
			System.out.println(request.getParameter("HiddenMontoCuota"));
			float montoCuota = Float.parseFloat(request.getParameter("HiddenMontoCuota"));
			System.out.println(montoCuota);
			int idCuota = Integer.parseInt(request.getParameter("HiddenIdCuota"));
			String cbu = request.getParameter("HiddenCbu");
			String dni = pNeg.buscarDni(usuario);
			String mensaje = null;
			float nuevoSaldo;
			float saldo;
			
			saldo = cuNeg.buscarSaldo(cbu);
			
			if(saldo >= montoCuota)
			{
				cNeg.eliminar(idCuota);
				nuevoSaldo = saldo - montoCuota;
				cuNeg.actualizarSaldo(String.valueOf(nuevoSaldo), cbu);
				mensaje = "Cuota pagada con exito";
				
				//AGREGAR EL MOVIMIENTO
				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String fecha = fechaActual.format(formatter);
				
				//movimiento negativo para quien transfiere
				m.setFecha(fecha);
				m.setDetalle("Pago Cuota");
				m.setImporte(String.valueOf(montoCuota));
				TipoMovimiento tm = new TipoMovimiento(2, "Egreso");
				m.setTipoMovimiento(tm);
				m.setCbu(cbu);
				mNeg.agregar(m);
			}
			if(montoCuota > saldo) 
			{
				mensaje = "Saldo insuficiente";
			}
			
			ArrayList<Cuota> lista = (ArrayList) cNeg.leerCuotas(dni);
			request.setAttribute("ListaCuotas", lista);
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/ClientePagoPrestamos.jsp");
			rd.forward(request, response);	
		}	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnListarCuotas")!=null) 
		{
			//entra si apretamos el boton para ver el listado de cuentas
			CuotaNegocio cNeg = new CuotaNegocioImpl();
			PrestamoNegocio pNeg = new PrestamoNegocioImpl();
			String usuario = request.getSession().getAttribute("nombreUsuario").toString();
			String dni = pNeg.buscarDni(usuario);
			
			ArrayList<Cuota> lista = (ArrayList) cNeg.leerCuotas(dni);
					
			request.setAttribute("ListaCuotas", lista);
					
			RequestDispatcher rd = request.getRequestDispatcher("/ClientePagoPrestamos.jsp");
			rd.forward(request, response);		
		}
		
	}

}
