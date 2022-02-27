//implementare database
public class article {
   private int id;

    private String Descr;
    private Product[] prodotto;
    private String comment;
    private int eval;
    public article() {

    }
    public article( int id,String Descr,Product[] prodotto,String comment, int eval){
        this.id=id;
        this.comment=comment;
        this.eval=eval;
        this.Descr=Descr;
        this.prodotto=prodotto;

    }
    // metodi get
    public int getId() {
        return id;
    }
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
    //METODI SET
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
