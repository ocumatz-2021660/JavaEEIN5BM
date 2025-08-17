
package modelo;

public class Accesorio {

  
    private int codigoAccesorio;
    private String nombreAccesorio;
    private String descripcionAccesorio;
    private double precioAccesorio;
    private int stockAccesorio;
    private EstadoAccesorio estadoAccesorio;
    public enum EstadoAccesorio {
        Disponibles, Agotados
    }

    public Accesorio() {
    }

    public Accesorio(int codigoAccesorio, String nombreAccesorio, String descripcionAccesorio, double precioAccesorio, int stockAccesorio, EstadoAccesorio estadoAccesorio) {
        this.codigoAccesorio = codigoAccesorio;
        this.nombreAccesorio = nombreAccesorio;
        this.descripcionAccesorio = descripcionAccesorio;
        this.precioAccesorio = precioAccesorio;
        this.stockAccesorio = stockAccesorio;
        this.estadoAccesorio = estadoAccesorio;
    }

    public int getCodigoAccesorio() {
        return codigoAccesorio;
    }

    public void setCodigoAccesorio(int codigoAccesorio) {
        this.codigoAccesorio = codigoAccesorio;
    }

    public String getNombreAccesorio() {
        return nombreAccesorio;
    }

    public void setNombreAccesorio(String nombreAccesorio) {
        this.nombreAccesorio = nombreAccesorio;
    }

    public String getDescripcionAccesorio() {
        return descripcionAccesorio;
    }

    public void setDescripcionAccesorio(String descripcionAccesorio) {
        this.descripcionAccesorio = descripcionAccesorio;
    }

    public double getPrecioAccesorio() {
        return precioAccesorio;
    }

    public void setPrecioAccesorio(double precioAccesorio) {
        this.precioAccesorio = precioAccesorio;
    }

    public int getStockAccesorio() {
        return stockAccesorio;
    }

    public void setStockAccesorio(int stockAccesorio) {
        this.stockAccesorio = stockAccesorio;
    }

    public EstadoAccesorio getEstadoAccesorio() {
        return estadoAccesorio;
    }

    public void setEstadoAccesorio(EstadoAccesorio estadoAccesorio) {
        this.estadoAccesorio = estadoAccesorio;
    }

    @Override
    public String toString() {
        return "Accesorio{" + "codigoAccesorio=" + codigoAccesorio + ", nombreAccesorio=" + nombreAccesorio + ", descripcionAccesorio=" + descripcionAccesorio + ", precioAccesorio=" + precioAccesorio + ", stockAccesorio=" + stockAccesorio + ", estadoAccesorio=" + estadoAccesorio + '}';
    }
    
    

   
   
       
    }
