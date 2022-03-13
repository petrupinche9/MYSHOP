package it.DAO;

import it.DbConnection;
import it.model.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class AdminDAO implements IAdminDAO{
    @Override
    public Admin findById(int id) {
        return null;
    }

    @Override
    public ArrayList<Admin> findAll() {
        return null;
    }

    //inserisci nuovo prodotto
    @Override
    public void newproduct(Product p, Produttore prod, File img){

        productDAO pro=new productDAO();
        String res2 = "INSERT INTO product ('"+p.getId()+"','"+p.getName()+"','"+p.getCosto()+"',  LOAD_FILE('"+img+"') ,'"+p.getCategoria()+"', '"+p.getDescr()+"', '"+p.getSottocategoria()+"', '"+p.getCorsia()+"', '"+p.getScaffale()+"','"+prod.getId()+"' )" +
                "SELECT C.idarticolo, C.Name, C.costo, C.Image_descr, C.description, C.category, U.subcategory, U.corsia, U.scaffale, U.Produttore_idProduttore FROM articolo AS C INNER JOIN product as U  ON U.idprodotto = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null,res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);

        //insert produttore
       // String res3="INSERT INTO produttore ('"+prod.getNome()+"','"+prod.getSitoweb()+"','"+ prod.getCitta()+"','"+ prod.getNazione()+"')" +
          //      "SELECT U.Name, U.Website, U.city, U.state FROM product AS U INNER JOIN produttore as P ON P.idprodotto = U.Produttore_idProduttore ";
        // "SELECT 1 FROM produttore AS prod INNER JOIN product AS P ON prod.idproduttore=P.Produttore_idProduttore" +
        String res3= "INSERT INTO produttore ('"+prod.getId()+"','"+prod.getNome()+"','"+prod.getNazione()+"','"+prod.getSitoweb()+"')" +
                "SELECT prod.idPropduttore, prod.Name, prod.Website, prod.Nazione FROM Produttore AS prod INNER JOIN Product AS P ON prod.idProduttore = P.Produttore.idProduttore ;";
        DbConnection.getInstance().eseguiAggiornamento(res3);
//aggiunta foto
        String img2="INSERT INTO article (Image_descr) WHERE idarticolo='"+p.getId()+"'";
        DbConnection.getInstance().addFoto(img,img2);

    }


    @Override
    //aggiunta nuovo sottoprodotto
    public void newsubproduct(SubProduct p, Produttore prod, File img) {
        JFrame frame = new JFrame();
        productDAO pro = new productDAO();
        String res2 = "INSERT INTO Subproduct ('"+p.getId()+"','" + p.getName() + "','" + p.getCosto() + "',NULL, '" + p.getDescr() + "','" +p.getCategory()+ "','" +p.getSottocategoria()+ "', '"+p.getCorsia()+"', '"+p.getScaffale()+"')" +
                "SELECT S.idSubproduct, C.Name, C.costo, C.Image_descr, C.description, C.category, U.subcategory, U.corsia, U.scaffale FROM article AS C INNER JOIN product as U ON U.idproduct=C.product_idproduct INNER JOIN Subproduct as S ON U.idproduct = S.product_idproduct ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null,res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);

        //inserimento produttore
        String res3="SELECT 1 FROM produttore AS prod INNER JOIN product AS P ON prod.idproduttore=P.Produttore_idProduttore" +
                " INSERT INTO produttore SET prod.idProduttore= '"+prod.getId()+"', prod.Name='"+prod.getNome()+"', prod.Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"',idprodotto='"+pro.findById(p.getId())+"')" ;
        DbConnection.getInstance().eseguiAggiornamento(res3);
//aggiunta foto
        String img2="INSERT INTO article (Image_descr) WHERE idarticolo='"+p.getId()+"'";
        DbConnection.getInstance().addFoto(img,img2);
    }

    @Override
    //inserisci nuovo servizio
    public void newservice( service p, Fornitore prod, File img){
        JFrame frame1 = new JFrame();
        serviceDAO serv= new serviceDAO();
        String res2 = "INSERT INTO service ('"+p.getId()+"','"+p.getName()+"','"+p.getCosto()+"', NULL , '"+p.getDescr()+"', '"+p.getCategory()+"')" +
                "SELECT U.idservice, C.Name, C.costo, C.Image_descr, C.description, C.category FROM articolo AS C INNER JOIN service as U  ON U.idservice = C.service_idservice ;";
        JOptionPane.showMessageDialog(null,res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);
      //aggiunta fornitore
        String res3="SELECT 1 FROM Fornitore AS forn INNER JOIN service AS serv ON forn.idFornitore=serv.Fornitore_idFornitore" +
                " INSERT INTO produttore SET idFornitore='"+prod.getId()+"', Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"', idservizio='"+serv.findById(p.getId())+"')" ;
        DbConnection.getInstance().eseguiAggiornamento(res3);

        //aggiunta foto
        String img2="INSERT INTO article (Image_descr) WHERE idarticolo='"+p.getId()+"'";
        DbConnection.getInstance().addFoto(img,img2);
    }

    @Override
    //elimina article (prodotto,servizio)
    public void erase_article(int id){
        articleDAO a=new articleDAO();
        String res3 = "DELETE FROM article WHERE idarticle = '"+a.findById(id).getId()+"';";
        JOptionPane.showMessageDialog(null,res3);
        DbConnection.getInstance().eseguiAggiornamento(res3);
    }

    @Override
    //modifica prodotti
    public void mod_prodotti(Product p, Produttore prod){
        productDAO s=new productDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE product as p INNER JOIN articolo as ar ON p.idproduct = as.product_idproduct  " +
                "SET idproduct='"+p.getId()+"', Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"',category'"+p.getCategoria()+"' , product.subcategory='"+p.getSottocategoria()+"', product.corsia='"+p.getCorsia()+"',product.scaffale='"+p.getScaffale()+"'" +
                "WHERE ar.product_idproduct = "+p.getId()+";");
        //modifica produttore
        ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("UPDATE Produttore AS pro INNER JOIN product AS prd ON pro.idProduttore = Produttore_idProduttore WHERE pro.idProduttore= '"+s.findById(p.getId())+"'" +
                "SET idProduttore='"+prod.getId()+"', Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"';");
    }

    //modifica servizi
    @Override
    public void mod_servizi(service p, Fornitore f){
        serviceDAO s=new serviceDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE service AS s INNER JOIN articolo AS ar ON s.idservice = ar.articolo_idarticolo  " +
                "SET idservice='"+p.getId()+"', Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"'" +
                "WHERE s.articolo_idarticolo = '"+s.findById(p.getId())+"';");
        //modifica fornitore
        ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("UPDATE Fornitore INNER JOIN service ON idFornitore = Fornitore_idFornitore " +
                "SET idFornitore='"+f.getId()+"', Name='"+f.getNome()+"',Website='"+f.getSitoweb()+"',city='"+ f.getCitta()+"',State='"+ f.getNazione()+"', idservizio='"+s.findById(p.getId())+"'" +
                "WHERE idservizio= '"+s.findById(p.getId())+"';");
    }

     public void add_article_to_catalogue(article ar){

     }

         @Override
