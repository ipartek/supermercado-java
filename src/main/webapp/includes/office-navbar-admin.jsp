 		<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="views/frontoffice/inicio">Mi Panel</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>          
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item">
                      <a class="dropdown-item text-white" href="logout">Cerrar Sesión</a>                 
                </li>
            </ul>
        </nav>
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            
                            <a class="nav-link" href="inicio">
                                <div class="sb-nav-link-icon"><i class="fa fa-globe"></i></div>
                                Inicio
                            </a>
                            <a class="nav-link" href="views/backoffice/inicio">
                                <div class="sb-nav-link-icon"><i class="fa fa-tachometer-alt"></i></div>
                                Mi Panel
                            </a>
                            <a class="nav-link" href="views/backoffice/productos">
                                <div class="sb-nav-link-icon"><i class="fa fa-check-square-o"></i></div>
                                Productos
                            </a>
                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fa fa-check-circle-o"></i></div>
                                Usuarios
                            </a>
                            <a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fa fa-plus-circle"></i></div>
                                Categorias
                            </a>
                             <a class="nav-link" href="views/backoffice/migracion">
                                <div class="sb-nav-link-icon"><i class="fa fa-plus-circle"></i></div>
                                Lanzar Proceso Migración
                            </a>
                             <a class="nav-link" href="views/backoffice/parsear">
                                <div class="sb-nav-link-icon"><i class="fa fa-plus-circle"></i></div>
                                Parsear Web
                            </a>
                         </div>   
                    </div>       
                </nav>
            </div>
            
            
            <!-- CONTENIDO PRINCIPAL -->
             <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid pt-3">
                    
                    
                    	<%@ include file="alerta.jsp" %>
				    
                    
            