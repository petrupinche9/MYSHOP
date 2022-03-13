package it.DAO;

import it.model.Shop_list;
import it.model.article;

import java.util.ArrayList;

public interface IShop_listDAO {
    Shop_list findById(int id);

    ArrayList<Shop_list> findAll();

    //salva lista spesa
    void save_Shop_list(Shop_list p, ArrayList<article> ar);
}
