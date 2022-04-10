package it.view;

import it.DAO.managerDAO;
import it.DAO.userDAO;
import it.model.user;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deleteusermanager extends JFrame{
    private JTextField textField1;
    private JButton CONFERMAButton;
    private JPanel deleteuserPanel;
    private JButton CHIUDIButton;

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
                userDAO userdao = new userDAO();
                user deleteuser = userdao.findById(iduser);
                managerDAO manager = new managerDAO();
                manager.erase_user_from_shop(deleteuser, manager.findById(Session.getInstance().getClienteLoggato().getId()));
                JOptionPane.showMessageDialog(null, "Utente Eliminato");
            }
        });
        CHIUDIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
