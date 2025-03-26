<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<!-- ACA HACEMOS EL INCLUDE DEL HEADER PARA AHORRARNOS ESPACIO -->
<%@ include file="componentes/head.jsp"  %>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-3 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenido!</h1>
                                    </div>
                                    
                                    <form class="user" action="servletLogin" method="get">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" id="txtUsuario" name="txtUsuarioLogin" placeholder="Ingrese el nombre de usuario">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" id="txtClave" name="txtClaveLogin" placeholder="Ingrese la contraseña">
                                        </div>
                                        <input type="submit" class="btn btn-primary btn-user btn-block" name="btnLogin" value="Ingresar">
                                    </form>  
                                    <hr>   
                                    <%
                                    	String mensaje = "";
                                    	if(request.getAttribute("mensaje") != null)
                                    	{
                                    		mensaje = (String)request.getAttribute("mensaje");
                                    		out.print(mensaje);
                                    		
                                    	}
                                    %>
                                    <hr>
                                    
                                                         
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>