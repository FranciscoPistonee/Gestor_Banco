<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
                        <h1 class="h3 mb-0 text-gray-800">Solicitar un Prestamo</h1>
                    </div>
                    <p>Los intereses de los prestamos son del 10%</p><hr>
                    
                             <form class="user" action="servletPrestamo" method="get">
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h4>Ingrese la cantidad de dinero a solicitar:  </h4>
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="number" class="form-control form-control-user" id="MontoSolicitar" name="txtMontoSolicitar" placeholder="Monto a solicitar">
                                    </div>
                                    <div class="col-sm-4.7">
                                    <h4>cbu de la cuenta:  </h4>
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="number" class="form-control form-control-user" id="CbuSolicitar" name="txtCbuSolicitar" placeholder="CBU de la cuenta que lo solicita">
                                    </div>
                                    <div class="col-sm-1">
                                        <select class="btn btn-primary dropdown-toggle" name="cuotas">
                                        <option value = "3" > 3 cuotas </option>
                                        <option value = "6" > 6 cuotas </option>
                                        <option value = "12"> 12 cuotas </option>
                                        <option value = "24"> 24 cuotas </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                        <input type="submit" class="btn btn-primary btn-user btn-block" id="btnSolicitarPrestamo" name="btnSolicitarPrestamo" value="Solicitar Prestamo">
                                </div>
                            </form>
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