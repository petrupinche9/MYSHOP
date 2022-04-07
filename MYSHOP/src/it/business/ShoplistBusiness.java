package it.business;

import it.model.Shop_list;
import it.util.MailHelper;
import it.util.PdfHelper;

import java.util.ArrayList;

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
       // new Shop_listDAO().save_Shop_list(p);

        // 1. inviare mail al manager
        String dest1 = p.getMng().getEmail();
        MailHelper.getInstance().send(dest1, "Nuova Shoplist", "Il giorno...");

        // 2. inviare mail di conferma all'utente
        String dest2 = p.getCliente().getEmail();
        MailHelper.getInstance().send(dest1, "Shoplist confermata!", "Il giorno...");

        // 3. generare pdf per l'utente
        ArrayList<String> testo = new ArrayList<String>();
        testo.add("Codice prenotazione: "+p.getId());
        testo.add("Il giorno...");
        testo.add("Stampa questo file e presentati in stazione");
        PdfHelper.getInstance().creaPdf(testo);

        return true;
    }
}
