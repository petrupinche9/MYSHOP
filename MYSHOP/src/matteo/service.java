import java.util.Scanner;

public class service
{
    private String categoria;
    private double costo;
public service(String categoria, double costo){
    this.categoria= categoria;
    this.costo=costo;
}
//metodi get

    public double getCosto() {
        return costo;
    }

    public String getCategoria() {
        return categoria;
    }
//metodi set

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
