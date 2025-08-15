<%-- 
    Document   : AutosAdmin
    Created on : 28/07/2025, 18:04:12
    Author     : Clara Lopez
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
        <title>Administración de Autos</title>
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
                <div class="formulario">
                    <h2>Agregar / Modificar Auto</h2>
                    <form action="Controlador?menu=AutosAdmin" method="POST">

                        <label for="codigoCliente">Código Cliente</label>
                        <input type="text" value="${auto.getCodigoCliente()}" min="0" name="txtCodigoCliente" placeholder="Ej: 1001" required/>

                        <label for="placa">Placa</label>
                        <input type="text" value="${auto.getPlaca()}" max="7" name="txtPlaca" placeholder="P123ABC" required/>

                        <label for="marca">Marca</label>
                        <input type="text" value="${auto.getMarca()}" name="txtMarca" placeholder="Toyota" required/>

                        <label for="modelo">Modelo</label>
                        <input type="text" value="${auto.getModelo()}" name="txtModelo" placeholder="Corolla 2022" required/>

                        <label for="color">Color</label>
                        <input type="text" value="${auto.getColor()}" name="txtColor" placeholder="Rojo" required/>

                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>
                <div class="tabla-registros">
                    <h2>Autos Registrados</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código Auto</th>
                                <th>Código Cliente</th>
                                <th>Placa</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Color</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="auto" items="${autos}">
                                <tr>
                                    <td>${auto.getCodigoAuto()}</td>
                                    <td>${auto.getCodigoCliente()}</td>
                                    <td>${auto.getPlaca()}</td>
                                    <td>${auto.getMarca()}</td>
                                    <td>${auto.getModelo()}</td>
                                    <td>${auto.getColor()}</td>
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
                <h2>Buscar y Eliminar Auto</h2>
                <div class="acciones-inputs">
                    <div>
                        <label for="buscar-auto">Buscar No. Auto</label>
                        <input type="text" id="buscar-auto" placeholder="Ej: 1010" />
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-agregar">Buscar</button>
                    </div>
                    <div>
                        <label for="eliminar-auto">Eliminar No. Auto</label>
                        <input type="text" id="eliminar-auto" placeholder="Ej: 1010" />
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop">Eliminar</button>
                    </div>
                </div>
            </section>
        </main>
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>

    </body>
</html>
