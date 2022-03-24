package it.model;

public class Fornitore
{

    private int id;
    private String nome;
    private String sitoweb;
    private String citta;
    private String nazione;
    public Fornitore(int id,String nome, String sitoweb, String citta, String nazione)
    {
        super();
        this.id=id;
        this.nome = nome;
        this.sitoweb = sitoweb;
        this.citta = citta;
        this.nazione = nazione;
    }

    public Fornitore() {

    }
    //metodi get

    public String getNome()
    {
        return nome;
    }

    public int getId() {return id;    }
    public String getSitoweb()
    {
        return sitoweb;
    }
    public String getCitta()
    {
        return citta;
    }
    public String getNazione()
    {
        return nazione;
    }

    //metodi setter

    public void setId(int id) {this.id = id;    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setSitoweb(String sitoweb)
    {
        this.sitoweb = sitoweb;
    }
    public void setCitta(String citta)
    {
        this.citta = citta;
    }
    public void setNazione(String nazione)
    {
        this.nazione = nazione;
    }
}
