<%-- 
    Document   : ServicoAdmin
    Created on : 24/07/2025, 15:38:46
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css" />
        <title>CRUD Servicio</title>
    </head>
    <body>

        <header class="headerOpciones">
            <div class="bannerHorario">
                <span><i class='bx bx-time-five'></i> Lunes a Viernes: 8:00 – 17:30 – Sábado: 8:00 – 12:00</span>
                <div class="social">
                    <a href="#"><i class='bx bxl-instagram'></i></a>
                    <a href="#"><i class='bx bxl-facebook'></i></a>
                    <a href="#"><i class='bx bxl-whatsapp'></i></a>
                </div>
            </div>
            <div class="bannerInfo">
                <div class="logo">
                    <img src="Images/logo.png" alt="logo" class="logo-img">
                    <h1>La caja de cambios</h1>
                </div>
                <div class="infoGroup">
                    <div class="infoItem">
                        <h4>LLÁMANOS</h4>
                        <span>+502 5967‑7843</span>
                    </div>
                    <div class="infoItem">
                        <h4>E-MAIL</h4>
                        <span>lacajadecambios2025@gmail.com</span>
                    </div>
                    <div class="infoItem">
                        <h4>VISÍTANOS</h4>
                        <span>19 Calle 2‑47 Zona 3 Ciudad Guatemala</span>
                    </div>
                </div>
            </div>
            <nav class="bannerOpciones">
                <ul class="menu">
                    <li><a href="MenuInicioAdmin.jsp">Inicio</a></li>
                    <li><a href="Controlador?menu=DetalleServicioAdmin&accion=Listar">Detalle Servicios </a></li>                  
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <!-- Formulario -->
                <div class="formulario">
                    <h2>Agregar / Modificar Servicio</h2>
                    <form action="Controlador?menu=ServiciosAdmin" method="POST">

                        <input type="hidden" name="txtCodigoServicio" value="${servicio.getCodigoServicio()}" />
                        
                        <label for="nombreServicio">Nombre del Servicio</label>
                        <input value="${servicio.getNombreServicio()}" type="text" name="txtNombreServicio" placeholder="Ej: Cambio de aceite" required />

                        <label for="descripcionServicio">Descripción</label>
                        <input value="${servicio.getDescripcionServicio()}" type="text" name="txtDescripcionServicio" placeholder="Detalle del servicio" required/>

                        <label for="precioServicio">Precio</label>
                        <input value="${servicio.getPrecioServicio()}" min="0" type="number" name="txtPrecioServicio" placeholder="Ej: 150.00" required/>
                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>

                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <!-- Tabla -->
                <div class="tabla-registros">
                    <h2>Servicios Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Precio</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="servicio" items="${servicios}">
                                <tr>
                                    <td>${servicio.getCodigoServicio()}</td>
                                    <td>${servicio.getNombreServicio()}</td>
                                    <td>${servicio.getDescripcionServicio()}</td>
                                    <td>${servicio.getPrecioServicio()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=ServiciosAdmin&accion=Editar&codigoServicio=${servicio.getCodigoServicio()}">Editar</a>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop" href="Controlador?menu=ServiciosAdmin&accion=Eliminar&codigoServicio=${servicio.getCodigoServicio()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
                        
        </main>
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
