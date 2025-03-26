package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.AdminNegocio;
import negocio.ClienteNegocio;
import negocioImpl.AdminNegocioImpl;
import negocioImpl.ClienteNegocioImpl;


@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletLogin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//LOGIN
		if(request.getParameter("btnLogin") != null){
		
			AdminNegocio aNeg = new AdminNegocioImpl();
			ClienteNegocio cNeg = new ClienteNegocioImpl();
			boolean loginAdmin = false;
			boolean loginCliente = false;
		
			String usuario = request.getParameter("txtUsuarioLogin");
			String clave = request.getParameter("txtClaveLogin");
		
			loginAdmin = aNeg.existe(usuario, clave);
			loginCliente = cNeg.existeLogin(usuario, clave);
		
			if(loginAdmin == true) 
			{
				//creamos la variable de tipo session:
				request.getSession().setAttribute("nombreUsuario", usuario);
				
				//redirigimos al menu
				response.sendRedirect("MenuAdmin.jsp");
			}
			if(loginCliente == true) 
			{
				//creamos la variable de tipo session:
				request.getSession().setAttribute("nombreUsuario", usuario);
				
				//redirigimos al menuz
				response.sendRedirect("MenuCliente.jsp");
			}
		    if(loginAdmin == false && loginCliente == false)
			{
				String mensaje = "Usuario o Contraseña incorrectos :(";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
