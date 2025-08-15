<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/CRUD.css">
    <link rel="icon" href="Images/logo.png" type="image/png">
    <title>Administración de Empleados</title>
</head>
<header class="headerOpciones">
    <div class="bannerHorario">
        <span><i class="bx bx-time-five"></i>Lunes a Viernes: 8:00 – 17:30 – Sábado: 8:00 – 12:00</span>
        <div class="social">
            <a href="#"><i class="bx bxl-instagram"></i></a>
            <a href="#"><i class="bx bxl-facebook"></i></a>
            <a href="#"><i class="bx bxl-whatsapp"></i></a>
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
        </ul>
    </nav>
</header>

<main class="crud-main">
    <section class="top-container">
        <!-- Formulario -->
        <div class="formulario">
            <h2>Agregar / Modificar Empleado</h2>
            <form action="Controlador?menu=MecanicosAdmin" method="POST">

                <label for="codigoEmpleado">Código del Empleado</label>
                <input value="${empleado.codigoEmpleado}" min="0" type="number" name="txtCodigoEmpleado" placeholder="Ej: 101" required>

                <label for="nombreEmpleado">Nombre</label>
                <input value="${empleado.nombreEmpleado}" type="text" name="txtNombreEmpleado" placeholder="Ej: Luis Pérez" required>

                <label for="telefonoEmpleado">Teléfono</label>
                <input value="${empleado.telefonoEmpleado}" type="text" name="txtTelefonoEmpleado" placeholder="Ej: 12345678" required maxlength="8">

                <label for="correoEmpleado">Correo</label>
                <input value="${empleado.correoEmpleado}" type="email" name="txtCorreoEmpleado" placeholder="Ej: ejemplo@gmail.com" required>

                <label for="direccionEmpleado">Dirección</label>
                <input value="${empleado.direccion}" type="text" name="txtDireccionEmpleado" placeholder="Ej: Zona 1" required>

                <label for="puestoEmpleado">Puesto</label>
                <select name="txtPuestoEmpleado" required>
                    <option value="Recepcionista">Recepcionista</option>
                    <option value="Mecanico">Mecánico</option>
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
                            <td>${emp.codigoEmpleado}</td>
                            <td>${emp.nombreEmpleado}</td>
                            <td>${emp.telefonoEmpleado}</td>
                            <td>${emp.correoEmpleado}</td>
                            <td>${emp.direccion}</td>
                            <td>${emp.puesto}</td>
                            <td>
                                <form action="Controlador?menu=MecanicosAdmin" method="POST" style="display:inline;">
                                    <input type="hidden" name="txtCodigoEmpleado" value="${emp.codigoEmpleado}">
                                    <button name="accion" value="Editar" class="btn btn-primary btn-block btn-Actualizar">Editar</button>
                                </form>
                                <form action="Controlador?menu=MecanicosAdmin" method="POST" style="display:inline;">
                                    <input type="hidden" name="txtCodigoEmpleado" value="${emp.codigoEmpleado}">
                                    <button name="accion" value="Eliminar" class="btn btn-primary btn-block btn-drop">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <!-- Sección acciones -->
    <section class="acciones">
        <h2>Buscar y Eliminar Empleado</h2>
        <div class="acciones-inputs">
            <div>
                <label for="buscarEmpleado">Buscar Código de Empleado</label>
                <input type="text" id="buscarEmpleado" placeholder="Ej: 101">
                <button>Buscar</button>
            </div>
            <div>
                <label for="eliminarEmpleado">Eliminar Código de Empleado</label>
                <input type="text" id="eliminarEmpleado" placeholder="Ej: 101">
                <button>Eliminar</button>
            </div>
        </div>
    </section>
</main>

<body>
    <footer id="footer" style="padding: 20px; text-align:center;">
        <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
    </footer>
</body>
</html>
