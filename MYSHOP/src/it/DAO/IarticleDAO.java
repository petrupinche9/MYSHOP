package it.DAO;

import it.model.article;

import java.util.ArrayList;

public interface IarticleDAO {
    public article findById(int id);
    public ArrayList<article> findAll();

}
