package it.model;

public class Product extends article
{
    private int id,corsia,scaffale;
    private String categoria;
    private String sottocategoria;
    private String produttore;
    private Product[] prodotto;


    public Product() {

    }



    public Product(int id, Product[] prodotto, String categoria, String sottocategoria, Double costo, int corsia, int scaffale, String produttore)
    {
        this.id=id;
        this.prodotto= prodotto;
        this.produttore = produttore; // produttore
        this.categoria=categoria;
        this.sottocategoria=sottocategoria;
        this.corsia=corsia;
        this.scaffale=scaffale;

    }
    //METODI GET
    public int getId() { return id; }

    public void setId(int id) { this.id = id;  }

    public Product[] getProdotto()
    {
        return prodotto;
    }

    public int getCorsia() {
        return corsia;
    }

    public int getScaffale() {
        return scaffale;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public String getSottocategoria()
    {
        return sottocategoria;
    }

    public String getProduttore() {
        return produttore;
    }

    //METODI SET
    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setCorsia(int corsia) {
        this.corsia = corsia;
    }

    public void setScaffale(int scaffale) {
        this.scaffale = scaffale;
    }

      public void setProdotto(Product[] prodotto)
    {
        prodotto = prodotto;
    }


    public void setSottocategoria(String sottocategoria)
    {
        this.sottocategoria = sottocategoria;
    }
}