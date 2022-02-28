package it.model;
//implementare database
public class article {
   private int id;
    private String name;
    private String Descr;
    private Product[] prodotto;
    private String comment;
    private int eval;
    private double costo;

    public article() {

    }

    public article(int id,String name, double costo, String Descr, Product[] prodotto, String comment, int eval){
        this.id=id;
        this.name=name;
        this.comment=comment;
        this.eval=eval;
        this.Descr=Descr;
        this.costo=costo;
        this.prodotto=prodotto;

    }
    // metodi get
    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public int getEval() {
        return eval;
    }
    public Product[] getProdotto() {
        return prodotto;
    }
    public String getComment() {
        return comment;
    }
    public String getDescr() {
        return Descr;
    }
    public double getCosto()
    {
        return costo;
    }

    //METODI SET
    public void setCosto(double costo)
    {
        this.costo = costo;
    }
    public void setName(String name) {this.name = name;}
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setDescr(String descr) {
        Descr = descr;
    }
    public void setEval(int eval) {
            this.eval = eval;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setProdotto(Product[] prodotto) {
        this.prodotto = prodotto;
    }

}
