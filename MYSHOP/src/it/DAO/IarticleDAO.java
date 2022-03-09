package it.DAO;

import it.model.article;

import java.util.ArrayList;

public interface IarticleDAO {
    //trova tutti i prodotti
    public article findById(int id);
    public ArrayList<article> findAll();

}
