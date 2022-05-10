package it.view;

import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager_gui extends JFrame
{
    private JPanel managerPanel;
    private JButton aggiungiUnArticoloAlButton;
    private JButton eliminaUnArticoloDaButton;
    private JButton aggiungiUtenteAlPuntoButton;
    private JButton eliminaUtenteDaUnButton;
    private JButton inviaEMailButton;
    private JButton LOGOUTButton;
    private JButton aggiornaListaSpesaButton;

    public Manager_gui()
    {
        setContentPane(managerPanel);
        setTitle("MANAGER GUI");
       // setSize(700, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        aggiungiUnArticoloAlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Addarticlemanager addarticle = new Addarticlemanager();
                addarticle.setVisible(true);
                addarticle.pack();
                addarticle.setLocationRelativeTo(null);
                addarticle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        eliminaUnArticoloDaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deletearticlemanager deleteproduct = new Deletearticlemanager();
                deleteproduct.setVisible(true);
                deleteproduct.pack();
                deleteproduct.setLocationRelativeTo(null);
                deleteproduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        aggiungiUtenteAlPuntoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Addusermanager adduser = new Addusermanager();
                adduser.setVisible(true);
                adduser.pack();
                adduser.setLocationRelativeTo(null);
                adduser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        eliminaUtenteDaUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Deleteusermanager deleteuser = new Deleteusermanager();
                deleteuser.setVisible(true);
                deleteuser.pack();
                deleteuser.setLocationRelativeTo(null);
                deleteuser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        inviaEMailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sendemailmanager send = new sendemailmanager();
                send.setVisible(true);
                send.pack();
                send.setLocationRelativeTo(null);
                send.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        aggiornaListaSpesaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiornaStatomanager agg = new AggiornaStatomanager();
                agg.setVisible(true);
                agg.pack();
                agg.setLocationRelativeTo(null);
                agg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
