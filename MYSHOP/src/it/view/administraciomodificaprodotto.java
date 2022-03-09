package it.view;

import javax.swing.*;

public class administraciomodificaprodotto extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JPanel modificaprodottoPanel;

    public administraciomodificaprodotto()
    {
        setContentPane(modificaprodottoPanel);
        setTitle("MODIFICA PRODOTTO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
