package modelo;
 
/**
*
* @author informatica
*/
public class Repuesto {

    private int codigoRepuesto;
    private String nombreRepuesto;
    private String descripcionRepuesto;
    private double precioRepuesto;
    private int stockRepuesto;
    private EstadoRepuesto estadoRepuesto;
 
    public Repuesto() {
    }
    // ENUM tipo estado repuesto
    public enum EstadoRepuesto {
        Disponibles,Agotados;
    }
 
    public Repuesto(int codigoRepuesto, String nombreRepuesto, String descripcionRepuesto, double precioRepuesto, int stockRepuesto, EstadoRepuesto estadoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.descripcionRepuesto = descripcionRepuesto;
        this.precioRepuesto = precioRepuesto;
        this.stockRepuesto = stockRepuesto;
        this.estadoRepuesto = estadoRepuesto;
    }
    public int getCodigoRepuesto() {
        return codigoRepuesto;
    }
 
    public void setCodigoRepuesto(int codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }
 
    public String getNombreRepuesto() {
        return nombreRepuesto;
    }
 
    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }
 
    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }
 
    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }
 
    public double getPrecioRepuesto() {
        return precioRepuesto;
    }
 
    public void setPrecioRepuesto(double precioRepuesto) {
        if (precioRepuesto < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precioRepuesto = precioRepuesto;
    }
 
    public int getStockRepuesto() {
        return stockRepuesto;
    }
 
    public void setStockRepuesto(int stockRepuesto) {
        if (stockRepuesto < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stockRepuesto = stockRepuesto;
    }
 
    public EstadoRepuesto getEstadoRepuesto() {
        return estadoRepuesto;
    }
 
    public void setEstadoRepuesto(EstadoRepuesto estadoRepuesto) {
        this.estadoRepuesto = estadoRepuesto;
    }
 
    @Override
    public String toString() {
        return "Repuesto{" +
                "codigoRepuesto=" + codigoRepuesto +
                ", nombreRepuesto='" + nombreRepuesto + '\'' +
                ", descripcionRepuesto='" + descripcionRepuesto + '\'' +
                ", precioRepuesto=" + precioRepuesto +
                ", stockRepuesto=" + stockRepuesto +
                ", estadoRepuesto=" + estadoRepuesto +
                '}';
    }
    }