package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdenReparacionDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

  
    public List<OrdenReparacion> listar() {
        List<OrdenReparacion> listaOrdenes = new ArrayList<>();
        String sql = "SELECT * FROM OrdenReparacion";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdenReparacion or = new OrdenReparacion();
                or.setCodigoOrdenReparacion(rs.getInt("codigoOrdenReparacion"));
                or.setCodigoAutoReparacion(rs.getInt("codigoAutoReparacion"));
                or.setCodigoClienteReparacion(rs.getInt("codigoClienteReparacion"));
                or.setCodigoEmpleadoReparacion(rs.getInt("codigoEmpleadoReparacion"));
                or.setCodigoReparacion(rs.getInt("codigoReparacion"));
                or.setFechaIngresoReparacion(rs.getDate("fechaIngresoReparacion"));
                or.setEstadoReparacion(rs.getString("estadoReparacion"));
                listaOrdenes.add(or);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaOrdenes;
    }


    public int agregar(OrdenReparacion or) {
        String sql = "INSERT INTO OrdenReparacion "
                   + "(codigoAutoReparacion, codigoClienteReparacion, codigoEmpleadoReparacion, codigoReparacion, fechaIngresoReparacion, estadoReparacion) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, or.getCodigoAutoReparacion());
            ps.setInt(2, or.getCodigoClienteReparacion());
            ps.setInt(3, or.getCodigoEmpleadoReparacion());
            ps.setInt(4, or.getCodigoReparacion());
            ps.setDate(5, new java.sql.Date(or.getFechaIngresoReparacion().getTime()));
            ps.setString(6, or.getEstadoReparacion());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    public OrdenReparacion listarCodigoOrden(int id) {
        OrdenReparacion or = new OrdenReparacion();
        String sql = "SELECT * FROM OrdenReparacion WHERE codigoOrdenReparacion = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                or.setCodigoOrdenReparacion(rs.getInt("codigoOrdenReparacion"));
                or.setCodigoAutoReparacion(rs.getInt("codigoAutoReparacion"));
                or.setCodigoClienteReparacion(rs.getInt("codigoClienteReparacion"));
                or.setCodigoEmpleadoReparacion(rs.getInt("codigoEmpleadoReparacion"));
                or.setCodigoReparacion(rs.getInt("codigoReparacion"));
                or.setFechaIngresoReparacion(rs.getDate("fechaIngresoReparacion"));
                or.setEstadoReparacion(rs.getString("estadoReparacion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return or;
    }


    public int actualizar(OrdenReparacion or) {
        int resp = 0;
        String sql = "UPDATE OrdenReparacion SET codigoAutoReparacion=?, codigoClienteReparacion=?, codigoEmpleadoReparacion=?, codigoReparacion=?, fechaIngresoReparacion=?, estadoReparacion=? WHERE codigoOrdenReparacion=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, or.getCodigoAutoReparacion());
            ps.setInt(2, or.getCodigoClienteReparacion());
            ps.setInt(3, or.getCodigoEmpleadoReparacion());
            ps.setInt(4, or.getCodigoReparacion());
            ps.setDate(5, new java.sql.Date(or.getFechaIngresoReparacion().getTime()));
            ps.setString(6, or.getEstadoReparacion());
            ps.setInt(7, or.getCodigoOrdenReparacion());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM OrdenReparacion WHERE codigoOrdenReparacion=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
