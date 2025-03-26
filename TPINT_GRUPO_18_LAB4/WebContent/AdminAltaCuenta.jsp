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
                        <h1 class="h3 mb-0 text-gray-800">Agregar una Cuenta</h1>
                    </div>
                    <p>Llene el formulario</p>
                    
                    <form class="user" action="servletCuenta" method="get">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="DniClienteAsignado" required name="txtDniClienteAsignado" placeholder="Dni del cliente asignado">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="NumCuenta" required name="txtNumeroCuenta" placeholder="Numero de Cuenta">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="TipoCuenta" required name="txtTipoCuenta" placeholder="Tipo de Cuenta: Corriente o de Ahorro">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user" id="FechaCreacion" required name="txtFecha" placeholder="Fecha de creación">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control form-control-user" id="CBU" required name="txtCBU" placeholder="CBU" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                </div>
                                <input type = "submit" name="btnAgregarCuenta" value="Agregar Cuenta" class="btn btn-primary btn-user btn-block">
                            </form>
                            <hr>
                            
                            
                            <% 
                            	//INICIO DE JAVA, INGRESAR USUARIO
                            	
                            	boolean filas = false;
                            	if(request.getAttribute("cantFilas")!= null)
                            	{
                            		//filas = Boolean.parseBoolean(request.getAttribute("cantFilas").toString());
                            		filas = (boolean)request.getAttribute("cantFilas");
                            	}
                            	
                            	if(filas == true)
                            	{
                            	%>
                            		<b>Cuenta agregado con exito</b>
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
                            	<hr>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->



   <!-- HACEMOS EL INCLUDE DE LOS EXTRAS RESTANTES DE HTML PARA QUE FUNCIONE BIEN EL PROGRAMA -->
   <%@ include file="componentes/ExtrasHTML.jsp"  %>

</body>
</html>