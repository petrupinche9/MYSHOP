package it.DAO;

import it.model.Product;
import java.util.ArrayList;

public interface IproductDAO extends IBaseDAO<Product> {
    public Product findById(int id);
    public ArrayList<Product> findAll();
}
