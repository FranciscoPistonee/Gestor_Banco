package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReporteDao;
import daoImpl.ReporteDaoImpl;
import negocio.ClienteNegocio;
import negocioImpl.ClienteNegocioImpl;


@WebServlet("/servletReporte")
public class servletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletReporte() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnReporteSaldo") != null) 
		{
			ReporteDao rDao = new ReporteDaoImpl();
			
			float saldo = Float.parseFloat(request.getParameter("txtSaldoCalcular"));
			float porcentaje;
			
			int cuentas = rDao.contarCuenta();
			System.out.println("cantidad de cuentas encontrada" + cuentas);
			
			int cuentasSaldo = rDao.contarCuentaSaldo(saldo);
			System.out.println("cantidad de cuentas con mayor sueldo encontradas" + cuentasSaldo);
			
			porcentaje = ((float)cuentasSaldo / cuentas) * 100;
			System.out.println("porcentaje final: " + porcentaje);
			
			request.setAttribute("porcentaje", String.valueOf(porcentaje));
			RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnPromedioSaldo") != null) 
		{
			ReporteDao rDao = new ReporteDaoImpl();
			ClienteNegocio cNeg = new ClienteNegocioImpl();
			
			String dni = request.getParameter("txtDniReporte");
			float promedioFloat = 0;
			String promedio = null;
			String mensaje = null;
			
			if(cNeg.existe(dni) == true) 
			{
				float saldoTotal = rDao.sumarSaldoCliente(dni);
				int cuentas = rDao.contarCuentaCliente(dni);
				promedioFloat = ((float)saldoTotal/cuentas);
				promedio = String.valueOf(promedioFloat);
			}
			if(cNeg.existe(dni) == false) 
			{
				mensaje = "El dni ingresado no existe en la base de datos";
			}
			
			request.setAttribute("promedio", promedio);
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnPromedioCuenta") != null) 
		{
			ReporteDao rDao = new ReporteDaoImpl();
			
			int cuentaCliente = rDao.contarCliente();
			int cuentaCuentas = rDao.contarCuenta();
			float promedio2 = ((float)cuentaCuentas/cuentaCliente);
			System.out.println("promedio final servlet: " + promedio2);
			
			request.setAttribute("promedioCuentas", String.valueOf(promedio2));
			RequestDispatcher rd = request.getRequestDispatcher("/AdminReportes.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
