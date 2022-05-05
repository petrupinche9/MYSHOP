package it.DAO;

import it.model.user;

import java.util.ArrayList;

public interface IuserDAO {
    user findById(int id);

    //ritorna tutti gli utenti
    ArrayList<user> findAll();

    //registrazione nuovo utente
    void newuser(user p);
    void mod_user(user p);
    //ArrayList<Cliente> findAll();
}
