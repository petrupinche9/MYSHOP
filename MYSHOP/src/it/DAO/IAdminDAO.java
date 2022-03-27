package it.DAO;

import it.model.*;

public interface IAdminDAO extends IBaseDAO<Admin>{
    void newproduct(Product p, Produttore prod, byte[] img);

    //aggiunta nuovo sottoprodotto
    void newsubproduct(SubProduct p, Produttore prod, byte[] img, Product p2);

    void newservice(service p, Fornitore prod, byte[] img);

    //elimina article (prodotto,servizio)
    void erase_article(String name, String category);

    //modifica prodotti,servizi
    void mod_prodotti(Product p);

    void mod_produttore(Produttore prod, Produttore lastprod);

    //modifica servizi
    void mod_servizi(service p);

    //modifica fornitore
    void mod_fornitore(Fornitore f, Fornitore lastf);

    //crea punto vendita e manager
    void create_shopandmanager(Point_shop shop, manager mng);
}
