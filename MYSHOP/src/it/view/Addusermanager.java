package it.view;

import it.DAO.ShopDAO;
import it.DAO.managerDAO;
import it.DAO.userDAO;
import it.model.Point_shop;
import it.model.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addusermanager extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JPanel adduserPanel;

    public Addusermanager()
    {
        setContentPane(adduserPanel);
        setTitle("AGGIUNGI UTENTE MANAGER");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                int iduser = Integer.parseInt(id);
                String id2 = textField2.getText();
                int idpoint = Integer.parseInt(id2);
                userDAO userdao = new userDAO();
                user adduser = userdao.findById(iduser);
                ShopDAO shop = new ShopDAO();
                Point_shop puntovendita = shop.findById(idpoint);
                managerDAO manager = new managerDAO();
                manager.add_user_to_shop(adduser, puntovendita);
                JOptionPane.showMessageDialog(null, "Utente Aggiunto");
            }
        });
    }
}
