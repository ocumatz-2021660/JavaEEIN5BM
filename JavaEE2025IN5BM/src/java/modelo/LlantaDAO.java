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



     public List listar(){



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
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaLlantas;
    }



       


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
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }


}
