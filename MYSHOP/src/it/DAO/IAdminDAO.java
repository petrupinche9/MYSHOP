package it.DAO;

import it.model.*;

public interface IAdminDAO extends IBaseDAO<Admin>{
    public void newproduct(Product p, Produttore prod, byte[] img);

    //aggiunta nuovo sottoprodotto
    public void newsubproduct(SubProduct p, Produttore prod, byte[] img);

    public void newservice(service p, Fornitore prod, byte[] img);

    //elimina article (prodotto,servizio)
   public  void erase_article(int id);

    public void mod_prodotti(Product p, Produttore prod);
    public void mod_servizi(service p, Fornitore f);

    //crea punto vendita e manager
    public void create_shopandmanager(Point_shop shop, manager mng);
}
