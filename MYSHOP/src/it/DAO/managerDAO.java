package it.DAO;

import it.DbConnection;
import it.model.Point_shop;
import it.model.Product;
import it.model.manager;
import it.model.user;
import it.util.MailHelper;
import javax.swing.*;
import java.util.ArrayList;
//azioni manager
public class managerDAO implements ImanagerDAO{
    @Override
    public manager findById(int id) {
        manager a = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT A.user_iduser, U.username, U.password, U.email FROM manager AS A INNER JOIN user as U  ON U.iduser = A.user_iduser WHERE A.user_iduser = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            a = new manager();
            a.setId(Integer.parseInt(riga[0]));
            a.setUsername(riga[1]);
            a.setEmail(riga[3]);
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
    public void add_product_to_shop(Product p, Point_shop shop){
        productDAO s=new productDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE articolo INNER JOIN Point_shop as shop ON Point_shop_idPoint_shop=shop.idPoint_shop INNER JOIN product AS p ON p.idproduct=product_idproduct  WHERE idarticolo= "+s.findById(p.getId()).getId()+" " +
                "SET Point_shop_idPoint_shop='"+shop.getId()+"', corsia='"+p.getCorsia()+"',scaffale='"+p.getScaffale()+"';");
        JOptionPane.showInputDialog(res);

    }
    @Override
    public void erase_product_from_shop(Product p, Point_shop shop){
        productDAO s=new productDAO();
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("UPDATE articolo INNER JOIN Point_shop as shop ON Point_shop_idPoint_shop=shop.idPoint_shop  WHERE  idarticolo= "+s.findById(p.getId()).getId()+" " +
                "SET Point_shop_idPoint_shop=NULL , corsia='"+p.getCorsia()+"',scaffale='"+p.getScaffale()+"';");
        JOptionPane.showInputDialog(res);
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
