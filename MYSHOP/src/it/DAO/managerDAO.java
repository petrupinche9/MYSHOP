package it.DAO;

import it.DbConnection;
import it.model.*;
import it.util.MailHelper;

import java.util.ArrayList;
//azioni manager
public class managerDAO implements ImanagerDAO{

    @Override
    public manager findById(int id) {


        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT U.iduser FROM Manager  INNER JOIN user as U  ON U.iduser = user_iduser WHERE idManager = '"+id+"';");
        manager a = new manager();
        if(res.size()==1) {
            String[] riga = res.get(0);
           // a = new manager();
            userDAO us = new userDAO();
           user user= us.findById(id);

            a.setId(id);
            a.setUsername(user.getUsername());
            a.setPassword(user.getPassword());
            a.setName(user.getName());
            a.setSurname(user.getSurname());
            a.setAge(user.getAge());
            a.setEmail(user.getEmail());
            a.setTelephone(user.getTelephone());
            a.setOccupation(user.getOccupation());


            ArrayList<String[]> shop = DbConnection.getInstance().eseguiQuery("SELECT * FROM Point_shop WHERE Manager_idManager='"+a.getId()+"';");
            if(shop.size()==1){
                Point_shop s =new Point_shop();
                String[] rigo = shop.get(0);
                s.setId(Integer.parseInt(rigo[0]));
                s.setShopname(rigo[1]);
                s.setCity(rigo[2]);
                s.setArticle_type(rigo[3]);
                a.setShop(s);
                s.setMng(a);
                return a;
            }
        }

        return a;

    }

    @Override
    public ArrayList<manager> findAll() {
        ArrayList<manager> c =new ArrayList<manager>() ;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idmanager FROM Manager ;");
        for(String[] riga : res) {
            manager mng = findById(Integer.parseInt(riga[0]));
            c.add(mng);
        }

        return c;
    }
    @Override
    public void add_article_to_shop(article p,manager m){
        DbConnection.getInstance().eseguiAggiornamento("UPDATE articolo SET Point_shop_idPoint_shop='"+m.getShop().getId()+"'WHERE idarticolo='"+p.getId()+"';");
    }
    @Override
    public void erase_article_from_shop(article p,manager m){
         DbConnection.getInstance().eseguiAggiornamento("UPDATE articolo SET Point_shop_idPoint_shop=NULL WHERE idarticolo='"+p.getId()+"' AND Point_shop_idPoint_shop='"+m.getShop().getId()+"';");
    }

    @Override
    public void send_email_to_client(user c,String obj,String mex){
        new MailHelper().send(c.getEmail(), obj, mex);
    }

    @Override
    public void add_user_to_shop(user p, manager m){
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idcliente FROM cliente INNER JOIN user AS us ON cliente.user_iduser=us.iduser WHERE us.iduser='"+p.getId()+"';");
        String[] tabellacliente = res.get(0);
        int idcliente = Integer.parseInt(tabellacliente[0]);
        DbConnection.getInstance().eseguiAggiornamento("INSERT INTO point_shop_has_cliente (Point_shop_idPoint_shop, Cliente_idCliente) VALUES ('"+m.getShop().getId()+"', '"+idcliente+"');");
    }
    @Override
    public void erase_user_from_shop(user p, manager m){
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM cliente INNER JOIN user ON cliente.user_iduser=user.iduser WHERE user.iduser='"+p.getId()+"';");
        String[] tabellacliente = res.get(0);
        int idcliente = Integer.parseInt(tabellacliente[0]);
        DbConnection.getInstance().eseguiAggiornamento("DELETE FROM point_shop_has_cliente WHERE Point_shop_idPoint_shop='"+m.getShop().getId()+"' AND Cliente_idCliente='"+idcliente+"';");
    }

    public void aggiornolostato(Shop_list l){
        DbConnection.getInstance().eseguiAggiornamento("UPDATE shop_list SET Stato='pagata' WHERE shop_list.idShop_List='"+l.getId()+"';");
    }
}
