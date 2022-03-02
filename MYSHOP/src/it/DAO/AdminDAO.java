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
    public void newproduct(Product p, Produttore prod){
        JFrame frame = new JFrame();
        productDAO pro=new productDAO();
        String res2 = "INSERT INTO product ('"+p.getName()+"','"+p.getCosto()+"', NULL , '"+p.getDescr()+"', '"+p.getSottocategoria()+"', '"+p.getCorsia()+"', '"+p.getScaffale()+"', '"+p.getProduttore()+"')" +
                "SELECT C.Name, C.costo, C.Image_descr, C.description, U.subcategory, U.corsia, U.scaffale, U.Produttore FROM articolo AS C INNER JOIN product as U  ON U.idprodotto = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showInputDialog(res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);

        //insert produttore
       // String res3="INSERT INTO produttore ('"+prod.getNome()+"','"+prod.getSitoweb()+"','"+ prod.getCitta()+"','"+ prod.getNazione()+"')" +
          //      "SELECT U.Name, U.Website, U.city, U.state FROM product AS U INNER JOIN produttore as P ON P.idprodotto = U.Produttore_idProduttore ";
        String res3="SELECT 1 FROM produttore AS prod INNER JOIN product AS P ON prod.idproduttore=P.Produttore_idProduttore" +
                " INSERT INTO produttore SET Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"',idprodotto='"+findById(p.getId())+"' ;" ;
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
    //aggiunta nuovo sottoprodotto
    public void newsubproduct( Product p,Produttore prod) {
        JFrame frame = new JFrame();
        productDAO pro = new productDAO();
        String res2 = "INSERT INTO Subproduct ('" + p.getName() + "','" + p.getCosto() + "', NULL , '" + p.getDescr() + "', '" + p.getSottocategoria() + "', '" + p.getCorsia() + "', '" + p.getScaffale() + "', '" + p.getProduttore() + "')" +
                "SELECT C.articolo_idarticolo, C.Name, C.costo, C.Image_descr, C.description, U.subcategory, U.corsia, U.scaffale, U.Produttore FROM product AS U INNER JOIN product as C INNER JOIN articolo as S INNER JOIN Subproduct ON S.idSubproduct = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showInputDialog(res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);

        //inserimento produttore
        String res3="SELECT 1 FROM produttore AS prod INNER JOIN product AS P ON prod.idproduttore=P.Produttore_idProduttore" +
                " INSERT INTO produttore SET Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"',idprodotto='"+pro.findById(p.getId())+"')" ;
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

    //inserisci nuovo servizio
    public void newservice( service p, Fornitore prod){
        JFrame frame1 = new JFrame();
        serviceDAO serv= new serviceDAO();
        String res2 = "INSERT INTO service ('"+p.getName()+"','"+p.getCosto()+"', NULL , '"+p.getDescr()+"', '"+p.getCategory()+"')" +
                "SELECT C.Name, C.costo, C.Image_descr, C.description FROM articolo AS C INNER JOIN service as U  ON U.idservice = C.articolo_idarticolo ;";
        JOptionPane.showInputDialog(res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);
      //aggiunta fornitore
        String res3="SELECT 1 FROM Fornitore AS forn INNER JOIN service AS serv ON forn.idFornitore=serv.Fornitore_idFornitore" +
                " INSERT INTO produttore SET Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"', idservizio='"+serv.findById(p.getId())+"')" ;
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

    //elimina article (prodotto,servizio)
    public void erase_product( article p){
        articleDAO a=new articleDAO();
        String res3 = "DELETE FROM article WHERE idarticle = '"+a.findById(p.getId())+"';";
        JOptionPane.showInputDialog(res3);
        DbConnection.getInstance().eseguiAggiornamento(res3);
    }


    //modifica prodotti
    public void mod_prodotti(Product p, Produttore prod){
        productDAO s=new productDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE product INNER JOIN articolo ON idprodotto = articolo_idarticolo WHERE articolo_idarticolo = "+findById(p.getId())+" " +
                "SET Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"',category'"+p.getCategoria()+"' , product.subcategory='"+p.getSottocategoria()+"', product.corsia='"+p.getCorsia()+"',product.scaffale='"+p.getScaffale()+"';");
        //modifica produttore
        ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("UPDATE Fornitore INNER JOIN service ON idFornitore = Fornitore_idFornitore WHERE idservizio= '"+findById(p.getId())+"'" +
                "SET Name='"+prod.getNome()+"',Website='"+prod.getSitoweb()+"',city='"+ prod.getCitta()+"',State='"+ prod.getNazione()+"', idservizio='"+s.findById(p.getId())+"'");
    }

    //modifica servizi
    public void mod_servizi(service p, Fornitore f){
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE service INNER JOIN articolo ON idservice = articolo_idarticolo WHERE articolo_idarticolo = '"+findById(p.getId())+"' " +
                "SET Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"';");
        //modifica fornitore
        ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("UPDATE Fornitore INNER JOIN service ON idFornitore = Fornitore_idFornitore WHERE idservizio= '"+findById(p.getId())+"'" +
                "SET Name='"+f.getNome()+"',Website='"+f.getSitoweb()+"',city='"+ f.getCitta()+"',State='"+ f.getNazione()+"', idservizio='"+findById(p.getId())+"'");

    }

    // TODO metodi estensione per gestione punti vendita e manager
}
