package it.business;

import it.DAO.IShop_listDAO;
import it.DAO.Shop_listDAO;
import it.DbConnection;
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

    public void inviashoplist(Shop_list p) {
        // logica di business

        // 1. chiamare il dao lista articoli per salvare la lista
        IShop_listDAO listdao=new Shop_listDAO();
        listdao.save_Shop_list(p);

        // 1. inviare mail al manager
        String dest1 = p.getShop().getMng().getEmail();
        Date today = new Date();
        MailHelper.getInstance().send(dest1, "Nuova Shoplist : "+p.getId()+"", "Effettuata il: "+ DateUtil.stringFromDate(today)+", Cliente:"+p.getCliente().getName()+"");

        // 2. inviare mail di conferma all'utente
        String dest2 = p.getCliente().getEmail();
        MailHelper.getInstance().send(dest2, "Shoplist confermata!", "Prenotazione articoli avvenuta con successo il giorno: "+ DateUtil.stringFromDate(today)+"");

        // 3. generare pdf per l'utente
        ArrayList<String[]> sea = DbConnection.getInstance().eseguiQuery("SELECT idCliente FROM Cliente INNER JOIN user AS p ON p.iduser=user_iduser WHERE p.username='"+p.getCliente().getUsername()+"'");
        String[] rigo;
        int idcliente=0;
        if(sea.size()==1) {
            rigo = sea.get(0);
            idcliente = Integer.parseInt(rigo[0]);
            ArrayList<String[]> search = DbConnection.getInstance().eseguiQuery("SELECT idShop_List FROM Shop_List WHERE Point_shop_idPoint_shop='" + p.getShop().getId() + "' AND Cliente_idCliente='" + idcliente + "' AND Date='" + DateUtil.stringFromDate(today) + "';");
            if (search.size() == 1) {
                String[] riga = search.get(0);
                ArrayList<String> testo = new ArrayList<String>();
                testo.add("Codice prenotazione: " + Integer.parseInt(riga[0]));
                testo.add("Effettuata il: " + p.getData());
                testo.add("Numero articoli: " + p.getArticoli().size());
                testo.add("");
                for (int i = 0; i < p.getArticoli().size(); i++)
                    testo.add("Nome: " + p.getArticoli().get(i).getName() + "     " + p.getArticoli().get(i).getCosto() + "???");

                testo.add("Totale Complessivo: " + p.getTotal_price() + "");
                testo.add("");
                testo.add("Stampa questo file e presentati al punto vendita ");
                testo.add("designato per finalizzare l'acquisto :)");
                testo.add("");
                testo.add("      MYSHOP22");
                PdfHelper.getInstance().creaPdf(testo, Integer.parseInt(riga[0]));
            }
        }
    }
}
