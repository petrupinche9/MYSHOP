package it.DAO;

import it.DbConnection;
import it.model.Point_shop;

import java.util.ArrayList;

public class ShopDAO implements IShopDAO{
    @Override
    public Point_shop findById(int id) {
        Point_shop c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM Point_shop WHERE idPoint_shop = "+id+";");
        // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new Point_shop();
            c.setId(Integer.parseInt(riga[0]));
            c.setShopname(riga[1]);
            c.setCity(riga[2]);
            c.setArticle_type(riga[3]);
            ImanagerDAO mDAO=new managerDAO();
            c.setMng(mDAO.findById(Integer.parseInt(riga[4])));
        }

        return c;
    }
    @Override
    //trova tutti i prodotti
    public ArrayList<Point_shop> findAll() {

        ArrayList<Point_shop> c =new ArrayList<Point_shop>() ;

        ArrayList<String[]> res1 = DbConnection.getInstance().eseguiQuery("SELECT idproduct FROM product ;");
        for(String[] riga : res1) {
            Point_shop p = findById(Integer.parseInt(riga[0]));
            c.add(p);
        }

        return c;
    }

}
