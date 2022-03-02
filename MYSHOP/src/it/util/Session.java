package it.util;

import it.model.user;

import java.util.HashMap;

public class Session {

    private static Session instance;

    private HashMap<String, Object> mappa = new HashMap<String, Object>();

    //definisco le chiavi
    public static final String UTENTE_LOGGATO = "UTENTE_LOGGATO";

    private user clienteLoggato;
    // ...

    public static synchronized Session getInstance() {
        if(instance == null)
            instance = new Session();
        return instance;
    }

    private Session() {

    }

    public user getClienteLoggato() {
        return clienteLoggato;
    }

    public void setClienteLoggato(user clienteLoggato) {
        this.clienteLoggato = clienteLoggato;
    }

    public void inserisci(String chiave, Object valore) {
        mappa.put(chiave, valore);
    }

    public Object ottieni(String chiave) {
        return mappa.get(chiave);
    }

    public void rimuovi(String chiave) {
        mappa.remove(chiave);
    }
}
