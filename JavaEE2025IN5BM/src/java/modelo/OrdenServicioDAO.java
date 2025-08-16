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
public class OrdenServicioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    OrdenServicio ordenServicio = new OrdenServicio();

    public List listar() {

        String sql = "call sp_ListarOrdenServicio();";
        List<OrdenServicio> listaOrdenServicio = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdenServicio oserv = new OrdenServicio();
                oserv.setCodigoOrdenServicio(rs.getInt(1));
                oserv.setCodigoAuto(rs.getInt(2));
                oserv.setCodigoCliente(rs.getInt(3));
                oserv.setCodigoEmpleado(rs.getInt(4));
                oserv.setCodigoServicio(rs.getInt(5));
                oserv.setFechaIngreso(rs.getString(6));
                oserv.setEstado(OrdenServicio.EstadoOrden.valueOf(rs.getString(7)));

                listaOrdenServicio.add(oserv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaOrdenServicio;
    }

    public int agregar(OrdenServicio oserv) {
        String sql = "call sp_AgregarOrdenServicio(?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, oserv.getCodigoAuto());
            ps.setInt(2, oserv.getCodigoCliente());
            ps.setInt(3, oserv.getCodigoEmpleado());
            ps.setInt(4, oserv.getCodigoServicio());
            ps.setString(5, oserv.getFechaIngreso());
            ps.setString(6, oserv.getEstado().name());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
