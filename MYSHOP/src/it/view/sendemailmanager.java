package it.view;

import it.DAO.managerDAO;
import it.DAO.userDAO;
import it.model.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sendemailmanager extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton CONFERMAButton;
    private JPanel sendmailPanel;

    public sendemailmanager()
    {
        setContentPane(sendmailPanel);
        setTitle("INVIA E_MAIL MANAGER");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                int iduser = Integer.parseInt(id);
                userDAO utente = new userDAO();
                user utentemessage = utente.findById(iduser);
                String object = textField2.getText();
                String message = textField3.getText();
                managerDAO manager = new managerDAO();
                manager.send_email_to_client(utentemessage, object, message);
                JOptionPane.showMessageDialog(null, "E-mail Inviata");
            }
        });
    }
}
