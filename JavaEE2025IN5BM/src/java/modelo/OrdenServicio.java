/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class OrdenServicio {
    
    private int codigoOrdenServicio;
    private int codigoAuto;
    private int codigoCliente;
    private int codigoEmpleado;
    private int codigoServicio;
    private String fechaIngreso;
    private EstadoOrden estado;

    public enum EstadoOrden {
        Pendiente, EnProceso, Finalizado
    }
    
    public OrdenServicio() {
    }

    public OrdenServicio(int codigoOrdenServicio, int codigoAuto, int codigoCliente, int codigoEmpleado, int codigoServicio, String fechaIngreso, EstadoOrden estado) {
        this.codigoOrdenServicio = codigoOrdenServicio;
        this.codigoAuto = codigoAuto;
        this.codigoCliente = codigoCliente;
        this.codigoEmpleado = codigoEmpleado;
        this.codigoServicio = codigoServicio;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public void setCodigoOrdenServicio(int codigoOrdenServicio) {
        this.codigoOrdenServicio = codigoOrdenServicio;
    }

    public void setCodigoAuto(int codigoAuto) {
        this.codigoAuto = codigoAuto;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public int getCodigoOrdenServicio() {
        return codigoOrdenServicio;
    }

    public int getCodigoAuto() {
        return codigoAuto;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "OrdenServicio{" + "codigoOrdenServicio=" + codigoOrdenServicio + ", codigoAuto=" + codigoAuto + ", codigoCliente=" + codigoCliente + ", codigoEmpleado=" + codigoEmpleado + ", codigoServicio=" + codigoServicio + ", fechaIngreso=" + fechaIngreso + ", estado=" + estado + '}';
    }
    
}

