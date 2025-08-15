package modelo;

public class Empleado {

    private int codigoEmpleado;
    private String nombreEmpleado;
    private String telefonoEmpleado;
    private String correoEmpleado;
    private String direccion;
    private Puesto puesto;

    public enum Puesto {
        Recepcionista, Mecanico
    }

    public Empleado() {
    }

    public Empleado(int codigoEmpleado, String nombreEmpleado, String telefonoEmpleado, String correoEmpleado, String direccion, Puesto puesto) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.direccion = direccion;
        this.puesto = puesto;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigoEmpleado=" + codigoEmpleado +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", telefonoEmpleado='" + telefonoEmpleado + '\'' +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", direccion='" + direccion + '\'' +
                ", puesto=" + puesto +
                '}';
    }
}
