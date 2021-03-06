package it.view;

import it.DAO.AdminDAO;
import it.DAO.IAdminDAO;
import it.model.Point_shop;
import it.model.manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionpuntivendita extends JFrame {
    private JTextField username;
    private JTextField shopname;
    private JButton CONFERMAButton;
    private JTextField city;
    private JPasswordField passwd;
    private JTextField surname;
    private JTextField age;
    private JTextField mail;
    private JTextField telephone;
    private JTextField occupation;
    private JTextField textField5;
    private JButton CREAUNMANAGERButton;
    private JPanel managerPanel;
    private JTextField name;
    private JButton GOBACKButton;
    private JComboBox article_type;

    public administracionpuntivendita()
    {
        setContentPane(managerPanel);
        setTitle("Creare Punti Vendita");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        article_type.addItem("prodotti");
        article_type.addItem("servizi");
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point_shop shop=new Point_shop();
                manager mng=new manager();
                //setta shop
                shop.setShopname(shopname.getText());
                shop.setCity(city.getText());
                shop.setArticle_type(article_type.getSelectedItem().toString());
                //setta manager
                mng.setUsername(username.getText());
                mng.setPassword(passwd.getText());
                mng.setName(name.getText());
                mng.setSurname(surname.getText());
                mng.setAge(Integer.parseInt(age.getText()));
                mng.setEmail(mail.getText());
                mng.setTelephone(Integer.parseInt(telephone.getText()));
                mng.setOccupation(occupation.getText());
                shop.setMng(mng);
                IAdminDAO admin=new AdminDAO();
                admin.create_shopandmanager(shop,mng);

            }
        });
        GOBACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionprincipal cf = new administracionprincipal();
                cf.setVisible(true);
                cf.pack();
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                dispose();
            }
        });
    }
}
