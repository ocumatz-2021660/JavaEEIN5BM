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
    
    public Cliente validar(String email, String pass) {
        //Instanciar el objeto de la entidad Cliene
        Cliente cliente = new Cliente();
        //Agregar una variable de tipo string para nuestra consulta sql
        String sql = "select * from Cliente where correoCliente = ? and contrasena = ?";
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
        String sql = "select * from Cliente";
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
        String sql = "insert into Cliente(nombreCliente, telefonoCliente, correoCliente, direccion, contrasena, rol) values (?, ?, ?, ?, ?, ?)";
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
}
