package modelo;
 
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class AccesoriosDAO {
 
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
 
    public List<Accesorio> listar() {
        String sql = "CALL sp_listarAccesorios();";
        List<Accesorio> listaAccesorios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accesorio acc = new Accesorio();
                acc.setCodigoAccesorio(rs.getInt(1));
                acc.setNombreAccesorio(rs.getString(2));
                acc.setDescripcionAccesorio(rs.getString(3));
                acc.setPrecioAccesorio(rs.getDouble(4));
                acc.setStockAccesorio(rs.getInt(5));
                acc.setEstadoAccesorio(Accesorio.EstadoAccesorio.valueOf(rs.getString(6)));
                listaAccesorios.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAccesorios;
    }
 
    public int agregar(Accesorio acc) {
        String sql = "CALL sp_insertarAccesorio(?, ?, ?, ?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, acc.getNombreAccesorio());
            ps.setString(2, acc.getDescripcionAccesorio());
            ps.setDouble(3, acc.getPrecioAccesorio());
            ps.setInt(4, acc.getStockAccesorio());
            ps.setString(5, acc.getEstadoAccesorio().name());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
 
    public Accesorio listarCodigoAccesorio(int id) {
        Accesorio acc = new Accesorio();
        String sql = "CALL sp_buscarAccesorio(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc.setCodigoAccesorio(rs.getInt(1));
                acc.setNombreAccesorio(rs.getString(2));
                acc.setDescripcionAccesorio(rs.getString(3));
                acc.setPrecioAccesorio(rs.getDouble(4));
                acc.setStockAccesorio(rs.getInt(5));
                acc.setEstadoAccesorio(Accesorio.EstadoAccesorio.valueOf(rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
 
    public int actualizar(Accesorio acc) {
        int resp = 0;
        String sql = "UPDATE Accesorio SET nombreAccesorio=?, descripcionAccesorio=?, precioAccesorio=?, stockAccesorio=?, estadoAccesorio=? WHERE codigoAccesorio=?;";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, acc.getNombreAccesorio());
            ps.setString(2, acc.getDescripcionAccesorio());
            ps.setDouble(3, acc.getPrecioAccesorio());
            ps.setInt(4, acc.getStockAccesorio());
            ps.setString(5, acc.getEstadoAccesorio().name());
            ps.setInt(6, acc.getCodigoAccesorio());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
 
    public void eliminar(int id) {
        String sql = "CALL sp_eliminarAccesorio(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}