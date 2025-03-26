<%@page import="entidad.Movimiento"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Historial de cuentas</h1>
                    </div>
                    <p>ingrese el cbu de la cuenta a la cual se desea ver su historial</p> <hr>
                    
                     		<form class="user" action="servletMovimiento" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h4>Ingrese el cbu de la cuenta a listar movimientos:</h4>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="number" class="form-control form-control-user" id="txtCbuMovimientos" required name="txtCbuMovimientos" placeholder="CBU">
                                    </div>
                                	<div class="col-sm-4">
                                        <input type="submit" class="btn btn-primary btn-user btn-block" id="btnListarMovimientos" name="btnListarMovimientos" value="Listar Movimientos">
                                	</div>
                                </div>
                            </form>
                            
                            <!-- TABLAAAAAAAAAA -->
					<%
					ArrayList<Movimiento> lista = null;
					if( request.getAttribute("ListaMovimientos") != null )
					{
						lista = (ArrayList<Movimiento>) request.getAttribute("ListaMovimientos");
					}
					%>
					<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Fecha</th>   
                                            <th>Detalle</th> 
                                            <th>Importe</th>
                                            <th>Tipo de Movimiento</th>
                                            <th>CBU</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null){ for(Movimiento m : lista) { %>
                                        <tr>
                                        	<form action="servletPrestamo" method="get">
                                            <td><%= m.getFecha() %> </td> 
                                            <td><%= m.getDetalle() %> </td>
                                            <td><%= m.getImporte() %></td>
                                            <td><%= m.getTipoMovimiento().getDescripcion() %></td>
                                            <td><%= m.getCbu() %> </td>
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
                            
                            	//FIN JAVA, INGRESAR CLIENTE
                            	%>
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