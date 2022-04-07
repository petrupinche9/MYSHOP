package it.view;

import it.DAO.userDAO;
import it.DbConnection;
import it.model.user;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class REGISTRAZIONE extends JFrame
{
    private JTextField Name;
    private JTextField Surname;
    private JTextField Email;
    private JTextField Telephone;
    private JTextField occupation;
    private JButton COMPLETAREGISTRAZIONEButton;
    private JPanel RegistrazionePannello;
    private JTextField Age;
    private JTextField username;
    private JPasswordField passwd;
    private JComboBox<String> comboBox1;
    private JTextField idtext;

    public REGISTRAZIONE()
    {
        setContentPane(RegistrazionePannello);
        setTitle("REGISTRAZIONE MYSHOP");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        //AZIONE DA COMPIERE bottone Registrati->> QUERY INSERT PER AGGIORNARE DATABASE
        COMPLETAREGISTRAZIONEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user p=new user();
                p.setName(Name.getText());
                p.setSurname(Surname.getText());
                p.setEmail(Email.getText());
                p.setTelephone(Integer.parseInt(Telephone.getText()));
                p.setTelephone(Integer.parseInt(Age.getText()));
                p.setOccupation(occupation.getText());
                p.setUsername(username.getText());
                p.setPassword(String.valueOf(passwd.getPassword()));
                userDAO reg =new userDAO();
                reg.newuser(p);
                Session.getInstance().setClienteLoggato(p);
                Catalogue mf = new Catalogue();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();

            }
        });



        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                comboBox1.removeAllItems();
                ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Shopname FROM Point_shop");

                     for (String[] riga : res) {
                                comboBox1.addItem(riga[0]);
                    }
                }
        });
    }
}
