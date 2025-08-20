package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReparacionDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;


    public List<Reparacion> listar() {
        List<Reparacion> listaReparacion = new ArrayList<>();
        String sql = "SELECT * FROM Reparacion";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reparacion rep = new Reparacion();
                rep.setCodigoReparacion(rs.getInt("codigoReparacion"));
                rep.setNombreReparacion(rs.getString("nombreReparacion"));
                rep.setDescripcionReparacion(rs.getString("descripcionReparacion"));
                rep.setPrecioReparacion(rs.getDouble("precioReparacion"));
                listaReparacion.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaReparacion;
    }

 
    public int agregar(Reparacion rep) {
        resp = 0;
        String sql = "INSERT INTO Reparacion(nombreReparacion, descripcionReparacion, precioReparacion) VALUES (?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rep.getNombreReparacion());
            ps.setString(2, rep.getDescripcionReparacion());
            ps.setDouble(3, rep.getPrecioReparacion());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    public Reparacion listarCodigoReparacion(int id) {
        Reparacion rep = new Reparacion();
        String sql = "SELECT * FROM Reparacion WHERE codigoReparacion=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                rep.setCodigoReparacion(rs.getInt("codigoReparacion"));
                rep.setNombreReparacion(rs.getString("nombreReparacion"));
                rep.setDescripcionReparacion(rs.getString("descripcionReparacion"));
                rep.setPrecioReparacion(rs.getDouble("precioReparacion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;
    }

 
    public int actualizar(Reparacion rep) {
        resp = 0;
        String sql = "UPDATE Reparacion SET nombreReparacion=?, descripcionReparacion=?, precioReparacion=? WHERE codigoReparacion=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rep.getNombreReparacion());
            ps.setString(2, rep.getDescripcionReparacion());
            ps.setDouble(3, rep.getPrecioReparacion());
            ps.setInt(4, rep.getCodigoReparacion());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    public int eliminar(int id) {
        resp = 0;
        String sql = "DELETE FROM Reparacion WHERE codigoReparacion=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
