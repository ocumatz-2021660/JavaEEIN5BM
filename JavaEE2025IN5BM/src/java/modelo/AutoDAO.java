package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "call sp_ListarAuto();";
        List<Auto> listaAutos = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Auto au = new Auto();
                au.setCodigoAuto(rs.getInt(1));
                au.setCodigoCliente(rs.getInt(2));
                au.setPlaca(rs.getString(3));
                au.setMarca(rs.getString(4));
                au.setModelo(rs.getString(5));
                au.setColor(rs.getString(6));
                listaAutos.add(au);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAutos;
    }

    public int agregar(Auto au) {
        String sql = "call sp_AgregarAuto(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, au.getCodigoCliente());
            ps.setString(2, au.getPlaca());
            ps.setString(3, au.getMarca());
            ps.setString(4, au.getModelo());
            ps.setString(5, au.getColor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // Método para listar un auto por su código
    public Auto listarCodigoAuto(int id) {
        Auto auto = null;
        String sql = "call sp_BuscarAuto(?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Establece el parámetro del ID
            rs = ps.executeQuery();
            if (rs.next()) {
                auto = new Auto();
                auto.setCodigoAuto(rs.getInt(1));
                auto.setCodigoCliente(rs.getInt(2));
                auto.setPlaca(rs.getString(3));
                auto.setMarca(rs.getString(4));
                auto.setModelo(rs.getString(5));
                auto.setColor(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auto;
    }

    // Método para actualizar un auto
    public int actualizar(Auto au) {
        String sql = "call sp_ModificarAuto(?, ?, ?, ?, ?, ?);";
        resp = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, au.getCodigoAuto());
            ps.setInt(2, au.getCodigoCliente());
            ps.setString(3, au.getPlaca());
            ps.setString(4, au.getMarca());
            ps.setString(5, au.getModelo());
            ps.setString(6, au.getColor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Método para eliminar un auto
    public void eliminar(int id) {
        String sql = "call sp_EliminarAuto(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}