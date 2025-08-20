package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    Cliente cliente = new Cliente();

    public Cliente validar(String email, String pass) {
        Cliente cliente = new Cliente();
        String sql = "call sp_validarCliente(?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setCodigoCliente(rs.getInt("codigoCliente"));
                cliente.setNombreCliente(rs.getString("nombreCliente"));
                cliente.setContrasena(rs.getString("contrasena"));
                cliente.setCorreoCliente(rs.getString("correoCliente"));
                cliente.setRol(rs.getString("rol"));
            }
        } catch (Exception e) {
            System.out.println("El correo o contrasena son incorrectos");
            e.printStackTrace();
        }
        return cliente;
    }

    public List listar() {
        String sql = "call sp_ListarCliente();";
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setCodigoCliente(rs.getInt(1));
                cl.setNombreCliente(rs.getString(2));
                cl.setTelefonoCliente(rs.getString(3));
                cl.setCorreoCliente(rs.getString(4));
                cl.setDireccion(rs.getString(5));
                cl.setContrasena(rs.getString(6));
                cl.setRol(rs.getString(7));
                listaClientes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public int agregar(Cliente cl) {
        String sql = "call sp_AgregarCliente(?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombreCliente());
            ps.setString(2, cl.getTelefonoCliente());
            ps.setString(3, cl.getCorreoCliente());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getContrasena());
            ps.setString(6, cl.getRol());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Cliente lisarCodigoCliente(int id) {
        Cliente clie = new Cliente();
        String sql = "call sp_BuscarCliente(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clie.setNombreCliente(rs.getString(2));
                clie.setTelefonoCliente(rs.getString(3));
                clie.setCorreoCliente(rs.getString(4));
                clie.setDireccion(rs.getString(5));
                clie.setContrasena(rs.getString(6));
                clie.setRol(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clie;
    }

    public int actualizar(Cliente cli) {
        String sql = "call sp_ModificarCliente(?,?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombreCliente());
            ps.setString(2, cli.getTelefonoCliente());
            ps.setString(3, cli.getCorreoCliente());
            ps.setString(4, cli.getDireccion());
            ps.setString(5, cli.getContrasena());
            ps.setString(6, cli.getRol());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id) {
        String sql = "call sp_EliminarCliente(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
