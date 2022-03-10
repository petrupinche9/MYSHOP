package it.model;

public class service extends article {
    private String fornitore;

    public service() {

    }


    public service(int id, String name, double costo, String Descr, String comment, int eval, byte[] img, String category, String fornitore)
    {
        super(id, name, costo, Descr, comment, eval, img, category);
        this.fornitore = fornitore;
    }

    //METODI GET

    public String getFornitore() {
        return fornitore;
    }


    //METODI SET

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }

}

