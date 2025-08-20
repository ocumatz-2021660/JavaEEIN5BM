
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
                <li><a href="MenuInicioAdmin.jsp">Menú Administrador</a></li>       
            </ul>
        </nav>
    </header>
    <body>      
        <main class="crud-main">
            <section class="top-container">
                <div class="formulario">
                    <h2>Agregar / Modificar Accesorio</h2>
                    <form action="Controlador?menu=AccesoriosAdmin" method="POST">

                        <label for="codigoAccesorio">Código del Accesorio</label>
                        <input type="number" value="${accesorio.getCodigoAccesorio()}" name="txtCodigoAccesorio" placeholder="Ej: 1" required/>

                        <label for="nombreAccesorio">Nombre</label>
                        <input type="text" value="${accesorio.getNombreAccesorio()}" name="txtNombreAccesorio" placeholder="Ej: Gato hidráulico" required/>

                        <label for="descripcionAccesorio">Descripción</label>
                        <input type="text" value="${accesorio.getDescripcionAccesorio()}" name="txtDescripcionAccesorio" placeholder="Ej: Para levantar el auto" required/>

                        <label for="precioAccesorio">Precio</label>
                        <input type="number" value="${accesorio.getPrecioAccesorio()}" min="0" step="0.01" name="txtPrecioAccesorio" placeholder="Ej: 450.00" required/>

                        <label for="stockAccesorio">Stock</label>
                        <input type="number" value="${accesorio.getStockAccesorio()}" min="0" name="txtStockAccesorio" placeholder="Ej: 10" required/>

                        <label for="estadoAccesorio">Estado</label>
                        <select name="txtEstadoAccesorio" required>
                            <option value="Disponibles" ${accesorio.getEstadoAccesorio() == 'Disponibles' ? 'selected' : ''}>Disponibles</option>
                            <option value="Agotados" ${accesorio.getEstadoAccesorio() == 'Agotados' ? 'selected' : ''}>Agotados</option>
                        </select>

                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
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
                            <c:forEach var="acc" items="${accesorios}">
                                <tr>
                                    <td>${acc.getCodigoAccesorio()}</td>
                                    <td>${acc.getNombreAccesorio()}</td>
                                    <td>${acc.getDescripcionAccesorio()}</td>
                                    <td>${acc.getPrecioAccesorio()}</td>
                                    <td>${acc.getStockAccesorio()}</td>
                                    <td>${acc.getEstadoAccesorio()}</td>
                                    <td>   
                                        <a class="btn btn-primary btn-Actualizar" href="Controlador?menu=AccesoriosAdmin&accion=Editar&codigoAccesorio=${acc.getCodigoAccesorio()}">Editar</a>
                                        <a class="btn btn-primary btn-drop" href="Controlador?menu=AccesoriosAdmin&accion=Eliminar&codigoAccesorio=${acc.getCodigoAccesorio()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>

            <section class="acciones">
                <h2>Buscar y Eliminar Accesorio</h2>
                <div class="acciones-inputs">
                    <div>
                        <label for="buscarAccesorio">Buscar Código de Accesorio</label>
                        <input type="text" id="txtBuscarAccesorio" placeholder="Ej: 1" />
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-agregar">Buscar</button>
                    </div>
                    <div>
                        <label for="eliminarAccesorio">Eliminar Código de Accesorio</label>
                        <input type="text" id="txtEliminarAccesorio" placeholder="Ej: 1" />
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