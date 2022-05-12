package it.DAO;

import it.DbConnection;
import it.model.Point_shop;
import it.model.Shop_list;
import it.model.user;
import it.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;

public class Shop_listDAO implements IShop_listDAO{
    @Override
    public Shop_list findById(int id) {

        Shop_list p = null;

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM Shop_list WHERE idShop_list = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            p = new Shop_list();
            p.setId(Integer.parseInt(riga[0]));
            p.setStato(riga[1]);
            p.setTotal_price(Integer.parseInt(riga[2]));
            IuserDAO cDao = new userDAO();
            IarticleDAO aDao= new articleDAO();
            IShopDAO mDao = new ShopDAO();
            user Cliente = cDao.findById(Integer.parseInt(riga[3]));
            Point_shop shop = mDao.findById(Integer.parseInt(riga[4]));
            p.setCliente(Cliente);
            p.setShop(shop);
            p.setData(riga[6]);
        }

        return p;
    }

    @Override
    public ArrayList<Shop_list> findAll() {

        ArrayList<Shop_list> lista = new ArrayList<Shop_list>();

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idShop_list FROM Shop_list");

        for(String[] riga : res) {
            Shop_list p = findById(Integer.parseInt(riga[0]));
            lista.add(p);
        }

        return lista;

    }

    @Override
    public void save_Shop_list(Shop_list p) {
        Date date = new Date();
        String strDataPrenotazione = DateUtil.stringFromDate(date);
        p.setData(strDataPrenotazione);
        ArrayList<String[]> sea = DbConnection.getInstance().eseguiQuery("SELECT user_iduser FROM Cliente WHERE idCliente='"+p.getCliente().getId()+"'");
        String[] riga;
        int idcliente=0;
        if(sea.size()==1) {
            riga = sea.get(0);
            idcliente= Integer.parseInt(riga[0]);

        String sql = "INSERT INTO Shop_list (Stato,total_price,Date,Point_shop_idPoint_shop,Cliente_idCliente) VALUES ('"+p.getStato()+"','"+p.getTotal_price()+"','"+p.getData()+"','"+p.getShop().getId()+"','"+idcliente+"');";
        System.out.println(sql);
        DbConnection.getInstance().eseguiAggiornamento(sql);


        for (int i = 0; i<p.getArticoli().size(); i++) {
            String articolo = "UPDATE articolo SET Shop_List_idShop_List='" + p.getId() + "' WHERE idarticolo='"+p.getArticoli().get(i).getId()+"';";
            System.out.println(sql);
            DbConnection.getInstance().eseguiAggiornamento(sql);
        }
        }

    }
}
