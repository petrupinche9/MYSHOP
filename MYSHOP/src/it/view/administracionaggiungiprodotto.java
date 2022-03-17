package it.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionaggiungiprodotto extends JFrame {
    private JTextField category;
    private JTextField subcategory;
    private JTextField costo;
    private JTextField corsia;
    private JTextField scaffale;
    private JTextField prod_name;
    private JTextField website;
    private JTextField city;
    private JTextField nation;
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

        AGGIUNGISOTTOPRODOTTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administracionaggiungisottoprodotto cf = new administracionaggiungisottoprodotto();
                cf.setVisible(true);
                cf.pack();
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
    }
}
