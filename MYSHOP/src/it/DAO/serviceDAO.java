package it.DAO;

import it.DbConnection;
import it.model.service;

import java.util.ArrayList;

public class serviceDAO {
    //trova servizi da id
    public service findById(int id) {
        service c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.articolo_idarticolo, U.Name, U.description, U.costo, U.Image_descr FROM service AS C INNER JOIN articolo as U  ON U.idservice = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new service();
            c.setId(Integer.parseInt(riga[0]));
            c.setName(riga[1]);
            c.setCosto(Double.parseDouble(riga[2]));
            byte[] img = riga[3].getBytes();  //parsing from string to byte
            c.setImg(img);
        }

        return c;
    }
    //trova tutti i service
    public ArrayList<service> findAll() {

        ArrayList<service> c =new ArrayList<service>() ;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idservice FROM service ;");
        for(String[] riga : res) {
            service p = findById(Integer.parseInt(riga[0]));
            c.add(p);
        }

        return c;
    }
    // TODO metodi estensione per funzionalità utenti con prodotti e servizi
}
