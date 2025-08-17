
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
public class AccesoriosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    Accesorio accesorio = new Accesorio();
    
    public List listar() {
        String sql = "CALL sp_listarAccesorios();";
        List<Accesorio> listaAccesorio = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accesorio Acc = new Accesorio();
                Acc.setCodigoAccesorio(rs.getInt(1));
                Acc.setNombreAccesorio(rs.getString(2));
                Acc.setDescripcionAccesorio(rs.getString(3));
                Acc.setPrecioAccesorio(rs.getDouble(4));
                Acc.setStockAccesorio(rs.getInt(5));
                Acc.setEstadoAccesorio(Accesorio.EstadoAccesorio.valueOf(rs.getString(6)));
                listaAccesorio.add(Acc);
            }
           
        }catch(Exception e){
                    e.printStackTrace();
                    
        } return listaAccesorio ;
}
    
     public int agregar(Accesorio Acc) {
        String sql = "CALL sp_insertarAccesorio(?, ?, ?, ?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Acc.getNombreAccesorio());
            ps.setString(2, Acc.getDescripcionAccesorio());
            ps.setDouble(3, Acc.getPrecioAccesorio());
            ps.setInt(4, Acc.getStockAccesorio());
            ps.setString(5, Acc.getEstadoAccesorio().name());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    }
    
    
