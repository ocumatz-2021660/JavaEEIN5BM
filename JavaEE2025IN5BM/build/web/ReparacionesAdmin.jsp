<%-- 
    Document   : ReparacionesAdmin
    Created on : 28/07/2025, 18:04:59
    Author     : Xavier Portillo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css" />
        <link rel="icon" href="Images/logo.png" type="image/png">
        <title>Administración de Reparaciones</title>
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
                    <li><a href="MenuInicioAdmin.jsp">Menu Administrador</a></li>
                    <li><a href="Controlador?menu=OrdenReparacionAdmin&accion=Listar">Órdenes</a></li>
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Reparación</h2>
                    <form action="Controlador?menu=ReparacionesAdmin" method="POST">
                        <label>Nombre</label>
                        <input type="text" name="txtNombreReparacion" value="${rep.getNombreReparacion()}" placeholder="Nombre" required/>
                        <label>Descripción</label>
                        <input type="text" name="txtDescripcionReparacion" value="${rep.getDescripcionReparacion()}" placeholder="Descripción" required/>
                        <label>Precio</label>
                        <input type="text" name="txtPrecioReparacion" value="${rep.getPrecioReparacion()}" placeholder="Q0.00" required/>
                        <input type="hidden" name="txtCodigoReparacion" value="${rep.getCodigoReparacion()}">
                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <div class="tabla-registros">
                    <h2>Reparaciones Registradas</h2>
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
                            <c:forEach var="rep" items="${reparaciones}">
                                <tr>
                                    <td>${rep.getCodigoReparacion()}</td>
                                    <td>${rep.getNombreReparacion()}</td>
                                    <td>${rep.getDescripcionReparacion()}</td>
                                    <td>Q${rep.getPrecioReparacion()}</td>
                                    <td>   
                                        <a class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=ReparacionesAdmin&accion=Editar&codigoReparacion=${rep.getCodigoReparacion()}">Editar</a>
                                        <a class="btn btn-primary btn-block btn-drop" href="Controlador?menu=ReparacionesAdmin&accion=Eliminar&codigoReparacion=${rep.getCodigoReparacion()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>

            <section class="acciones">
                <h2>Buscar y Eliminar Reparación</h2>
                <div class="acciones-inputs">
                    <div>
                        <label for="buscar-reparacion">Buscar Código Reparación</label>
                        <input type="text" id="txtBuscar-reparacion" name="txtBuscarCodigo" placeholder="Ej: 101" />
                        <button class="btn btn-primary btn-block btn-agregar" onclick="location.href = 'Controlador?menu=ReparacionesAdmin&accion=Buscar&codigoReparacion=' + document.getElementById('txtBuscar-reparacion').value;">Buscar</button>
                    </div>
                    <div>
                        <label for="eliminar-reparacion">Eliminar Código Reparación</label>
                        <input type="text" id="txtEliminar-reparacion" name="txtEliminarCodigo" placeholder="Ej: 101" />
                        <button class="btn btn-primary btn-block btn-drop" onclick="location.href = 'Controlador?menu=ReparacionesAdmin&accion=Eliminar&codigoReparacion=' + document.getElementById('txtEliminar-reparacion').value;">Eliminar</button>
                    </div>
                </div>
            </section>

            <footer id="footer" style="padding: 20px; text-align:center;">
                <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
            </footer>
        </main>
    </body>
</html>
