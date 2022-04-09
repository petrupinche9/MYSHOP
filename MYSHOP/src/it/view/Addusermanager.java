package it.view;

import it.DAO.managerDAO;
import it.DAO.userDAO;
import it.model.user;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addusermanager extends JFrame{
    private JTextField textField1;
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
                userDAO userdao = new userDAO();
                user adduser = userdao.findById(iduser);
                managerDAO manager = new managerDAO();
                manager.add_user_to_shop(adduser, manager.findById(Session.getInstance().getClienteLoggato().getId()));
                JOptionPane.showMessageDialog(null, "Utente Aggiunto");
            }
        });
    }
}
