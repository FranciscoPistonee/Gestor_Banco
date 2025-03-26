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
                        <h1 class="h3 mb-0 text-gray-800">Realizar una Transferencia</h1>
                    </div>
                    <p>Complete los campos</p><hr>
                    
                    <form class="user" action = "servletCuenta" method = "get">
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h5>Ingrese el CBU de su cuenta :</h5> 
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="number" class="form-control form-control-user" id="txtCbuTransferente" name="txtCbuTransferente" placeholder="CBU de su cuenta" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                     <h5>CBU de la cuenta a tranferir :</h5> 
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="number" class="form-control form-control-user" id="txtCbuReceptor" name="txtCbuReceptor" placeholder="CBU cuenta a transferir" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h5>Ingrese el monto de dinero para transferir :</h5> 
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="number" class="form-control form-control-user" id="txtMontoTransferir" name="txtMontoTransferir" placeholder="Monto a transferir" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="submit" class="btn btn-primary btn-user btn-block" id="btnTransferir" name="btnTransferir" value="Tranferir"> 
                                    </div>
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
     								%><%=mensaje %><%
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