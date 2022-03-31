package it.view;

import it.DAO.IserviceDAO;
import it.DAO.serviceDAO;
import it.DbConnection;
import it.model.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class adminmod_serv extends JFrame {
    private JTextField idtext;
    private JButton SEARCHButton;
    private JPanel search_serv;


    public adminmod_serv() {
        setContentPane(search_serv);
        setTitle("MODIFICA MYSHOP");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mod_serv agg = new mod_serv();
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setVisible(true);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                IserviceDAO s=new serviceDAO();
                service serv=s.findById(Integer.parseInt(idtext.getText()));
                mod_serv cf=new mod_serv();
                byte[] img= DbConnection.getInstance().getFoto("SELECT Image_descr FROM articolo_photo INNER JOIN articolo AS f ON articolo_idarticolo=f.idarticolo WHERE f.Name='"+serv.getName()+"' AND f.description='"+serv.getDescr()+"';");
                try {
                    cf.setimage_mod(img);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                cf.setVisible(true);
                cf.pack();
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              //  cf.setSize(300,300);

                cf.setName_mod(serv.getName());
                cf.setDescr_mod(serv.getDescr());
                cf.setcat_mod(serv.getCategory());
                cf.setcosto_mod(serv.getCosto());
                cf.setlastid_serv(Integer.parseInt(idtext.getText()));
                try {
                    cf.setimage_mod(serv.getImg());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
