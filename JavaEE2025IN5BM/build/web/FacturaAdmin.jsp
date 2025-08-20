<%-- 
    Document   : FacturaAdmin
    Created on : 23 jul 2025, 10:54:03
    Author     : informatica
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
        <title>CRUD Factura</title>
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
                    <li><a href="Controlador?menu=DetalleFacturaAdmin&accion=Listar">Detalle factura </a></li>                
                </ul>
            </nav>
        </header>

        <main class="crud-main">
            <section class="top-container">
                <!-- Formulario -->
                <div class="formulario">
                    <h2>Agregar / Modificar Factura</h2>
                    <form action="Controlador?menu=FacturaAdmin" method="POST">                        
                        <input type="hidden" name="txtCodigoFactura" value="${factura.getCodigoFactura()}" />
                        
                        <label for="codigoClienteFactura">Cliente</label>
                        <input value="${factura.getCodigoClienteFactura()}" min="0" type="number" name="txtCodigoClienteFactura" placeholder="Nombre del cliente" required/>

                        <label for="codigoEmpleadoFactura">Empleado</label>
                        <input value="${factura.getCodigoEmpleadoFactura()}" min="0" type="number" name="txtCodigoEmpleadoFactura" placeholder="Empleado a cargo" required/>

                        <label for="codigoAutoFactura">Automóvil</label>
                        <input value="${factura.getCodigoAutoFactura()}" min="0" type="number" name="txtCodigoAutoFactura" placeholder="Vehículo" required/>

                        <label for="fechaEmision">Fecha de emision</label>
                        <input value="${factura.getFechaEmision()}" type="texto" name="txtFechaEmision" placeholder="yyyy/mm/dd" required/>

                        <label for="metodoPago">Metodo de pago</label>
                        <select value="${factura.getMetodoPago()}" name="txtMetodoPago" required>
                            <option value="Efectivo">Effectivo</option>
                            <option value="Targeta">Targeta</option>
                        </select>
                        <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                        <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>
                    </form>
                    <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
                </div>

                <!-- Tabla -->
                <div class="tabla-registros">
                    <h2>Facturas Registradas</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>No.Factura</th>
                                <th>Cliente</th>
                                <th>Empleado</th>
                                <th>Auto</th>
                                <th>Fecha</th>
                                <th>Total</th>
                                <th>Metodo de Pago</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="factura" items="${facturas}">
                                <tr>
                                    <td>${factura.getCodigoFactura()}</td>
                                    <td>${factura.getCodigoClienteFactura()}</td>
                                    <td>${factura.getCodigoEmpleadoFactura()}</td>
                                    <td>${factura.getCodigoAutoFactura()}</td>
                                    <td>${factura.getFechaEmision()}</td>
                                    <td>${factura.getTotal()}</td>                                    
                                    <td>${factura.getMetodoPago()}</td>
                                    <td>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=FacturaAdmin&accion=Editar&codigoFactura=${factura.getCodigoFactura()}" >Editar</a>
                                        <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop" href="Controlador?menu=FacturaAdmin&accion=Eliminar&codigoFactura=${factura.getCodigoFactura()}">Elimina</a>
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
                <h2>Buscar y Eliminar Factura</h2>
                <div class="acciones-inputs">
                    <div>
                        <label for="buscar-factura">Buscar No. Factura</label>                        
                        <button name="accion" value="Buscar" class="btn btn-primary btn-block btn-agregar">Buscar</button>
                    </div>
                    <div>
                        <label for="eliminar-factura">Eliminar No. Factura</label>
                        <input type="text" id="eliminar-factura" placeholder="Ej: 1010" />
                        <button name="accion" value="Buscar" >Eliminar</button>
                    </div>
                </div>
            </section>
        </main>
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
