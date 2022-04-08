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
    private JButton CONFERMAButton;
    private JPanel addarticlePanel;
    private JTextField textField1;

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
                int idproduct = Integer.parseInt(id);
                String id2 = textField1.getText();
                int idpoint = Integer.parseInt(id2);
                productDAO add = new productDAO();
                Product addproduct = add.findById(idproduct);
                ShopDAO shop = new ShopDAO();
                Point_shop puntovendita = shop.findById(idpoint);
                managerDAO manager = new managerDAO();
                manager.add_product_to_shop(addproduct, puntovendita);
                JOptionPane.showMessageDialog(null, "Prodotto Aggiunto");
            }
        });
    }


}
