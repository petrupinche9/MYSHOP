package it.DAO;

import it.DbConnection;
import it.model.article;

import java.util.ArrayList;

public class articleDAO implements IarticleDAO {
    public article findById(int id) {
        article c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.user_iduser, U.username, U.passwd, U.Email FROM Cliente AS C INNER JOIN user as U  ON U.iduser = C.user_iduser WHERE C.user_iduser = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new article();
            c.setId(Integer.parseInt(riga[0]));
           // c.setUsername(riga[1]);
           // c.setEmail(riga[3]);
        }

        return c;
    }


    /*@Override
    public ArrayList<Cliente> findAll() {
        return null;
    }*/
    /*public void newuser( user p){
        String res = "INSERT INTO user VALUES (NULL,'"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getName()+"','"+p.getSurname()+"','"+p.getAge()+"','"+p.getEmail()+"','"+p.getTelephone()+"', '"+p.getOccupation()+"'); ";
        JOptionPane.showInputDialog(res);
        DbConnection.getInstance().eseguiAggiornamento(res);
    }*/

}
