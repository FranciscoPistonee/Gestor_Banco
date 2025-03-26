<%@page import="entidad.Cuota"%>
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
       <%@ include file="componentes/SideBarCliente.jsp"  %>

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
                        <h1 class="h3 mb-0 text-gray-800">Menú Pago Prestamos</h1>
                    </div>
                    <p>Seleccione la cuota que quiere pagar</p>
                    <form class="user" method="post" action="servletCuota">
                    
                     <input type = "submit" name="btnListarCuotas" value="Listar Cuotas" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
                    
                     <!-- TABLAAAAAAAAAA -->
					<%
					ArrayList<Cuota> lista = null;
					if( request.getAttribute("ListaCuotas") != null )
					{
						lista = (ArrayList<Cuota>) request.getAttribute("ListaCuotas");
					}
					%>
					<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>ID PRESTAMO</th>  	
                                            <th>NOMBRE</th>   
                                            <th>APELLIDO</th> 
                                            <th>DNI</th>
                                            <th>CBU</th>
                                            <th>FECHA</th>
                                            <th>IMPORTE + INTERESES</th>
                                            <th>CUOTAS</th>
                                            <th>MONTO X CUOTA</th>
                                            <th>-ACCION-</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null){ for(Cuota c : lista) { %>
                                        <tr>
                                        	<form action="servletCuota" method="get">
                                            <td><%= c.getIdPrestamo() %> <input type="hidden" name="HiddenIdCuota" value="<%= c.getIdCuota() %>"></td> 
                                            <td><%= c.getNombreCliente() %></td>
                                            <td><%= c.getApellidoCliente() %></td>
                                            <td><%= c.getDniCliente() %></td>
                                            <td><%= c.getCbuCliente() %> <input type="hidden" name="HiddenCbu" value="<%= c.getCbuCliente() %>"></td>
                                            <td><%= c.getFecha() %></td>
                                            <td><%= c.getImporteIntereses() %></td>
                                            <td><%= c.getCuotas() %></td>
                                            <td><%= c.getMontoCuota() %> <input type="hidden" name="HiddenMontoCuota" value="<%= c.getMontoCuota() %>"></td>
                                            <td><input type="submit" class="btn btn-primary btn-user btn-block" name="btnPagarCuota" value="Pagar Cuota"></td>
                                            </form>
                                        </tr>
                                        <% }  } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
        			</div>
				<!-- FINAL DE LA TABLAAAAAA -->
				<hr>
				
				<%
					String mensaje = null;
					if(request.getAttribute("mensaje") != null)
					{
						mensaje = (String)request.getAttribute("mensaje");
					}
				%>
				<%
                    if(mensaje != null)
                    {
              	%>
                     	<%= mensaje %>
                <%
                    }
                %>
				
				<hr>
				
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