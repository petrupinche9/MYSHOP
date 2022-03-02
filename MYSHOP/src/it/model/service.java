package it.model;

public class service extends article {
    private int id;
    private String fornitore;

    public service() {

    }


    public service(int id, String fornitore) {
        this.id = id;
        this.fornitore = fornitore;
    }

    //METODI GET
    public int getId() {
        return id;
    }

    public String getFornitore() {
        return fornitore;
    }

    //METODI SET
    public void setId(int id) {
        this.id = id;
    }

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }
}

