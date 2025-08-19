package modelo;

import java.util.List;

public class Llanta {

    private int codigoLlanta;
    private int anchoMilimetros;
    private int perfil;
    private TipoConstruccion tipoConstruccion;
    private int diametroRin;
    private int cargaMaximakg;
    private double precioLlanta;




    public enum TipoConstruccion {
        RADIAL, DIAGONAL, CINTURADA
    }

    
    public Llanta() {
    }


    public int getCodigoLlanta() {
        return codigoLlanta;
    }

    public void setCodigoLlanta(int codigoLlanta) {
        this.codigoLlanta = codigoLlanta;
    }

    public int getAnchoMilimetros() {
        return anchoMilimetros;
    }

    public void setAnchoMilimetros(int anchoMilimetros) {
        this.anchoMilimetros = anchoMilimetros;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public TipoConstruccion getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(TipoConstruccion tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public int getDiametroRin() {
        return diametroRin;
    }

    public void setDiametroRin(int diametroRin) {
        this.diametroRin = diametroRin;
    }

    public int getCargaMaximakg() {
        return cargaMaximakg;
    }

    public void setCargaMaximakg(int cargaMaximakg) {
        this.cargaMaximakg = cargaMaximakg;
    }

    public double getPrecioLlanta() {
        return precioLlanta;
    }

    public void setPrecioLlanta(double precioLlanta) {
        this.precioLlanta = precioLlanta;
    }


}