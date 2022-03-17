package it.view;

import it.DbConnection;
import it.model.user;
import it.util.Session;

import javax.swing.*;
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

                String query = "SELECT * FROM user WHERE username="+uname+" AND passwd ="+pass+";";

                res = DbConnection.getInstance().eseguiQuery(query);
                if(res.size()==1) {
                    String[] riga = res.get(0);
                    user c = new user();
                    c.setId(Integer.parseInt(riga[0]));
                    c.setUsername(riga[1]);
                    c.setPassword(riga[2]);
                    c.setName(riga[3]);
                    c.setSurname(riga[4]);
                    c.setAge(Integer.parseInt(riga[5]));
                    c.setEmail(riga[6]);
                    c.setTelephone(Integer.parseInt(riga[7]));
                    c.setOccupation(riga[8]);
                    Session.getInstance().setClienteLoggato(c);

                    HomePage_guest mf = new HomePage_guest();
                    mf.setVisible(true);
                    mf.pack();
                    mf.setLocationRelativeTo(null);
                    mf.setExtendedState(JFrame.DO_NOTHING_ON_CLOSE);

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
                rf.setExtendedState(JFrame.EXIT_ON_CLOSE);
            }
        });
      /*  comboBox1.addActionListener(new ActionListener() {
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
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ArrayList<String[]> ShopNames = DbConnection.getInstance().eseguiQuery("SELECT Shopname FROM Point_shop ORDER BY Shopname");
// Populate the combo box
                DefaultComboBoxModel model = new DefaultComboBoxModel(ShopNames.toArray());
                comboBox1.setModel(model);
            }
        });*/
    }

}
