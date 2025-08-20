package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

public class Controlador extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    Factura factura = new Factura();
    FacturaDAO facturaDAO = new FacturaDAO();
    DetalleFactura detalleFactura = new DetalleFactura();
    DetalleFacturaDAO detalleFacturaDao = new DetalleFacturaDAO();
    Auto auto = new Auto();
    AutoDAO autoDAO = new AutoDAO();
    int codFactura;
    int codCliente;
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    int codEmpleado;
    Servicio servicio = new Servicio();
    ServicioDAO servicioDAO = new ServicioDAO();
    OrdenServicio ordenServicio = new OrdenServicio();
    OrdenServicioDAO ordenServicioDAO = new OrdenServicioDAO();
    Reparacion reparacion = new Reparacion();
    ReparacionDAO reparacionDAO = new ReparacionDAO();
    OrdenReparacion ordenReparacion = new OrdenReparacion();
    OrdenReparacionDAO ordenReparacionDAO = new OrdenReparacionDAO();
    int codReparacion;
    int codOrdenReparacion;

    Accesorio accesorio = new Accesorio();
    AccesoriosDAO accesorioDao = new AccesoriosDAO();
    Llanta llanta = new Llanta();
    LlantaDAO llantaDAO = new LlantaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String menuAdmin = request.getParameter("menuAdmin");

        // Verificar si el parámetro 'menu' es igual a "Principal"
        if (menu.equals("MenuInicio")) {
            // Hacer el forward al JSP 'MenuInicio.jsp'
            request.getRequestDispatcher("MenuInicio.jsp").forward(request, response);
        } else if (menu.equals("ClientesAdmin")) {

            switch (accion) {
                case "Listar":
                    List listaClientes = clienteDAO.listar();
                    request.setAttribute("clientes", listaClientes);
                    break;
                case "Agregar":
                    String nombreCliente = request.getParameter("txtNombreCliente");
                    String telefonoCliente = request.getParameter("txtTelefonoCliente");
                    String correoCliente = request.getParameter("txtCorreoCliente");
                    String direccion = request.getParameter("txtDireccion");
                    String contrasena = request.getParameter("txtContrasena");
                    String rol = request.getParameter("txtRol");
                    cliente.setNombreCliente(nombreCliente);
                    cliente.setTelefonoCliente(telefonoCliente);
                    cliente.setCorreoCliente(correoCliente);
                    cliente.setDireccion(direccion);
                    cliente.setContrasena(contrasena);
                    cliente.setRol(rol);
                    clienteDAO.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=ClientesAdmin&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    Cliente e = clienteDAO.lisarCodigoCliente(codCliente);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=ClientesAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomCliente = request.getParameter("txtNombreCliente");
                    String telCliente = request.getParameter("txtTelefonoCliente");
                    String emailCliente = request.getParameter("txtCorreoCliente");
                    String ubicacion = request.getParameter("txtDireccion");
                    String pass = request.getParameter("txtContrasena");
                    String puesto = request.getParameter("txtRol");
                    cliente.setNombreCliente(nomCliente);
                    cliente.setTelefonoCliente(telCliente);
                    cliente.setCorreoCliente(emailCliente);
                    cliente.setDireccion(ubicacion);
                    cliente.setContrasena(pass);
                    cliente.setRol(puesto);
                    clienteDAO.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=ClientesAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    clienteDAO.eliminar(codCliente);
                    request.getRequestDispatcher("Controlador?menu=ClientesAdmin&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("ClientesAdmin.jsp").forward(request, response);
        } else if (menu.equals("MecanicosAdmin")) {
            switch (accion) {
                case "Listar":
                    List<Empleado> listaEmpleados = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    break;
                case "Agregar":
                    String nombreEmp = request.getParameter("txtNombreEmpleado");
                    String telefonoEmp = request.getParameter("txtTelefonoEmpleado");
                    String correoEmp = request.getParameter("txtCorreoEmpleado");
                    String direccionEmp = request.getParameter("txtDireccionEmpleado");
                    String puestoEmp = request.getParameter("txtPuestoEmpleado");
                    empleado.setNombreEmpleado(nombreEmp);
                    empleado.setTelefonoEmpleado(telefonoEmp);
                    empleado.setCorreoEmpleado(correoEmp);
                    empleado.setDireccion(direccionEmp);
                    empleado.setPuesto(Empleado.Puesto.valueOf(puestoEmp));
                    empleadoDAO.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=MecanicosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("MecanicosAdmin.jsp").forward(request, response);
        } else if (menu.equals("LlantasAdmin")) {
            switch (accion) {
                case "Listar":
                    List<modelo.Llanta> listarLlantas = llantaDAO.listar();
                    request.setAttribute("Llantas", listarLlantas);
                    break;
                case "Agregar":
                    String anchoMilimentosStr = request.getParameter("txtAnchoMilimentos");
                    String perfilStr = request.getParameter("txtPerfil");
                    String tipoConstruccion = request.getParameter("txtTipoConstruccion");
                    String diametroRinStr = request.getParameter("txtDiametroRin");
                    String cargaMaximakgStr = request.getParameter("txtCargaMaximakg");
                    String precioLlantaStr = request.getParameter("txtPrecioLlanta");
                    int anchoMilimentos = Integer.parseInt(anchoMilimentosStr);
                    int perfil = Integer.parseInt(perfilStr);
                    int diametroRin = Integer.parseInt(diametroRinStr);
                    int cargaMaximakg = Integer.parseInt(cargaMaximakgStr);
                    double precioLlanta = Double.parseDouble(precioLlantaStr);
                    llanta.setPerfil(perfil);
                    llanta.setDiametroRin(diametroRin);
                    llanta.setCargaMaximakg(cargaMaximakg);
                    llanta.setPrecioLlanta(precioLlanta);
                    String agregar = "Controlador?menu=LlantasAdmin&accion=Listar";
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("LlantasAdmin.jsp").forward(request, response);
        } else if (menu.equals("FacturaAdmin")) {
            switch (accion) {
                case "Listar":
                    List listaFactura = facturaDAO.listar();
                    request.setAttribute("facturas", listaFactura);
                    System.out.println("Mostrar Facturas");
                    break;
                case "Agregar":
                    int codigoCliente = Integer.parseInt(request.getParameter("txtCodigoClienteFactura"));
                    int codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleadoFactura"));
                    int codigoAuto = Integer.parseInt(request.getParameter("txtCodigoAutoFactura"));
                    String fechaEmision = request.getParameter("txtFechaEmision");
                    String metodoPago = request.getParameter("txtMetodoPago");
                    factura.setCodigoClienteFactura(codigoCliente);
                    factura.setCodigoEmpleadoFactura(codigoEmpleado);
                    factura.setCodigoAutoFactura(codigoAuto);
                    factura.setFechaEmision(fechaEmision);
                    factura.setMetodoPago(Factura.MetodoPago.valueOf(metodoPago));
                    facturaDAO.agregar(factura);
                    if (factura != null) {
                        request.getRequestDispatcher("Controlador?menu=FacturaAdmin&accion=Listar").forward(request, response);
                        System.out.println("Factura Agregada correctamente");
                    } else {
                        System.out.println("No se pudo realizsar la factura");
                    }
                    break;
                case "Editar":
                    codFactura = Integer.parseInt(request.getParameter("codigoFactura"));
                    Factura fa = facturaDAO.listarCodigoFactura(codFactura);
                    request.setAttribute("factura", fa);
                    request.getRequestDispatcher("Controlador?menu=FacturaAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int codigoFactura = Integer.parseInt(request.getParameter("txtCodigoFactura"));
                    int idCliente = Integer.parseInt(request.getParameter("txtCodigoClienteFactura"));
                    int idEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleadoFactura"));
                    int idAuto = Integer.parseInt(request.getParameter("txtCodigoAutoFactura"));
                    String diaEmision = request.getParameter("txtFechaEmision");
                    String Pago = request.getParameter("txtMetodoPago");

                    factura.setCodigoFactura(codigoFactura);
                    factura.setCodigoClienteFactura(idCliente);
                    factura.setCodigoEmpleadoFactura(idEmpleado);
                    factura.setCodigoAutoFactura(idAuto);
                    factura.setFechaEmision(diaEmision);
                    factura.setMetodoPago(Factura.MetodoPago.valueOf(Pago));
                    facturaDAO.actualizar(factura);
                    request.getRequestDispatcher("Controlador?menu=FacturaAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codFactura = Integer.parseInt(request.getParameter("codigoFactura"));
                    facturaDAO.eliminar(codFactura);
                    request.getRequestDispatcher("Controlador?menu=FacturaAdmin&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("FacturaAdmin.jsp").forward(request, response);
        } else if (menu != null && menu.equals("AutosAdmin")) {
            switch (accion) {
                case "Listar":
                    List listaAutos = autoDAO.listar();
                    request.setAttribute("autos", listaAutos);
                    request.getRequestDispatcher("AutosAdmin.jsp").forward(request, response);
                    break;
                case "Agregar":
                    int codigoCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    String placa = request.getParameter("txtPlaca");
                    String marca = request.getParameter("txtMarca");
                    String modelo = request.getParameter("txtModelo");
                    String color = request.getParameter("txtColor");
                    auto.setCodigoCliente(codigoCliente);
                    auto.setPlaca(placa);
                    auto.setMarca(marca);
                    auto.setModelo(modelo);
                    auto.setColor(color);
                    autoDAO.agregar(auto);
                    if (auto != null) {
                        request.getRequestDispatcher("Controlador?menu=AutosAdmin&accion=Listar").forward(request, response);
                        System.out.println("Auto Agregada correctamente");
                    } else {
                        System.out.println("No se pudo agregar el Auto");
                    }
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
            }
            request.getRequestDispatcher("AutosAdmin.jsp").forward(request, response);
        } else if (menu.equals("RepuestosAdmin")) {
            switch (accion) {
                case "Listar":
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("RepuestosAdmin.jsp").forward(request, response);
        } else if (menu.equals("AccesoriosAdmin")) {
            switch (accion) {
                case "Listar":
                    List listaAccesorio = accesorioDao.listar();
                    request.setAttribute("accesorios", listaAccesorio);
                    System.out.println("Mostrar Accesorio");
                    break;
                case "Agregar":

                    String nombreAccesorio = request.getParameter("txtNombreAccesorio");
                    String descripcionAccesorio = request.getParameter("txtDescripcionAccesorio");
                    double precioAccesorio = Double.parseDouble(request.getParameter("txtPrecioAccesorio"));
                    int stockAccesorio = Integer.parseInt(request.getParameter("txtStockAccesorio"));
                    String estadoAccesorio = request.getParameter("txtEstadoAccesorio");
                    accesorio.setNombreAccesorio(nombreAccesorio);
                    accesorio.setDescripcionAccesorio(descripcionAccesorio);
                    accesorio.setPrecioAccesorio(precioAccesorio);
                    accesorio.setStockAccesorio(stockAccesorio);
                    accesorio.setEstadoAccesorio(Accesorio.EstadoAccesorio.valueOf(estadoAccesorio));
                    accesorioDao.agregar(accesorio);
                    if (accesorio != null) {
                        request.getRequestDispatcher("Controlador?menu=AccesoriosAdmin&accion=Listar").forward(request, response);
                        System.out.println("Accesorio agregado correctamente");
                    } else {
                        System.out.println("No se pudo agregar el Accesorio");
                    }
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("AccesoriosAdmin.jsp").forward(request, response);
        } else if (menu.equals("ServiciosAdmin")) {
            switch (accion) {
                case "Listar":
                    List listaServicios = servicioDAO.listar();
                    request.setAttribute("servicios", listaServicios);
                    System.out.println("Mostrar Servicios");
                    break;
                case "Agregar":
                    String nombreServicio = request.getParameter("txtNombreServicio");
                    String descripcionServicio = request.getParameter("txtDescripcionServicio");
                    double precioServicio = Double.parseDouble(request.getParameter("txtPrecioServicio"));
                    Servicio servicio = new Servicio();
                    servicio.setNombreServicio(nombreServicio);
                    servicio.setDescripcionServicio(descripcionServicio);
                    servicio.setPrecioServicio(precioServicio);
                    servicioDAO.agregar(servicio);
                    if (servicio != null) {
                        request.getRequestDispatcher("Controlador?menu=ServiciosAdmin&accion=Listar").forward(request, response);
                        System.out.println("Servicio agregado correctamente");
                    } else {
                        System.out.println("No se pudo agregar el Servicio");
                    }
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("ServicioAdmin.jsp").forward(request, response);
        } else if (menu.equals("DetalleServicioAdmin")) {
            switch (accion) {
                case "Listar":
                    List listaOrdenServicio = ordenServicioDAO.listar();
                    request.setAttribute("ordenServicios", listaOrdenServicio);
                    System.out.println("Mostrar Ordenes Servicios");
                    break;
                case "Agregar":
                    int codigoAuto = Integer.parseInt(request.getParameter("txtCodigoAuto"));
                    int codigoCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    int codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    int codigoServicio = Integer.parseInt(request.getParameter("txtCodigoServicio"));
                    String fechaIngreso = request.getParameter("txtFechaIngreso");
                    String estado = request.getParameter("txtEstado");
                    OrdenServicio ordenServicio = new OrdenServicio();
                    ordenServicio.setCodigoAuto(codigoAuto);
                    ordenServicio.setCodigoCliente(codigoCliente);
                    ordenServicio.setCodigoEmpleado(codigoEmpleado);
                    ordenServicio.setCodigoServicio(codigoServicio);
                    ordenServicio.setFechaIngreso(fechaIngreso);
                    ordenServicio.setEstado(OrdenServicio.EstadoOrden.valueOf(estado));
                    ordenServicioDAO.agregar(ordenServicio);
                    if (ordenServicio != null) {
                        request.getRequestDispatcher("Controlador?menu=DetalleServicioAdmin&accion=Listar").forward(request, response);
                        System.out.println("Servicio agregado correctamente");
                    } else {
                        System.out.println("No se pudo agregar el Servicio");
                    }
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("DetalleServicioAdmin.jsp").forward(request, response);
        } else if (menu.equals("ReparacionesAdmin")) {
            switch (accion) {
                case "Listar":
                    List<Reparacion> listaReparaciones = reparacionDAO.listar();
                    request.setAttribute("reparaciones", listaReparaciones);
                    request.getRequestDispatcher("ReparacionesAdmin.jsp").forward(request, response);
                    break;
                case "Agregar":
                    reparacion.setNombreReparacion(request.getParameter("txtNombreReparacion"));
                    reparacion.setDescripcionReparacion(request.getParameter("txtDescripcionReparacion"));
                    reparacion.setPrecioReparacion(Double.parseDouble(request.getParameter("txtPrecioReparacion")));
                    reparacionDAO.agregar(reparacion);
                    response.sendRedirect("Controlador?menu=ReparacionesAdmin&accion=Listar");
                    break;
                case "Editar":
                    codReparacion = Integer.parseInt(request.getParameter("codigoReparacion"));
                    Reparacion rep = reparacionDAO.listarCodigoReparacion(codReparacion);
                    request.setAttribute("rep", rep);
                    request.setAttribute("reparaciones", reparacionDAO.listar());
                    request.getRequestDispatcher("ReparacionesAdmin.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    reparacion.setCodigoReparacion(Integer.parseInt(request.getParameter("txtCodigoReparacion")));
                    reparacion.setNombreReparacion(request.getParameter("txtNombreReparacion"));
                    reparacion.setDescripcionReparacion(request.getParameter("txtDescripcionReparacion"));
                    reparacion.setPrecioReparacion(Double.parseDouble(request.getParameter("txtPrecioReparacion")));
                    reparacionDAO.actualizar(reparacion);
                    response.sendRedirect("Controlador?menu=ReparacionesAdmin&accion=Listar");
                    break;
                case "Eliminar":
                    codReparacion = Integer.parseInt(request.getParameter("codigoReparacion"));
                    reparacionDAO.eliminar(codReparacion);
                    response.sendRedirect("Controlador?menu=ReparacionesAdmin&accion=Listar");
                    break;
            }
        } else if (menu.equals("OrdenReparacionAdmin")) {
            switch (accion) {
                case "Listar":
                    List<OrdenReparacion> listaOrdenes = ordenReparacionDAO.listar();
                    request.setAttribute("ordenesReparacion", listaOrdenes);
                    request.getRequestDispatcher("OrdenReparacionAdmin.jsp").forward(request, response);
                    break;
                case "Agregar":
                    ordenReparacion.setCodigoAutoReparacion(Integer.parseInt(request.getParameter("txtCodigoAutoReparacion")));
                    ordenReparacion.setCodigoClienteReparacion(Integer.parseInt(request.getParameter("txtCodigoClienteReparacion")));
                    ordenReparacion.setCodigoEmpleadoReparacion(Integer.parseInt(request.getParameter("txtCodigoEmpleadoReparacion")));
                    ordenReparacion.setCodigoReparacion(Integer.parseInt(request.getParameter("txtCodigoReparacion")));
                    ordenReparacion.setFechaIngresoReparacion(java.sql.Date.valueOf(request.getParameter("txtFechaIngresoReparacion")));
                    ordenReparacion.setEstadoReparacion(request.getParameter("txtEstadoReparacion"));
                    ordenReparacionDAO.agregar(ordenReparacion);
                    response.sendRedirect("Controlador?menu=OrdenReparacionAdmin&accion=Listar");
                    break;
                case "Editar":
                    codOrdenReparacion = Integer.parseInt(request.getParameter("codigoOrdenReparacion"));
                    OrdenReparacion ord = ordenReparacionDAO.listarCodigoOrden(codOrdenReparacion);
                    request.setAttribute("ord", ord);
                    request.setAttribute("ordenesReparacion", ordenReparacionDAO.listar());
                    request.getRequestDispatcher("OrdenReparacionAdmin.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    ordenReparacion.setCodigoOrdenReparacion(Integer.parseInt(request.getParameter("txtCodigoOrdenReparacion")));
                    ordenReparacion.setCodigoAutoReparacion(Integer.parseInt(request.getParameter("txtCodigoAutoReparacion")));
                    ordenReparacion.setCodigoClienteReparacion(Integer.parseInt(request.getParameter("txtCodigoClienteReparacion")));
                    ordenReparacion.setCodigoEmpleadoReparacion(Integer.parseInt(request.getParameter("txtCodigoEmpleadoReparacion")));
                    ordenReparacion.setCodigoReparacion(Integer.parseInt(request.getParameter("txtCodigoReparacion")));
                    ordenReparacion.setFechaIngresoReparacion(java.sql.Date.valueOf(request.getParameter("txtFechaIngresoReparacion")));
                    ordenReparacion.setEstadoReparacion(request.getParameter("txtEstadoReparacion"));
                    ordenReparacionDAO.actualizar(ordenReparacion);
                    response.sendRedirect("Controlador?menu=OrdenReparacionAdmin&accion=Listar");
                    break;
                case "Eliminar":
                    codOrdenReparacion = Integer.parseInt(request.getParameter("codigoOrdenReparacion"));
                    ordenReparacionDAO.eliminar(codOrdenReparacion);
                    response.sendRedirect("Controlador?menu=OrdenReparacionAdmin&accion=Listar");
                    break;
            }
        } else if (menu.equals("DetalleFacturaAdmin")) {
            switch (accion) {
                case "Listar":
                    List listaDetalleFactura = detalleFacturaDao.listar();
                    request.setAttribute("detalleFacturas", listaDetalleFactura);
                    System.out.println("Mostrar detalle Facturas");
                    break;
                case "Agregar":
                    int codigoFacuta = Integer.parseInt(request.getParameter("txtCodigoFacturaDetalle"));
                    String tipoGasto = request.getParameter("txtTipoGasto");
                    int codigoGasto = Integer.parseInt(request.getParameter("txtCodigoGasto"));
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    detalleFactura.setCodigoFactura(codigoFacuta);
                    detalleFactura.setTipoGasto(DetalleFactura.TipoGasto.valueOf(tipoGasto));
                    detalleFactura.setCodigoGasto(codigoGasto);
                    detalleFactura.setCantidad(cantidad);
                    detalleFacturaDao.agregar(detalleFactura);
                    if (factura != null) {
                        request.getRequestDispatcher("Controlador?menu=DetalleFacturaAdmin&accion=Listar").forward(request, response);
                        System.out.println("DetalleFactura agregado correctaemente");
                    } else {
                        System.out.println("No se pudo agregar el detalle factura");
                    }
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("DetalleFacturaAdmin.jsp").forward(request, response);
        } else if (menu != null && menu.equals("Registro")) {
            switch (accion) {
                case "Agregar":
                    String nombreCliente = request.getParameter("txtNombreCliente");
                    String telefonoCliente = request.getParameter("txtTelefonoCliente");
                    String correoCliente = request.getParameter("txtCorreoCliente");
                    String direccion = request.getParameter("txtDireccion");
                    String contrasena = request.getParameter("txtContrasena");
                    String rol = request.getParameter("txtRol");
                    cliente.setNombreCliente(nombreCliente);
                    cliente.setTelefonoCliente(telefonoCliente);
                    cliente.setCorreoCliente(correoCliente);
                    cliente.setDireccion(direccion);
                    cliente.setContrasena(contrasena);
                    cliente.setRol(rol);
                    clienteDAO.agregar(cliente);
                    response.sendRedirect("index.jsp");
                    break;
                default:
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                    break;
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
