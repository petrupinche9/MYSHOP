package it.model;

public class service extends article {
    private Fornitore fornitore;

    public service() {

    }


    public service(int id, String name, double costo, String Descr, String comment, int eval, byte[] img, String category, Fornitore fornitore)
    {
        super(id, name, costo, Descr, comment, eval, img, category);
        this.fornitore = fornitore;
    }

    //METODI GET

    public Fornitore getFornitore() {
        return fornitore;
    }


    //METODI SET

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

}

