package it.view;

import it.DAO.ShopDAO;
import it.DAO.managerDAO;
import it.DAO.userDAO;
import it.model.Point_shop;
import it.model.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deleteusermanager extends JFrame{
    private JTextField textField1;
    private JButton CONFERMAButton;
    private JTextField textField2;
    private JPanel deleteuserPanel;

    public Deleteusermanager()
    {
        setContentPane(deleteuserPanel);
        setTitle("ELIMINA UTENTE MANAGER");
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
                user deleteuser = userdao.findById(iduser);
                ShopDAO shop = new ShopDAO();
                Point_shop puntovendita = shop.findById(idpoint);
                managerDAO manager = new managerDAO();
                manager.erase_user_from_shop(deleteuser, puntovendita);
                JOptionPane.showMessageDialog(null, "Utente Eliminato");
            }
        });
    }
}
