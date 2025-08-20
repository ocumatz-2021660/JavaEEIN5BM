<%-- 
    Document   : RepuestosAdmin
    Created on : 28 jul 2025, 14:04:39
    Author     : VictorHugo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="Styles/CRUD.css" />
        <link rel="icon" href="Images/logo.png" type="image/png">
        <title>CRUD de Repuestos</title>
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
                    <h2>Agregar / Modificar Repuestos</h2>
                    <form action="Controlador?menu=RepuestosAdmin" method="post"> 
                       
                        <input type="hidden" name="txtCodigoRepuesto" value="${repuesto.getCodigoRepuesto()}" />
                       
                        <label for="nombreRepuesto">Nombre Repuesto</label>
                        <input value="${repuesto.getNombreRepuesto()}" type="texto" name="txtNombreRepuesto" placeholder="Nombre del repuesto" required/>

                        <label for="descripcionRepuesto">Descripción</label>
                        <input value="${repuesto.getDescripcionRepuesto()}" type="texto" name="txtDescripcionRepuesto" placeholder="Descripción del repuesto" required/>

                        <label for="precioRepuesto">Precio</label>
                        <input value="${repuesto.getPrecioRepuesto()}" min="0"  type="number" name="txtPrecioRepuesto" placeholder="Precio del repuesto" required/>

                        <label for="stockRepuesto">Stock</label>
                        <input value="${repuesto.getStockRepuesto()}" min="0" type="number" name="txtStockRepuesto" placeholder="Cantidad en inventario" required/>

                        <label for="estadoRepuesto">Estado</label>
                        <select value="${repuesto.getEstadoRepuesto()}" name="txtEstadoRepuesto" required>
                            <option value="Disponibles">Disponibles</option>
                            <option value="Agotados">Agotados</option>
                        </select>

                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <!-- Tabla -->
                <div class="tabla-registros">
                    <h2>Repuestos Registrados</h2>
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
                            <c:forEach var="repuesto" items="${repuestos}">
                                <tr>
                                    <td>${repuesto.getCodigoRepuesto()}</td>
                                    <td>${repuesto.getNombreRepuesto()}</td>
                                    <td>${repuesto.getDescripcionRepuesto()}</td>
                                    <td>${repuesto.getPrecioRepuesto()}</td>
                                    <td>${repuesto.getStockRepuesto()}</td>
                                    <td>${repuesto.getEstadoRepuesto()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=RepuestosAdmin&accion=Editar&id=${repuesto.getCodigoRepuesto()}">Editar</a>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop"  href="Controlador?menu=RepuestosAdmin&accion=Eliminar&id=${repuesto.getCodigoRepuesto()}">Eliminar</a>
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