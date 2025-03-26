package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Movimiento;
import negocio.CuentaNegocio;
import negocio.MovimientoNegocio;
import negocio.PrestamoNegocio;
import negocioImpl.CuentaNegocioImpl;
import negocioImpl.MovimientoNegocioImpl;
import negocioImpl.PrestamoNegocioImpl;

@WebServlet("/servletMovimiento")
public class servletMovimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletMovimiento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnListarMovimientos")!=null) 
		{
			//entra si apretamos el boton para ver el listado de cuentas
			MovimientoNegocio mNeg = new MovimientoNegocioImpl();
			CuentaNegocio cNeg = new CuentaNegocioImpl();
			String usuario = request.getSession().getAttribute("nombreUsuario").toString();
			System.out.println("USUARIO RECIBIDO: " + request.getSession().getAttribute("nombreUsuario").toString());
			String cbu = request.getParameter("txtCbuMovimientos");
			String mensaje = null;
			ArrayList<Movimiento> lista = null;
			
			if(cNeg.coincideCbu(cbu, usuario) == true) 
			{
				lista = (ArrayList) mNeg.leerCuotas(cbu);
			}
			if(cNeg.coincideCbu(cbu, usuario) == false) 
			{ 
				mensaje = "el cbu no pertenece a una cuenta suya"; 
			}
			
			request.setAttribute("ListaMovimientos", lista);
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/ClienteHistorialCuenta.jsp");
			rd.forward(request, response);	
		}
	}

}
