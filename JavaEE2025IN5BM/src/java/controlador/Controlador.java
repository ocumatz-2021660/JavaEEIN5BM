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
    Repuesto repuesto = new Repuesto();
    RepuestoDao repuestoDao = new RepuestoDao();
    int codReparacion;
    int codOrdenReparacion;
    int codRepuesto; 
    

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
                    Cliente e = clienteDAO.listarCodigoCliente(codCliente);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=ClientesAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int id = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    String nomCliente = request.getParameter("txtNombreCliente");
                    String telCliente = request.getParameter("txtTelefonoCliente");
                    String emailCliente = request.getParameter("txtCorreoCliente");
                    String ubicacion = request.getParameter("txtDireccion");
                    String pass = request.getParameter("txtContrasena");
                    String puesto = request.getParameter("txtRol");
                    cliente.setCodigoCliente(id);
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
                    request.getRequestDispatcher("MecanicosAdmin.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String nombreEmpleado = request.getParameter("txtNombreEmpleado");
                    String telefonoEmpleado = request.getParameter("txtTelefonoEmpleado");
                    String correoEmpleado = request.getParameter("txtCorreoEmpleado");
                    String direccionEmpleado = request.getParameter("txtDireccionEmpleado");
                    String puestoEmpleado = request.getParameter("txtPuestoEmpleado");

                    empleado.setNombreEmpleado(nombreEmpleado);
                    empleado.setTelefonoEmpleado(telefonoEmpleado);
                    empleado.setCorreoEmpleado(correoEmpleado);
                    empleado.setDireccion(direccionEmpleado);
                    empleado.setPuesto(Empleado.Puesto.valueOf(puestoEmpleado));
                    empleadoDAO.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=MecanicosAdmin&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    int codigoEmp = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado emp = empleadoDAO.listarCodigoEmpleado(codigoEmp);
                    request.setAttribute("empleado", emp);
                    List<Empleado> listaEmpleadosEditar = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleadosEditar);
                    request.getRequestDispatcher("MecanicosAdmin.jsp").forward(request, response);
                    break;

                case "Actualizar":
                    int codigoEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    String nombreEmpAct = request.getParameter("txtNombreEmpleado");
                    String telefonoEmpAct = request.getParameter("txtTelefonoEmpleado");
                    String correoEmpAct = request.getParameter("txtCorreoEmpleado");
                    String direccionEmpAct = request.getParameter("txtDireccionEmpleado");
                    String puestoEmpAct = request.getParameter("txtPuestoEmpleado");

                    empleado.setCodigoEmpleado(codigoEmpleado);
                    empleado.setNombreEmpleado(nombreEmpAct);
                    empleado.setTelefonoEmpleado(telefonoEmpAct);
                    empleado.setCorreoEmpleado(correoEmpAct);
                    empleado.setDireccion(direccionEmpAct);
                    empleado.setPuesto(Empleado.Puesto.valueOf(puestoEmpAct));
                    empleadoDAO.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=MecanicosAdmin&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    int codigoEliminar = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDAO.eliminar(codigoEliminar);
                    request.getRequestDispatcher("Controlador?menu=MecanicosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    break;
            }
            request.getRequestDispatcher("MecanicosAdmin.jsp").forward(request, response);
     } else if (menu.equals("LlantasAdmin")) {
            switch (accion) {
                case "Listar":
                    List<Llanta> listaLlantas = llantaDAO.listar();
                    request.setAttribute("llantas", listaLlantas);
                    request.getRequestDispatcher("LlantasAdmin.jsp").forward(request, response);
                    break;
                case "Agregar":
                    try {
                        int anchoMilimetros = Integer.parseInt(request.getParameter("txtAnchoLlanta"));
                        int perfil = Integer.parseInt(request.getParameter("txtPerfilLlanta"));
                        String tipoConstruccion = request.getParameter("txtTipoConstruccion");
                        int diametroRin = Integer.parseInt(request.getParameter("txtDiametroRinLlanta"));
                        int cargaMaximaKg = Integer.parseInt(request.getParameter("txtCargaMaximaKgLlanta"));
                        double precioLlanta = Double.parseDouble(request.getParameter("txtPrecioLlanta"));
                        Llanta llanta = new Llanta();
                        llanta.setAnchoMilimetros(anchoMilimetros);
                        llanta.setPerfil(perfil);
                        llanta.setTipoConstruccion(Llanta.TipoConstruccion.valueOf(tipoConstruccion));
                        llanta.setDiametroRin(diametroRin);
                        llanta.setCargaMaximakg(cargaMaximaKg);
                        llanta.setPrecioLlanta(precioLlanta);
                        llantaDAO.agregar(llanta);
                        request.getRequestDispatcher("Controlador?menu=LlantasAdmin&accion=Listar").forward(request, response);
                        System.out.println("Llanta agregada correctamente");
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir valores numéricos: " + e.getMessage());
                        request.getRequestDispatcher("LlantasAdmin.jsp").forward(request, response);
                    }
                    break;
                case "Editar":
                    int codLlanta = Integer.parseInt(request.getParameter("codigoLlanta"));
                    Llanta llantaEditar = llantaDAO.listarCodigoLlanta(codLlanta);
                    request.setAttribute("llanta", llantaEditar);
                    request.getRequestDispatcher("Controlador?menu=LlantasAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    try {
                        int codigoLlanta = Integer.parseInt(request.getParameter("txtCodigoLlanta"));
                        int anchoMili = Integer.parseInt(request.getParameter("txtAnchoLlanta"));
                        int perf = Integer.parseInt(request.getParameter("txtPerfilLlanta"));
                        String tipo = request.getParameter("txtTipoConstruccion");
                        int diametroR = Integer.parseInt(request.getParameter("txtDiametroRinLlanta"));
                        int carga = Integer.parseInt(request.getParameter("txtCargaMaximaKgLlanta"));
                        double precioLlan = Double.parseDouble(request.getParameter("txtPrecioLlanta"));
                        Llanta llanta = new Llanta();
                        llanta.setCodigoLlanta(codigoLlanta);
                        llanta.setAnchoMilimetros(anchoMili);
                        llanta.setPerfil(perf);
                        llanta.setTipoConstruccion(Llanta.TipoConstruccion.valueOf(tipo));
                        llanta.setDiametroRin(diametroR);
                        llanta.setCargaMaximakg(carga);
                        llanta.setPrecioLlanta(precioLlan);
                        llantaDAO.actualizar(llanta);
                        request.getRequestDispatcher("Controlador?menu=LlantasAdmin&accion=Listar").forward(request, response);
                        System.out.println("Llanta actualizada correctamente");
                    } catch (NumberFormatException e) {                       
                        request.getRequestDispatcher("LlantasAdmin.jsp").forward(request, response);
                         System.out.println("Error al convertir valores numéricos: " + e.getMessage());
                    }
                    break;
                case "Eliminar":
                    codLlanta = Integer.parseInt(request.getParameter("codigoLlanta"));
                    llantaDAO.eliminar(codLlanta);
                    request.getRequestDispatcher("Controlador?menu=LlantasAdmin&accion=Listar").forward(request, response);
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
                    int idEditar = Integer.parseInt(request.getParameter("codigoAuto"));
                    Auto autoSeleccionado = autoDAO.listarCodigoAuto(idEditar);
                    request.setAttribute("auto", autoSeleccionado);
                    List listaAutosEditar = autoDAO.listar();
                    request.setAttribute("autos", listaAutosEditar);
                    request.getRequestDispatcher("AutosAdmin.jsp").forward(request, response);
                    break;
                case "Actualizar":
                    int idActualizar = Integer.parseInt(request.getParameter("txtCodigoAuto"));
                    int codigoClienteAct = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    String placaAct = request.getParameter("txtPlaca");
                    String marcaAct = request.getParameter("txtMarca");
                    String modeloAct = request.getParameter("txtModelo");
                    String colorAct = request.getParameter("txtColor");
                    Auto autoActualizado = new Auto();
                    autoActualizado.setCodigoAuto(idActualizar);
                    autoActualizado.setCodigoCliente(codigoClienteAct);
                    autoActualizado.setPlaca(placaAct);
                    autoActualizado.setMarca(marcaAct);
                    autoActualizado.setModelo(modeloAct);
                    autoActualizado.setColor(colorAct);
                    autoDAO.actualizar(autoActualizado);
                    request.getRequestDispatcher("Controlador?menu=AutosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("codigoAuto"));
                    autoDAO.eliminar(idEliminar);
                    request.getRequestDispatcher("Controlador?menu=AutosAdmin&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("AutosAdmin.jsp").forward(request, response);
        } else if (menu.equals("RepuestosAdmin")) {
            switch (accion) {
                case "Listar":
                    List<Repuesto> listaRepuestos = repuestoDao.listar();
                    request.setAttribute("repuestos", listaRepuestos);
                    System.out.println("Mostrar Repuestos");
                    break;
                case "Agregar":
                    String nombreRepuesto = request.getParameter("txtNombreRepuesto");
                    String descripcionRepuesto = request.getParameter("txtDescripcionRepuesto");
                    double precioRepuesto = Double.parseDouble(request.getParameter("txtPrecioRepuesto"));
                    int stockRepuesto = Integer.parseInt(request.getParameter("txtStockRepuesto"));
                    String estadoRepuesto = request.getParameter("txtEstadoRepuesto");

                    repuesto.setNombreRepuesto(nombreRepuesto);
                    repuesto.setDescripcionRepuesto(descripcionRepuesto);
                    repuesto.setPrecioRepuesto(precioRepuesto);
                    repuesto.setStockRepuesto(stockRepuesto);
                    repuesto.setEstadoRepuesto(Repuesto.EstadoRepuesto.valueOf(estadoRepuesto));

                    repuestoDao.agregar(repuesto);
                    if (repuesto != null) {
                        request.getRequestDispatcher("Controlador?menu=RepuestosAdmin&accion=Listar").forward(request, response);
                        System.out.println("Repuesto Agregado correctamente");
                    } else {
                        System.out.println("No se pudo agregar el repuesto");
                    }
                    break;
                case "Editar":
                    codRepuesto = Integer.parseInt(request.getParameter("id"));
                    Repuesto rep = repuestoDao.listarCodigoRepuesto(codRepuesto);
                    request.setAttribute("repuesto", rep);
                    request.getRequestDispatcher("Controlador?menu=RepuestosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int codigoRepuesto = Integer.parseInt(request.getParameter("txtCodigoRepuesto"));
                    String nombreRep = request.getParameter("txtNombreRepuesto");
                    String descripcionRep = request.getParameter("txtDescripcionRepuesto");
                    double precioRep = Double.parseDouble(request.getParameter("txtPrecioRepuesto"));
                    int stockRep = Integer.parseInt(request.getParameter("txtStockRepuesto"));
                    String estadoRep = request.getParameter("txtEstadoRepuesto");
                    
                    Repuesto repuesto = new Repuesto();
                    repuesto.setCodigoRepuesto(codigoRepuesto);
                    repuesto.setNombreRepuesto(nombreRep);
                    repuesto.setDescripcionRepuesto(descripcionRep);
                    repuesto.setPrecioRepuesto(precioRep);
                    repuesto.setStockRepuesto(stockRep);
                    repuesto.setEstadoRepuesto(Repuesto.EstadoRepuesto.valueOf(estadoRep));
                    
                    repuestoDao.actualizar(repuesto);
                    request.getRequestDispatcher("Controlador?menu=RepuestosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codRepuesto = Integer.parseInt(request.getParameter("id"));
                    repuestoDao.eliminar(codRepuesto);
                    request.getRequestDispatcher("Controlador?menu=RepuestosAdmin&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("RepuestosAdmin.jsp").forward(request, response);
        } else if (menu.equals("AccesoriosAdmin")) {
            switch (accion) {
                case "Listar":
                    List<Accesorio> listaAccesorios = accesorioDao.listar();
                    request.setAttribute("accesorios", listaAccesorios);
                    request.getRequestDispatcher("AccesoriosAdmin.jsp").forward(request, response);
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
                    request.getRequestDispatcher("Controlador?menu=AccesoriosAdmin&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    int codigoAcc = Integer.parseInt(request.getParameter("codigoAccesorio"));
                    Accesorio acc = accesorioDao.listarCodigoAccesorio(codigoAcc);
                    request.setAttribute("accesorio", acc); // accesorio a editar
                    List<Accesorio> listaEditar = accesorioDao.listar(); // mostrar tabla
                    request.setAttribute("accesorios", listaEditar);
                    request.getRequestDispatcher("AccesoriosAdmin.jsp").forward(request, response);
                    break;

                case "Actualizar":
                    int codigoActualizar = Integer.parseInt(request.getParameter("txtCodigoAccesorio"));
                    String nombreActualizar = request.getParameter("txtNombreAccesorio");
                    String descripcionActualizar = request.getParameter("txtDescripcionAccesorio");
                    double precioActualizar = Double.parseDouble(request.getParameter("txtPrecioAccesorio"));
                    int stockActualizar = Integer.parseInt(request.getParameter("txtStockAccesorio"));
                    String estadoActualizar = request.getParameter("txtEstadoAccesorio");

                    accesorio.setCodigoAccesorio(codigoActualizar);
                    accesorio.setNombreAccesorio(nombreActualizar);
                    accesorio.setDescripcionAccesorio(descripcionActualizar);
                    accesorio.setPrecioAccesorio(precioActualizar);
                    accesorio.setStockAccesorio(stockActualizar);
                    accesorio.setEstadoAccesorio(Accesorio.EstadoAccesorio.valueOf(estadoActualizar));

                    accesorioDao.actualizar(accesorio);
                    request.getRequestDispatcher("Controlador?menu=AccesoriosAdmin&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    int codigoEliminar = Integer.parseInt(request.getParameter("codigoAccesorio"));
                    accesorioDao.eliminar(codigoEliminar);
                    request.getRequestDispatcher("Controlador?menu=AccesoriosAdmin&accion=Listar").forward(request, response);
                    break;

                case "Buscar":
                    // Aquí puedes implementar la lógica de búsqueda si la necesitas
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
                    int codServicio = Integer.parseInt(request.getParameter("codigoServicio"));
                    Servicio ser = servicioDAO.listarCodigoServicio(codServicio);
                    request.setAttribute("servicio", ser);
                    request.getRequestDispatcher("Controlador?menu=ServiciosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int codigoServicio = Integer.parseInt(request.getParameter("txtCodigoServicio"));
                    String nombre = request.getParameter("txtNombreServicio");
                    String descripcion = request.getParameter("txtDescripcionServicio");
                    double precio = Double.parseDouble(request.getParameter("txtPrecioServicio"));

                    Servicio serv = new Servicio();
                    serv.setCodigoServicio(codigoServicio);
                    serv.setNombreServicio(nombre);
                    serv.setDescripcionServicio(descripcion);
                    serv.setPrecioServicio(precio);
                    servicioDAO.actualizar(serv);
                    request.getRequestDispatcher("Controlador?menu=ServiciosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int codigoServicioEliminar = Integer.parseInt(request.getParameter("codigoServicio"));
                    servicioDAO.eliminar(codigoServicioEliminar);
                    request.getRequestDispatcher("Controlador?menu=ServiciosAdmin&accion=Listar").forward(request, response);
                    break;
                case "Buscar":
                    // Implementar búsqueda si es necesario
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
                    ordenServicio.setCodigoAuto(codigoAuto);
                    ordenServicio.setCodigoCliente(codigoCliente);
                    ordenServicio.setCodigoEmpleado(codigoEmpleado);
                    ordenServicio.setCodigoServicio(codigoServicio);
                    ordenServicio.setFechaIngreso(fechaIngreso);
                    ordenServicio.setEstado(OrdenServicio.EstadoOrden.valueOf(estado));
                    ordenServicioDAO.agregar(ordenServicio);
                    if (ordenServicio != null) {
                        request.getRequestDispatcher("Controlador?menu=DetalleServicioAdmin&accion=Listar").forward(request, response);
                        System.out.println("Orden de Servicio Agregada correctamente");
                    } else {
                        System.out.println("No se pudo realizar la Orden de Servicio");
                    }
                    break;
                case "Editar":
                    int codOrden = Integer.parseInt(request.getParameter("codigoOrdenServicio"));
                    OrdenServicio os = ordenServicioDAO.listarCodigoOrdenServicio(codOrden);
                    request.setAttribute("ordenServicio", os);
                    request.getRequestDispatcher("Controlador?menu=DetalleServicioAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int codigoOrdenServicio = Integer.parseInt(request.getParameter("txtCodigoOrdenServicio"));
                    int idAuto = Integer.parseInt(request.getParameter("txtCodigoAuto"));
                    int idCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    int idEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    int idServicio = Integer.parseInt(request.getParameter("txtCodigoServicio"));
                    String diaIngreso = request.getParameter("txtFechaIngreso");
                    String Estado = request.getParameter("txtEstado");

                    ordenServicio.setCodigoOrdenServicio(codigoOrdenServicio);
                    ordenServicio.setCodigoAuto(idAuto);
                    ordenServicio.setCodigoCliente(idCliente);
                    ordenServicio.setCodigoEmpleado(idEmpleado);
                    ordenServicio.setCodigoServicio(idServicio);
                    ordenServicio.setFechaIngreso(diaIngreso);
                    ordenServicio.setEstado(OrdenServicio.EstadoOrden.valueOf(Estado));
                    ordenServicioDAO.actualizar(ordenServicio);
                    request.getRequestDispatcher("Controlador?menu=DetalleServicioAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codOrden = Integer.parseInt(request.getParameter("codigoOrdenServicio"));
                    ordenServicioDAO.eliminar(codOrden);
                    request.getRequestDispatcher("Controlador?menu=DetalleServicioAdmin&accion=Listar").forward(request, response);
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
                    int codDetalleFac = Integer.parseInt(request.getParameter("id"));
                    DetalleFactura df = detalleFacturaDao.listarCodigoDetalle(codDetalleFac);
                    request.setAttribute("detalleFactura", df);
                    request.getRequestDispatcher("Controlador?menu=DetalleFacturaAdmin&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int codigoDetalle = Integer.parseInt(request.getParameter("txtCodigoDetalle"));
                    int idFacuta = Integer.parseInt(request.getParameter("txtCodigoFacturaDetalle"));
                    String Gasto = request.getParameter("txtTipoGasto");
                    int idGasto = Integer.parseInt(request.getParameter("txtCodigoGasto"));
                    int cuanto = Integer.parseInt(request.getParameter("txtCantidad"));
                    detalleFactura.setCodigoDetalle(codigoDetalle);
                    detalleFactura.setCodigoFactura(idFacuta);
                    detalleFactura.setTipoGasto(DetalleFactura.TipoGasto.valueOf(Gasto));
                    detalleFactura.setCodigoGasto(idGasto);
                    detalleFactura.setCantidad(cuanto);
                    detalleFacturaDao.actualizar(detalleFactura);
                    request.getRequestDispatcher("Controlador?menu=DetalleFacturaAdmin&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int codDetalleFactura = Integer.parseInt(request.getParameter("id"));
                    detalleFacturaDao.eliminar(codDetalleFactura);
                    request.getRequestDispatcher("Controlador?menu=DetalleFacturaAdmin&accion=Listar").forward(request, response);
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
