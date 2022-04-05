package it.view;

import it.DAO.ShopDAO;
import it.DAO.managerDAO;
import it.DAO.productDAO;
import it.model.Point_shop;
import it.model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addarticlemanager extends JFrame{
    private JTextField idarticle;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JComboBox shops;
    private JPanel addarticlePanel;

    public Addarticlemanager()
    {
        setContentPane(addarticlePanel);
        setTitle("AGGIUNGI PRODOTTO MANAGER");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idarticle.getText();
                int idarticle = Integer.parseInt(id);
                String id2 = textField2.getText();
                int idpoint = Integer.parseInt(id2);
                productDAO add = new productDAO();
                Product addarticle = add.findById(idarticle);
                ShopDAO shop = new ShopDAO();
                Point_shop puntovendita = shop.findById(idpoint);
                managerDAO manager = new managerDAO();
                manager.add_product_to_shop(addarticle, puntovendita);
                JOptionPane.showMessageDialog(null, "Prodotto Aggiunto");
            }
        });
    }


}
