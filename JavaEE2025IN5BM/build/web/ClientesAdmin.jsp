<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css" />
        <link rel="icon" href="Images/logo.png" type="image/png">
        <title>Administración de Clientes</title>
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
            </ul>
        </nav>
    </header>
    <body>      
        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Cliente</h2>
                    <form action="Controlador?menu=ClientesAdmin" method="POST">
                        
                        <input type="hidden" value="${cliente.getCodigoCliente()}" name="txtCodigoCliente" />

                        <label for="nombreCliente">Nombre</label>
                        <input type="text" value="${cliente.getNombreCliente()}" name="txtNombreCliente" placeholder="Nombre completo" required/>

                        <label for="telefonoCliente">Teléfono</label>
                        <input type="text" value="${cliente.getTelefonoCliente()}" name="txtTelefonoCliente" placeholder="59677843" maxlength="8" required/>

                        <label for="correoCliente">Correo</label>
                        <input type="email" value="${cliente.getCorreoCliente()}" name="txtCorreoCliente" placeholder="cliente@correo.com" required/>

                        <label for="direccion">Dirección</label>
                        <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" placeholder="Dirección del cliente" required/>

                        <label for="contrasena">Contraseña</label>
                        <input type="text" value="${cliente.getContrasena()}" name="txtContrasena" placeholder="Contraseña del cliente" required/>

                        <label for="rol">Rol</label>
                        <input type="text" value="${cliente.getRol()}" name="txtRol" placeholder="Rol" required/>
                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <div class="tabla-registros">
                    <h2>Clientes Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Teléfono</th>
                                <th>Correo</th>
                                <th>Dirección</th>
                                <th>Contraseña</th>
                                <th>Rol</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.getCodigoCliente()}</td>
                                    <td>${cliente.getNombreCliente()}</td>
                                    <td>${cliente.getTelefonoCliente()}</td>
                                    <td>${cliente.getCorreoCliente()}</td>
                                    <td>${cliente.getDireccion()}</td>
                                    <td>${cliente.getContrasena()}</td>
                                    <td>${cliente.getRol()}</td>
                                    <td id="table-button">   
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=ClientesAdmin&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}" >Editar</a>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop" href="Controlador?menu=ClientesAdmin&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}">Eliminar</a>
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