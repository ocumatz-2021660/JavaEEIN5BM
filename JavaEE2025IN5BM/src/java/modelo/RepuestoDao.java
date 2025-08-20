package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepuestoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    Repuesto repuesto = new Repuesto();

    public List listar() {
        String sql = "call sp_ListarRepuestos();";
        List<Repuesto> listaRepuesto = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Repuesto rep = new Repuesto();
                rep.setCodigoRepuesto(rs.getInt(1));
                rep.setNombreRepuesto(rs.getString(2));
                rep.setDescripcionRepuesto(rs.getString(3));
                rep.setPrecioRepuesto(rs.getDouble(4));
                rep.setStockRepuesto(rs.getInt(5));
                rep.setEstadoRepuesto(Repuesto.EstadoRepuesto.valueOf(rs.getString(6)));
                listaRepuesto.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return listaRepuesto;
    }
    
   public int agregar(Repuesto rep) {
    String sql = "call sp_AgregarRepuesto(?,?,?,?,?);";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, rep.getNombreRepuesto());
        ps.setString(2, rep.getDescripcionRepuesto());
        ps.setDouble(3, rep.getPrecioRepuesto());
        ps.setInt(4, rep.getStockRepuesto());
        ps.setString(5, rep.getEstadoRepuesto().name());
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }return resp;
    
   }
    public Repuesto listarCodigoRepuesto(int id) {
    String sql = "call sp_BuscarRepuesto(?); ";    
    Repuesto repue = null;
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            repue = new Repuesto();
            repue.setCodigoRepuesto(rs.getInt(1));
            repue.setNombreRepuesto(rs.getString(2));
            repue.setDescripcionRepuesto(rs.getString(3));
            repue.setPrecioRepuesto(rs.getDouble(4));
            repue.setStockRepuesto(rs.getInt(5));
            repue.setEstadoRepuesto(Repuesto.EstadoRepuesto.valueOf(rs.getString(6)));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }return repue;
  
  }
    
    
 public int actualizar(Repuesto repu){
        String sql = "call sp_EditarRepuesto(?,?,?,?,?,?)";
        resp = 0;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, repu.getCodigoRepuesto());
            ps.setString(2, repu.getNombreRepuesto());
            ps.setString(3, repu.getDescripcionRepuesto());
            ps.setDouble(4, repu.getPrecioRepuesto());
            ps.setInt(5, repu.getStockRepuesto());
            ps.setString(6, repu.getEstadoRepuesto().name());
            resp = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
}
    public void eliminar(int id){
        String sql = "call sp_EliminarRepuesto("+id+");";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}