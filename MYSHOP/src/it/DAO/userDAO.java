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

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM user WHERE iduser='"+id+"' ;");

        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new user();
            c.setId(Integer.parseInt(riga[0]));
            c.setUsername(riga[1]);
            c.setPassword(riga[2]);
            c.setName(riga[3]);
            c.setSurname(riga[4]);
            c.setAge(Integer.parseInt(riga[5]));
            c.setEmail(riga[6]);
            c.setTelephone(Integer.parseInt(riga[7]));
            c.setOccupation(riga[8]);
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
        String res = "INSERT INTO user (username,passwd,Name,Surname,Age,Email,telephone,occupation) VALUES ('"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getName()+"','"+p.getSurname()+"','"+p.getAge()+"','"+p.getEmail()+"','"+p.getTelephone()+"', '"+p.getOccupation()+"'); ";
        DbConnection.getInstance().eseguiAggiornamento(res);
         String cliente="INSERT INTO Cliente (user_iduser) VALUES ((SELECT iduser FROM user WHERE username='"+p.getUsername()+"' && passwd='"+p.getPassword()+"'))";
        DbConnection.getInstance().eseguiAggiornamento(cliente);
    }
    @Override
    public void mod_user(user p){
        String res = "UPDATE user SET username='"+p.getUsername()+"' , passwd='"+p.getPassword()+"', Name='"+p.getName()+"',Surname='"+p.getSurname()+"',Age='"+p.getAge()+"',Email='"+p.getEmail()+"',telephone='"+p.getTelephone()+"', occupation='"+p.getOccupation()+"' WHERE username='"+p.getUsername()+"' && passwd='"+p.getPassword()+"'";
        DbConnection.getInstance().eseguiAggiornamento(res);

    }

    //commenta
    public void newcomment(article ar, user p, article.comments new_comm){
        ar.setComment(p,new_comm);
        String res = "INSERT INTO comments VALUES ('"+new_comm.getText()+"','"+new_comm.getFeedback()+"','"+p.getId()+"','"+ar.getId()+"'); ";
        DbConnection.getInstance().eseguiAggiornamento(res);
        JOptionPane.showMessageDialog(null,"commento inviato");
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
