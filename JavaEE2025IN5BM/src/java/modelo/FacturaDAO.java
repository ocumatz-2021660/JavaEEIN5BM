
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
    
}
