package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

public class OrdenReparacionDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List<OrdenReparacion> listar() {
        String sql = "SELECT * FROM OrdenReparacion";
        List<OrdenReparacion> listaOrdenes = new ArrayList<>();
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
            ps.setDate(5, new java.sql.Date(or.getFechaIngresoReparacion().getTime())); // ✅ cambio importante
            ps.setString(6, or.getEstadoReparacion());
            resp = ps.executeUpdate(); // ✅ ahora sí devuelve filas afectadas
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}