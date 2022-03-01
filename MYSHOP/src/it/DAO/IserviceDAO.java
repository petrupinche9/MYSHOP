package it.DAO;

import it.model.service;

import java.util.ArrayList;

public interface IserviceDAO extends IBaseDAO<service>{
    public service findById(int id);
    public ArrayList<service> findAll();
}
