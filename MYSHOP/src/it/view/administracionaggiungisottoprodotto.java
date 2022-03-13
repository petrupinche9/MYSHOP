package it.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionaggiungisottoprodotto extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton CONFERMAButton1;
    private JButton CREAFORNITOREButton1;
    private JPanel administracionaggiungiPanel;

    public administracionaggiungisottoprodotto()
    {
        setContentPane(administracionaggiungiPanel);
        setTitle("AGGIUNGI PRODOTTO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        CONFERMAButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
