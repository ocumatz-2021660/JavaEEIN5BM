
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css" />
        <link rel="icon" href="Images/logo.png" type="image/png">
        <title>Administración de Empleados</title>
    </head>
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
                    <span>+502 5967-7843</span>
                </div>
                <div class="infoItem">
                    <h4>E-MAIL</h4>
                    <span>lacajadecambios2025@gmail.com</span>
                </div>
                <div class="infoItem">
                    <h4>VISÍTANOS</h4>
                    <span>19 Calle 2-47 Zona 3 Ciudad Guatemala</span>
                </div>
            </div>
        </div>
        <nav class="bannerOpciones">
            <ul class="menu">
                <li><a href="MenuInicioAdmin.jsp">Menu Administrador</a></li>       
            </ul>
        </nav>
    </header>
    <body>      
        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Empleado</h2>
                    <form action="Controlador?menu=MecanicosAdmin" method="POST">

                        <label for="codigoEmpleado">Código del Empleado</label>
                        <input type="number" value="${empleado.getCodigoEmpleado()}" name="txtCodigoEmpleado" placeholder="Ej: 101" required/>

                        <label for="nombreEmpleado">Nombre</label>
                        <input type="text" value="${empleado.getNombreEmpleado()}" name="txtNombreEmpleado" placeholder="Ej: Luis Pérez" required/>

                        <label for="telefonoEmpleado">Teléfono</label>
                        <input type="text" value="${empleado.getTelefonoEmpleado()}" name="txtTelefonoEmpleado" placeholder="59677843" maxlength="8" required/>

                        <label for="correoEmpleado">Correo</label>
                        <input type="email" value="${empleado.getCorreoEmpleado()}" name="txtCorreoEmpleado" placeholder="empleado@correo.com" required/>

                        <label for="direccion">Dirección</label>
                        <input type="text" value="${empleado.getDireccion()}" name="txtDireccionEmpleado" placeholder="Ej: Zona 1" required/>

                        <label for="puestoEmpleado">Puesto</label>
                        <select name="txtPuestoEmpleado" required>
                            <option value="Recepcionista" ${empleado.getPuesto() == 'Recepcionista' ? 'selected' : ''}>Recepcionista</option>
                            <option value="Mecanico" ${empleado.getPuesto() == 'Mecanico' ? 'selected' : ''}>Mecánico</option>
                        </select>
                        

                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <!-- Tabla -->
                <div class="tabla-registros">
                    <h2>Empleados Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Correo</th>
                                <th>Dirección</th>
                                <th>Puesto</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="emp" items="${empleados}">
                                <tr>
                                    <td>${emp.getCodigoEmpleado()}</td>
                                    <td>${emp.getNombreEmpleado()}</td>
                                    <td>${emp.getTelefonoEmpleado()}</td>
                                    <td>${emp.getCorreoEmpleado()}</td>
                                    <td>${emp.getDireccion()}</td>
                                    <td>${emp.getPuesto()}</td>
                                    <td id="table-button">   
                                        <a class="btn btn-primary btn-Actualizar" href="Controlador?menu=MecanicosAdmin&accion=Editar&codigoEmpleado=${emp.getCodigoEmpleado()}">Editar</a>
                                        <a class="btn btn-primary btn-drop" href="Controlador?menu=MecanicosAdmin&accion=Eliminar&codigoEmpleado=${emp.getCodigoEmpleado()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>

            <section class="acciones">
                <h2>Buscar y Eliminar Empleado</h2>
                <div class="acciones-inputs">
                    <div>
                        <label for="buscarEmpleado">Buscar Código de Empleado</label>
                        <input type="text" id="txtBuscarEmpleado" placeholder="Ej: 101" />
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-agregar">Buscar</button>
                    </div>
                    <div>
                        <label for="eliminarEmpleado">Eliminar Código de Empleado</label>
                        <input type="text" id="txtEliminarEmpleado" placeholder="Ej: 101" />
                        <button name="accion" value="Eliminar" class="btn btn-primary btn-block btn-drop">Eliminar</button>
                    </div>
                </div>
            </section>
        </main>
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
