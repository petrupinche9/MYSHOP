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
//PRODOTTO ESISTE GIà?
        ArrayList<String[]> check = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN product AS p ON idarticolo=p.articolo_idarticolo " +
                "WHERE name='"+p.getName()+"'  AND p.corsia='"+p.getCorsia()+"' AND p.scaffale='"+p.getScaffale()+"';");

        if(check.size()==1) {
            String[] riga = check.get(0);
            JOptionPane.showMessageDialog(null,"PRODOTTO GIA' PRESENTE CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
        }else {

            //insert articolo
            String res2 = "INSERT INTO articolo (Name,description,costo,category) VALUES " +
                    "('" + p.getName() + "','" + p.getDescr() + "','" + p.getCosto() + "','" + p.getCategory() + "');";
            JOptionPane.showMessageDialog(null, res2);
            DbConnection.getInstance().eseguiAggiornamento(res2);
//aggiunta foto
            String img2 = "INSERT INTO articolo_photo (Image_descr,articolo_idarticolo) VALUES (?," +
                    "(SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) )  ;";
            DbConnection.getInstance().addFoto(img, img2);
//CHECK PRODUTTORE E INSERIMENTO NUOVO PRODUTTORE
            ArrayList<String[]> check_prod = DbConnection.getInstance().eseguiQuery("SELECT idproduttore FROM produttore  " +
                    " WHERE Name='" + prod.getNome() + "' AND Website='" + prod.getSitoweb() + "' AND citta='" + prod.getCitta() + "' AND Nazione ='" + prod.getNazione() + "';");

            if(check_prod.size()==1) {
                String[] riga = check_prod.get(0);
                JOptionPane.showMessageDialog(null,"PRODOTTURE GIA' PRESENTE CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
                String mngs = "INSERT INTO product (articolo_idarticolo,Produttore_idProduttore) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "  '"+Integer.parseInt(riga[0])+"');";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);
                String uppr = "UPDATE product INNER JOIN articolo AS d ON articolo_idarticolo=d.idarticolo SET subcategory='" + p.getSottocategoria() + "', corsia='" + p.getCorsia() + "' , scaffale='" + p.getScaffale() + "'" +
                        " WHERE d.idarticolo=(SELECT idarticolo FROM articolo  WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' );";
                JOptionPane.showMessageDialog(null, uppr);
                DbConnection.getInstance().eseguiAggiornamento(uppr);
            }else {
                //insert produttore
                String prodfin = "INSERT INTO Produttore (Name,Website,citta,Nazione) VALUES ('" + prod.getNome() + "', '" + prod.getSitoweb() + "', '" + prod.getCitta() + "',  '" + prod.getNazione() + "');" ;
                JOptionPane.showMessageDialog(null, prodfin);
                DbConnection.getInstance().eseguiAggiornamento(prodfin);
                //insert prodotto
                String mngs = "INSERT INTO product (articolo_idarticolo, Produttore_idProduttore) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "(SELECT idproduttore from produttore where Name='"+prod.getNome()+"' AND Website='"+prod.getSitoweb()+"' AND citta='"+prod.getCitta()+"' AND Nazione='"+prod.getNazione()+"' ) );";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);
                String uppr = "UPDATE product INNER JOIN articolo AS d ON articolo_idarticolo=d.idarticolo SET subcategory='" + p.getSottocategoria() + "', corsia='" + p.getCorsia() + "' , scaffale='" + p.getScaffale() + "'" +
                        " WHERE d.idarticolo=(SELECT idarticolo FROM articolo  WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' );";
                JOptionPane.showMessageDialog(null, uppr);
                DbConnection.getInstance().eseguiAggiornamento(uppr);

            }
            //conferma salvataggio
            ArrayList<String[]> id = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN product AS p ON idarticolo=p.articolo_idarticolo " +
                    "WHERE name='" + p.getName() + "' AND category='" + p.getCategory() + "' AND p.corsia='" + p.getCorsia() + "' AND p.scaffale='" + p.getScaffale() + "'");

            if (id.size() == 1) {
                String[] riga = id.get(0);
                JOptionPane.showMessageDialog(null, "PRODOTTO INSERITO CON MATRICOLA ==> " + Integer.parseInt(riga[0]) + "");
            } else {
                JOptionPane.showMessageDialog(null, "PRODOTTO NON INSERITO CORRETTAMENTE");
            }
        }

    }


    @Override
    //aggiunta nuovo sottoprodotto
    public void newsubproduct(SubProduct p, Produttore prod, byte[] img, Product p2) {
        //PRODOTTO ESISTE GIà?
        ArrayList<String[]> check = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN product AS p ON idarticolo=p.articolo_idarticolo " +
                "WHERE name='"+p.getName()+"'  AND p.corsia='"+p.getCorsia()+"' AND p.scaffale='"+p.getScaffale()+"';");

        if(check.size()==1) {
            String[] riga = check.get(0);
            JOptionPane.showMessageDialog(null,"SUBPRODOTTO GIA' PRESENTE CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
        }else {

            //insert articolo subprodotto
            String res2 = "INSERT INTO articolo (Name,description,costo,category) VALUES " +
                    "('" + p.getName() + "','" + p.getDescr() + "','" + p.getCosto() + "','" + p.getCategory() + "');";
            JOptionPane.showMessageDialog(null, res2);
            DbConnection.getInstance().eseguiAggiornamento(res2);
//aggiunta foto
            String img2 = "INSERT INTO articolo_photo (Image_descr,articolo_idarticolo) VALUES (?," +
                    "(SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) )  ;";
            DbConnection.getInstance().addFoto(img, img2);

//CHECK PRODUTTORE E INSERIMENTO NUOVO PRODUTTORE
            ArrayList<String[]> check_prod = DbConnection.getInstance().eseguiQuery("SELECT idproduttore FROM produttore  " +
                    " WHERE Name='" + prod.getNome() + "' AND Website='" + prod.getSitoweb() + "' AND citta='" + prod.getCitta() + "' AND Nazione ='" + prod.getNazione() + "';");

            if(check_prod.size()==1) {
                String[] riga = check_prod.get(0);
                JOptionPane.showMessageDialog(null,"PRODUTTURE GIA' PRESENTE CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");

                String mngs = "INSERT INTO product (articolo_idarticolo,Produttore_idProduttore) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "  '"+Integer.parseInt(riga[0])+"');";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);

                String uppr = "UPDATE product INNER JOIN articolo AS d ON articolo_idarticolo=d.idarticolo SET subcategory='" + p.getSottocategoria() + "'" +
                        " WHERE d.idarticolo=(SELECT idarticolo FROM articolo  WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' );";
                JOptionPane.showMessageDialog(null, uppr);
                DbConnection.getInstance().eseguiAggiornamento(uppr);

                String SUB = "INSERT INTO Subproduct (articolo_idarticolo,Product_idProduct) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "  (SELECT idproduct from product INNER JOIN articolo AS a WHERE a.Name='" + p2.getName() + "' AND a.description ='" + p2.getDescr() + "' AND subcategory='"+p2.getSottocategoria()+"' AND corsia='"+p2.getCorsia()+"' AND scaffale='"+p2.getScaffale()+"'));";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);

            }else {
                //insert produttore
                String prodfin = "INSERT INTO Produttore (Name,Website,citta,Nazione) VALUES ('" + prod.getNome() + "', '" + prod.getSitoweb() + "', '" + prod.getCitta() + "',  '" + prod.getNazione() + "');" ;
                JOptionPane.showMessageDialog(null, prodfin);
                DbConnection.getInstance().eseguiAggiornamento(prodfin);

                ArrayList<String[]> prodii = DbConnection.getInstance().eseguiQuery("SELECT idproduttore FROM produttore  " +
                        " WHERE Name='" + prod.getNome() + "' AND Website='" + prod.getSitoweb() + "' AND citta='" + prod.getCitta() + "' AND Nazione ='" + prod.getNazione() + "';");
                String[] riga = check_prod.get(0);
                String mngs = "INSERT INTO product (articolo_idarticolo,Produttore_idProduttore) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "  '"+Integer.parseInt(riga[0])+"');";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);

                String uppr = "UPDATE product INNER JOIN articolo AS d ON articolo_idarticolo=d.idarticolo SET subcategory='" + p.getSottocategoria() + "'" +
                        " WHERE d.idarticolo=(SELECT idarticolo FROM articolo  WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "' );";
                JOptionPane.showMessageDialog(null, uppr);
                DbConnection.getInstance().eseguiAggiornamento(uppr);

                String SUB = "INSERT INTO Subproduct (articolo_idarticolo,Product_idProduct) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "  (SELECT idproduct from product INNER JOIN articolo AS a WHERE a.Name='" + p2.getName() + "' AND a.description ='" + p2.getDescr() + "' AND subcategory='"+p2.getSottocategoria()+"' AND corsia='"+p2.getCorsia()+"' AND scaffale='"+p2.getScaffale()+"'));";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);

            }
            //conferma salvataggio
            ArrayList<String[]> id = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN Subproduct AS p ON idarticolo=p.articolo_idarticolo " +
                    "WHERE name='" + p.getName() + "' AND category='" + p.getCategory() + "' ;");

            if (id.size() == 1) {
                String[] riga = id.get(0);
                JOptionPane.showMessageDialog(null, "SUBPRODOTTO INSERITO CON MATRICOLA ==> " + Integer.parseInt(riga[0]) + "");
            } else {
                JOptionPane.showMessageDialog(null, "SUBPRODOTTO NON INSERITO CORRETTAMENTE");
            }
        }

    }

    @Override
    //inserisci nuovo servizio
    public void newservice( service p, Fornitore prod, byte[] img){
        //PRODOTTO ESISTE GIà?
        ArrayList<String[]> check = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo  " +
                "WHERE name='"+p.getName()+"' AND description='"+p.getDescr()+"';");

        if(check.size()==1) {
            String[] riga = check.get(0);
            JOptionPane.showMessageDialog(null,"SERVIZIO GIA' PRESENTE CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
        }else {

            //insert articolo
            String res2 = "INSERT INTO articolo (Name,description,costo,category) VALUES " +
                    "('" + p.getName() + "','" + p.getDescr() + "','" + p.getCosto() + "','" + p.getCategory() + "');";
            JOptionPane.showMessageDialog(null, res2);
            DbConnection.getInstance().eseguiAggiornamento(res2);
//aggiunta foto
            String img2 = "INSERT INTO articolo_photo (Image_descr,articolo_idarticolo) VALUES (?," +
                    "(SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) )  ;";
            DbConnection.getInstance().addFoto(img, img2);
//CHECK PRODUTTORE E INSERIMENTO NUOVO PRODUTTORE
            ArrayList<String[]> check_forn = DbConnection.getInstance().eseguiQuery("SELECT idFornitore FROM  Fornitore " +
                    " WHERE Name='" + prod.getNome() + "' AND Website='" + prod.getSitoweb() + "' AND citta='" + prod.getCitta() + "' AND Nazione ='" + prod.getNazione() + "';");

            if(check_forn.size()==1) {
                String[] riga = check_forn.get(0);
                JOptionPane.showMessageDialog(null,"FORNITORE GIA' PRESENTE CON MATRICOLA ==> "+Integer.parseInt(riga[0])+"");
                String mngs = "INSERT INTO service (articolo_idarticolo,Fornitore_idFornitore) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "  '"+Integer.parseInt(riga[0])+"');";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);

            }else {
                //insert produttore
                String prodfin = "INSERT INTO Fornitore (Name,Website,citta,Nazione) VALUES ('" + prod.getNome() + "', '" + prod.getSitoweb() + "', '" + prod.getCitta() + "',  '" + prod.getNazione() + "');" ;
                JOptionPane.showMessageDialog(null, prodfin);
                DbConnection.getInstance().eseguiAggiornamento(prodfin);
                //insert prodotto
                String mngs = "INSERT INTO service (articolo_idarticolo, Fornitore_idFornitore) VALUES " +
                        "( (SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  )," +
                        "(SELECT idFornitore from Fornitore where Name='"+prod.getNome()+"' AND Website='"+prod.getSitoweb()+"' AND citta='"+prod.getCitta()+"' AND Nazione='"+prod.getNazione()+"' ) );";
                JOptionPane.showMessageDialog(null, mngs);
                DbConnection.getInstance().eseguiAggiornamento(mngs);


            }
            //conferma salvataggio
            ArrayList<String[]> id = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN service AS p ON idarticolo=p.articolo_idarticolo " +
                    "WHERE name='" + p.getName() + "' AND category='" + p.getCategory() + "' ");

            if (id.size() == 1) {
                String[] riga = id.get(0);
                JOptionPane.showMessageDialog(null, "PRODOTTO INSERITO CON MATRICOLA ==> " + Integer.parseInt(riga[0]) + "");
            } else {
                JOptionPane.showMessageDialog(null, "PRODOTTO NON INSERITO CORRETTAMENTE");
            }
        }

    }

    @Override
    //elimina article (prodotto,servizio)
    public void erase_article(int id){
        articleDAO ar=new articleDAO();
        article a=ar.findById(id);
        String res3 = "DELETE from articolo WHERE Name='" +a.getName() + "' AND description= '"+a.getDescr()+"' AND category ='" + a.getCategory() + "' ; ";
        JOptionPane.showMessageDialog(null,res3);
        ArrayList<String[]> erase_article = DbConnection.getInstance().eseguiQuery(res3);
    }

    @Override
    //modifica prodotti
    public void mod_prodotti(Product p, int lastid_prod){

        String res = "UPDATE articolo INNER JOIN product as p ON p.articolo_idarticolo = idarticolo  " +
                "SET Name='"+p.getName()+"',description='"+p.getDescr()+"',costo='"+p.getCosto()+"',category='"+p.getCategory()+"' , p.subcategory='"+p.getSottocategoria()+"', p.corsia='"+p.getCorsia()+"',p.scaffale='"+p.getScaffale()+"'" ;
        DbConnection.getInstance().eseguiAggiornamento(res);
        String del_image = "DELETE FROM articolo_photo WHERE articolo_idarticolo='"+lastid_prod+"';" ;
        DbConnection.getInstance().eseguiAggiornamento(del_image);
        //aggiunta foto
        String img2="INSERT INTO articolo_photo (Image_descr,articolo_idarticolo) VALUES (?,(SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) )  ;";
        DbConnection.getInstance().addFoto(p.getImg(),img2);
        JOptionPane.showMessageDialog(null,"PRODOTTO AGGIORNATO");

    }

    @Override
    //modifica servizi
    public void mod_servizi(service p, int lastid_serv){
        serviceDAO s=new serviceDAO();
        String res ="UPDATE articolo INNER JOIN service AS ar ON idarticolo = ar.articolo_idarticolo  " +
                "SET Name='"+p.getName()+"',description'"+p.getDescr()+"',costo='"+p.getCosto()+"',category ='"+p.getCategory()+"'" +
                "WHERE d.idservice=(SELECT idservice from service INNER JOIN articolo AS us ON articolo_idarticolo=us.idarticolo  WHERE us.idarticolo='"+lastid_serv+"' );";
        DbConnection.getInstance().eseguiAggiornamento(res);
        String del_image = "DELETE FROM articolo_photo WHERE articolo_idarticolo='"+lastid_serv+"';" ;
        DbConnection.getInstance().eseguiAggiornamento(del_image);
        //aggiunta foto
        String img2="INSERT INTO articolo_photo (Image_descr,articolo_idarticolo) VALUES (?,(SELECT idarticolo from articolo WHERE Name='" + p.getName() + "' AND description ='" + p.getDescr() + "'  ) )  ;";
        DbConnection.getInstance().addFoto(p.getImg(),img2);
        JOptionPane.showMessageDialog(null,"SERVIZIO AGGIORNATO");
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

