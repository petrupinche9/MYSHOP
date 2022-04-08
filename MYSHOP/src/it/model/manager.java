package it.model;

public class manager extends user
{
    private Point_shop shop;
    public manager(int id, String username, String password, String Name, String Surname, int age, String Email, int telephone, String Occupation, Point_shop shop)
    {
        super(id, username, password, Name, Surname, age, Email, telephone, Occupation);
        this.shop=shop;
    }

    public manager(){

    }


    public Point_shop getShop() {
        return shop;
    }

    public void setShop(Point_shop shop) {
        this.shop = shop;
    }
}
