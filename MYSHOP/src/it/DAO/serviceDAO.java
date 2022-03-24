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

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.articolo_idarticolo, C.Name, C.description, C.costo, C.Image_descr, C.category, U.Fornitore FROM service AS C INNER JOIN articolo as U  ON U.idservice = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        // byte[] img = DbConnection.getInstance().getFoto("SELECT C.articolo_idarticolo, U.Image_descr FROM product AS C INNER JOIN articolo as U  ON U.idprodotto = C.articolo_idarticolo WHERE C.articolo_idarticolo = "+id+";");
        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new service();
            c.setId(Integer.parseInt(riga[0]));
            c.setName(riga[1]);
            c.setCosto(Double.parseDouble(riga[2]));
            byte[] img = riga[3].getBytes();  //parsing from string to byte
            c.setImg(img);
            c.setCategory(riga[4]);
            ArrayList<String[]> forn = DbConnection.getInstance().eseguiQuery("SELECT * FROM Fornitore INNER JOIN service AS serv " +
                    "ON  service_idservice=serv.idservice WHERE serv.idservice='"+riga[0]+"'");
            if(forn.size()==1){
                Fornitore f=new Fornitore();
                String[] dio = forn.get(0);
                f.setId(Integer.parseInt(dio[0]));
                f.setNome(dio[1]);
                f.setSitoweb(dio[2]);
                f.setNazione(dio[3]);
                c.setFornitore(f);
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
