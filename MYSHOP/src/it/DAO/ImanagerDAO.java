package it.DAO;

import it.model.*;

import java.util.ArrayList;

public interface ImanagerDAO {
    manager findById(int id);

    ArrayList<manager> findAll();

    void add_article_to_shop(article p,manager m);

    void erase_article_from_shop(article p,manager m);

    void send_email_to_client(user c, String obj, String mex);

    void add_user_to_shop(user p, Point_shop shop);

    void erase_user_from_shop(user p, Point_shop shop);
}
