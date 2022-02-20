import java.util.Scanner;

public class Product
{

    private String categoria;
    private String sottocategoria;
    private double costo;
    private int[][] magazzino;

    public Product() {

    }

    public class produttore {
       private String nome;
       private String sitoweb;
       private String citta;
       private String nazione;
       public produttore(String nome,
                         String sitoweb,
                         String citta,
                         String nazione) {

           this.nome = nome;
           this.sitoweb = sitoweb;
           this.citta = citta;
           this.nazione = nazione;
       }
       //metodi get
       public String getNome() {
           return nome;
       }

       public String getSitoweb() {
           return sitoweb;
       }

       public String getCitta() {
           return citta;
       }
       public String getNazione() {
           return nazione;
       }

       //metodi setter
       public void setNome(String nome) {
           this.nome = nome;
       }
       public void setSitoweb(String sitoweb) {
           this.sitoweb = sitoweb;
       }
       public void setCitta(String citta) {
           this.citta = citta;
       }
       public void setNazione(String nazione) {
           this.nazione = nazione;
       }
   }
private produttore prod ;
    private Product[] Prodotto;
   public Product(String categoria, String sottocategoria, Double costo,Product[] prodotto, int[][] magazzino, produttore prod){
       this.prod = prod;
       this.categoria=categoria;
       this.costo=costo;
       this.sottocategoria=sottocategoria;
       this.magazzino=magazzino;
       this.Prodotto=prodotto;
   }
 //METODI GET
    public Product[] getProdotto() {
        return Prodotto;
    }

    public produttore getProd(){
       return prod;
   }

    public int[][] getMagazzino() {
        return magazzino;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSottocategoria() {
        return sottocategoria;
    }

    public double getCosto() {
        return costo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setMagazzino(int[][] magazzino) {
        this.magazzino = magazzino;
    }

    public void setProd(produttore prod) {
        this.prod = prod;
    }

    //METODI SET

    public void setProdotto(Product[] prodotto) {
        Prodotto = prodotto;
    }

    public void setSottocategoria(String sottocategoria) {
        this.sottocategoria = sottocategoria;
    }


}
