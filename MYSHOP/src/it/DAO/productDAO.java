package it.DAO;

import it.DbConnection;
import it.model.Product;
import it.model.Produttore;

import javax.swing.*;
import java.util.ArrayList;

public class productDAO implements IproductDAO {
    @Override
 //trova prodotti da id
    public Product findById(int id) {
        Product c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Name, costo, description, category, U.subcategory, U.corsia, U.scaffale FROM articolo INNER JOIN product as U ON idarticolo = U.articolo_idarticolo  WHERE idarticolo = '"+id+"';");
        // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new Product();
            c.setId(id);
            c.setName(riga[0]);
            c.setCosto(Double.parseDouble(riga[1]));
            c.setDescr(riga[2]);
            c.setCategory(riga[3]);
            c.setSottocategoria(riga[4]);
            c.setCorsia(Integer.parseInt(riga[5]));
            c.setScaffale(Integer.parseInt(riga[6]));
            byte[] img = DbConnection.getInstance().getFoto("SELECT Image_descr FROM articolo_photo INNER JOIN articolo AS a ON articolo_idarticolo=a.idarticolo  WHERE idarticolo = '"+id+"'; ");  //parsing from string to byte
            c.setImg(img);
        }else{
            JOptionPane.showMessageDialog(null, "PRODOTTO NON TROVATO O INESISTENTE");
        }
        ArrayList<String[]> prod = DbConnection.getInstance().eseguiQuery("SELECT * FROM Produttore INNER JOIN Product AS p " +
                "ON  Product_idProduct=p.idProduct WHERE p.articolo_idarticolo='"+id+"'");
        if(prod.size()==1){
            Produttore p=new Produttore();
            String[] dio = prod.get(0);
            p.setId(Integer.parseInt(dio[0]));
            p.setNome(dio[1]);
            p.setSitoweb(dio[2]);
            p.setNazione(dio[3]);
            c.setProduttore(p);
        }else{
            JOptionPane.showMessageDialog(null, "PRODUTTORE NON TROVATO O INESISTENTE");
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
