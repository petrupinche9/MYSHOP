package it.view;

import it.DAO.AdminDAO;
import it.DAO.IAdminDAO;
import it.model.Point_shop;
import it.model.manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicLong;

public class administracionpuntivendita extends JFrame {
    private JTextField username_mng;
    private JTextField shopname;
    private JButton CONFERMAButton;
    private JTextField city;
    private JTextField article_type;
    private JTextField passwd_mng;
    private JTextField surname;
    private JTextField age;
    private JTextField mail;
    private JTextField telephone;
    private JTextField profession;
    private JTextField textField5;
    private JButton CREAUNMANAGERButton;
    private JPanel managerPanel;
    private JTextField idshop;
    private JTextField name;

    public administracionpuntivendita()
    {
        setContentPane(managerPanel);
        setTitle("Creare Punti Vendita");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point_shop shop=new Point_shop();
                manager mng=new manager();
                //parsing shop
                shop.setShopname(shopname.getText());
                shop.setCity(city.getText());
                shop.setArticle_type(article_type.getText());

                //parsing manager
                mng.setId(Integer.parseInt(createID()));
                mng.setUsername(username_mng.getText());
                mng.setPassword(passwd_mng.getText());
                mng.setName(name.getText());
                mng.setSurname(surname.getText());
                mng.setAge(Integer.parseInt(age.getText()));
                mng.setEmail(mail.getText());
                mng.setTelephone(Integer.parseInt(telephone.getText()));
                mng.setOccupation(profession.getText());
                mng.setShop(shop);
                IAdminDAO admin =new AdminDAO();
                admin.create_shopandmanager(shop,mng);

            }
        });
    }
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }

}
