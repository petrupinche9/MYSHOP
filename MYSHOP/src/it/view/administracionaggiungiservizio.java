package it.view;

import it.DAO.AdminDAO;
import it.model.Fornitore;
import it.model.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionaggiungiservizio extends JFrame {
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField1;
    private JButton CONFERMAButton;
    private JPanel aggiungiservicePanel;

    public administracionaggiungiservizio()
    {
        setContentPane(aggiungiservicePanel);
        setTitle("AGGIUNGI SERVIZIO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namefor = textField1.getText();
                String namefornitore = textField3.getText();
                String siteweb = textField4.getText();
                String city = textField5.getText();
                String nation = textField6.getText();
                int id = (int)(Math.random()*100);
                service newservice = new service(id, namefor);
                Fornitore newfornitore = new Fornitore(id, namefornitore, siteweb, city, nation);
                AdminDAO aggiungiservice = new AdminDAO();
                aggiungiservice.newservice(newservice, newfornitore);
            }
        });
    }
}
