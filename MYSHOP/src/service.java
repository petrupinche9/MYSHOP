public class service extends article
{
    private int id;
    private String categoria;
    private double costo;
    public service(int id, String categoria, double costo)
    {
        super();
        this.id=id;
        this.categoria= categoria;
        this.costo=costo;
    }
//metodi get

    public int getId() { return id; }

    public double getCosto()
    {
        return costo;
    }

    public String getCategoria()
    {
        return categoria;
    }
//metodi set

    public void setId(int id) { this.id = id;    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }
}