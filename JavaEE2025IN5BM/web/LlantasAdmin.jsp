import java.util.List;

<%-- 
    Document   : LlantasAdmin
    Created on : 25/07/2025, 17:03:58
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <header

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 class="headerOpciones">
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
                <h2>Agregar / Modificar Llanta</h2>
                  <form action="Controlador?menu=LlantasAdmin" method="POST">  
                    <label for="codigoLlanta">Código Llanta</label>
                     <input value="${Llanta.getCodigoLlanta}" min="0" type="number" name="txtCodigoLlanta" placeholder="Nombre de la Llanta" required/>

                    <label for="anchoMilimentos">Ancho (mm)</label>
                   <input value="${Llanta.getAnchoMilimetros}" min="0" type="number" name="txtAnchoLlanta" placeholder="Nombre de la Llanta" required/>

                    <label for="perfil">Perfil</label>
                  <input value="${Llanta.getPerfil}" min="0" type="number" name="txtPerfilLlanta" placeholder="Nombre de la Llanta" required/>

                    <label for="tipoConstruccion">Tipo Construcción</label>
                    <select value="${Llanta.getTipoConstruccion}" name="txtTipoConstruccion" required>
                        <option value="Radial">Radial</option>
                        <option value="Diagonal">Diagonal</option>
                        <option value="Cinturada">Cinturada</option>
                    </select>

                    <label for="diametroRin">Diámetro del Rin</label>
                    <input value="${Llanta.getDiametroRin}" min="0" type="number" name="txtDiametroRinLlanta" placeholder="Nombre de la Llanta" required/>

                    <label for="cargaMaximakg">Carga Máxima (kg)</label>
                    <input value="${Llanta.getCargaMaximakg}" min="0" type="number" name="txtCargaMaximaKgLlanta" placeholder="Nombre de la Llanta" required/>

                    <label for="precioLlanta">Precio de la Llanta</label>
                    <input value="${Llanta. getPrecioLlanta}" min="0" type="number" name="txtPrecioLlanta" placeholder="Nombre de la Llanta" required/>

                    <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                </form>
                  <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>   
            </div>

            <!-- Tabla -->
            <div class="tabla-registros">
                <h2>Llantas Registradas</h2>
                <table>
                    <thead>
                        <tr>
                            <th>codigoLlanta</th>
                            <th>anchoMilimentos</th>
                            <th>perfil</th>
                            <th>tipoConstruccion</th>
                            <th>diametroRin</th>
                            <th>cargaMaximakg</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                         <c:forEach var="Llanta" items="${Llanta}">
                        <tr>
                            <td>${Llanta.getCodigoLlanta}</td>
                            <td>${Llanta.getAnchoMilimetros}</td>
                            <td>${Llanta.getPerfil}}</td>
                            <td>${Llanta.getTipoConstruccion}</td>
                            <td>${Llanta.getDiametroRin}</td>
                            <td>${Llanta.getCargaMaximakg}</td>
                            <td>${Llanta. getPrecioLlanta}</td>
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
            <h2>Buscar y Eliminar Llanta</h2>
            <div class="acciones-inputs">
                <div>
                    <label for="buscarLlanta">Buscar No. Llanta</label>
                    <input type="text" id="buscarLlanta" placeholder="Ej: 1010" />
                    <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-agregar">Buscar</button>
                </div>
                <div>
                    <label for="eliminarLlanta">Eliminar No. Llanta</label>
                    <input type="text" id="eliminarLlanta" placeholder="Ej: 1010" />
                    <button>Eliminar</button>
                </div>
            </div>
        </section>
    </main>
    <footer id="footer" style="padding: 20px; text-align:center;">
        <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
    </footer>
</body>
</html>
