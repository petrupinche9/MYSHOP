package it;

import it.model.Admin;
import it.view.administracionaggiungiprodotto;
import it.view.administracionelimina;

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
        // service.InsertService();
    }
}
//inserisci prodotto
class Ascoltatore4 implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        administracionaggiungiprodotto agg = new administracionaggiungiprodotto();
    }
}

class Ascoltatore7 implements ActionListener
{
    Admin mod = new Admin();
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        // mod.ModificationService();
    }
}

public class administracion extends JFrame
{
    private JButton aggiungiProfottoButton;
    private JButton modificaProdottoButton;
    private JButton eliminaArticoloButton;
    private JButton modificaServizioButton;
    private JButton aggiungiServizioButton;
    private JPanel administracionPanel;
    Ascoltatore5 listener5 = new Ascoltatore5();
    Ascoltatore4 listener4 = new Ascoltatore4();
    Ascoltatore7 listener7 = new Ascoltatore7();

    public administracion()
    {
        setContentPane(administracionPanel);
        setTitle("MODIFICA MYSHOP");
        aggiungiProfottoButton.addActionListener(listener4);
        aggiungiServizioButton.addActionListener(listener5);
        modificaServizioButton.addActionListener(listener7);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        eliminaArticoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionelimina delete = new administracionelimina();
            }
        });
    }
}
