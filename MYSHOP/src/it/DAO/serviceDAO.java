package it.DAO;

import it.DbConnection;
import it.model.Fornitore;
import it.model.service;

import java.util.ArrayList;

public class serviceDAO implements IserviceDAO{
    @Override
    //trova servizi da id
    public service findById(int id) {
        service c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.Name, C.costo, C.description, C.category FROM articolo AS C INNER JOIN service as U ON C.idarticolo = U.articolo_idarticolo  WHERE C.idarticolo = '"+id+"';");
        // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new service();
            c.setId(id);
            c.setName(riga[0]);
            c.setCosto(Double.parseDouble(riga[1]));
            byte[] img = DbConnection.getInstance().getFoto("SELECT Image_descr FROM articolo WHERE C.idarticolo = '"+id+"'; ");  //parsing from string to byte
            c.setImg(img);
            c.setDescr(riga[2]);
            c.setCategory(riga[3]);
            ArrayList<String[]> prod = DbConnection.getInstance().eseguiQuery("SELECT * FROM Fornitore INNER JOIN service AS p " +
                    "ON  service_idservice=p.idservice WHERE p.articolo_idarticolo='"+id+"'");
            if(prod.size()==1){
                Fornitore p=new Fornitore();
                String[] dio = prod.get(0);
                p.setId(Integer.parseInt(dio[0]));
                p.setNome(dio[1]);
                p.setSitoweb(dio[2]);
                p.setNazione(dio[3]);
                c.setFornitore(p);
            }

        }

        return c;
    }
    @Override
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
