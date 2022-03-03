package it.model;

import java.util.Date;

public class Shop_list {
    private int id;
    private user cliente;
    private manager mng;
    private article articoli;
    private user Cliente;
    private Point_shop shop;
private String stato ;
private double total_price;
private Date data;

public Shop_list(int id, user cliente, article articoli,manager mng, String stato, double total_price, Date data){
    this.id=id;
    this.cliente=cliente;
    this.articoli=articoli;
    this.mng=mng;
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
    public article getArticoli() {
        return articoli;
    }
    public void setArticoli( article articoli) {
        this.articoli = articoli;
    }
    public manager getMng() {    return mng;    }
    public void setMng(manager mng) {this.mng = mng;    }
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
    public Date getData() {  return data;    }
    public void setData(Date data) {   this.data = data;    }
}
