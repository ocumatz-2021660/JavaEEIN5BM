package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DetalleFacturaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    DetalleFactura detalleFactura = new DetalleFactura();

    public List listar() {
        String sql = "call sp_MostrarDetallesFactura();";
        List<DetalleFactura> listaDetalleFactura = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleFactura dfac = new DetalleFactura();
                dfac.setCodigoDetalle(rs.getInt(1));
                dfac.setCodigoFactura(rs.getInt(2));
                dfac.setTipoGasto(DetalleFactura.TipoGasto.valueOf(rs.getString(3)));
                dfac.setCodigoGasto(rs.getInt(4));
                dfac.setCantidad(rs.getInt(5));
                listaDetalleFactura.add(dfac);
            }
           
        }catch(Exception e){
                    e.printStackTrace();
                    } return listaDetalleFactura ;
    }
    public int agregar(DetalleFactura dfac){
        String sql = "call sp_AgregarDetalleFactura(?,?,?,?);";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dfac.getCodigoFactura());
            ps.setString(2, dfac.getTipoGasto().name());
            ps.setInt(3, dfac.getCodigoGasto());
            ps.setInt(4, dfac.getCantidad());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }return resp;
    }
    public DetalleFactura listarCodigoDetalle(int id){
        String sql = "call sp_BuscarDetalleFactura("+id+");";  
        DetalleFactura detalleFactura = null;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalleFactura = new DetalleFactura();
                detalleFactura.setCodigoDetalle(rs.getInt(1));
                detalleFactura.setCodigoFactura(rs.getInt(2));
                detalleFactura.setTipoGasto(DetalleFactura.TipoGasto.valueOf(rs.getString(3)));
                detalleFactura.setCodigoGasto(rs.getInt(4));
                detalleFactura.setCantidad(rs.getInt(5));                              
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return detalleFactura;
    }
    public int actualizar(DetalleFactura dfac){
        String sql = "call sp_ActualizarDetalleFactura(?,?,?,?,?)";
        resp = 0;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dfac.getCodigoDetalle());
            ps.setInt(2, dfac.getCodigoFactura());
            ps.setString(3, dfac.getTipoGasto().name());
            ps.setInt(4, dfac.getCodigoGasto());
            ps.setInt(5, dfac.getCantidad());
            resp = ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public void eliminar(int id){
        String sql = "call sp_EliminarDetalleFactura("+id+");";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
