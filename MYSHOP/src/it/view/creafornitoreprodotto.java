package it.view;

import javax.swing.*;

public class creafornitoreprodotto extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton CONFERMAButton;
    private JPanel fornitorePanel;

    public creafornitoreprodotto()
    {
        setContentPane(fornitorePanel);
        setTitle("FORNITORE PRODOTTO");
        setSize(700, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
