package it.view;

import javax.swing.*;

public class administracionaggiungiservizio extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JButton CREAFORNITOREButton;
    private JPanel aggiungiservicePanel;

    public administracionaggiungiservizio()
    {
        setContentPane(aggiungiservicePanel);
        setTitle("AGGIUNGI SERVIZIO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
