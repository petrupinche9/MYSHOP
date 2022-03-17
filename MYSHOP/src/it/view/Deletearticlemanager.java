package it.view;

import it.DAO.ShopDAO;
import it.DAO.managerDAO;
import it.DAO.productDAO;
import it.model.Point_shop;
import it.model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deletearticlemanager extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JPanel deletearticlePanel;

    public Deletearticlemanager()
    {
        setContentPane(deletearticlePanel);
        setTitle("ELIMINA PRODOTTO MANAGER");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                int idarticle = Integer.parseInt(id);
                String id2 = textField2.getText();
                int idpoint = Integer.parseInt(id2);
                productDAO delete = new productDAO();
                Product deletearticle = delete.findById(idarticle);
                ShopDAO shop = new ShopDAO();
                Point_shop puntovendita = shop.findById(idpoint);
                managerDAO manager = new managerDAO();
                manager.erase_product_from_shop(deletearticle, puntovendita);
                JOptionPane.showMessageDialog(null, "Prodotto Eliminato");
            }
        });
    }
}
