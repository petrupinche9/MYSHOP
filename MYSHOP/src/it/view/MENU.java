package it.view;

import it.DbConnection;
import it.model.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MENU extends JFrame
{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel Login;
    private JButton LOGINButton;
    private JButton LOGINASGUESTButton;
    private JButton REGISTRATIButton;
    private JComboBox comboBox1;

    public MENU()
    {
        setContentPane(Login);
        setTitle("MYSHOP");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        //Azione da compiere al Click (LOGIN)
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String[]> res;
                ResultSet rs;
                String uname = textField1.getText();
                String pass = String.valueOf(passwordField1.getPassword());

                String query = "SELECT * FROM it.model.user WHERE username="+uname+" AND passwd ="+pass+";";

                res = DbConnection.getInstance().eseguiQuery(query);

                if(res.size()==1) {
                    String[] riga = res.get(0);
                    user c = new user();
                    c.setId(Integer.parseInt(riga[0]));
                    c.setUsername(riga[1]);
                    c.setPassword(riga[2]);

                    HomePage_guest mf = new HomePage_guest();
                    mf.setVisible(true);
                    mf.pack();
                    mf.setLocationRelativeTo(null);
                    mf.setExtendedState(JFrame.MAXIMIZED_BOTH);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                }

            }
        });
        //Azione da compiere al Click(LOGIN GUEST)
        LOGINASGUESTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage_guest mf = new HomePage_guest();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        //Azione da compiere al Click->> UTENTE SI REGISTRA
        REGISTRATIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                REGISTRAZIONE rf = new REGISTRAZIONE();
                rf.setVisible(true);
                rf.pack();
                rf.setLocationRelativeTo(null);
                rf.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {// updates to the Swing GUI must be done on EDT
                        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Shopname FROM Point_shop");
                        if(res.size()==1) {
                            for (int i = 0; i < res.size(); ++i) {
                                String[] riga = res.get(0);
                                comboBox1.addItem(riga[i]);
                            }
                        }
                    }
                });

            }
        });
    }
}
