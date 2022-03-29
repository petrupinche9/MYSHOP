package it.DAO;

import it.DbConnection;
import it.model.*;

import javax.swing.*;
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
    public void newproduct(Product p, Produttore prod, byte[] img){

        //insert articolo
        String res2 = "INSERT INTO articolo (Name,description,costo,Image_descr,category) VALUES ('"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"',  NULL ,'"+p.getCategory()+"');" ;
               // "SELECT C.idarticolo, C.Name, C.costo, C.Image_descr, C.description, C.category, U.subcategory, U.corsia, U.scaffale, U.Produttore_idProduttore FROM articolo AS C INNER JOIN product as U  ON U.idprodotto = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null, res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);
//aggiunta foto
        String img2="UPDATE articolo SET Image_descr=? WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' ;";
        DbConnection.getInstance().addFoto(img,img2);

        //insert prodotto
        String mngs = "INSERT INTO product (articolo_idarticolo) VALUES " +
                "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) );";
        JOptionPane.showMessageDialog(null, mngs);
        DbConnection.getInstance().eseguiAggiornamento(mngs);
        String uppr = "UPDATE product INNER JOIN articolo AS d ON articolo_idarticolo=d.idarticolo SET subcategory='"+p.getSottocategoria()+"', corsia='"+p.getCorsia()+"' , scaffale='"+p.getScaffale()+"'" +
                " WHERE d.idarticolo=(SELECT idarticolo FROM articolo  WHERE Name='"+p.getName()+"' AND description ='"+p.getDescr()+"' );";
        JOptionPane.showMessageDialog(null, uppr);
        DbConnection.getInstance().eseguiAggiornamento(uppr);

//insert produttore
        String produttore = "INSERT INTO Produttore (product_idproduct) VALUES ( (SELECT idproduct from product INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.Name='" + p.getName() + "' AND us.description ='" + p.getDescr() + "' ) ); ";
        JOptionPane.showMessageDialog(null, produttore);
        DbConnection.getInstance().eseguiAggiornamento(produttore);
        String prodfin = "UPDATE Produttore INNER JOIN product AS d ON product_idproduct=d.idproduct SET Name='"+prod.getNome()+"', Website='"+prod.getSitoweb()+"', citta='"+prod.getCitta()+"', Nazione ='"+prod.getNazione()+"'" +
                "WHERE d.idproduct=(SELECT idproduct from product INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE Name='"+p.getName()+"' AND description ='"+p.getDescr()+"'  );";
        JOptionPane.showMessageDialog(null, prodfin);
        DbConnection.getInstance().eseguiAggiornamento(prodfin);

        //conferma salvataggio
        ArrayList<String[]> id = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN product AS p ON idarticolo=p.articolo_idarticolo " +
                "WHERE name='"+p.getName()+"' AND category='"+p.getCategory()+"' AND p.corsia='"+p.getCorsia()+"' AND p.scaffale='"+p.getScaffale()+"'");

        if(id.size()==1) {
            String[] riga = id.get(0);
            JOptionPane.showMessageDialog(null,"PRODOTTO INSERITO CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
        }else{
            JOptionPane.showMessageDialog(null,"PRODOTTO NON INSERITO CORRETTAMENTE");
        }


    }


    @Override
    //aggiunta nuovo sottoprodotto
    public void newsubproduct(SubProduct p, Produttore prod, byte[] img, Product p2) {

        //insert articolo
        String res2 = "INSERT INTO articolo (Name,description,costo,Image_descr,category) VALUES ('"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"',  NULL ,'"+p.getCategory()+"');" ;
        // "SELECT C.idarticolo, C.Name, C.costo, C.Image_descr, C.description, C.category, U.subcategory, U.corsia, U.scaffale, U.Produttore_idProduttore FROM articolo AS C INNER JOIN product as U  ON U.idprodotto = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null, res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);
//aggiunta foto
        String img2="UPDATE articolo SET Image_descr=? WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' ;";
        DbConnection.getInstance().addFoto(img,img2);

        //insert prodotto
        String mngs = "INSERT INTO product (articolo_idarticolo) VALUES " +
                "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) );";
        JOptionPane.showMessageDialog(null, mngs);
        DbConnection.getInstance().eseguiAggiornamento(mngs);
        String uppr = "UPDATE product INNER JOIN articolo AS d ON articolo_idarticolo=d.idarticolo SET subcategory='"+p.getSottocategoria()+"', " +
                " WHERE d.idarticolo=(SELECT idarticolo FROM articolo  WHERE Name='"+p.getName()+"' AND description ='"+p.getDescr()+"' );";
        JOptionPane.showMessageDialog(null, uppr);
        DbConnection.getInstance().eseguiAggiornamento(uppr);

        //insert prodotto
        String sub = "INSERT INTO Subproduct (articolo_idarticolo,product_idproduct) VALUES " +
                "((SELECT idarticolo FROM articolo  WHERE Name='"+p.getName()+"' AND description ='"+p.getDescr()+"' )," +
                " (SELECT idproduct from product INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.Name='" + p2.getName() + "' AND us.description ='" + p2.getDescr() + "' ));";
        JOptionPane.showMessageDialog(null, sub);
        DbConnection.getInstance().eseguiAggiornamento(mngs);

//insert produttore
        String produttore = "INSERT INTO Produttore (product_idproduct) VALUES ( (SELECT idproduct from product INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.Name='" + p.getName() + "' AND us.description ='" + p.getDescr() + "' ) ); ";
        JOptionPane.showMessageDialog(null, produttore);
        DbConnection.getInstance().eseguiAggiornamento(produttore);
        String prodfin = "UPDATE Produttore INNER JOIN product AS d ON product_idproduct=d.idproduct SET Name='"+prod.getNome()+"', Website='"+prod.getSitoweb()+"', Citta='"+prod.getCitta()+"', Nazione ='"+prod.getNazione()+"'" +
                "WHERE d.idproduct=(SELECT idproduct from product INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE Name='"+p.getName()+"' AND description ='"+p.getDescr()+"'  );";
        JOptionPane.showMessageDialog(null, prodfin);
        DbConnection.getInstance().eseguiAggiornamento(prodfin);

        //conferma salvataggio
        ArrayList<String[]> id = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN product AS p  ON idarticolo=p.articolo_idarticolo INNER JOIN Subproduct AS ar ON p.idproduct=ar.product_idproduct  " +
                "WHERE name='"+p.getName()+"' AND category='"+p.getCategory()+"' AND p.corsia='"+p.getCorsia()+"' AND p.scaffale='"+p.getScaffale()+"'");

        if(id.size()==1) {
            String[] riga = id.get(0);
            JOptionPane.showMessageDialog(null,"SUBPRODOTTO INSERITO CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
        }else{
            JOptionPane.showMessageDialog(null,"SUBPRODOTTO NON INSERITO CORRETTAMENTE");
        }


    }

    @Override
    //inserisci nuovo servizio
    public void newservice( service p, Fornitore prod, byte[] img){

        //insert articolo
        String res2 = "INSERT INTO articolo (Name,description,costo,category) VALUES ('"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"' ,'"+p.getCategory()+"');" ;
        // "SELECT C.idarticolo, C.Name, C.costo, C.Image_descr, C.description, C.category, U.subcategory, U.corsia, U.scaffale, U.Produttore_idProduttore FROM articolo AS C INNER JOIN product as U  ON U.idprodotto = C.articolo_idarticolo ;";
        //VALUES ('"+p.getId()+"','"+p.getName()+"','"+p.getDescr()+"','"+p.getCosto()+"','"+p.getCategoria()+"', '"+p.getSottocategoria()+"','"+p.getCorsia()+"','"+p.getScaffale()+"','"+ Arrays.toString(p.getProdotto()) +"',); ";
        JOptionPane.showMessageDialog(null, res2);
        DbConnection.getInstance().eseguiAggiornamento(res2);
//aggiunta foto
        String img2="UPDATE articolo SET Image_descr=? WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' ;";
        DbConnection.getInstance().addFoto(img,img2);

        //insert prodotto
        String mngs = "INSERT INTO service (articolo_idarticolo) VALUES " +
                "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) );";
        JOptionPane.showMessageDialog(null, mngs);
        DbConnection.getInstance().eseguiAggiornamento(mngs);

//insert fornitore
        String produttore = "INSERT INTO Fornitore (service_idservice) VALUES ( (SELECT idservice from service INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.Name='" + p.getName() + "' AND us.description ='" + p.getDescr() + "' ) ); ";
        JOptionPane.showMessageDialog(null, produttore);
        DbConnection.getInstance().eseguiAggiornamento(produttore);
        String prodfin = "UPDATE Fornitore INNER JOIN service AS d ON service_idservice=d.idservice SET Name='"+prod.getNome()+"', Website='"+prod.getSitoweb()+"', Citta='"+prod.getCitta()+"', Nazione ='"+prod.getNazione()+"'" +
                "WHERE d.idservice=(SELECT idservice from service INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE Name='"+p.getName()+"' AND description ='"+p.getDescr()+"'  );";
        JOptionPane.showMessageDialog(null, prodfin);
        DbConnection.getInstance().eseguiAggiornamento(prodfin);

        //conferma salvataggio
        ArrayList<String[]> id = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN service AS ar ON idarticolo=ar.articolo_idarticolo " +
                "WHERE ar.name='"+p.getName()+"' AND ar.category='"+p.getCategory()+"' AND ar.description='"+p.getDescr()+"' ");

        if(id.size()==1) {
            String[] riga = id.get(0);
            JOptionPane.showMessageDialog(null,"SERVIZIO INSERITO CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
        }else{
            JOptionPane.showMessageDialog(null,"SERVIZIO NON INSERITO CORRETTAMENTE");
        }


    }

    @Override
    //elimina article (prodotto,servizio)
    public void erase_article(String name, String category){
        articleDAO a=new articleDAO();
        String res3 = "DELETE from articolo WHERE Name='" + name + "' AND category ='" + category + "' ; ";
        JOptionPane.showMessageDialog(null,res3);
        ArrayList<String[]> erase_article = DbConnection.getInstance().eseguiQuery(res3);
    }

    @Override
    //modifica prodotti
    public void mod_prodotti(Product p, int lastid_prod){

        String res = "UPDATE articolo INNER JOIN product as p ON p.articolo_idarticolo = idarticolo  " +
                "SET Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"',category'"+p.getCategory()+"' , p.subcategory='"+p.getSottocategoria()+"', p.corsia='"+p.getCorsia()+"',p.scaffale='"+p.getScaffale()+"'" +
                "WHERE d.idproduct=(SELECT idproduct from product INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.idarticolo='"+lastid_prod+"' );";
        DbConnection.getInstance().eseguiAggiornamento(res);
    }

    @Override
    //modifica servizi
    public void mod_servizi(service p, int lastid_serv){
        serviceDAO s=new serviceDAO();
        String res ="UPDATE articolo INNER JOIN service AS ar ON idarticolo = ar.articolo_idarticolo  " +
                "SET Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"',category ='"+p.getCategory()+"'" +
                "WHERE d.idservice=(SELECT idservice from service INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.idarticolo='"+lastid_serv+"' );";
        DbConnection.getInstance().eseguiAggiornamento(res);
    }

    @Override
    public void mod_produttore(Produttore prod, Produttore lastprod){
        //modifica produttore
        String forn = "UPDATE Produttore SET  Name='"+lastprod.getNome()+"',Website='"+lastprod.getSitoweb()+"',city='"+ lastprod.getCitta()+"',State='"+ lastprod.getNazione()+"' " +
                "WHERE Name='"+prod.getNome()+"'" ;
        DbConnection.getInstance().eseguiAggiornamento(forn);
    }

    @Override
    //modifica fornitore
    public void mod_fornitore(Fornitore f, Fornitore lastf){
        String forn = "UPDATE Fornitore INNER JOIN service as s ON idFornitore = s.Fornitore_idFornitore " +
                "SET  Name='"+lastf.getNome()+"',Website='"+lastf.getSitoweb()+"',city='"+ lastf.getCitta()+"',State='"+ lastf.getNazione()+"'" +
                "WHERE Name='"+f.getNome()+"'; ";
        DbConnection.getInstance().eseguiAggiornamento(forn);
    }
     public void add_article_to_catalogue(article ar){

     }

         @Override
    //crea punto vendita e manager
    public void create_shopandmanager(Point_shop shop, manager mng) {
             userDAO user = new userDAO();

             //crea manager
             String mng_sql = "INSERT INTO user (username,passwd,Name,Surname,Age,Email,telephone,occupation)" +
                     " VALUES ('" + mng.getUsername() + "','" + mng.getPassword() + "', '" + mng.getName() + "' , '" + mng.getSurname() + "', '" + mng.getAge() + "','" + mng.getEmail() + "','" + mng.getTelephone() + "','" + mng.getOccupation() + "')";
             JOptionPane.showMessageDialog(null, mng_sql);
             DbConnection.getInstance().eseguiAggiornamento(mng_sql);
             String mngs = "INSERT INTO manager (user_iduser) VALUES " +
                     "( (SELECT iduser from user WHERE username='" + mng.getUsername() + "' AND passwd ='" + mng.getPassword() + "' ) )";
             JOptionPane.showMessageDialog(null, mngs);
             DbConnection.getInstance().eseguiAggiornamento(mngs);
             //crea punto vendita
             String sh = "INSERT INTO Point_shop (Manager_idManager) VALUES " +
                     "( (SELECT idManager from Manager INNER JOIN user AS us ON us.iduser=user_iduser  WHERE us.username='" + mng.getUsername() + "' AND us.passwd ='" + mng.getPassword() + "' ) )";
             JOptionPane.showMessageDialog(null, sh);
             DbConnection.getInstance().eseguiAggiornamento(sh);
             //,(SELECT iduser from user WHERE username='"+mng.getUsername()+"' AND passwd ='"+mng.getPassword()+"' )
             String res3 = "UPDATE Point_shop AS s INNER JOIN manager AS d ON s.Manager_idManager=d.idManager SET s.Shopname='" + shop.getShopname() + "' , s.city='" + shop.getCity() + "' , s.article_type='" + shop.getArticle_type() + "'" +
                     "WHERE d.idManager=(SELECT idManager from Manager INNER JOIN user AS us ON us.iduser=user_iduser  WHERE us.username='"+mng.getUsername()+"' AND us.passwd ='"+mng.getPassword()+"' );";
             JOptionPane.showMessageDialog(null, res3);
             DbConnection.getInstance().eseguiAggiornamento(res3);
         }
    }

