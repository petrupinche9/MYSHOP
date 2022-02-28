package it.model;

public class Product extends article
{
    private int id,corsia,scaffale;
    private String categoria;
    private String sottocategoria;
    private double costo;
    private int[][] magazzino;


    public class produttore
    {
        private String nome;
        private String sitoweb;
        private String citta;
        private String nazione;
        public produttore(String nome, String sitoweb, String citta, String nazione)
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
    private produttore prod ;
    private Product[] prodotto;
    public Product(int id, Product[] prodotto, String categoria, String sottocategoria, Double costo, int corsia, int scaffale, produttore prod)
    {
        this.id=id;
        this.prodotto= prodotto;
        this.prod = prod;
        this.categoria=categoria;
        this.costo=costo;
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

    public produttore getProd()
    {
        return prod;
    }

    public int[][] getMagazzino()
    {
        return magazzino;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public String getSottocategoria()
    {
        return sottocategoria;
    }

    public double getCosto()
    {
        return costo;
    }
    //METODI SET
    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public void setMagazzino(int[][] magazzino)
    {
        this.magazzino = magazzino;
    }

    public void setProd(produttore prod)
    {
        this.prod = prod;
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