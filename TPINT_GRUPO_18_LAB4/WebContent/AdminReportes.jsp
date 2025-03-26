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
                        <h1 class="h3 mb-0 text-gray-800">Reportes</h1>
                    </div>
                    <hr>
                    <form class="user" action="servletReporte" method="get">
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h4>1) Calcular porcentaje de cuentas con un saldo mayor a  :</h4>
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="number" class="form-control form-control-user" id="txtSaldoCalcular" required name="txtSaldoCalcular" placeholder="Saldo" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="submit" class="btn btn-primary btn-user btn-block" id="btnReporteSaldo" name="btnReporteSaldo" value="Calcular">
                                    </div>
                                </div>
                            </form> 
                            <hr>
                            <%
                            	String porcentaje = null;
                            	if(request.getAttribute("porcentaje") != null)
                            	{
                            		porcentaje = (String)request.getAttribute("porcentaje");
                            	}
                            %>
                            <%
     							if(porcentaje != null)
     							{
     								%>El porcentaje de cuentas con un mayor saldo al ingresado es del: <%=porcentaje%>%<%
     							}
                            %>
                            <hr>
                            <form class="user" action="servletReporte" method="get">
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h4>2) Calcular saldo promedio de entre todas las cuentas de un cliente :</h4>
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="number" class="form-control form-control-user" id="txtDniReporte" required name="txtDniReporte" placeholder="Dni del cliente" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="submit" class="btn btn-primary btn-user btn-block" id="btnPromedioSaldo" name="btnPromedioSaldo" value="Calcular">
                                    </div>
                                </div>
                            </form>
                            <hr>
                            <%
                            	String promedio = null;
                            	if(request.getAttribute("promedio") != null)
                            	{
                            		promedio = (String)request.getAttribute("promedio");
                            	}
                            	
                            	String mensaje = null;
                            	if(request.getAttribute("mensaje") != null)
                            	{
                            		mensaje = (String)request.getAttribute("mensaje");
                            	}
                            %>
                            <%
     							if(promedio != null)
     							{
     								%>El promedio de saldo del cliente es de : $<%=promedio%><%
     							}
                            
                            	if(mensaje != null)
 								{
 									%><%=mensaje%><%
 								}
                            %>
                            <hr>
                            <form class="user" action="servletReporte" method="get">
                                <div class="form-group row">
                                    <div class="col-sm-4.7 mb-5 mb-sm-0">
                                    <h4>3) Calcular el promedio de cantidad de cuentas por cliente :</h4>
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="submit" class="btn btn-primary btn-user btn-block" id="btnPromedioSaldo" name="btnPromedioCuenta" value="Calcular Promedio">
                                    </div>
                                </div>
                            </form>
                            <hr>
                            <%
                            	String promedioCuentas = null;
                            	if(request.getAttribute("promedioCuentas") != null)
                            	{
                            		promedioCuentas = (String)request.getAttribute("promedioCuentas");
                            	}
                            %>
                            <%
     							if(promedioCuentas != null)
     							{
     								%>En promedio, un cliente tiene : <%=promedioCuentas%> cuentas.<%
     							}
                            %>
                            <hr>
                                
            <!-- End of Main Content -->
        </div>
            <!-- End of Main Content -->


        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

   <!-- HACEMOS EL INCLUDE DE LOS EXTRAS RESTANTES DE HTML PARA QUE FUNCIONE BIEN EL PROGRAMA -->
   <%@ include file="componentes/ExtrasHTML.jsp"  %>
</body>
</html>