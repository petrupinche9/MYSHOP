package it.DAO;

import it.DbConnection;
import it.model.manager;

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
}
