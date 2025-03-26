<%@page import="entidad.Cuenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<!-- ACA HACEMOS EL INCLUDE DEL HEADER PARA AHORRARNOS ESPACIO -->
<%@ include file="componentes/head.jsp"  %>

<script>
    function confirmarModificacion() {
        return confirm("¿Estas seguro de que desea modificar la cuenta?");
    }
</script>

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
                        <h1 class="h3 mb-0 text-gray-800">Modificar una Cuenta</h1>
                    </div>
                    <p>Seleccione una cuenta y luego completes los campos a modificar</p>
                    
                    <form class="user" method="post" action="servletCuenta">
                    
                     <input type = "submit" name="btnListarCuentas3" value="Listar Cuentas" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
                    
                     <!-- TABLAAAAAAAAAA -->
				<%
				ArrayList<Cuenta> lista = null;
				if( request.getAttribute("ListaCuentas3") != null )
				{
					lista = (ArrayList<Cuenta>) request.getAttribute("ListaCuentas3");
				}
				
				//el cbu:
				String cbu = null;
				if(request.getAttribute("cbuModificar") != null)
				{
					cbu =(String)request.getAttribute("cbuModificar");
				}
				
				//la cuenta
				Cuenta c = null;
				String clienteAsignado = null;
				String fecha = null;
				String tipo = null; 
				String numCuenta = null;
				String saldo = null;
				if(request.getAttribute("Cuenta") != null)
				{
					c =(Cuenta)request.getAttribute("Cuenta");
					
					clienteAsignado = c.getDniClienteAsignado();
					fecha = c.getFechaCreacion();
					tipo = c.getTipoCuenta();
					numCuenta = c.getNumCuenta();
					saldo = c.getSaldo();

				}
				%>
				<div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Cliente Asignado</th>   
                                            <th>Tipo Cuenta</th>
                                            <th>Fecha de Creacion</th>
                                            <th>Numero de Cuenta</th>
                                            <th>CBU</th>
                                            <th>Saldo</th>
                                            <th> <!-- aca va el boton modificar --> </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null)
                                    		for(Cuenta cuenta : lista) { %>
                                        <tr>
                                        	<form action="servletCuenta" method="get">
                                            <td><%= cuenta.getDniClienteAsignado() %></td> 
                                            <td><%= cuenta.getTipoCuenta() %></td>
                                            <td><%= cuenta.getFechaCreacion() %></td>
                                            <td><%= cuenta.getNumCuenta() %> </td>
                                            <td><%= cuenta.getCBU() %> <input type="hidden" name="HiddenCBUCuenta2" value="<%= cuenta.getCBU() %>"> </td>
                                            <td><%= cuenta.getSaldo() %></td>
                                            <td><input type="submit" class="btn btn-primary btn-user btn-block" name="btnModificarCuenta" value="Modificar"></td>
                                            </form>
                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
        			</div>
				<!-- FINAL DE LA TABLAAAAAA -->
        
        <p>Llene el formulario</p>
                    
                    <form class="user" action="servletCuenta" method="get" onsubmit="return confirmarModificacion();">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="DniClienteAsignado"  name="txtDniClienteAsignadoModificar" placeholder="<%=clienteAsignado%>">
                                        <input type="hidden" name="HiddenClienteAsignado" value="<%=clienteAsignado%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="NumCuenta"  name="txtNumeroCuentaModificar" placeholder="<%=numCuenta%>">
                                        <input type="hidden" name="HiddenNumCuenta" value="<%=numCuenta%>>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="TipoCuenta"  name="txtTipoCuentaModificar" placeholder="<%=tipo%>">
                                    <input type="hidden" name="HiddenTipo" value="<%=tipo%>">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user" id="FechaCreacion"  name="txtFechaModificar" placeholder="<%=fecha%>">
                                        <input type="hidden" name="HiddenFecha" value="<%=fecha%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control form-control-user" id="CBU"  name="txtCBUModificar" placeholder="CBU del cliente a modificar: <%=cbu%>" value="<%=cbu%>" readonly >
                                        <input type="hidden" name="HiddenCBUCuenta3" value="<%=cbu%>">
                                    </div>
                                </div>
                                <input type = "submit" name="btnAgregarCuentaModificado" value="Modificar Cuenta" class="btn btn-primary btn-user btn-block"><hr>
                            </form>
                            
                            <%
                            	//inicio de java para actualizar la cuenta
                            	boolean filas = false;
                            	if(request.getAttribute("Filas") != null)
                            	{
                            		
                            		filas = (boolean)request.getAttribute("Filas");
                            		
                            	}
                            	if(filas == true)
                            	{
                            	%>
                            		<b>Cuenta modificada con exito</b>
                                <%
                                }
                            
                            	//fin de java para actualizar cuenta
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