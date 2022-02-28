package it;

import it.model.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//inserisci servizio
class Ascoltatore5 implements ActionListener
{
    Admin service = new Admin();
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        service.InsertService();
    }
}
//inserisci prodotto
class Ascoltatore4 implements ActionListener
{
    Admin insert = new Admin();
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        insert.Insertitem();
    }
}

class Ascoltatore6 implements ActionListener
{
    Admin rem = new Admin();
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        rem.DeleteService();
    }
}

class Ascoltatore7 implements ActionListener
{
    Admin mod = new Admin();
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        mod.ModificationService();
    }
}

public class administracion extends JFrame
{
    private JButton aggiungiProfottoButton;
    private JButton modificaProdottoButton;
    private JButton eliminaProdottoButton;
    private JButton eliminaServizioButton;
    private JButton modificaServizioButton;
    private JButton aggiungiServizioButton;
    private JPanel administracionPanel;
    Ascoltatore5 listener5 = new Ascoltatore5();
    Ascoltatore4 listener4 = new Ascoltatore4();
    Ascoltatore6 listener6 = new Ascoltatore6();
    Ascoltatore7 listener7 = new Ascoltatore7();

    public administracion()
    {
        setContentPane(administracionPanel);
        setTitle("MODIFICA MYSHOP");
        aggiungiProfottoButton.addActionListener(listener4);
        aggiungiServizioButton.addActionListener(listener5);
        eliminaServizioButton.addActionListener(listener6);
        modificaServizioButton.addActionListener(listener7);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
