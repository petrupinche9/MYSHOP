package it.model;

import java.util.ArrayList;

public class Shop_list {
    private int id;
    private user cliente;
    private Point_shop shop;
    private ArrayList<article> articoli;
    private String stato ;
private double total_price;
private String data;

public Shop_list(int id, user cliente, Point_shop shop, ArrayList<article> articoli, String stato, double total_price, String data){
    this.id=id;
    this.cliente=cliente;
    this.articoli=articoli;
    this.shop=shop;
    this.stato=stato;
    this.total_price=total_price;
    this.data=data;
}

    public Shop_list() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<article> getArticoli() {
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
    public String getStato() {
        return stato;
    }
    public void setStato(String stato) {
        this.stato = stato;
    }
    public user getCliente() {  return cliente;    }
    public void setCliente(user cliente) {
        this.cliente = cliente;
    }
    public Point_shop getShop() {   return shop;    }
    public void setShop(Point_shop shop) {  this.shop = shop;    }
    public String getData() {  return data;    }
    public void setData(String data) {   this.data = data;    }
}
