<%@page import="entidad.Cliente"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Listar Clientes</h1>
                    </div>
                    
                    <form class="user" method="post" action="servletCliente">
                    
                     <input type ="submit" name="btnListarClientes" value="Listar Clientes" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
					
				<!-- TABLAAAAAAAAAA -->
				<%
				ArrayList<Cliente> lista = null;
				if( request.getAttribute("ListaClientes") != null )
				{
					lista = (ArrayList<Cliente>) request.getAttribute("ListaClientes");
				}
				%>
				<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>DNI</th>   
                                            <th>CUIL</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Sexo</th>
                                            <th>Nacionalidad</th>
                                            <th>Fecha de Nacimiento</th>
                                            <th>Direccion</th>
                                            <th>Localidad</th>
                                            <th>Provincia</th>
                                            <th>Correo Electronico</th>
                                            <th>Telefono</th>
                                            <th>Usuario</th>
                                            <th>Contrasena</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null){ for(Cliente cliente : lista) { %>
                                        <tr>
                                            <td><%= cliente.getP().getDNI() %></td> 
                                            <td><%= cliente.getP().getCUIL() %></td>
                                            <td><%= cliente.getP().getNombre() %></td>
                                            <td><%= cliente.getP().getApellido() %></td>
                                            <td><%= cliente.getP().getSexo() %></td>
                                            <td><%= cliente.getP().getNacionalidad() %></td>
                                            <td><%= cliente.getP().getFechaNacimiento() %></td>
                                            <td><%= cliente.getP().getDirección() %></td>
                                            <td><%= cliente.getP().getLocalidad() %></td>
                                            <td><%= cliente.getP().getProvincia() %></td>
                                            <td><%= cliente.getCorreo() %></td>
                                            <td><%= cliente.getTeléfonos() %></td>
                                            <td><%= cliente.getUsuario() %></td>
                                            <td><%= cliente.getContrasena() %></td>
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