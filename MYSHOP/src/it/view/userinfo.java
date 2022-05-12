package it.view;

import it.DAO.userDAO;
import it.model.user;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userinfo extends JFrame
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


    public userinfo()
    {
        setContentPane(RegistrazionePannello);
        setTitle("REGISTRAZIONE MYSHOP");
        setSize(700, 500);
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
    }

    public void setName(String name) {
        Name.setText(name);
    }

    public void setSurname(String surname) {
        Surname.setText(surname);
    }

    public void setEmail(String email) {
        Email.setText(email);
    }

    public void setAge(String age) {
        Age.setText(age);
    }

    public void setUsername(String Username) {
        username.setText(Username);
    }

    public void setOccupation(String Occupation) {
        occupation.setText(Occupation);
    }

    public void setTelephone(String telephone) {
        Telephone.setText(telephone);
    }

    public void setPasswd(String Passwd) {
        passwd.setText(Passwd);
    }

}
