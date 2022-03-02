package it.model;

import java.util.ArrayList;

public class Shop_list {
    private int id;
    private user cliente;
    private ArrayList<article> articoli;
private String state ;
private double total_price;
public Shop_list(int id, user cliente, ArrayList<article> articoli, String state, double total_price){
    this.id=id;
    this.cliente=cliente;
    this.articoli=articoli;
    this.state=state;
    this.total_price=total_price;
}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public  ArrayList<article> getArticoli() {
        return articoli;
    }
    public void setArticoli( ArrayList<article> articoli) {
        this.articoli = articoli;
    }
    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public user getCliente() {
        return cliente;
    }
    public void setCliente(user cliente) {
        this.cliente = cliente;
    }
}
