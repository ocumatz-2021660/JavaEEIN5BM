package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    Empleado empleado = new Empleado();

    public List<Empleado> listar() {
        String sql = "call sp_ListarEmpleado();";
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setCodigoEmpleado(rs.getInt(1));
                emp.setNombreEmpleado(rs.getString(2));
                emp.setTelefonoEmpleado(rs.getString(3));
                emp.setCorreoEmpleado(rs.getString(4));
                emp.setDireccion(rs.getString(5));
                emp.setPuesto(Empleado.Puesto.valueOf(rs.getString(6)));
                listaEmpleados.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public int agregar(Empleado emp) {
        String sql = "CALL sp_AgregarEmpleado(?, ?, ?, ?, ?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getTelefonoEmpleado());
            ps.setString(3, emp.getCorreoEmpleado());
            ps.setString(4, emp.getDireccion());
            ps.setString(5, emp.getPuesto().name());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
