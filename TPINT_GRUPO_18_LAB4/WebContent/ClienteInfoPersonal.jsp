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
                        <h1 class="h3 mb-0 text-gray-800">Información Personal</h1>
                    </div>
              		<form class="user" method="post" action="servletCliente">
                    
                     <input type ="submit" name="btnInfoPersonal" value="Listar Info Personal" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
                    <!-- TABLAAAAAAAAAA -->
				<%
				Cliente c = null;
				if( request.getAttribute("Cliente") != null )
				{
					c = (Cliente)request.getAttribute("Cliente");
				}
				%>
				<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    	<% if(c != null){ %>
                                        <tr>
                                            <th> DNI: <%= c.getP().getDNI() %></th> 
                                        </tr>
                                        <tr>
                                            <th>CUIL: <%= c.getP().getCUIL() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Nombre: <%= c.getP().getNombre() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Apellido: <%= c.getP().getApellido() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Sexo: <%= c.getP().getSexo() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Nacionalidad: <%= c.getP().getNacionalidad() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Fecha de Nacimiento: <%= c.getP().getFechaNacimiento() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Direccion: <%= c.getP().getDirección() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Localidad: <%= c.getP().getLocalidad() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Provincia: <%= c.getP().getProvincia() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Correo: <%= c.getCorreo() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Telefono: <%= c.getTeléfonos() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Usuario: <%= c.getUsuario() %></th> 
                                        </tr>
                                        <tr>
                                            <th>Constraseña: <%= c.getContrasena() %></th> 
                                        </tr>
                                        <%} %>
                                    </thead>
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

</body>
</html></html>