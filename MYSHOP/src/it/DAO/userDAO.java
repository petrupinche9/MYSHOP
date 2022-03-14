package it.DAO;

import it.DbConnection;
import it.model.article;
import it.model.user;

import javax.swing.*;
import java.util.ArrayList;
//base dao per tutti
public class userDAO implements IuserDAO {
    @Override
//cerca utenti da id
    public user findById(int id) {
        user c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.user_iduser, U.username, U.passwd, U.Email FROM Cliente AS C INNER JOIN user as U  ON U.iduser = C.user_iduser WHERE C.user_iduser = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new user();
            c.setId(Integer.parseInt(riga[0]));
            c.setUsername(riga[1]);
            c.setEmail(riga[3]);
        }

        return c;
    }
    @Override
//ritorna tutti gli utenti
    public ArrayList<user> findAll() {
        ArrayList<user> c =new ArrayList<user>() ;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT iduser FROM user ;");
        for(String[] riga : res) {
            user usr = findById(Integer.parseInt(riga[0]));
            c.add(usr);
        }

        return c;
    }
    @Override
    //registrazione nuovo utente
    public void newuser(user p){
        String res = "INSERT INTO user VALUES ('"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getName()+"','"+p.getSurname()+"','"+p.getAge()+"','"+p.getEmail()+"','"+p.getTelephone()+"', '"+p.getOccupation()+"'); ";
        JOptionPane.showMessageDialog(null,res);
        DbConnection.getInstance().eseguiAggiornamento(res);

       // userDAO s=new userDAO();
        //ArrayList<String[]> sh = DbConnection.getInstance().eseguiQuery("UPDATE Point_shop INNER JOIN Cliente as cl ON cl.isCliente=Cliente_idCLiente WHERE idCliente= "+s.findById(p.getId()).getId()+" " +
                //"SET Cliente_idCliente='"+p.getId()+"';");
       // JOptionPane.showInputDialog(sh);
    }

    //commenta
    public void newcomment(user p, article ar, String text){
        String res = "INSERT INTO comments VALUES ('"+text+"','"+ar.getEval()+"','"+p.getId()+"','"+ar.getId()+"'); ";
        JOptionPane.showMessageDialog(null,res);
        DbConnection.getInstance().eseguiAggiornamento(res);

    }
    /*public void erase_user( user p){
        String res = "DELETE FROM user WHERE iduser='"+p.getId()+"' ";
        JOptionPane.showInputDialog(res);
        DbConnection.getInstance().eseguiAggiornamento(res);
        userDAO s=new userDAO();
        ArrayList<String[]> sh = DbConnection.getInstance().eseguiQuery("UPDATE Point_shop INNER JOIN Cliente as cl ON cl.isCliente=Cliente_idCLiente WHERE idCliente= "+s.findById(p.getId()).getId()+" " +
                "SET Cliente_idCliente=NULL;");
        JOptionPane.showInputDialog(sh);
    }*/

}