//crea punto vendita e manager
    public void create_shopandmanager(Point_shop shop, manager mng){
        userDAO user=new userDAO();
        String res3 = "INSERT INTO Point_shop VALUES ('"+shop.getId()+"','"+shop.getShopname()+"','"+shop.getCity()+"','"+shop.getArticle_type()+"','"+mng.getId()+"');";
        JOptionPane.showMessageDialog(null,res3);
        DbConnection.getInstance().eseguiAggiornamento(res3);
        //crea manager
        String mng_sql = "INSERT INTO Manager ('"+mng.getId()+"','"+mng.getUsername()+"','"+mng.getPassword()+"', '"+mng.getName()+"' , '"+mng.getSurname()+"', '"+mng.getAge()+"','"+mng.getEmail()+"','"+mng.getTelephone()+"','"+mng.getOccupation()+"','"+shop.getId()+"')" +
                "SELECT us.iduser, us.Username, us.passwd, us.Name, us.Surname, us.Age, us.Email, us.telephone, us.occupation, mng.Point_shop_idPoint_shop, FROM user AS us INNER JOIN Manager as mng ON us.iduser = mng.user_iduser WHERE us.iduser='"+user.findById(mng.getId())+"'  ;";
        JOptionPane.showMessageDialog(null,mng_sql);
        DbConnection.getInstance().eseguiAggiornamento(mng_sql);
    }
}
