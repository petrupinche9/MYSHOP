package it.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionpuntivendita extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField inserisciPASSWORDTextField;
    private JTextField textField7;
    private JTextField inserisciCOGNOMETextField;
    private JTextField inserisciETÀTextField;
    private JTextField inserisciEMAILTextField;
    private JTextField inserisciNUMERODITELEFONOTextField;
    private JTextField inserisciPROFESSIONETextField;
    private JTextField textField5;
    private JButton CREAUNMANAGERButton;
    private JPanel managerPanel;

    public administracionpuntivendita()
    {
        setContentPane(managerPanel);
        setTitle("Creare Punti Vendita");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                int id = Integer.parseInt(text1);
                String text2 = textField2.getText();
                String text3 = textField3.getText();
                String text4 = textField4.getText();

            }
        });
    }
}
