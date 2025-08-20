
package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    Factura factura = new Factura();
    
    
    public List listar(){
        
        String sql = "call sp_ListarFactura();";
        List<Factura> listaFacturas = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura fac = new Factura();
                fac.setCodigoFactura(rs.getInt(1));
                fac.setCodigoClienteFactura(rs.getInt(2));
                fac.setCodigoEmpleadoFactura(rs.getInt(3));
                fac.setCodigoAutoFactura(rs.getInt(4));
                fac.setFechaEmision(rs.getString(5));
                fac.setTotal(rs.getDouble(6));
                fac.setMetodoPago(Factura.MetodoPago.valueOf(rs.getString(7)));
                
                listaFacturas.add(fac);
            }
        }catch(Exception e){
            e.printStackTrace();
        }return listaFacturas;
    }
    
    public int agregar(Factura fac){
        String sql = "call sp_agregarFactura(?,?,?,?,?);";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fac.getCodigoClienteFactura());
            ps.setInt(2, fac.getCodigoEmpleadoFactura());
            ps.setInt(3, fac.getCodigoAutoFactura());
            ps.setString(4, fac.getFechaEmision());
            ps.setString(5, fac.getMetodoPago().name());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public Factura listarCodigoFactura(int id){        
        String sql = "call sp_BuscarFactura(?);";
        Factura fact = null;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {               
                fact = new Factura();
                fact.setCodigoFactura(rs.getInt(1));
                fact.setCodigoClienteFactura(rs.getInt(2));
                fact.setCodigoEmpleadoFactura(rs.getInt(3));
                fact.setCodigoAutoFactura(rs.getInt(4));
                fact.setFechaEmision(rs.getString(5));                
                fact.setMetodoPago(Factura.MetodoPago.valueOf(rs.getString(6)));
            }                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return fact;
    }
    public int actualizar(Factura factu){
        String sql = "call sp_EditarFactura(?,?,?,?,?,?)";
        resp = 0;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, factu.getCodigoFactura());
            ps.setInt(2, factu.getCodigoClienteFactura());
            ps.setInt(3, factu.getCodigoEmpleadoFactura());
            ps.setInt(4, factu.getCodigoAutoFactura());
            ps.setString(5, factu.getFechaEmision());
            ps.setString(6, factu.getMetodoPago().name());
            resp = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public void eliminar(int id){
        String sql = "call sp_EliminarFactura("+id+");";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
