package it.view;

import it.DAO.AdminDAO;
import it.model.Admin;
import it.model.Point_shop;
import it.model.manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionpuntivendita extends JFrame {
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField1;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton CONFERMAButton;
    private JPanel puntovenditaPanel;

    public administracionpuntivendita()
    {
        setContentPane(puntovenditaPanel);
        setTitle("Creare Punti Vendita");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shopname = textField2.getText();
                String cityname = textField3.getText();
                String articletype = textField4.getText();
                String user = textField1.getText();
                String pwd = textField6.getText();
                String name = textField7.getText();
                String surname = textField8.getText();
                String a = textField9.getText();
                int age = Integer.parseInt(a);
                String email = textField10.getText();
                String p = textField11.getText();
                int phone = Integer.parseInt(p);
                String occupation = textField12.getText();
                int randomid = (int)(Math.random()*100);
                manager newmanager = new manager(randomid, user, pwd, name, surname, age, email, phone, occupation);
                Point_shop newpoint = new Point_shop(randomid, shopname, cityname, articletype, newmanager);
                AdminDAO function = new AdminDAO();
                function.create_shopandmanager(newpoint, newmanager);
                JOptionPane.showMessageDialog(null,"Punto Vendita e Manager creati!");
            }
        });
    }
}
