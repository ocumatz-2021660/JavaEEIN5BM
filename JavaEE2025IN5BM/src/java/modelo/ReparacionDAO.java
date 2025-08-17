package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ReparacionDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar() {
        String sql = "select * from Reparacion";
        List<Reparacion> listaReparacion = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reparacion rep = new Reparacion();
                rep.setCodigoReparacion(rs.getInt(1));
                rep.setNombreReparacion(rs.getString(2));
                rep.setDescripcionReparacion(rs.getString(3));
                rep.setPrecioReparacion(rs.getDouble(4));
                listaReparacion.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaReparacion;
    }
    
    public int agregar(Reparacion rep) {
        String sql = "insert into Reparacion (nombreReparacion, descripcionReparacion, precioReparacion) values (?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rep.getNombreReparacion());
            ps.setString(2, rep.getDescripcionReparacion());
            ps.setDouble(3, rep.getPrecioReparacion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}