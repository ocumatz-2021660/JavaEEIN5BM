<%-- 
    Document   : DetalleFacturaAdmin
    Created on : 24/07/2025, 18:38:25
    Author     : Clara Lopez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/CRUD.css">
        <link rel="icon" href="Images/logo.png" type="Image/png">
        <title>Administracion Detalle Factura</title>
    </head>
    <header class="headerOpciones">
        <div class="bannerHorario">
            <span><i class="bx bx-time-five"></i>Lunes a Viernes: 8:00 -
                17:30 - Sabado: 8:00 - 12:00</span>
            <div class="social">
                <a href="#"><i class="bx bxl-instagram"></i></a>
                <a href="#"><i class="bx bxl-facebook"></i></a>
                <a href="#"><i class="bx bxl-whatsapp"></i></a>
            </div>
        </div>
        <div class="bannerInfo">
            <div class="logo">
                <img src="Images/logo.png" alt="logo" class="logo-img">
                <h1>La caja de cambiso</h1>                
            </div>
            <div class="infoGroup">
                <div class="infoItem">
                    <h4>LLAMANOS</h4>
                    <span>+502 5967-7843</span>
                </div>
                <div class="infoItem">
                    <h4>E-MAIL</h4>
                    <span>lacajadecambios2025</span>
                </div>
                <div class="infoItem">
                    <h4>VISITANOS</h4>
                    <span>19 calle 2-47 Zona 3 Cieudad Guatemala</span>
                </div>
            </div>
        </div>
        <nav class="bannerOpciones">
            <ul class="menu">
                <li><a href="MenuInicioAdmin.jsp">Inicio</a></li>
                <li><a href="Controlador?menu=FacturaAdmin&accion=Listar">Facturas</a></li>
            </ul>
        </nav>
    </header>
    <main class="crud-main">
        <section class="top-container">
            <div class="formulario">
                <h2>Agregar / Modificar Detalles de facturas</h2>
                <form action="Controlador?menu=DetalleFacturaAdmin" method="POST"> 
                    <input type="hidden" name="txtCodigoDetalle" value="${detalleFactura.getCodigoDetalle()}" />
                        
                    <label for="codigoFacturaDetalle">No.Factura</label>
                    <input value="${detalleFactura.getCodigoFactura()}"min="0" type="number" name="txtCodigoFacturaDetalle" placeholder="Ej: 1010" required>

                    <label for="tipoGasto">Tipo de gasto</label>
                    <select value="${detalleFactura.getTipoGasto()}" name="txtTipoGasto" required>
                        <option value="Servicio">Servicio</option>
                        <option value="Reparacion">Reparacion</option>
                        <option value="Llanta">Llanta</option>
                        <option value="Repuesto">Repuesto</option>
                        <option value="Accesorio">Accesorio</option>
                    </select>

                    <Label for="codigoGasto">Codigo Gasto</Label>
                    <input value="${detalleFactura.getCodigoGasto()}" min="0" type="number" name="txtCodigoGasto" placeholder="Ej: Servicio: 1" required>

                    <label for="cantidad">cantidad</label>
                    <input value="${detalleFactura.getCantidad()}" min="0" type="number" name="txtCantidad" placeholder="0" required>                                    
                    <button name="accion" value="Agregar" class="btn btn-primary btn-block btn-agregar">Agregar</button>
                    <button name="accion" value="Actualizar" class="btn btn-primary btn-block btn-Actualizar">Actualizar</button>

                </form>
                <button class="scroll-footer-btn" onclick="document.getElementById('footer').scrollIntoView({behavior: 'smooth'})">Ir al final</button>
            </div>
            <div class="tabla-registros">
                <h2>Detalles facturas registradas</h2>
                <table>
                    <thead>
                        <tr>
                            <th>No.Detalle</th>
                            <th>No.Factura</th>
                            <th>Tipo de gasot</th>
                            <th>No.Gasto</th>
                            <th>cantidad</th>
                            <th>Acciones</th>
                        </tr>  
                    </thead>   
                    <tbody>
                        <c:forEach var="detalleFactura" items="${detalleFacturas}">
                            <tr>
                                <td>${detalleFactura.getCodigoDetalle()}</td>
                                <td>${detalleFactura.getCodigoFactura()}</td>
                                <td>${detalleFactura.getTipoGasto()}</td>
                                <td>${detalleFactura.getCodigoGasto()}</td>
                                <td>${detalleFactura.getCantidad()}</td>
                                <td>
                                    <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-Actualizar" href="Controlador?menu=DetalleFacturaAdmin&accion=Editar&id=${detalleFactura.getCodigoDetalle()}" >Editar</a>
                                    <a name="accion" value="Buscar" class="btn btn-primary btn-block btn-drop" href="Controlador?menu=DetalleFacturaAdmin&accion=Eliminar&id=${detalleFactura.getCodigoDetalle()}">Elimina</a>                                    
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>               
                </table>
            </div>

        </section>
    </main>
    <body>
        <footer id="footer" style="padding: 20px; text-align:center;">
            <p>&copy; 2025 La caja de cambios - Todos los derechos reservados.</p>
        </footer>
    </body>
</html> 