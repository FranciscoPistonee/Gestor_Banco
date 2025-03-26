<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Agregar un Cliente</h1>
                    </div>
                    <p>Llene el formulario</p>
                    
                     <form class="user" action="servletCliente" method="get">
                     
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="number" class="form-control form-control-user" id="DniCliente" required name="txtDniCliente" placeholder="Ingrese el DNI" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="Localidad" required name="txtLocalidad" placeholder="Ingrese la localidad">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="number" class="form-control form-control-user" id="Cuil" required name="txtCuil" placeholder="Ingrese el CUIL" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="Provincia" required name="txtProvincia" placeholder="Ingrese la provincia">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Nombre" required name="txtNombre" placeholder="Ingrese el nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="Email" required name="txtEmail" placeholder="Ingrese la dirección de correo electronico">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Apellido" required name="txtApellido" placeholder="Ingrese el apellido">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control form-control-user" id="Telefono" required name="txtTelefono" placeholder="Ingrese el telefono" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Sexo" required name="txtSexo" placeholder="Ingrese el sexo">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="NombreUsuario" required name="txtNombreUsuario" placeholder="Ingrese el nombre de usuario">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Nacionalidad" required name="txtNacionalidad" placeholder="Ingrese la Nacionalidad">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="Ingreso" required name="txtIngreso" placeholder="Ingrese la contraseña">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user" id="FechaNacimiento" required name="txtFechaNac" placeholder="Ingrese la Fecha de Nacimiento">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="RepetirClave" required name="txtRepetirClave" placeholder="Repita la contraseña">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="Direccion" required name="txtDireccion" placeholder="Ingrese la dirección">
                                </div>
                                   <input type = "submit" name="btnAgregarCliente" value="Agregar Cliente" class="btn btn-primary btn-user btn-block">
                            </form>
                            
                            <% 
                            	//INICIO DE JAVA, INGRESAR CLIENTE
                            	
                            	boolean filas = false;
                            	if(request.getAttribute("cantFilas")!= null)
                            	{
                            		//filas = Boolean.parseBoolean(request.getAttribute("cantFilas").toString());
                            		filas = (boolean)request.getAttribute("cantFilas");
                            	}
                            	
                            	if(filas == true)
                            	{
                            	%>
                            		<b>Cliente agregado con exito</b>
                                <%
                                }
                            %>
                            <%
                            	String mensaje = null;
                            	if(request.getAttribute("mensaje") != null)
                            	{
                            		mensaje = (String)request.getAttribute("mensaje");
                            	}
                            
                            	if(mensaje != null)
                          	 	{
                            		out.print(mensaje);
                            	}
                           	%>
                            
            <!-- End of Main Content -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->

   <!-- HACEMOS EL INCLUDE DE LOS EXTRAS RESTANTES DE HTML PARA QUE FUNCIONE BIEN EL PROGRAMA -->
   <%@ include file="componentes/ExtrasHTML.jsp"  %>

</body>
</html>