<%-- 
    Document   : AccesoriosAdmin
    Created on : 28/07/2025, 16:12:00
    Author     : joaqu
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
        <title>Administración de Accesorios</title>
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
                        <span>19 Calle 2‑47 Zona 3 Ciudad Guatemala</span>
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
                    <h2>Agregar / Modificar Accesorio</h2>
                    <form action="Controlador?menu=AccesoriosAdmin" method="POST">


                        <label for="nombreAccesorio">Nombre</label>
                        <input value="${accesorio.nombreAccesorio}" type="text" name="txtNombreAccesorio" placeholder="Ej: Gato hidráulico" required />

                        <label for="descripcionAccesorio">Descripción</label>
                        <input value="${accesorio.descripcionAccesorio}" type="text" name="txtDescripcionAccesorio" placeholder="Ej: Para levantar el auto" required />

                        <label for="precioAccesorio">Precio</label>
                        <input value="${accesorio.precioAccesorio}" min="0" type="number" name="txtPrecioAccesorio" placeholder="Ej: 450.00" step="0.01" required />

                        <label for="stockAccesorio">Stock</label>
                        <input value="${accesorio.stockAccesorio}" min="0" type="number" name="txtStockAccesorio" placeholder="Ej: 10" required />

                        <label for="estadoAccesorio">Estado</label>
                        <select id="estadoAccesorio" name="txtEstadoAccesorio" required>
                            <option value="Disponibles" ${accesorio.estadoAccesorio == 'Disponible' ? 'selected' : ''}>Disponibles</option>
                            <option value="Agotados" ${accesorio.estadoAccesorio == 'Agotados' ? 'selected' : ''}>Agotados</option>
                        </select>
                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>  
                        <button type="submit">Guardar</button>
                    </form>
                    <!-- Botón para ir al footer -->
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">
                        Ir al final
                    </button>
                </div>

                <!-- Tabla -->
                <div class="tabla-registros">
                    <h2>Accesorios Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="accesorio" items="${accesorios}">   
                                <tr>
                                    <td>${accesorio.codigoAccesorio}</td>
                                    <td>${accesorio.nombreAccesorio}</td>
                                    <td>${accesorio.descripcionAccesorio}</td>
                                    <td>${accesorio.precioAccesorio}</td>
                                    <td>${accesorio.stockAccesorio}</td>
                                    <td>${accesorio.estadoAccesorio}</td>
                                    <td>
                                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar">Editar</button>
                                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            <!-- Más registros aquí -->
                        </tbody>
                    </table>
                </div>
            </section>

            <!-- Sección inferior -->
            <section class="acciones">
                <h2>Buscar y Eliminar Accesorio</h2>
                <div class="acciones-inputs">
                    <div>
                        <label for="buscar-accesorio">Buscar Código</label>
                        <input type="text" id="buscar-accesorio" placeholder="Ej: 1" />
                        <button>Buscar</button>
                    </div>
                    <div>
                        <label for="eliminar-accesorio">Eliminar Código</label>
                        <input type="text" id="eliminar-accesorio" placeholder="Ej: 1" />
                        <button>Eliminar</button>
                    </div>
                </div>
            </section>
        </main>
        <!-- Footer para anclaje del scroll -->
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>

    </body>
</html>
