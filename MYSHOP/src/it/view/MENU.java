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
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        passwordField1.setHorizontalAlignment(JTextField.CENTER);
        //Azione da compiere al Click (LOGIN)
        LOGINButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String[]> res;
                ResultSet rs;
                String uname = textField1.getText();
                String pass = String.valueOf(passwordField1.getPassword());

                String query = "SELECT * FROM user WHERE username='"+uname+"' AND passwd ='"+pass+"';";

                res = DbConnection.getInstance().eseguiQuery(query);
                if(admin_cred(uname, pass)==true && res.size()==1) {
                    JOptionPane.showMessageDialog(null,"BENVENUTO ADMIN");
                    String[] riga = res.get(0);
                    user admin = new user();
                    admin.setId(Integer.parseInt(riga[0]));
                    admin.setUsername(riga[1]);
                    admin.setPassword(riga[2]);
                    admin.setName(riga[3]);
                    admin.setSurname(riga[4]);
                    admin.setAge(Integer.parseInt(riga[5]));
                    admin.setEmail(riga[6]);
                    admin.setTelephone(Integer.parseInt(riga[7]));
                    admin.setOccupation(riga[8]);
                    Session.getInstance().setClienteLoggato(admin);
                    administracionprincipal cf = new administracionprincipal();
                    cf.setVisible(true);
                    cf.pack();
                    cf.setLocationRelativeTo(null);
                    cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    dispose();
                    // dispatchEvent(new WindowEvent(MENU1, WindowEvent.WINDOW_CLOSING));


                }else if(mng_cred(uname, pass)==true && res.size()==1){
                    JOptionPane.showMessageDialog(null,"BENVENUTO MANAGER");
                    String[] riga = res.get(0);
                    user mng = new user();
                    mng.setId(Integer.parseInt(riga[0]));
                    mng.setUsername(riga[1]);
                    mng.setPassword(riga[2]);
                    mng.setName(riga[3]);
                    mng.setSurname(riga[4]);
                    mng.setAge(Integer.parseInt(riga[5]));
                    mng.setEmail(riga[6]);
                    mng.setTelephone(Integer.parseInt(riga[7]));
                    mng.setOccupation(riga[8]);
                    Session.getInstance().setClienteLoggato(mng);
                    Manager_gui lf = new Manager_gui();
                    lf.setVisible(true);
                    lf.pack();
                    //lf.setSize(300, 300);
                    lf.setLocationRelativeTo(null);
                    lf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    dispose();
                    // dispatchEvent(new WindowEvent(MENU1, JFrame.DISPOSE_ON_CLOSE));

                } else if(res.size()==1 && mng_cred(uname, pass)!=true && admin_cred(uname, pass)!=true ) {
                    JOptionPane.showMessageDialog(null,"BENVENUTO CLIENTE");
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

                    Catalogue mf = new Catalogue();
                    mf.setSize(700,700);
                    mf.setVisible(true);
                    mf.pack();
                    mf.setLocationRelativeTo(null);
                    mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    dispose();
                    //  dispatchEvent(new WindowEvent(MENU1, JFrame.DISPOSE_ON_CLOSE));
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
                mf.setSize(700,700);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
                dispose();
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
                rf.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
                dispose();
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
    public boolean admin_cred( String globalus, String globalpass){
        String admin = "SELECT * FROM user INNER JOIN admin AS a ON iduser=a.user_iduser WHERE username='"+globalus+"' AND passwd ='"+globalpass+"';";
        ArrayList<String[]> res_adm = DbConnection.getInstance().eseguiQuery(admin);
        if(res_adm.size()==1){
            return true;
        }else{return false;}
    }
    public boolean mng_cred(String globalus, String globalpass){
        String mng = "SELECT * FROM user INNER JOIN manager AS m ON iduser=m.user_iduser WHERE username='"+globalus+"' AND passwd ='"+globalpass+"';";
        ArrayList<String[]> res_mng = DbConnection.getInstance().eseguiQuery(mng);
        if(res_mng.size()==1){
            return true;
        }else
        {return false;}
    }

}
