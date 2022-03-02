package it.DAO;

import it.model.Point_shop;

import java.util.ArrayList;

public interface IShopDAO {
    public Point_shop findById(int id);
    public ArrayList<Point_shop> findAll();
}
