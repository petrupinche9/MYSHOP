package it.DAO;

import it.DbConnection;
import it.model.*;
import it.view.Manager;

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
    public void newproduct(Product p, Produttore prod){
        JFrame frame = new JFrame();
        productDAO pro=new productDAO();
        String res2 = "INSERT INTO product ('"+p.getId()+"','"+p.getName()+"','"+p.getCosto()+"', NULL , '"+p.getDescr()+"', '"+p.getSottocategoria()+"', NULL, NULL)" +
                "SELECT C.idarticolo, C.Name, C.costo, C.Image_descr, C.description, U.subcategory, U.corsia, U.scaffale, U.Produttore FROM articolo AS C INNER JOIN product as U  ON U.idprodotto = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null,res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);

        //insert produttore
       // String res3="INSERT INTO produttore ('"+prod.getNome()+"','"+prod.getSitoweb()+"','"+ prod.getCitta()+"','"+ prod.getNazione()+"')" +
          //      "SELECT U.Name, U.Website, U.city, U.state FROM product AS U INNER JOIN produttore as P ON P.idprodotto = U.Produttore_idProduttore ";
        String res3="SELECT 1 FROM produttore AS prod INNER JOIN product AS P ON prod.idproduttore=P.Produttore_idProduttore" +
                " INSERT INTO produttore SET idProduttore='"+prod.getId()+"', Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"',idprodotto='"+findById(p.getId())+"' ;" ;
        DbConnection.getInstance().eseguiAggiornamento(res3);

        //aggiunta foto
        String img2="INSERT INTO article (Image_descr) WHERE idarticolo='"+pro.findById(p.getId())+"'";
        String filename = File.separator+"tmp";
        JFileChooser fc = new JFileChooser(new File(filename));
        // Show open dialog; this method does not return until the dialog is closed
        fc.showOpenDialog(frame);
        File selFile = fc.getSelectedFile();
        DbConnection.getInstance().addFoto(selFile,img2);
    }
    @Override
    //aggiunta nuovo sottoprodotto
    public void newsubproduct( Product p,Produttore prod) {
        JFrame frame = new JFrame();
        productDAO pro = new productDAO();
        String res2 = "INSERT INTO Subproduct ('"+p.getId()+"','" + p.getName() + "','" + p.getCosto() + "', NULL , '" + p.getDescr() + "', '" + p.getSottocategoria() + "', NULL, NULL)" +
                "SELECT S.idSubproduct, C.Name, C.costo, C.Image_descr, C.description, U.subcategory, U.corsia, U.scaffale FROM article AS C INNER JOIN product as U ON U.idproduct=C.product_idproduct INNER JOIN Subproduct as S ON U.idproduct = S.product_idproduct ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null,res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);

        //inserimento produttore
        String res3="SELECT 1 FROM produttore AS prod INNER JOIN product AS P ON prod.idproduttore=P.Produttore_idProduttore" +
                " INSERT INTO produttore SET idProduttore= '"+prod.getId()+"', Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"',idprodotto='"+pro.findById(p.getId())+"')" ;
        DbConnection.getInstance().eseguiAggiornamento(res3);

        //aggiunta foto
        String img2 = "INSERT INTO article (Image_descr) WHERE idarticolo='" + pro.findById(p.getId()) + "'";
        String filename = File.separator + "tmp";
        JFileChooser fc = new JFileChooser(new File(filename));
        // Show open dialog; this method does not return until the dialog is closed
        fc.showOpenDialog(frame);
        File selFile = fc.getSelectedFile();
        DbConnection.getInstance().addFoto(selFile, img2);
    }
    @Override
    //inserisci nuovo servizio
    public void newservice( service p, Fornitore prod){
        JFrame frame1 = new JFrame();
        serviceDAO serv= new serviceDAO();
        String res2 = "INSERT INTO service ('"+p.getId()+"','"+p.getName()+"','"+p.getCosto()+"', NULL , '"+p.getDescr()+"', '"+p.getCategory()+"')" +
                "SELECT U.idservice, C.Name, C.costo, C.Image_descr, C.description FROM articolo AS C INNER JOIN service as U  ON U.idservice = C.service_idservice ;";
        JOptionPane.showMessageDialog(null,res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);
      //aggiunta fornitore
        String res3="SELECT 1 FROM Fornitore AS forn INNER JOIN service AS serv ON forn.idFornitore=serv.Fornitore_idFornitore" +
                " INSERT INTO produttore SET idFornitore='"+prod.getId()+"', Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"', idservizio='"+serv.findById(p.getId())+"')" ;
        DbConnection.getInstance().eseguiAggiornamento(res3);

        //aggiunta foto
        String img2="INSERT INTO article (Image_descr) WHERE idarticolo='"+serv.findById(p.getId())+"'";
        String filename = File.separator+"tmp";
        JFileChooser fc = new JFileChooser(new File(filename));
        // Show open dialog; this method does not return until the dialog is closed
        fc.showOpenDialog(frame1);
        File selFile = fc.getSelectedFile();
        DbConnection.getInstance().addFoto(selFile,img2);
    }
    @Override
    //elimina article (prodotto,servizio)
    public void erase_article( article p){
        articleDAO a=new articleDAO();
        String res3 = "DELETE FROM article WHERE idarticle = '"+p.getId()+"';";
        JOptionPane.showMessageDialog(null,res3);
        DbConnection.getInstance().eseguiAggiornamento(res3);
    }

    @Override
    //modifica prodotti
    public void mod_prodotti(Product p, Produttore prod){
        productDAO s=new productDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE product as p INNER JOIN articolo as ar ON p.idproduct = as.product_idproduct WHERE product_idproduct = "+p.getId()+" " +
                "SET idproduct='"+p.getId()+"', Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"',category'"+p.getCategoria()+"' , product.subcategory='"+p.getSottocategoria()+"', product.corsia='"+p.getCorsia()+"',product.scaffale='"+p.getScaffale()+"';");
        //modifica produttore
        ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("UPDATE Produttore AS pro INNER JOIN product AS prd ON pro.idProduttore = Produttore_idProduttore WHERE pro.idProduttore= '"+s.findById(p.getId())+"'" +
                "SET idProduttore='"+prod.getId()+"', Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"';");
    }

    //modifica servizi
    @Override
    public void mod_servizi(service p, Fornitore f){
        serviceDAO s=new serviceDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE service AS s INNER JOIN articolo AS ar ON s.idservice = ar.articolo_idarticolo WHERE s.articolo_idarticolo = '"+s.findById(p.getId())+"' " +
                "SET idservice='"+p.getId()+"', Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"';");
        //modifica fornitore
        ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("UPDATE Fornitore INNER JOIN service ON idFornitore = Fornitore_idFornitore WHERE idservizio= '"+s.findById(p.getId())+"'" +
                "SET idFornitore='"+f.getId()+"', Name='"+f.getNome()+"',Website='"+f.getSitoweb()+"',city='"+ f.getCitta()+"',State='"+ f.getNazione()+"', idservizio='"+s.findById(p.getId())+"'");

    }
    @Override
//crea punto vendita e manager
    public void create_shopandmanager(Point_shop shop, Manager mng){
        userDAO user=new userDAO();
        String res3 = "INSERT INTO Point_shop VALUES ('"+shop.getId()+"','"+shop.getShopname()+"','"+shop.getCity()+"','"+shop.getArticle_type()+"');";
        JOptionPane.showMessageDialog(null,res3);
        DbConnection.getInstance().eseguiAggiornamento(res3);
        //crea manager
        String mng_sql = "INSERT INTO Manager ('"+mng.getId()+"','"+mng.getUsername()+"','"+mng.getPassword()+"', '"+mng.getName()+"' , '"+mng.getSurname()+"', '"+mng.getAge()+"','"+mng.getEmail()+"','"+mng.getTelephone()+"','"+mng.getOccupation()+"','"+shop.getId()+"')" +
                "SELECT us.iduser, us.Username, us.passwd, us.Name, us.Surname, us.Age, us.Email, us.telephone, us.occupation, mng.Point_shop_idPoint_shop, FROM user AS us INNER JOIN Manager as mng ON us.iduser = mng.Manager_idManager WHERE us.iduser='"+user.findById(mng.getId())+"'  ;";
        JOptionPane.showMessageDialog(null,mng_sql);
        DbConnection.getInstance().eseguiAggiornamento(mng_sql);
    }
}
