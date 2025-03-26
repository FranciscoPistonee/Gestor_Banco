<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="MenuCliente.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-solid fa-coins"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Gestión Bancaria</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="MenuCliente.jsp">
                    <i class="fas fa-solid fa-bars"></i>
                    <span>Menú</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">
            <!-- Heading -->
            <div class="sidebar-heading">
                Historial
            </div>
            <!-- Nav Item - Pages Collapse Menu -->
                        <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="ClienteHistorialCuenta.jsp">
                    <i class="fas fa-regular fa-clock"></i>
                    <span>Ver Historial de Cuentas</span>
                 </a>
            </li>


			<!-- Divider -->
            <hr class="sidebar-divider">
            <!-- Heading -->
			<div class="sidebar-heading">
                Prestamos
            </div>     
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="ClientePagoPrestamos.jsp">
                    <i class="fas fa-regular fa-credit-card"></i>
                    <span>Menú Pago Prestamos</span></a>
            </li>
            
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="ClienteSolicitarPrestamo.jsp">
                    <i class="fas fa-solid fa-dollar-sign"></i>
                    <span>Solicitar Prestamo</span></a>
            </li>
			
			<!-- Divider -->
            <hr class="sidebar-divider">
            <!-- Heading -->
			<div class="sidebar-heading">
                Transferencia
            </div>     
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="ClienteRealizarTransferencia.jsp">
                    <i class="fas fa-solid fa-comment-dollar"></i>
                    <span>Realizar una Transferencia</span></a>
            </li>
			
			<!-- Divider -->
            <hr class="sidebar-divider">
            <!-- Heading -->
			<div class="sidebar-heading">
                Info
            </div>     
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="ClienteInfoPersonal.jsp">
                    <i class="fas fa-solid fa-info"></i>
                    <span>Información Personal</span></a>
            </li>


        </ul>
        <!-- End of Sidebar -->
</html>