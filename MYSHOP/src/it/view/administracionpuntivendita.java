package it.view;
import it.model.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ascoltatore implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        puntovenditamanager manager = new puntovenditamanager();
    }
}

public class administracionpuntivendita extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONFERMAButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton CREAUNMANAGERButton;
    private JPanel managerPanel;
    Ascoltatore listener = new Ascoltatore();

    public administracionpuntivendita()
    {
        setContentPane(managerPanel);
        setTitle("Creare Punti Vendita");
        CREAUNMANAGERButton.addActionListener(listener);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
