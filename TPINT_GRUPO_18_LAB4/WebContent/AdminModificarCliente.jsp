<%@page import="entidad.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<!-- ACA HACEMOS EL INCLUDE DEL HEADER PARA AHORRARNOS ESPACIO -->
<%@ include file="componentes/head.jsp"  %>

<script>
    function confirmarModificacion() {
        return confirm("¿Estas seguro de que desea modificar el cliente?");
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
                        <h1 class="h3 mb-0 text-gray-800">Modificar un Cliente</h1>
                    </div>
                    <p>Seleccione un cliente y luego completes los campos a modificar</p>
                    
                    <form class="user" method="post" action="servletCliente">
                    
                     <input type = "submit" name="btnListarClientes2" value="Listar Clientes" class="btn btn-primary btn-user btn-block">
                     
                    </form> <hr>
                  <!-- TABLAAAAAAAAAA -->
				<%
				//arraylist para la tabla
				ArrayList<Cliente> lista = null;
				if( request.getAttribute("ListaCli") != null )
				{
					lista = (ArrayList<Cliente>) request.getAttribute("ListaCli");
				}
				
				//el dni:
				String dni = null;
				if(request.getAttribute("DniModificar") != null)
				{
					dni =(String)request.getAttribute("DniModificar");
				}
				
        		//el cliente
				Cliente c = null;
        		String CUIL = null;
        		String nombre = null;
        		String apellido = null;
        		String sexo = null;
        		String nacionalidad  = null;
        		String fecha = null;
        		String direccion = null;
        		String localidad = null;
        		String provincia = null;
        		String correo = null;
        		String telefono = null;
        		String nombreUsuario = null;
        		String clave = null;
				if(request.getAttribute("Cliente") != null)
				{
					c =(Cliente)request.getAttribute("Cliente");
					
					CUIL = c.getP().getCUIL();
					nombre = c.getP().getNombre();
					apellido = c.getP().getApellido();
					sexo = c.getP().getSexo();
					nacionalidad = c.getP().getNacionalidad();
					fecha = c.getP().getFechaNacimiento();
					direccion = c.getP().getDirección();
					localidad = c.getP().getLocalidad();
					provincia = c.getP().getProvincia();
					correo = c.getCorreo();
					telefono = c.getTeléfonos();
					nombreUsuario = c.getUsuario();
					clave = c.getContrasena();
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
                                            <th> <!-- aca va el boton modificar --> </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<% 	if(lista != null){ 
                                    		for(Cliente cliente : lista) { %>
                                        <tr>
                                        	<form action="servletCliente" method="get">
                                            <td><%= cliente.getP().getDNI() %> <input type="hidden" name="HiddenDniCliente2" value="<%= cliente.getP().getDNI() %>"></td> 
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
                                            <td><input type="submit" class="btn btn-primary btn-user btn-block" name="btnModificarCliente" value="Modificar"></td>
                                            </form>
                                        </tr>
                                        <% }  } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
        			</div>
				<!-- FINAL DE LA TABLAAAAAA -->
        
        			<p>Llene el formulario</p>
                    
                     <form class="user" action="servletCliente" method="get" onsubmit="return confirmarModificacion();">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="number" class="form-control form-control-user" id="DniCliente"  name="txtDniClienteModificar" placeholder="DNI del cliente a modificar: <%=dni%>" value="<%=dni%>" readonly>       
                                        <input type="hidden" name="HiddenDniCliente3" value="<%=dni%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="Localidad" name="txtLocalidadModificar" placeholder="<%=localidad%>">
                                        <input type="hidden" name="HiddenLocalidad" value="<%=localidad%>">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="number" class="form-control form-control-user" id="Cuil" name="txtCuilModificar" placeholder="<%=CUIL%>" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                        <input type="hidden" name="HiddenCUIL" value="<%=CUIL%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="Provincia"  name="txtProvinciaModificar" placeholder="<%=provincia%>">
                                        <input type="hidden" name="HiddenProvincia" value="<%=provincia%>">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Nombre" name="txtNombreModificar" placeholder="<%=nombre%>">
                                        <input type="hidden" name="HiddenNombre" value="<%=nombre%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="email" class="form-control form-control-user" id="Email" name="txtEmailModificar" placeholder="<%=correo%>">
                                        <input type="hidden" name="HiddenCorreo" value="<%=correo%>">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Apellido"  name="txtApellidoModificar" placeholder="<%=apellido%>">
                                        <input type="hidden" name="HiddenApellido" value="<%=apellido%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control form-control-user" id="Telefono"  name="txtTelefonoModificar" placeholder="<%=telefono%>" pattern="^\d+(.\d{1,2})?$" title="El saldo debe ser un numero positivo.">
                                        <input type="hidden" name="HiddenTelefono" value="<%=telefono%>">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Sexo"  name="txtSexoModificar" placeholder="<%=sexo%>">
                                        <input type="hidden" name="HiddenSexo" value="<%=sexo%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="NombreUsuarioModificar"  name="txtNombreUsuarioModificar" placeholder="<%=nombreUsuario%>" readonly>
                                        <input type="hidden" name="HiddenUsuario" value="<%=nombreUsuario%>">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Nacionalidad"  name="txtNacionalidadModificar" placeholder="<%=nacionalidad%>">
                                        <input type="hidden" name="HiddenNacionalidad" value="<%=nacionalidad%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="Contraseña"  name="txtClaveModificar" placeholder="<%=clave%>">
                                        <input type="hidden" name="HiddenClave" value="<%=clave%>">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user" id="FechaNacimiento"  name="txtFechaNacModificar" placeholder="<%=fecha%>">
                                        <input type="hidden" name="HiddenFecha" value="<%=fecha%>">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="RepetirContraseña"  name="txtRepetirClaveModificar" placeholder="<%=clave%>">
                                        <input type="hidden" name="HiddenRepetirClave" value="<%=clave%>">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="Direccion"  name="txtDireccionModificar" placeholder="<%=direccion%>">
                                    <input type="hidden" name="HiddenDireccion" value="<%=direccion%>">
                                </div>
                                <input type = "submit" name="btnAgregarClienteModificado" value="Modificar Cliente" class="btn btn-primary btn-user btn-block"><hr>
                            </form>
                            
                            <%
                            	//inicio de java para actualizar al cliente
                            	boolean filas = false;
                            	if(request.getAttribute("Filas") != null)
                            	{
                            		
                            		filas = (boolean)request.getAttribute("Filas");
                            		
                            	}
                            	
                            	if(filas == true)
                            	{
                            	%>
                            		<b>Cliente modificado con exito</b>
                                <%
                                }
                            
                            	//fin java para actualizar al cliente
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