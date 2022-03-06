package it.DAO;

import it.model.*;

public interface IAdminDAO extends IBaseDAO<Admin>{
    public void newproduct(Product p, Produttore prod);
    public void newsubproduct( Product p,Produttore prod);
    public void newservice(service p, Fornitore prod);
    public void erase_article( int id);
    public void mod_prodotti(Product p, Produttore prod);
    public void mod_servizi(service p, Fornitore f);
    public void create_shopandmanager(Point_shop shop, manager mng);

}
