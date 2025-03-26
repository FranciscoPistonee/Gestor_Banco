package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Persona;
import exceptions.FaltaArrobaException;
import exceptions.FaltaPuntoException;
import negocio.ClienteNegocio;
import negocio.CuentaNegocio;
import negocioImpl.ClienteNegocioImpl;
import negocioImpl.CuentaNegocioImpl;


@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//INICIO ALTA DE CLIENTE
				boolean filas = false;
				if(request.getParameter("btnAgregarCliente") != null) {

					//creamos un objeto cliente y le setteamos todo
					Cliente cliente = new Cliente();
					String mensaje = null;
					String DNI = request.getParameter("txtDniCliente");
					String CUIL = request.getParameter("txtCuil");			 
					String nombre = request.getParameter("txtNombre");	  	   	 
					String apellido = request.getParameter("txtApellido");	 
					String sexo = request.getParameter("txtSexo");			 
					String nacionalidad = request.getParameter("txtNacionalidad");	 
					String fechaNacimiento = request.getParameter("txtFechaNac");  
					String dirección = request.getParameter("txtDireccion"); 		 
					String localidad = request.getParameter("txtLocalidad");		 
					String provincia = request.getParameter("txtProvincia");	
					
					Persona p = new Persona(DNI, CUIL, nombre, apellido, sexo, nacionalidad, fechaNacimiento, dirección, localidad, provincia);
					cliente.setP(p);

					String correoValido = null;
					try 
					{
						String correo = request.getParameter("txtEmail");
						validarMail(correo);
						correoValido = correo;
					}
					catch(FaltaArrobaException e) 
					{
						e.printStackTrace();
						mensaje = "El correo electrónico debe contener una arroba (@).";
					    request.setAttribute("mensaje", mensaje);
					    RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCliente.jsp");
					    rd.forward(request, response);
					    return;
					}
					catch(FaltaPuntoException  e) 
					{
						e.printStackTrace();
						mensaje = "El correo electrónico debe contener un punto (.).";
					    request.setAttribute("mensaje", mensaje);
					    RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCliente.jsp");
					    rd.forward(request, response);
					    return; 
					}
					if(correoValido != null) 
					{
						cliente.setCorreo(correoValido);
					}
					
					cliente.setTeléfonos(request.getParameter("txtTelefono"));
					cliente.setUsuario(request.getParameter("txtNombreUsuario"));
					
					//REPETIR CLAVESSSSSSSSSSSSSS
					//------------------------------------------------------------------------------------------------------------------------
					String clave = request.getParameter("txtIngreso");
					String claveRepetir = request.getParameter("txtRepetirClave");

					// Verificar si ambos campos están vacíos
					if(clave != null && !clave.trim().isEmpty() && claveRepetir != null && !claveRepetir.trim().isEmpty()) {
					    
						// Si ambas claves fueron ingresadas, verificar que coincidan
					    if(clave.equals(claveRepetir)) 
					    {
					        cliente.setContrasena(clave);
					    } 
					    else 
					    {
					    	// Las claves no coinciden
					        mensaje = "Las claves deben coincidir";
					        request.setAttribute("mensaje", mensaje);
					        RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCliente.jsp");
					        rd.forward(request, response);
					        return;
					    }
					} 
					else
					{
						// Si una de las claves está vacía
					    mensaje = "Complete ambos campos de clave";
					    request.setAttribute("mensaje", mensaje);
					    RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCliente.jsp");
					    rd.forward(request, response);
					    return;
					}
					
					//FIN REPETIR CLAVESSSSSSSSSSSSSS
					//------------------------------------------------------------------------------------------------------------------------
					
					//Creamos un objte negocio y le mandamos el objeto cliente
					ClienteNegocio cNeg = new ClienteNegocioImpl();
					if(cNeg.existe(request.getParameter("txtDniCliente")) == false) 
					{
						filas = cNeg.agregar(cliente);
						request.setAttribute("cantFilas", filas);
						RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCliente.jsp");
						rd.forward(request, response);
					}
					if(cNeg.existe(request.getParameter("txtDniCliente")) == true) 
					{
						mensaje = "ya existe el cliente en la base de datos";
					}
					//redirigimos al .jsp
					request.setAttribute("mensaje", mensaje);
					RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCliente.jsp");
					rd.forward(request, response);
				}
				//FIN ALTA DE CLIENTE
				
				//------------------------------------------------------------------------------------------------------------------------
				
				//INICIO BAJA DE CLIENTE
				if(request.getParameter("btnEliminarCliente") != null) 
				{
					String dni = request.getParameter("HiddenDniCliente").toString();
					boolean seElimino = false;
					boolean seEliminoCuenta = false;
					
					ClienteNegocio cNeg3 = new ClienteNegocioImpl();
					CuentaNegocio cuNeg = new CuentaNegocioImpl();
					
					seEliminoCuenta = cuNeg.eliminarDni(dni);
					seElimino = cNeg3.eliminar(dni);
					if(seElimino == true) 
					{
						ArrayList<Cliente> lista3 = (ArrayList)cNeg3.leerTodos();
						
						request.setAttribute("ListaCli", lista3);
							
						RequestDispatcher rd = request.getRequestDispatcher("/AdminBajaCliente.jsp");
						rd.forward(request, response);
					}
				}
				//FIN BAJA DE CLIENTE
				
				//------------------------------------------------------------------------------------------------------------------------
				
				//INICIO MODIFICACION
				
				//agarrar el dni
				if(request.getParameter("btnModificarCliente") != null) 
				{
					String dniModificar = request.getParameter("HiddenDniCliente2").toString();
					ClienteNegocio cNeg = new ClienteNegocioImpl();
					Cliente c = new Cliente();
					c = cNeg.getByDni(dniModificar);
					
					request.setAttribute("Cliente", c);
					request.setAttribute("DniModificar", dniModificar);
					RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCliente.jsp");
					rd.forward(request, response);
				}
				
				//agregar el cliente modificado
				boolean filitas = false;
				if(request.getParameter("btnAgregarClienteModificado") != null) {

					//creamos un objeto cliente y le setteamos todo
					Cliente cliente = new Cliente();
					String mensaje = null;
					boolean existeUsuario = false; 
					String DNI= null;
					String CUIL= null;			 
					String nombre= null;  	   	 
					String apellido= null;	 	 
					String sexo= null;			 
					String nacionalidad= null;	 
					String fechaNacimiento= null;
					String dirección= null;	 
					String localidad= null;		 
					String provincia= null;

					String dni = request.getParameter("HiddenDniCliente3");
					System.out.println("DNI RECIBIDO: " + request.getParameter("HiddenDniCliente3"));
					
					if(request.getParameter("HiddenDniCliente3") != null) {DNI = (request.getParameter("HiddenDniCliente3"));}
					
					if(request.getParameter("txtLocalidadModificar") != null) {localidad =(request.getParameter("txtLocalidadModificar"));}
					if(request.getParameter("txtLocalidadModificar").trim().isEmpty()) 
					{
						localidad = (request.getParameter("HiddenLocalidad"));
					}
					
					if(request.getParameter("txtCuilModificar") != null) {CUIL = (request.getParameter("txtCuilModificar"));}
					if(request.getParameter("txtCuilModificar").trim().isEmpty()) 
					{
						CUIL = (request.getParameter("HiddenCUIL"));
					}
					
					if(request.getParameter("txtProvinciaModificar") != null) {provincia = (request.getParameter("txtProvinciaModificar"));} 
					if(request.getParameter("txtProvinciaModificar").trim().isEmpty()) 
					{
						provincia = (request.getParameter("HiddenProvincia"));
					}
						
					if(request.getParameter("txtNombreModificar") != null) {nombre = (request.getParameter("txtNombreModificar"));} 
					if(request.getParameter("txtNombreModificar").trim().isEmpty()) 
					{
						nombre = (request.getParameter("HiddenNombre"));
					}
						
					if(request.getParameter("txtEmailModificar") != null) {cliente.setCorreo(request.getParameter("txtEmailModificar"));}
					if(request.getParameter("txtEmailModificar").trim().isEmpty()) 
					{	
						cliente.setCorreo(request.getParameter("HiddenCorreo"));
					}
						
					if(request.getParameter("txtApellidoModificar") != null) {apellido = (request.getParameter("txtApellidoModificar"));} 
					if(request.getParameter("txtApellidoModificar").trim().isEmpty()) 
					{
						apellido = (request.getParameter("HiddenApellido"));
					}
						
					if(request.getParameter("txtTelefonoModificar") != null) {cliente.setTeléfonos(request.getParameter("txtTelefonoModificar"));} 
					if(request.getParameter("txtTelefonoModificar").trim().isEmpty()) 
					{
						cliente.setTeléfonos(request.getParameter("HiddenTelefono"));
					} 
						
					if(request.getParameter("txtSexoModificar") != null) {sexo = (request.getParameter("txtSexoModificar"));} 
					if(request.getParameter("txtSexoModificar").trim().isEmpty()) 
					{
						sexo = (request.getParameter("HiddenSexo"));
					} 
						
					if(request.getParameter("txtNombreUsuarioModificar") != null) {cliente.setUsuario(request.getParameter("txtNombreUsuarioModificar"));} 
					if(request.getParameter("txtNombreUsuarioModificar").trim().isEmpty()) 
					{
						cliente.setUsuario(request.getParameter("HiddenUsuario"));
					}
						
					if(request.getParameter("txtNacionalidadModificar") != null) {nacionalidad = (request.getParameter("txtNacionalidadModificar"));} 
					if(request.getParameter("txtNacionalidadModificar").trim().isEmpty()) 
					{
						nacionalidad = (request.getParameter("HiddenNacionalidad"));
					} 
						
					if(request.getParameter("txtFechaNacModificar") != null) {fechaNacimiento = (request.getParameter("txtFechaNacModificar"));} 
					if(request.getParameter("txtFechaNacModificar").trim().isEmpty()) 
					{
						fechaNacimiento = (request.getParameter("HiddenFecha"));
					} 
						
					if(request.getParameter("txtDireccionModificar") != null) {dirección = (request.getParameter("txtDireccionModificar"));} 
					if(request.getParameter("txtDireccionModificar").trim().isEmpty()) 
					{
						dirección = (request.getParameter("HiddenDireccion"));
					}
						
					String clave = request.getParameter("txtClaveModificar");
					String claveRepetir = request.getParameter("txtRepetirClaveModificar");
					String hiddenClave = request.getParameter("HiddenClave");

					// Verificar si ambos campos están vacíos
					if ((clave == null || clave.trim().isEmpty()) && (claveRepetir == null || claveRepetir.trim().isEmpty())) {
					    
						// Si ambas están vacías, usar la clave oculta
					    cliente.setContrasena(hiddenClave);
					} else if (clave != null && !clave.trim().isEmpty() && claveRepetir != null && !claveRepetir.trim().isEmpty()) {
					    
						// Si ambas claves fueron ingresadas, verificar que coincidan
					    if (clave.equals(claveRepetir)) {
					        cliente.setContrasena(clave);
					    } else {
					        
					    	// Las claves no coinciden
					        mensaje = "Las claves deben coincidir";
					        request.setAttribute("mensaje", mensaje);
					        RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCliente.jsp");
					        rd.forward(request, response);
					        return;
					    }
					} else {
					    
						// Si una de las claves está vacía
					    mensaje = "Complete ambos campos de clave";
					    request.setAttribute("mensaje", mensaje);
					    RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCliente.jsp");
					    rd.forward(request, response);
					    return;
					}
					
					Persona p = new Persona(DNI, CUIL, nombre, apellido, sexo, nacionalidad, fechaNacimiento, dirección, localidad, provincia);
					cliente.setP(p);

					//Creamos un objte negocio y le mandamos el objeto cliente
					ClienteNegocio cNeg = new ClienteNegocioImpl();
					
						existeUsuario = cNeg.existeUsuario(request.getParameter("txtNombreUsuarioModificar"));
						if(existeUsuario == false) 
						{
							filitas = cNeg.modificar(dni, cliente);
							request.setAttribute("Filas", filitas);
							RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCliente.jsp");
							rd.forward(request, response);
						}
						if(existeUsuario == true) 
						{
							mensaje = "ya existe ese usuario en la base de datos";
							request.setAttribute("mensaje", mensaje);
							RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCliente.jsp");
							rd.forward(request, response);
						}
					
				}
				//FIN MODIFICACION CLIENTE
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//INICIO LISTADO CLIENTES
		if(request.getParameter("btnListarClientes")!=null) 
		{
			//entra si apretamos el hyperlink para ver el listado de clientes
			ClienteNegocio cNeg = new ClienteNegocioImpl();
			ArrayList<Cliente> lista = (ArrayList)cNeg.leerTodos();
			
			request.setAttribute("ListaClientes", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AdminListarClientes.jsp");
			rd.forward(request, response);
			
		}
		//FIN LISTADO DE CLIENTES
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO LISTADO CLIENTE PARA MODIFICAR
		if(request.getParameter("btnListarClientes2")!=null) 
		{
			//entra si apretamos el hyperlink para ver el listado de clientes
			ClienteNegocio cNeg2 = new ClienteNegocioImpl();
			ArrayList<Cliente> lista2 = (ArrayList)cNeg2.leerTodos();
			
			request.setAttribute("ListaCli", lista2);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AdminModificarCliente.jsp");
			rd.forward(request, response);
			
		}
		//FIN LISTADO CLIENTES PARA MODIFICAR
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO LISTADO CLIENTE PARA ELIMINAR
		if(request.getParameter("btnListarClientes3")!=null) 
		{
			//entra si apretamos el hyperlink para ver el listado de clientes
			ClienteNegocio cNeg3 = new ClienteNegocioImpl();
			ArrayList<Cliente> lista3 = (ArrayList)cNeg3.leerTodos();
				
			request.setAttribute("ListaCli", lista3);
				
			RequestDispatcher rd = request.getRequestDispatcher("/AdminBajaCliente.jsp");
			rd.forward(request, response);
					
		}
		//FIN LISTADO CLIENTES PARA ELIMINAR
		
		//------------------------------------------------------------------------------------------------------------------------
		
		//INICIO LISTADO CLIENTE INFO PERSONAL
		if(request.getParameter("btnInfoPersonal")!=null) 
		{
			//entra si apretamos el hyperlink para ver el listado de clientes
			ClienteNegocio cNeg3 = new ClienteNegocioImpl();
			Cliente c = new Cliente();
			String usuario = request.getSession().getAttribute("nombreUsuario").toString();   
			
			c = cNeg3.get(usuario);
						
			request.setAttribute("Cliente", c);
			RequestDispatcher rd = request.getRequestDispatcher("/ClienteInfoPersonal.jsp");
			rd.forward(request, response);
							
		}
		//FIN LISTADO CLIENTES INFO PERSONAL
	}
	
	public static boolean validarMail(String mail) throws FaltaArrobaException, FaltaPuntoException
	{
		boolean auxArroba = false;
		boolean auxPunto = false;
		
		for(int i=0; i<mail.length(); i++) 
		{
			if(mail.charAt(i) == '@') 
			{
				auxArroba = true;
			}
			if(mail.charAt(i) == '.') 
			{
				auxPunto = true;
			}
		}
		if(auxArroba == false) 
		{
			FaltaArrobaException exc1 = new FaltaArrobaException();
			throw exc1;
		}
		if(auxPunto == false) 
		{
			FaltaPuntoException exc2 = new FaltaPuntoException();
			throw exc2;
		}
		
		if(auxArroba && auxPunto)
		   {
			   return true;
		   }
		   return false;
	}
}
