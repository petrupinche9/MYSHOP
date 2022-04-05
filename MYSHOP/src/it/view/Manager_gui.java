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

                Addarticlemanager addproduct = new Addarticlemanager();
            }
        });

        eliminaUnArticoloDaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deletearticlemanager deleteproduct = new Deletearticlemanager();
            }
        });

        aggiungiUtenteAlPuntoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Addusermanager adduser = new Addusermanager();
            }
        });

        eliminaUtenteDaUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Deleteusermanager deleteuser = new Deleteusermanager();
            }
        });

        inviaEMailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sendemailmanager send = new sendemailmanager();
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
