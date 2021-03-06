package it.DAO;

import it.DbConnection;
import it.model.Point_shop;
import it.model.Shop_list;
import it.model.article;
import it.model.user;
import it.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;

public class Shop_listDAO implements IShop_listDAO{
    @Override
    public Shop_list findById(int id) {

        Shop_list p = new Shop_list();

        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM Shop_list WHERE idShop_list = "+id+";");

        if(res.size()==1) {
            String[] riga = res.get(0);
            p = new Shop_list();
            p.setId(Integer.parseInt(riga[0]));
            p.setStato(riga[1]);
            p.setTotal_price(Double.parseDouble(riga[2]));
            IuserDAO cDao = new userDAO();
            IarticleDAO aDao= new articleDAO();
            ArrayList<article> lista=new ArrayList<>();
            ArrayList<String[]> art = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Shop_List_idShop_List = "+id+";");
            for(String[] ris : art) {
                article ro = aDao.findById(Integer.parseInt(ris[0]));
                lista.add(ro);
            }
            p.setArticoli(lista);
            IShopDAO mDao = new ShopDAO();
            user Cliente = cDao.findById(Integer.parseInt(riga[5]));
            Point_shop shop = mDao.findById(Integer.parseInt(riga[4]));
            p.setCliente(Cliente);
            p.setShop(shop);
            p.setData(riga[3]);
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
        ArrayList<String[]> sea = DbConnection.getInstance().eseguiQuery("SELECT idCliente FROM Cliente INNER JOIN user AS p ON p.iduser=user_iduser WHERE p.username='"+p.getCliente().getUsername()+"'");
        String[] riga;
        int idcliente=0;
        if(sea.size()==1) {
            riga = sea.get(0);
            idcliente = Integer.parseInt(riga[0]);
            String sql = "INSERT INTO Shop_list (Stato,total_price,Date,Point_shop_idPoint_shop,Cliente_idCliente) VALUES ('" + p.getStato() + "','" + p.getTotal_price() + "','" + p.getData() + "','" + p.getShop().getId() + "','" + idcliente + "');";
            DbConnection.getInstance().eseguiAggiornamento(sql);

            ArrayList<String[]> point = DbConnection.getInstance().eseguiQuery("SELECT idShop_List FROM Shop_list WHERE Cliente_idCliente='" + idcliente + "' && Date='" + p.getData() + "';");
            String[] rig;
            int idlista = 0;
            if (sea.size() == 1) {
                rig = point.get(0);
                idlista = Integer.parseInt(rig[0]);
                for (int i = 0; i < p.getArticoli().size(); i++) {
                    String articolo = "UPDATE articolo SET Shop_List_idShop_List='" + idlista + "' WHERE idarticolo='" + p.getArticoli().get(i).getId() + "';";
                    DbConnection.getInstance().eseguiAggiornamento(articolo);
                }
            }
        }

    }
}
