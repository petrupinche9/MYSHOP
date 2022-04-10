package it.DAO;

import it.DbConnection;
import it.model.*;
import it.util.MailHelper;

import javax.swing.*;
import java.util.ArrayList;
//azioni manager
public class managerDAO implements ImanagerDAO{
    @Override
    public manager findById(int id) {


        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idmanager FROM manager  INNER JOIN user as U  ON U.iduser = user_iduser WHERE user_iduser = '"+id+"';");

        if(res.size()==1) {
            String[] riga = res.get(0);
           // a = new manager();
            userDAO us = new userDAO();
           user user= us.findById(id);
           JOptionPane.showMessageDialog(null,id);
            manager a = new manager(Integer.parseInt(riga[0]),user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getAge(), user.getEmail(), user.getTelephone(), user.getOccupation(), null);
            JOptionPane.showMessageDialog(null,a.getId());

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

        //return a;
        return null;
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
        //JOptionPane.showMessageDialog(null, "update agg");

    }
    @Override
    public void erase_article_from_shop(article p,manager m){
       articleDAO s=new articleDAO();
        boolean res = DbConnection.getInstance().eseguiAggiornamento("UPDATE articolo INNER JOIN Point_shop as shop ON Point_shop_idPoint_shop=shop.idPoint_shop  WHERE  idarticolo= "+p.getId()+" && shop.idPoint_shop='"+m.getShop().getId()+"' " +
                "SET Point_shop_idPoint_shop=NULL , corsia=null ,scaffale=null;");
        JOptionPane.showMessageDialog(null,res);
    }

    @Override
    public void send_email_to_client(user c,String obj,String mex){
        new MailHelper().send(c.getEmail(), obj, mex);
    }

    @Override
    public void add_user_to_shop(user p, manager m){
        DbConnection.getInstance().eseguiAggiornamento("UPDATE point_shop_has_cliente" +
                "SET primarykey='"+m.getShop().getId()+"',Point_shop_idPoint_shop='"+m.getShop().getId()+"'," +
                "Cliente_idCliente='(SELECT idCliente FROM cliente INNER JOIN user ON user.iduser=cliente.user_iduser'" +
                "WHERE user.iduser='"+p.getId()+"');");


    }
    @Override
    public void erase_user_from_shop(user p, manager m){
        userDAO s=new userDAO();
        DbConnection.getInstance().eseguiAggiornamento("DELETE FROM point_shop_has_cliente" +
                "WHERE Point_shop_idPoint_shop='"+m.getShop().getId()+"'" +
                "AND Cliente_idCliente='(SELECT idCliente FROM cliente INNER JOIN user ON user.iduser=cliente.user_iduser WHERE user.iduser='"+p.getId()+"')';");
    }
}
