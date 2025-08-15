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
    int codCliente;
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    int codEmpleado;

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
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                case "Buscar":
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
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
            }
            request.getRequestDispatcher("FacturaAdmin.jsp").forward(request, response);
        } else if (menu.equals("AutosAdmin")) {
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
            request.getRequestDispatcher("AccesoriosAdmin.jsp").forward(request, response);
        } else if (menu.equals("ServiciosAdmin")) {
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
            request.getRequestDispatcher("ServicioAdmin.jsp").forward(request, response);
        } else if (menu.equals("DettalleOrdenServicio")) {
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
            request.getRequestDispatcher("DetalleServicioAdmin.jsp").forward(request, response);
        } else if (menu.equals("ReparacionesAdmin")) {
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
            request.getRequestDispatcher("ReparacionesAdmin.jsp").forward(request, response);
        } else if (menu.equals("OrdenReparacionAdmin")) {
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
            request.getRequestDispatcher("OrdenReparacionAdmin.jsp").forward(request, response);
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
