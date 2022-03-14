package it.DAO;

import it.DbConnection;
import it.model.Point_shop;
import it.model.Shop_list;
import it.model.article;
import it.model.user;
import it.util.DateUtil;

import java.util.ArrayList;

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
            p.setData(DateUtil.dateTimeFromString(riga[6]));
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
    public void save_Shop_list(Shop_list p, ArrayList<article> ar) {

        String strDataPrenotazione = DateUtil.stringFromDate(p.getData());
        String sql = "INSERT INTO Shop_list VALUES ('"+p.getId()+"', '"+p.getStato()+"',"+p.getTotal_price()+","+p.getData()+","+p.getShop().getId()+","+p.getCliente().getId()+");";
        System.out.println(sql);
        DbConnection.getInstance().eseguiAggiornamento(sql);

        for (int i = 0; i<p.getArticoli().size(); i++) {
            String articolo = "UPDATE articolo SET Shop_List_idShop_List='" + p.getId() + "' WHERE idarticolo='"+ar.get(i).getId()+"';";
            System.out.println(sql);
            DbConnection.getInstance().eseguiAggiornamento(sql);
        }


    }
}
