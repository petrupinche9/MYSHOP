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
        manager a = null;
        Point_shop s =null;
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT A.user_iduser, U.username, U.passwd, U.email FROM manager AS A INNER JOIN user as U  ON U.iduser = A.user_iduser WHERE A.user_iduser = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            a = new manager();
            a.setId(Integer.parseInt(riga[0]));
            a.setUsername(riga[1]);
            a.setPassword(riga[2]);
            a.setEmail(riga[3]);

            ArrayList<String[]> shop = DbConnection.getInstance().eseguiQuery("SELECT * FROM Point_shop WHERE Manager_idManager='"+riga[0]+"'");
            if(shop.size()==1){
                String[] rigo = shop.get(0);
                s.setId(Integer.parseInt(rigo[0]));
                s.setShopname(rigo[1]);
                s.setCity(rigo[2]);
                s.setArticle_type(rigo[3]);
                s.setMng(a);
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
        boolean res = DbConnection.getInstance().eseguiAggiornamento("UPDATE articolo SET Point_shop_idPoint_shop='"+m.getShop().getId()+"'WHERE idarticolo='"+p.getId()+"';");
        JOptionPane.showMessageDialog(null, res);

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
    public void add_user_to_shop(user p, Point_shop shop){
        userDAO s=new userDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE Point_shop_has_Cliente SET Cliente_idCliente='"+p.getId()+"' Point_shop_idPoint_shop='"+shop.getId()+"';");
        JOptionPane.showInputDialog(res);

    }
    @Override
    public void erase_user_from_shop(user p, Point_shop shop){
        userDAO s=new userDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("DELETE FROM Point_shop_has_Cliente WHERE Cliente_idCliente='"+p.getId()+"' Point_shop_idPoint_shop='"+shop.getId()+"'; ");
        JOptionPane.showInputDialog(res);
    }
}
