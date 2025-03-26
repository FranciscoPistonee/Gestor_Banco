<%@page import="entidad.Cuenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<!-- ACA HACEMOS EL INCLUDE DEL HEADER PARA AHORRARNOS ESPACIO -->
<%@ include file="componentes/head.jsp"  %>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

       <!-- ACA HACEMOS EL INCLUDE DE LA SIDE BAR PARA AHORRARNOS ESPACIO -->
       <%@ include file="componentes/SideBarAdmin.jsp"  %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- ACA HACEMOS EL INCLUDE DE LA TOP BAR PARA AHORRARNOS ESPACIO -->
                <%@ include file="componentes/TopBar.jsp"  %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Listar Cuentas</h1>
                    </div>

					<form class="user" method="post" action="servletCuenta">
                    
                     <input type ="submit" name="btnListarCuentas" value="Listar Cuentas" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
                    
                  <!-- TABLAAAAAAAAAA -->
				<%
				ArrayList<Cuenta> lista = null;
				if( request.getAttribute("ListaCuentas") != null )
				{
					lista = (ArrayList<Cuenta>) request.getAttribute("ListaCuentas");
				}
				%>
				<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Cliente Asignado</th>   
                                            <th>Tipo Cuenta</th>
                                            <th>Fecha de Creacion</th>
                                            <th>Numero de Cuenta</th>
                                            <th>CBU</th>
                                            <th>Saldo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null){ for(Cuenta cuenta : lista) { %>
                                        <tr>
                                            <td><%= cuenta.getDniClienteAsignado() %></td> 
                                            <td><%= cuenta.getTipoCuenta() %></td>
                                            <td><%= cuenta.getFechaCreacion() %></td>
                                            <td><%= cuenta.getNumCuenta() %></td>
                                            <td><%= cuenta.getCBU() %></td>
                                            <td> $<%= cuenta.getSaldo() %></td>
                                        </tr>
                                        <% }  } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
        			</div>
				<!-- FINAL DE LA TABLAAAAAA -->
                                
            <!-- End of Main Content -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
    
    <!-- HACEMOS EL INCLUDE DE LOS EXTRAS RESTANTES DE HTML PARA QUE FUNCIONE BIEN EL PROGRAMA -->
   <%@ include file="componentes/ExtrasHTML.jsp"  %>
	
	    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>


</body>
</html>