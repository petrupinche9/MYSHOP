package it.model;

import it.DbConnection;

//implementare database
public class article {
   private int id;
    private String name;
    private String Descr;
    private String comment;
    private int eval;
    private double costo;
    private byte[] img;
    private String category;
    public article() {

    }

    public article(int id,String name, double costo, String Descr, String comment, int eval, byte[] img, String category){
        this.id=id;
        this.name=name;
        this.comment=comment;
        this.eval=eval;
        this.Descr=Descr;
        this.costo=costo;
        this.img=img;
        this.category=category;
    }
    // metodi get
    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public int getEval() {
        return eval;
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
    public byte[] getImg(int id) {
        return DbConnection.getInstance().getFoto("SELECT Image_descr FROM article WHERE idarticle='"+id+"';");
    }
    public String getCategory() {return category;}

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
    public void setImg(byte[] img) { this.img = img; }
    public void setCategory(String category) {this.category = category;   }
}
