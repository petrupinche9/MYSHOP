package it.DAO;

import it.model.user;

public interface IuserDAO {
    user findById(int id);


    //ArrayList<Cliente> findAll();
}
