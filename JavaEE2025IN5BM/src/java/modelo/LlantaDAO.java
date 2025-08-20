package modelo;
 
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import modelo.Llanta.TipoConstruccion;
 
public class LlantaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
 
    // LISTAR TODAS LAS LLANTAS
    public List<Llanta> listar() {
        String sql = "call sp_verllantas();";
        List<Llanta> listaLlantas = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Llanta llan = new Llanta();
                llan.setCodigoLlanta(rs.getInt(1));
                llan.setAnchoMilimetros(rs.getInt(2));
                llan.setPerfil(rs.getInt(3));
                llan.setTipoConstruccion(TipoConstruccion.valueOf(rs.getString(4)));
                llan.setDiametroRin(rs.getInt(5));
                llan.setCargaMaximakg(rs.getInt(6));
                llan.setPrecioLlanta(rs.getDouble(7));
                listaLlantas.add(llan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaLlantas;
    }
 
    // AGREGAR UNA LLANTA
    public int agregar(Llanta llan) {
        String sql = "call sp_nuevaLlanta(?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, llan.getAnchoMilimetros());
            ps.setInt(2, llan.getPerfil());
            ps.setString(3, llan.getTipoConstruccion().name());
            ps.setInt(4, llan.getDiametroRin());
            ps.setInt(5, llan.getCargaMaximakg());
            ps.setDouble(6, llan.getPrecioLlanta());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
 
    // LISTAR UNA LLANTA POR ID
    public Llanta listarCodigoLlanta(int id) {
        String sql = "call sp_buscarLlanta(?);";
        Llanta llan = null;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                llan = new Llanta();
                llan.setCodigoLlanta(rs.getInt(1));
                llan.setAnchoMilimetros(rs.getInt(2));
                llan.setPerfil(rs.getInt(3));
                llan.setTipoConstruccion(TipoConstruccion.valueOf(rs.getString(4)));
                llan.setDiametroRin(rs.getInt(5));
                llan.setCargaMaximakg(rs.getInt(6));
                llan.setPrecioLlanta(rs.getDouble(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return llan;
    }
 
    // ACTUALIZAR LLANTA
    public int actualizar(Llanta llan) {
        String sql = "call sp_editarLlanta(?,?,?,?,?,?,?);";
        resp = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, llan.getCodigoLlanta());
            ps.setInt(2, llan.getAnchoMilimetros());
            ps.setInt(3, llan.getPerfil());
            ps.setString(4, llan.getTipoConstruccion().name());
            ps.setInt(5, llan.getDiametroRin());
            ps.setInt(6, llan.getCargaMaximakg());
            ps.setDouble(7, llan.getPrecioLlanta());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
 
    // ELIMINAR LLANTA
    public void eliminar(int id) {
        String sql = "call sp_EliminarLanta(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}