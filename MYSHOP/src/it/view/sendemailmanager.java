package it.view;

import it.DAO.managerDAO;
import it.DAO.userDAO;
import it.DbConnection;
import it.model.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class sendemailmanager extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton CONFERMAButton;
    private JTextArea textArea1;
    private JPanel sendmailPanel;
    private JButton CHIUDIButton;

    public boolean utentetrovato(int number)
    {
        String ut = "SELECT * FROM user WHERE iduser='"+number+"'";
        ArrayList<String[]> res_utente = DbConnection.getInstance().eseguiQuery(ut);
        if(res_utente.size()==1)
        {
            return true;
        } else {
            return false;
        }
    }

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
                boolean trovato = utentetrovato(iduser);
                if (trovato==true)
                {
                    userDAO utente = new userDAO();
                    user utentemessage = utente.findById(iduser);
                    String object = textField2.getText();
                    String message = textArea1.getText();
                    managerDAO manager = new managerDAO();
                    manager.send_email_to_client(utentemessage, object, message);
                    JOptionPane.showMessageDialog(null, "E-mail Inviata");
                } else {
                    JOptionPane.showMessageDialog(null, "Utente non trovato", "User not Found", 2);
                }
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
