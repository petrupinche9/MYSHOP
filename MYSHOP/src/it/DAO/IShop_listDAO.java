package it.DAO;

import it.model.Shop_list;

import java.util.ArrayList;

public interface IShop_listDAO {
    Shop_list findById(int id);

    ArrayList<Shop_list> findAll();

    void save_Shop_list(Shop_list p);
}
