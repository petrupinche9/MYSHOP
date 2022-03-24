package it.model;

public class Product extends article
{
    private int id,corsia,scaffale;
    private String sottocategoria;
    private Produttore produttore;
    private Product[] prodotto;


    public Product() {

    }



    public Product(int id, Product[] prodotto, String sottocategoria, Double costo, int corsia, int scaffale, Produttore produttore)
    {
        this.id=id;
        this.prodotto= prodotto;
        this.produttore = produttore; // produttore
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

    public String getSottocategoria()
    {
        return sottocategoria;
    }

    public Produttore getProduttore() {
        return produttore;
    }

    //METODI SET

    public void setProduttore(Produttore produttore) {
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