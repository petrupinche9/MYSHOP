package it.model;
//implementare database
public class article {
   private int id;
    private String name;
    private String Descr;
    private String comment;
    private int eval;
    private double costo;
    private byte[] img;
    public article() {

    }

    public article(int id,String name, double costo, String Descr, String comment, int eval, byte[] img){
        this.id=id;
        this.name=name;
        this.comment=comment;
        this.eval=eval;
        this.Descr=Descr;
        this.costo=costo;
        this.img=img;

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
    public byte[] getImg() {return img;}

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
}
