package it.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracion extends JFrame
{
    private JButton aggiungiProdottoButton;
    private JButton modificaProdottoButton;
    private JButton eliminaArticoloButton;
    private JButton modificaServizioButton;
    private JButton aggiungiServizioButton;
    private JPanel administracionPanel;

    public administracion()
    {
        setContentPane(administracionPanel);
        setTitle("MODIFICA MYSHOP");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        //elimina articolo
        eliminaArticoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionelimina agg = new administracionelimina();
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setVisible(true);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        //modifica articolo
        modificaProdottoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminmod_prod agg = new adminmod_prod();
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setVisible(true);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        //modifica servizio
        modificaServizioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminmod_serv agg = new adminmod_serv();
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setVisible(true);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        aggiungiProdottoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionaggiungiprodotto agg = new administracionaggiungiprodotto();
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setVisible(true);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        aggiungiServizioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionaggiungiservizio agg = new administracionaggiungiservizio();
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setVisible(true);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
/*
    //inserisci servizio
    class Ascoltatore5 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JButton b = (JButton)event.getSource();

        }
    }

    //inserisci prodotto
    class Ascoltatore4 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JButton b = (JButton)event.getSource();

        }
    }
*/

}
