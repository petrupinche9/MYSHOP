package it.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ascoltatore2 implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {

    }
}

public class puntovenditamanager extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JPanel puntovenditamanagerPanel;
    private JButton CONFERMAButton;
    Ascoltatore2 listener2 = new Ascoltatore2();

    public puntovenditamanager()
    {
        setContentPane(puntovenditamanagerPanel);
        CONFERMAButton.addActionListener(listener2);
        setTitle("Crea Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
