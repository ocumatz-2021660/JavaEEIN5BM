/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class ServicioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    Servicio servicio = new Servicio();
    
    public List listar(){
        
        String sql = "call sp_listarservicio();";
        List<Servicio> listaServicios = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicio serv = new Servicio();
                serv.setCodigoServicio(rs.getInt(1));
                serv.setNombreServicio(rs.getString(2));
                serv.setDescripcionServicio(rs.getString(3));
                serv.setPrecioServicio(rs.getInt(4));
                
                listaServicios.add(serv);
            }
        }catch(Exception e){
            e.printStackTrace();
        }return listaServicios;
    }
    
    public int agregar(Servicio serv){
        String sql = "call sp_agregarservicio(?,?,?);";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, serv.getNombreServicio());
            ps.setString(2, serv.getDescripcionServicio());
            ps.setDouble(3, serv.getPrecioServicio());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
}
