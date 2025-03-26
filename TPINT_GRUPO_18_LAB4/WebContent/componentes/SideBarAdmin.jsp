<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="MenuAdmin.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-solid fa-coins"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Gestión Bancaria</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="MenuAdmin.jsp">
                    <i class="fas fa-solid fa-bars"></i>
                    <span>Menú</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                ABML
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-regular fa-user"></i>
                    <span>Cuentas</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">opciones:</h6>
                        <a class="collapse-item" href="AdminAltaCuenta.jsp">Agregar Cuenta</a>
                        <a class="collapse-item" href="AdminBajaCuenta.jsp">Eliminar Cuenta</a>
                        <a class="collapse-item" href="AdminModificarCuenta.jsp">Modificar Cuenta</a>
                        <a class="collapse-item" href="AdminListarCuentas.jsp">Listar Cuentas</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-solid fa-id-card"></i>
                    <span>Clientes</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">opciones:</h6>
                        <a class="collapse-item" href="AdminAltaCliente.jsp">Agregar Cliente</a>
                        <a class="collapse-item" href="AdminBajaCliente.jsp">Eliminar Cliente</a>
                        <a class="collapse-item" href="AdminModificarCliente.jsp">Modificar Cliente</a>
                        <a class="collapse-item" href="AdminListarClientes.jsp">Listar Clientes</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Prestamos
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
                        <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="AdminAutorizacionPrestamo.jsp">
                    <i class="fas fa-solid fa-money-bill "></i>
                    <span>Autorización Prestamos</span></a>
            </li>


			<!-- Divider -->
            <hr class="sidebar-divider">
            
            <!-- Heading -->
			<div class="sidebar-heading">
                Reportes
            </div>     
            
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="AdminReportes.jsp">
                    <i class="fas fa-regular fa-folder-open"></i>
                    <span>Reportes</span></a>
            </li>

        </ul>
        <!-- End of Sidebar -->
</html>