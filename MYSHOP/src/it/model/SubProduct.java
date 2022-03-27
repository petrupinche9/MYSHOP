package it.model;

public class SubProduct extends Product
{
    private int id_master_product;
    public SubProduct(int id){
        this.id_master_product=id;
    }

    public SubProduct() {

    }

    @Override
    public int getId() {
        return id_master_product;
    }

    @Override
    public void setId(int id) {
        this.id_master_product = id;
    }
}
