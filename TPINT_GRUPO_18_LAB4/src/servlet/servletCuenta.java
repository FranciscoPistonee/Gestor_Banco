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

import entidad.Cuenta;
import entidad.Movimiento;
import entidad.TipoMovimiento;
import negocio.ClienteNegocio;
import negocio.CuentaNegocio;
import negocio.MovimientoNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;

@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletCuenta() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//INICIO ALTA DE CUENTA
		String saldo ="10000";
		boolean filas = false;
		if(request.getParameter("btnAgregarCuenta") != null) {
			
			//preguntamos si existe el cliente del cual se pide el dni
			Movimiento m = new Movimiento();
			MovimientoNegocio mNeg = new MovimientoNegocioImpl();
			ClienteNegocio cliNeg = new ClienteNegocioImpl();
			CuentaNegocio cuenNeg = new CuentaNegocioImpl();
			
			String dni = request.getParameter("txtDniClienteAsignado");
			boolean encontroDni = cliNeg.existe(dni);
			boolean masDe3 = cuenNeg.verificarCuentas(dni);
			String mensaje = null;
			
			if(encontroDni == true) 
			{
				if(masDe3 == false)
				{
					//creamos un objeto cuenta y le setteamos todo
					Cuenta cuenta = new Cuenta();
					cuenta.setDniClienteAsignado(request.getParameter("txtDniClienteAsignado"));
					cuenta.setNumCuenta(request.getParameter("txtNumeroCuenta"));
					cuenta.setTipoCuenta(request.getParameter("txtTipoCuenta"));
					cuenta.setFechaCreacion(request.getParameter("txtFecha"));
					cuenta.setCBU(request.getParameter("txtCBU"));
					cuenta.setSaldo(saldo);
					
					//Creamos un objte negocio y le mandamos el objeto cuenta
					CuentaNegocio cNeg = new CuentaNegocioImpl();
					boolean existeCbu = cNeg.existeCbu(request.getParameter("txtCBU"));
					if(existeCbu == false) 
					{
						filas = cNeg.agregar(cuenta);
					}
					if(existeCbu == true) 
					{
						mensaje = "El cbu ingresado ya existe en la base de datos";
					}
					
					//AGREGAR EL MOVIMIENTO
					LocalDate fechaActual = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String fecha = fechaActual.format(formatter);
					
					m.setFecha(fecha);
					m.setDetalle("Alta Cuenta");
					m.setImporte(saldo);
					TipoMovimiento tm = new TipoMovimiento(1, "Ingreso");
					m.setTipoMovimiento(tm);
					m.setCbu(request.getParameter("txtCBU"));
					mNeg.agregar(m);
					
					//redirigimos al .jsp
					request.setAttribute("cantFilas", filas);
					request.setAttribute("mensaje", mensaje);
					RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCuenta.jsp");
					rd.forward(request, response);
					
				}
				else 
				{
					mensaje = "El cliente ingresado ya posee 3 cuentas";
				}
			}
			else 
			{
				mensaje = "El cliente ingresado no existe";
			}
			
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCuenta.jsp");
			rd.forward(request, response);
			
		}
		//FIN ALTA DE CUENTA
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO BAJA DE CUENTA
		if(request.getParameter("btnEliminarCuenta") != null) 
		{
			String cbu = request.getParameter("HiddenCBUCuenta").toString();
			System.out.println("cbu RECIBIDO: " + request.getParameter("HiddenCBUCuenta"));
			boolean seElimino = false;
			
			CuentaNegocio cNeg3 = new CuentaNegocioImpl();
			
			seElimino = cNeg3.eliminar(cbu);
			if(seElimino == true) 
			{
				ArrayList<Cuenta> listaPostEliminar = (ArrayList)cNeg3.leerTodos();
				
				request.setAttribute("ListaCuentas2", listaPostEliminar);
					
				RequestDispatcher rd = request.getRequestDispatcher("/AdminBajaCuenta.jsp");
				rd.forward(request, response);
			}
		}
		//FIN BAJA DE CUENTA
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO MODIFICACION DE CUENTA
		
		//agarrar el CBU
		if(request.getParameter("btnModificarCuenta") != null) 
		{
			String cbuModificar = request.getParameter("HiddenCBUCuenta2").toString();
			CuentaNegocio cNeg = new CuentaNegocioImpl();
			Cuenta c = new Cuenta();
			c = cNeg.get(cbuModificar);
			
			request.setAttribute("Cuenta", c);
			request.setAttribute("cbuModificar", cbuModificar);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCuenta.jsp");
			rd.forward(request, response);
		}
		
		//agregar el cliente modificado
		boolean filitas = false;
		if(request.getParameter("btnAgregarCuentaModificado") != null) {
			
			//creamos un objeto cuenta y le setteamos todo
			ClienteNegocio cliNeg = new ClienteNegocioImpl();
			CuentaNegocio cuenNeg = new CuentaNegocioImpl();
			String mensaje = null;
			String dni = null;
			
			if(request.getParameter("txtDniClienteAsignadoModificar") != null)
			{
				dni = request.getParameter("txtDniClienteAsignadoModificar");
			}
			if(request.getParameter("txtDniClienteAsignadoModificar").trim().isEmpty())
			{
				dni = request.getParameter("HiddenClienteAsignado");
			}
			
			Cuenta cuenta = new Cuenta();
			boolean encontroDni = cliNeg.existe(dni);
			boolean masDe3 = cuenNeg.verificarCuentas(dni);
			
			if(encontroDni == true) 
			{
				if(masDe3 == false)
				{
					String cbu = request.getParameter("HiddenCBUCuenta3");	
					
					if(request.getParameter("txtDniClienteAsignadoModificar") != null) {cuenta.setDniClienteAsignado(request.getParameter("txtDniClienteAsignadoModificar"));}
					if(request.getParameter("txtDniClienteAsignadoModificar").trim().isEmpty()) 
					{
						cuenta.setDniClienteAsignado(request.getParameter("HiddenClienteAsignado"));
					}
					
					if(request.getParameter("txtFechaModificar") != null) {cuenta.setFechaCreacion(request.getParameter("txtFechaModificar"));}
					if(request.getParameter("txtFechaModificar").trim().isEmpty()) 
					{
						cuenta.setFechaCreacion(request.getParameter("HiddenFecha"));
					}

					if(request.getParameter("txtNumeroCuentaModificar") != null) {cuenta.setNumCuenta(request.getParameter("txtNumeroCuentaModificar"));}
					if(request.getParameter("txtNumeroCuentaModificar").trim().isEmpty()) 
					{
						cuenta.setNumCuenta(request.getParameter("HiddenNumCuenta"));
					}
					
					if(request.getParameter("txtTipoCuentaModificar") != null) {cuenta.setTipoCuenta(request.getParameter("txtTipoCuentaModificar"));}
					if(request.getParameter("txtTipoCuentaModificar").trim().isEmpty()) 
					{
						cuenta.setTipoCuenta(request.getParameter("HiddenTipo"));
					}

					//Creamos un objte negocio y le mandamos el objeto cliente
					CuentaNegocio cNeg = new CuentaNegocioImpl();
					filitas = cNeg.modificar(cbu, cuenta);
					
					//redirigimos al .jsp
					request.setAttribute("Filas", filitas);
					RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCuenta.jsp");
					rd.forward(request, response);
				}
				else 
				{
					mensaje = "El cliente ingresado ya posee 3 cuentas";
				}
			}
			else 
			{
				mensaje = "El cliente ingresado no existe";
			}
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCuenta.jsp");
			rd.forward(request, response);
		}
		
		//FIN MODIFICACION DE CUENTA
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO TRANSFERENCIA
		
		if(request.getParameter("btnTransferir") != null) 
		{
			CuentaNegocio cNeg = new CuentaNegocioImpl();
			Movimiento m = new Movimiento();
			MovimientoNegocio mNeg = new MovimientoNegocioImpl();
			
			float saldoActual;
			float saldoReceptor;
			float saldoNuevoT;
			float saldoNuevoR;
			String mensaje = "";
			String usuario = request.getSession().getAttribute("nombreUsuario").toString();      	
			String cbu = request.getParameter("txtCbuTransferente");
			String cbu2 = request.getParameter("txtCbuReceptor");
			
			System.out.println("MONTO A TRANSFERIR RECIBIDO: " + request.getParameter("txtMontoTransferir"));
			
			float mTransferir = Float.parseFloat(request.getParameter("txtMontoTransferir"));
			System.out.println("MONTO A TRANSFERIR (FLOAT): " + mTransferir);
		
			if(cNeg.coincideCbu(cbu, usuario) == true)
			{
				saldoActual = cNeg.buscarSaldo(cbu);
				if(cNeg.existeCbu(cbu2) == true) 
				{
					saldoReceptor = cNeg.buscarSaldo(cbu2);
					if(saldoActual >= mTransferir) 
					{
						saldoNuevoT = saldoActual - mTransferir;
						saldoNuevoR = saldoReceptor + mTransferir;
						
						cNeg.actualizarSaldo(String.valueOf(saldoNuevoT), cbu);
						cNeg.actualizarSaldo(String.valueOf(saldoNuevoR), cbu2);
						
						mensaje = "La transferencia fue realizada con exito";
						
						//AGREGAR EL MOVIMIENTO
						LocalDate fechaActual = LocalDate.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						String fecha = fechaActual.format(formatter);
						
						//movimiento negativo para quien transfiere
						m.setFecha(fecha);
						m.setDetalle("Transferencia");
						m.setImporte(String.valueOf(mTransferir));
						TipoMovimiento tm = new TipoMovimiento(2, "Egreso");
						m.setTipoMovimiento(tm);
						m.setCbu(cbu);
						mNeg.agregar(m);
						
						//movimiento positivo para quien recibe la transferencia
						m.setFecha(fecha);
						m.setDetalle("Transferencia");
						m.setImporte(String.valueOf(mTransferir));
						TipoMovimiento tm2 = new TipoMovimiento(1, "Ingreso");
						m.setTipoMovimiento(tm2);
						m.setCbu(cbu2);
						mNeg.agregar(m);
					}
					if(mTransferir > saldoActual) {mensaje = "saldo insuficiente para la transferencia";}
				}
				if(cNeg.existeCbu(cbu2) == false)  {mensaje = "el cbu de la cuenta a la cual se desea transferir no existe";}
			}
			if(cNeg.coincideCbu(cbu, usuario) == false) {mensaje = "el cbu ingresado no corresponde a una cuenta asignada a usted";}
			
			
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/ClienteRealizarTransferencia.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//INICIO LISTADO DE CUENTAS
		if(request.getParameter("btnListarCuentas")!=null) 
		{
			//entra si apretamos el boton para ver el listado de cuentas
			CuentaNegocio cNeg = new CuentaNegocioImpl();
			
			ArrayList<Cuenta> lista = (ArrayList)cNeg.leerTodos();
					
			request.setAttribute("ListaCuentas", lista);
					
			RequestDispatcher rd = request.getRequestDispatcher("/AdminListarCuentas.jsp");
			rd.forward(request, response);
					
		}
		//FIN LISTADO DE CUENTAS
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO LISTADO CUENTA PARA ELIMINAR
		if(request.getParameter("btnListarCuentas2")!=null) 
		{
			//entra si apretamos el hyperlink para ver el listado de cuentas
			CuentaNegocio cNeg2 = new CuentaNegocioImpl();
			ArrayList<Cuenta> lista2 = (ArrayList)cNeg2.leerTodos();
						
			request.setAttribute("ListaCuentas2", lista2);
						
			RequestDispatcher rd = request.getRequestDispatcher("/AdminBajaCuenta.jsp");
			rd.forward(request, response);
							
		}
		//FIN LISTADO CUENTA PARA ELIMINAR
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO LISTADO CUENTAS PARA MODIFICAR
		if(request.getParameter("btnListarCuentas3")!=null) 
		{
			//entra si apretamos el hyperlink para ver el listado de clientes
			CuentaNegocio cNeg3 = new CuentaNegocioImpl();
			ArrayList<Cuenta> lista3 = (ArrayList)cNeg3.leerTodos();
					
			request.setAttribute("ListaCuentas3", lista3);
					
			RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCuenta.jsp");
			rd.forward(request, response);
					
		}
		//FIN LISTADO CUENTAS PARA MODIFICAR
	
	}

}
