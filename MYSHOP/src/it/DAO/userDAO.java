package it.DAO;

import it.DbConnection;
import it.model.user;
import java.util.ArrayList;

public class userDAO implements IuserDAO {
    @Override
    public user findById(int id) {
        user c = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT C.user_iduser, U.username, U.passwd, U.Email FROM Cliente AS C INNER JOIN it.model.user as U  ON U.iduser = C.user_iduser WHERE C.user_iduser = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            c = new user();
            c.setId(Integer.parseInt(riga[0]));
            c.setUsername(riga[1]);
            c.setEmail(riga[3]);
        }

        return c;
    }


    /*@Override
    public ArrayList<Cliente> findAll() {
        return null;
    }*/
}
