package it.DAO;

import it.model.Point_shop;
import it.model.Product;
import it.model.manager;
import it.model.user;

import java.util.ArrayList;

public interface ImanagerDAO {
    manager findById(int id);

    ArrayList<manager> findAll();

    void add_product_to_shop(Product p, Point_shop shop);

    void erase_product_from_shop(Product p, Point_shop shop);

    void send_email_to_client(user c, String obj, String mex);

    void add_user_to_shop(user p, Point_shop shop);

    void erase_user_from_shop(user p, Point_shop shop);
}
