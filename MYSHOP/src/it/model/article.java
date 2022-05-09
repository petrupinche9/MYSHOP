package it.model;

import it.DAO.commentsDAO;
import it.DbConnection;

import java.util.ArrayList;

//implementare database
public class article {
   private int id;
    private String name;
    private String Descr;

    public static class comments
    {
        private user people;
        private int id;
        private int feedback;
        private String text;
        private int article_id;
        public comments(int id, String text,
                        int feedback,user people,int article_id){
            this.feedback=feedback;
            this.id=id;
            this.people=people;
            this.text=text;
            this.article_id=article_id;
        }

        public comments() {

        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getFeedback() {
            return feedback;
        }
        public void setFeedback(int feedback) {
            this.feedback = feedback;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public user getUser() {
            return people;
        }
        public void setUser(user people) {
            this.people = people;
        }
        public int getArticle_id() {
            return article_id;
        }
        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }
    };
    private double costo;
    private byte[] img;
    private String category;

    public article() {

    }

    public article(int id,String name, double costo, String Descr, byte[] img, String category){
        this.id=id;
        this.name=name;
        this.Descr=Descr;
        this.costo=costo;
        this.img=img;
        this.category=category;
    }
    // metodi get
    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public String getDescr() {
        return Descr;
    }
    public double getCosto()
    {
        return costo;
    }
    public byte[] getImg() {
        return DbConnection.getInstance().getFoto("SELECT Image_descr FROM articolo_photo INNER JOIN articolo AS f ON articolo_idarticolo=f.idarticolo WHERE f.Name='"+name+"' AND f.description='"+Descr+"';");
    }
    public ArrayList<comments> getcomments() {
        commentsDAO daao=new commentsDAO();
        return daao.findById_article(id);
    }
    public String getCategory() {return category;}

    //METODI SET
    public void setCosto(double costo)
    {
        this.costo = costo;
    }
    public void setName(String name) {this.name = name;}
    public void setComment(user people, comments new_comm) {
        commentsDAO daao=new commentsDAO();
        ArrayList<comments> comm= daao.findById_article(id);
        comments news=new comments(0,new_comm.getText(),new_comm.getFeedback(),people,id);
    }
    public void setDescr(String descr) {
        Descr = descr;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setImg(byte[] img) { this.img = img; }
    public void setCategory(String category) {this.category = category;   }
    public int getEval(){
        ArrayList<comments> rev=getcomments();
        int eval=0;
        for(int i=0;i<rev.size();i++){
            eval+=rev.get(i).getFeedback();
        }
        return eval/rev.size();
    }
}
