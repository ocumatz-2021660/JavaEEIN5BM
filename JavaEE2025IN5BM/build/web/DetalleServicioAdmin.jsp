<%-- 
    Document   : DetalleServicio
    Created on : 27/07/2025, 15:20:32
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css"/>
        <link rel="icon" href="Images/logo.png" type="image/png"/>
        <title>Administración Detalle Servicio</title>
    </head>
    <body>
        <header class="headerOpciones">
            <div class="bannerHorario">
                <span><i class="bx bx-time-five"></i> Lunes a Viernes: 8:00 - 17:30 | Sábado: 8:00 - 12:00</span>
                <div class="social">
                    <a href="#"><i class="bx bxl-instagram"></i></a>
                    <a href="#"><i class="bx bxl-facebook"></i></a>
                    <a href="#"><i class="bx bxl-whatsapp"></i></a>
                </div>
            </div>
            <div class="bannerInfo">
                <div class="logo">
                    <img src="Images/logo.png" alt="logo" class="logo-img">
                    <h1>La Caja de Cambios</h1>
                </div>
                <div class="infoGroup">
                    <div class="infoItem">
                        <h4>LLÁMANOS</h4>
                        <span>+502 5967-7843</span>
                    </div>
                    <div class="infoItem">
                        <h4>E-MAIL</h4>
                        <span>lacajadecambios2025</span>
                    </div>
                    <div class="infoItem">
                        <h4>VISÍTANOS</h4>
                        <span>19 calle 2-47 Zona 3 Ciudad Guatemala</span>
                    </div>
                </div>
            </div>
            <nav class="bannerOpciones">
                <ul class="menu">
                    <li><a href="MenuInicioAdmin.jsp">Inicio</a></li>
                    <li><a href="Controlador?menu=ServiciosAdmin&accion=Listar">Servicios </a></li>    
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Orden de Servicio</h2>
                    <form action="Controlador?menu=DetalleServicioAdmin" method="POST">
                        
                        <input type="hidden" name="txtCodigoOrdenServicio" value="${ordenServicio.getCodigoOrdenServicio()}" />
                        
                        <label for="codigoAuto">Código Auto</label>
                        <input value="${ordenServicio.getCodigoAuto()}" min="0" type="number" name="txtCodigoAuto" placeholder="Ej: 2001" required>

                        <label for="codigoCliente">Código Cliente</label>
                        <input value="${ordenServicio.getCodigoCliente()}" min="0" type="number" name="txtCodigoCliente" placeholder="Ej: 3001" required>

                        <label for="codigoEmpleado">Código Empleado</label>
                        <input value="${ordenServicio.getCodigoEmpleado()}" min="0" type="number" name="txtCodigoEmpleado" placeholder="Ej: 4001" required >

                        <label for="codigoServicio">Código Servicio</label>
                        <input value="${ordenServicio.getCodigoServicio()}" min="0" type="number" name="txtCodigoServicio" placeholder="Ej: 5001" required>

                        <label for="fechaIngreso">Fecha de Ingreso</label>
                        <input value="${ordenServicio.getFechaIngreso()}" type="text" name="txtFechaIngreso" placeholder="Ej: 2025-02-07" required>

                        <label for="estado">Estado</label>
                        <select value="${ordenServicio.getEstado()}" name="txtEstado" required>
                            <option value="Pendiente">Pendiente</option>
                            <option value="En proceso">EnProceso</option>
                            <option value="Finalizado">Finalizado</option>
                        </select>
                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                    <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <div class="tabla-registros">
                    <h2>Órdenes Registradas</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Auto</th>
                                <th>Cliente</th>
                                <th>Empleado</th>
                                <th>Servicio</th>
                                <th>Fecha</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ordenServicio" items="${ordenServicios}">
                                <tr>
                                    <td>${ordenServicio.getCodigoOrdenServicio()}</td>
                                    <td>${ordenServicio.getCodigoAuto()}</td>
                                    <td>${ordenServicio.getCodigoCliente()}</td>
                                    <td>${ordenServicio.getCodigoEmpleado()}</td>
                                    <td>${ordenServicio.getCodigoServicio()}</td>
                                    <td>${ordenServicio.getFechaIngreso()}</td>
                                    <td>${ordenServicio.getEstado()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=DetalleServicioAdmin&accion=Editar&codigoOrdenServicio=${ordenServicio.getCodigoOrdenServicio()}">Editar</a>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop" href="Controlador?menu=DetalleServicioAdmin=Eliminar&codigoOrdenServicio=${ordenServicio.getCodigoOrdenServicio()}">Eliminar</a>
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