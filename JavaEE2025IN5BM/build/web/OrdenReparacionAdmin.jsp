<%-- 
    Document   : OrdenesReparacionAdmin
    Created on : 28/07/2025
    Author     : Xavier Portillo 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css"/>
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
                    <li><a href="MenuInicioAdmin.jsp">Inicio</a></li>
                    <li><a href="Controlador?menu=ReparacionesAdmin&accion=Listar">Reparaciones</a></li>
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Orden de Reparación</h2>
                    <form action="Controlador?menu=OrdenReparacionAdmin" method="post">
                        <input type="hidden" name="menu" value="OrdenesReparacionAdmin"/>
                        <label>Código Auto</label>
                        <input type="text" name="txtCodigoAutoReparacion" value="${ord.codigoAutoReparacion}" placeholder="Ej: 101"/>
                        <label>Código Cliente</label>
                        <input type="text" name="txtCodigoClienteReparacion" value="${ord.codigoClienteReparacion}" placeholder="Ej: 101"/>
                        <label>Código Empleado</label>
                        <input type="text" name="txtCodigoEmpleadoReparacion" value="${ord.codigoEmpleadoReparacion}" placeholder="Ej: 101"/>
                        <label>Código Reparación</label>
                        <input type="text" name="txtCodigoReparacion" value="${ord.codigoReparacion}" placeholder="Ej: 101"/>
                        <label>Fecha Ingreso</label>
                        <input type="date" name="txtFechaIngresoReparacion" value="${ord.fechaIngresoReparacion}"/>
                        <label>Estado</label>
                        <select name="txtEstadoReparacion">
                            <option value="Pendiente" ${ord.estadoReparacion=='Pendiente'?'selected':''}>Pendiente</option>
                            <option value="En proceso" ${ord.estadoReparacion=='En proceso'?'selected':''}>En proceso</option>
                            <option value="Finalizado" ${ord.estadoReparacion=='Finalizado'?'selected':''}>Finalizado</option>
                        </select>
                        <div>
                            <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                            <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                        </div>
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
                                <th>Reparación</th>
                                <th>Fecha</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ord" items="${ordenesReparacion}">
                                <tr>
                                    <td>${ord.codigoOrdenReparacion}</td>
                                    <td>${ord.codigoAutoReparacion}</td>
                                    <td>${ord.codigoClienteReparacion}</td>
                                    <td>${ord.codigoEmpleadoReparacion}</td>
                                    <td>${ord.codigoReparacion}</td>
                                    <td>${ord.fechaIngresoReparacion}</td>
                                    <td>${ord.estadoReparacion}</td>
                                    <td>
                                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar">Editar</button>
                                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>

            <section class="acciones">
                <h2>Buscar y Eliminar Orden</h2>
                <div class="acciones-inputs">
                    <div>
                        <form action="Controlador?menu=OrdenReparacionAdmin&accion=Buscar" method="POST">
                            <label for="buscar-orden">Buscar Código Orden</label>
                            <input type="text" id="txtBuscar-orden" name="txtBuscarCodigo" placeholder="Ej: 101" />
                            <button type="submit" id="btnBuscar-orden">Buscar</button>
                        </form>
                    </div>
                    <div>
                        <form action="Controlador?menu=OrdenReparacionAdmin&accion=Eliminar" method="POST">
                            <label for="eliminar-orden">Eliminar Código Orden</label>
                            <input type="text" id="txtEliminar-orden" name="txtEliminarCodigo" placeholder="Ej: 101" />
                            <button type="submit" id="btnEliminar-orden">Eliminar</button>
                        </form>
                    </div>
                </div>
            </section>
        </main>
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>
    </body>
</html>