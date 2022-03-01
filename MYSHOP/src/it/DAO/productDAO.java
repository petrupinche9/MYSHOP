package it.DAO;

import it.DbConnection;
import it.model.Product;

import java.util.ArrayList;

public abstract class productDAO implements IproductDAO {
 //trova prodotti da id
    public Product findById(int id) {
        Product c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.articolo_idarticolo, U.Name, U.description, U.costo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
       // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new Product();
            c.setId(Integer.parseInt(riga[0]));
            c.setName(riga[1]);
            c.setCosto(Double.parseDouble(riga[2]));
            byte[] img = riga[3].getBytes();  //parsing from string to byte
            c.setImg(img);
        }

        return c;
    }
    //trova tutti i prodotti
    public ArrayList<Product> findAll() {

        ArrayList<Product> c =new ArrayList<Product>() ;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idproduct FROM product ;");
        for(String[] riga : res) {
            Product p = findById(Integer.parseInt(riga[0]));
            c.add(p);
        }

        return c;
    }
    // TODO metodi estensione per funzionalità utenti con prodotti e servizi

}
