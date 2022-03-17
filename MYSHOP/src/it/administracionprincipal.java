package it;

import it.util.Session;
import it.view.Catalogue;
import it.view.MENU;
import it.view.administracionpuntivendita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class administracionprincipal extends JFrame
{
    private JButton vaiAlMyShopButton;
    private JButton vaiAllaClasseDiButton;
    private JButton creaPuntiVenditaButton;
    private JButton LOGOUTButton;
    private JPanel administracionprincipal;
    private JButton logout;

    public administracionprincipal()
    {
        setContentPane(administracionprincipal);
        setTitle("GESTIONE MYSHOP");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // vai al catalogo
        vaiAlMyShopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Catalogue mf = new Catalogue();
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
                mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        //vai a creare punti vendita
        creaPuntiVenditaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionpuntivendita mf = new administracionpuntivendita();
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
                mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        //vai a modifica
        vaiAllaClasseDiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracion mf= new administracion();
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
                mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });

        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session.getInstance().setClienteLoggato(null);
                MENU mf = new MENU();
                mf.setSize(300,300);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
                dispose();

            }
        });

    }
}
