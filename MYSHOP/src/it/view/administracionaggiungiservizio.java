package it.view;

import it.DAO.AdminDAO;
import it.model.Fornitore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class administracionaggiungiservizio extends JFrame {
    private JTextField Nomefield;
    private JTextField Sitoweb;
    private JTextField Citta;
    private JTextField Nazione;
    private JButton CONFERMAButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField11;
    private JButton sfogliaButton;
    private JTextArea textArea1;
    private JPanel aggiungiservicePanel;

    public administracionaggiungiservizio()
    {
        setContentPane(aggiungiservicePanel);
        setTitle("AGGIUNGI SERVIZIO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namefornitore = Nomefield.getText();
                String siteweb = Sitoweb.getText();
                String city = Citta.getText();
                String nation = Nazione.getText();
                int id = (int)(Math.random()*100);
                Fornitore newfornitore = new Fornitore(id, namefornitore, siteweb, city, nation);
                AdminDAO aggiungiservice = new AdminDAO();
            }
        });
        //button sfoglia
        sfogliaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//aggiunta foto
                JFrame frame = new JFrame();

                 String filename = File.separator+"tmp";
        JFileChooser fc = new JFileChooser(new File(filename));
        // Show open dialog; this method does not return until the dialog is closed
        fc.showOpenDialog(frame);
        File selFile = fc.getSelectedFile();
            }
        });
    }
}
