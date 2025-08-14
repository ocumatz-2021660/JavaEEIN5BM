
package modelo;

public class Factura {

    private int codigoFactura;
    private int codigoClienteFactura;
    private int codigoEmpleadoFactura;
    private int codigoAutoFactura;
    private String fechaEmision;
    private double total;
    private MetodoPago metodoPago;
    
    //Metodo de pago enum
    public enum MetodoPago {
        Targeta,Efectivo
    }
    public Factura(){
        
    }

    public Factura(int codigoFactura, int codigoClienteFactura, int codigoEmpleadoFactura, int codigoAutoFactura, String fechaEmision, double total, MetodoPago metodoPago) {
        this.codigoFactura = codigoFactura;
        this.codigoClienteFactura = codigoClienteFactura;
        this.codigoEmpleadoFactura = codigoEmpleadoFactura;
        this.codigoAutoFactura = codigoAutoFactura;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoClienteFactura() {
        return codigoClienteFactura;
    }

    public void setCodigoClienteFactura(int codigoClienteFactura) {
        this.codigoClienteFactura = codigoClienteFactura;
    }

    public int getCodigoEmpleadoFactura() {
        return codigoEmpleadoFactura;
    }

    public void setCodigoEmpleadoFactura(int codigoEmpleadoFactura) {
        this.codigoEmpleadoFactura = codigoEmpleadoFactura;
    }

    public int getCodigoAutoFactura() {
        return codigoAutoFactura;
    }

    public void setCodigoAutoFactura(int codigoAutoFactura) {
        this.codigoAutoFactura = codigoAutoFactura;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

   
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Factura{" + "codigoFactura=" + codigoFactura + ", codigoClienteFactura=" + codigoClienteFactura + ", codigoEmpleadoFactura=" + codigoEmpleadoFactura + ", codigoAutoFactura=" + codigoAutoFactura + ", fechaEmision=" + fechaEmision + ", total=" + total + ", metodoPago=" + metodoPago + '}';
    }

    
    
}

