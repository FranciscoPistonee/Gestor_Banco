<%@page import="entidad.Prestamo"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Autorización de Prestamos</h1>
                    </div>
                    <p>Seleccione "Autorizar" o "No Autorizar" según desee</p>
                    <form class="user" method="post" action="servletPrestamo">
                    
                     <input type = "submit" name="btnListarPrestamos" value="Listar Prestamos" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
                    
                     <!-- TABLAAAAAAAAAA -->
					<%
					ArrayList<Prestamo> lista = null;
					if( request.getAttribute("ListaPrestamos") != null )
					{
						lista = (ArrayList<Prestamo>) request.getAttribute("ListaPrestamos");
					}
					%>
					<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>DNI Cliente</th>   
                                            <th>CBU</th> 
                                            <th>Fecha</th>
                                            <th>Importe mas intereses</th>
                                            <th>Importe solicitado</th>
                                            <th>Cuotas</th>
                                            <th>Monto por cuota</th>
                                            <th> <!-- aca va el boton autorizar --> </th>
                                            <th> <!-- aca va el boton no autorizar --> </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null){ for(Prestamo p : lista) { %>
                                        <tr>
                                        	<form action="servletPrestamo" method="get">
                                            <td><%= p.getDniClienteAsignado() %> <input type="hidden" name="HiddenIdPrestamo" value="<%= p.getIdPrestamo() %>"></td> 
                                            <td><%= p.getCbu() %> <input type="hidden" name="HiddenCbu" value="<%= p.getCbu() %>"></td>
                                            <td><%= p.getFecha() %></td>
                                            <td><%= p.getImporteConIntereses() %></td>
                                            <td><%= p.getImportePedido() %> <input type="hidden" name="HiddenImportePedido" value="<%= p.getImportePedido() %>"></td>
                                            <td><%= p.getCuotas() %></td>
                                            <td><%= p.getMontoXMes() %></td>
                                            <td><input type="submit" class="btn btn-primary btn-user btn-block" name="btnAutorizar" value="Autorizar"></td>
                                            <td><input type="submit" class="btn btn-primary btn-user btn-block" name="btnNoAutorizar" value="No Autorizar"></td>
                                            </form>
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
   
      <!-- EN ESTE CASO NO INCLUIMO EL INCLUDE DE EXTRAS YA QUE SINO NO FUNCIONA LOS FILTROS, BUSQUEDAS,ETC -->
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