package it.business;

import it.DAO.Shop_listDAO;
import it.model.Shop_list;
import it.util.DateUtil;
import it.util.MailHelper;
import it.util.PdfHelper;

import java.util.ArrayList;
import java.util.Date;

public class ShoplistBusiness {
    private static ShoplistBusiness instance;

    public static synchronized ShoplistBusiness getInstance() {
        if(instance == null)
            instance = new ShoplistBusiness();
        return instance;
    }
    private ShoplistBusiness(){}

    public boolean inviashoplist(Shop_list p) {
        // logica di business

        // 1. chiamare il dao lista articoli per salvare la lista
       new Shop_listDAO().save_Shop_list(p);

        // 1. inviare mail al manager
        String dest1 = p.getShop().getMng().getEmail();
        Date today = new Date();
        MailHelper.getInstance().send(dest1, "Nuova Shoplist", "Effettuata il: "+ DateUtil.stringFromDate(today)+", Cliente:"+p.getCliente().getName()+"");

        // 2. inviare mail di conferma all'utente
        String dest2 = p.getCliente().getEmail();
        MailHelper.getInstance().send(dest1, "Shoplist confermata!", "Prenotazione articoli avvenuta con successo il giorn: "+ DateUtil.stringFromDate(today)+"");

        // 3. generare pdf per l'utente
        ArrayList<String> testo = new ArrayList<String>();
        testo.add("Codice prenotazione: "+p.getId());
        testo.add("Effettuata il: "+ DateUtil.stringFromDate(today)+"");
        testo.add("Stampa questo file e presentati al punto vendita designato per finalizzare l'acquisto :)");
        PdfHelper.getInstance().creaPdf(testo);

        return true;
    }
}
