package it.model;

public class service extends article
{
    private int id;
    private String categoria;
    private String Name;
    public service() {

    }
    public class Fornitore
    {
        private String nome;
        private String sitoweb;
        private String citta;
        private String nazione;
        public Fornitore(String nome, String sitoweb, String citta, String nazione)
        {
            super();
            this.nome = nome;
            this.sitoweb = sitoweb;
            this.citta = citta;
            this.nazione = nazione;
        }
        //metodi get

        public String getNome()
        {
            return nome;
        }

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
    private service.Fornitore maker ;
    public service(int id, String categoria, Fornitore maker)
    {
        this.id=id;
        this.categoria=categoria;
        this.maker=maker;

    }
    //METODI GET
    public int getId() { return id; }

    public String getCategoria()
    {
        return categoria;
    }

    public Fornitore getMaker() {return maker;   }

    //METODI SET
    public void setId(int id) { this.id = id;  }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public void setMaker(Fornitore maker) {this.maker = maker;    }
}