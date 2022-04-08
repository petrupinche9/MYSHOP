package it.view;

import it.DAO.ShopDAO;
import it.DAO.articleDAO;
import it.DAO.managerDAO;
import it.DbConnection;
import it.model.Point_shop;
import it.model.article;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Addarticlemanager extends JFrame{
    private JTextField idarticle;
    private JButton CONFERMAButton;
    private JPanel addarticlePanel;
    private JComboBox comboBox1;
    private JTextField textField1;

    public Addarticlemanager()
    {
        setContentPane(addarticlePanel);
        setTitle("AGGIUNGI ARTICOLO MANAGER");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idarticle.getText();
                int idarticle = Integer.parseInt(id);
                String  name_shop= (String) comboBox1.getSelectedItem();
                ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idPoint_shop FROM Point_shop WHERE Shopname='"+name_shop+"'");

                if(res.size()==1){
                    String[] riga=res.get(0);
                    int idpoint = Integer.parseInt(riga[0]);
                    articleDAO add = new articleDAO();
                    article addarticle = add.findById(idarticle);
                    ShopDAO shop = new ShopDAO();
                    Point_shop puntovendita = shop.findById(idpoint);
                    managerDAO manager = new managerDAO();
                    manager.add_article_to_shop(addarticle, puntovendita);
                    JOptionPane.showMessageDialog(null, "Articolo Aggiunto");
                }else{
                    JOptionPane.showMessageDialog(null, "ERRORE");

                }






            }
        });
        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                comboBox1.removeAllItems();
                ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Shopname FROM Point_shop");

                for (String[] riga : res) {
                    comboBox1.addItem(riga[0]);
                }
            }
        });
    }


}
