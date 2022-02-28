package it.DAO;

import it.model.manager;

import java.util.ArrayList;

public interface ImanagerDAO {
    manager findById(int id);

    ArrayList<manager> findAll();
}
