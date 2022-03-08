package it.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionaggiungiprodotto extends JFrame {
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField9;
    private JTextField textField10;
    private JButton CONFERMAButton;
    private JButton AGGIUNGISOTTOPRODOTTOButton;
    private JPanel aggiungiprodottoPanel;

    public administracionaggiungiprodotto()
    {
        setContentPane(aggiungiprodottoPanel);
        setTitle("AGGIUNGI PRODOTTO");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
