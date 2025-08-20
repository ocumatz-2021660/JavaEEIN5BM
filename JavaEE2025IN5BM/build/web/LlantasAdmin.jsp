<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.ArrayList" %>

<%-- 
    Document   : LlantasAdmin
    Created on : 25/07/2025, 17:03:58
    Author     : Usuario
--%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css" />
        <link rel="icon" href="Images/logo.png" type="Image/png">
        <title>CRUD Llanta</title>
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
                    <li><a href="MenuInicioAdmin.jsp">Inicio</a></li>
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <!-- Formulario -->
                <div class="formulario">
                    <h2>Agregar / Modificar Llanta</h2>
                    <form action="Controlador?menu=LlantasAdmin" method="POST">  
                        <input type="hidden" name="txtCodigoLlanta" value="${llanta.getCodigoLlanta()}" />                      

                        <label for="anchoMilimetros">Ancho (mm)</label>
                        <input value="${llanta.getAnchoMilimetros()}" min="0" type="number" name="txtAnchoLlanta" required/>

                        <label for="perfil">Perfil</label>
                        <input value="${llanta.getPerfil()}" min="0" type="number" name="txtPerfilLlanta" required/>

                        <label for="tipoConstruccion">Tipo Construcción</label>
                        <select value="${llanta.getTipoConstruccion()}" name="txtTipoConstruccion" required>
                            <option value="Radial" >Radial</option>
                            <option value="Diagonal" >Diagonal</option>
                            <option value="Cinturada">Cinturada</option>
                        </select>

                        <label for="diametroRin">Diámetro del Rin</label>
                        <input value="${llanta.getDiametroRin()}" min="0" type="number" name="txtDiametroRinLlanta" required/>

                        <label for="cargaMaximakg">Carga Máxima (kg)</label>
                        <input value="${llanta.getCargaMaximakg()}" min="0" type="number" name="txtCargaMaximaKgLlanta" required/>

                        <label for="precioLlanta">Precio de la Llanta</label>
                        <input step="0.01" value="${llanta.getPrecioLlanta()}" min="0" type="number" name="txtPrecioLlanta" required/>

                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>

                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>   
                </div>

                <!-- Tabla -->
                <div class="tabla-registros">
                    <h2>Llantas Registradas</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Ancho (mm)</th>
                                <th>Perfil</th>
                                <th>Tipo Construcción</th>
                                <th>Diámetro Rin</th>
                                <th>Carga Máxima (kg)</th>
                                <th>Precio</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="llanta" items="${llantas}">
                                <tr>
                                    <td>${llanta.getCodigoLlanta()}</td>
                                    <td>${llanta.getAnchoMilimetros()}</td>
                                    <td>${llanta.getPerfil()}</td>
                                    <td>${llanta.getTipoConstruccion()}</td>
                                    <td>${llanta.getDiametroRin()}</td>
                                    <td>${llanta.getCargaMaximakg()}</td>
                                    <td>${llanta.getPrecioLlanta()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=LlantasAdmin&accion=Editar&codigoLlanta=${llanta.getCodigoLlanta()}" >Editar</a>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop" href="Controlador?menu=LlantasAdmin&accion=Eliminar&codigoLlanta=${llanta.getCodigoLlanta()}">Eliminar</a>

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