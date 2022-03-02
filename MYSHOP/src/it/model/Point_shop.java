package it.model;

public class Point_shop {
    private int id;
private String Shopname;
private String city;
private String article_type;
public Point_shop(int id, String Shopname,String city, String article_type){
    this.id=id;
    this.Shopname=Shopname;
    this.city=city;
    this.article_type=article_type;
}

    public Point_shop() {

    }
//metodi get
    public int getId() {
        return id;
    }
    public String getShopname() {
        return Shopname;
    }
    public String getCity() { return city;  }
    public String getArticle_type() {return article_type;   }
    //metodi set
    public void setArticle_type(String article_type) {this.article_type = article_type;    }
    public void setCity(String city) {   this.city = city; }
    public void setId(int id) {
        this.id = id;
    }
    public void setShopname(String shopname) {
        Shopname = shopname;
    }
}
