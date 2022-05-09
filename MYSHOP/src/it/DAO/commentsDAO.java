package it.DAO;

import it.DbConnection;
import it.model.article;

import java.util.ArrayList;

public class commentsDAO implements IcommentsDAO {
    @Override
//cerca utenti da id
    public  ArrayList<article.comments> findById_article(int id) {
        ArrayList<article.comments> c =new ArrayList<article.comments>() ;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM comments WHERE articolo_idarticolo='" + id + "' ;");
        for(String[] riga : res){
            userDAO ser = new userDAO();
            article.comments cid = new article.comments(Integer.parseInt(riga[0]), riga[1], Integer.parseInt(riga[2]), ser.findById(Integer.parseInt(riga[3])), id);
        c.add(cid);
        }
        return c;
    }


}
