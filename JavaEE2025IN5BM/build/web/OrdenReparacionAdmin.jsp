<%-- 
    Document   : OrdenesReparacionAdmin
    Created on : 28/07/2025
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
        <title>Administración de Órdenes de Reparación</title>
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
                    <li><a href="Controlador?menu=ReparacionesAdmin&accion=Listar">Reparaciones</a></li>
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Orden de Reparación</h2>
                    <form action="Controlador?menu=OrdenReparacionAdmin" method="POST">
                        <label>Código Auto</label>
                        <input type="number" name="txtCodigoAutoReparacion" value="${ord.getCodigoAutoReparacion()}" placeholder="Código Auto" required/>

                        <label>Código Cliente</label>
                        <input type="number" name="txtCodigoClienteReparacion" value="${ord.getCodigoClienteReparacion()}" placeholder="Código Cliente" required/>

                        <label>Código Empleado</label>
                        <input type="number" name="txtCodigoEmpleadoReparacion" value="${ord.getCodigoEmpleadoReparacion()}" placeholder="Código Empleado" required/>

                        <label>Código Reparación</label>
                        <input type="number" name="txtCodigoReparacion" value="${ord.getCodigoReparacion()}" placeholder="Código Reparación" required/>

                        <label>Fecha de Ingreso</label>
                        <input type="date" name="txtFechaIngresoReparacion" value="${ord.getFechaIngresoReparacion()}" required/>

                        <label>Estado</label>
                        <select name="txtEstadoReparacion" required>
                            <option value="Pendiente" ${ord.getEstadoReparacion() == 'Pendiente' ? 'selected' : ''}>Pendiente</option>
                            <option value="En Proceso" ${ord.getEstadoReparacion() == 'En Proceso' ? 'selected' : ''}>En Proceso</option>
                            <option value="Finalizado" ${ord.getEstadoReparacion() == 'Finalizado' ? 'selected' : ''}>Finalizado</option>
                        </select>

                        <input type="hidden" name="txtCodigoOrdenReparacion" value="${ord.getCodigoOrdenReparacion()}">

                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                </div>

                <div class="tabla-registros">
                    <h2>Órdenes Registradas</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Código Auto</th>
                                <th>Código Cliente</th>
                                <th>Código Empleado</th>
                                <th>Código Reparación</th>
                                <th>Fecha Ingreso</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ord" items="${ordenesReparacion}">
                                <tr>
                                    <td>${ord.getCodigoOrdenReparacion()}</td>
                                    <td>${ord.getCodigoAutoReparacion()}</td>
                                    <td>${ord.getCodigoClienteReparacion()}</td>
                                    <td>${ord.getCodigoEmpleadoReparacion()}</td>
                                    <td>${ord.getCodigoReparacion()}</td>
                                    <td>${ord.getFechaIngresoReparacion()}</td>
                                    <td>${ord.getEstadoReparacion()}</td>
                                    <td>
                                        <a class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=OrdenReparacionAdmin&accion=Editar&codigoOrdenReparacion=${ord.getCodigoOrdenReparacion()}">Editar</a>
                                        <a class="btn btn-primary btn-block btn-drop" href="Controlador?menu=OrdenReparacionAdmin&accion=Eliminar&codigoOrdenReparacion=${ord.getCodigoOrdenReparacion()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>

            <footer id="footer" style="padding: 20px; text-align:center;">
                <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
            </footer>
        </main>
    </body>
</html>

