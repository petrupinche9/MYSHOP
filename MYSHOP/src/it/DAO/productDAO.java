package it.DAO;

import it.DbConnection;
import it.model.Product;

import java.util.ArrayList;

public class productDAO implements IproductDAO {
    @Override
 //trova prodotti da id
    public Product findById(int id) {
        Product c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.articolo_idarticolo, C.Name, C.costo, C.Image_descr, C.description, U.subcategory, U.corsia, U.scaffale, U.Produttore FROM articolo AS C INNER JOIN product as U  ON C.idarticolo = U.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new Product();
            c.setId(Integer.parseInt(riga[0]));
            c.setName(riga[1]);
            c.setCosto(Double.parseDouble(riga[2]));
            byte[] img = riga[3].getBytes();  //parsing from string to byte
            c.setImg(img);
            c.setDescr(riga[4]);
            c.setSottocategoria(riga[5]);
            c.setCorsia(Integer.parseInt(riga[6]));
            c.setScaffale(Integer.parseInt(riga[7]));

        }

        return c;
    }
    @Override
    //trova tutti i prodotti
    public ArrayList<Product> findAll() {

        ArrayList<Product> c =new ArrayList<Product>() ;

        ArrayList<String[]> res1 = DbConnection.getInstance().eseguiQuery("SELECT idproduct FROM product ;");
        for(String[] riga : res1) {
            Product p = findById(Integer.parseInt(riga[0]));
            c.add(p);
        }

        return c;
    }


}
