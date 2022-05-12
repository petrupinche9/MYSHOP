package it.view;

import it.DAO.Shop_listDAO;
import it.DAO.managerDAO;
import it.model.Shop_list;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiornaStatomanager extends JFrame
{
    private JPanel aggiornastatoPanel;
    private JTextField textField1;
    private JButton AGGIORNAButton;

    public AggiornaStatomanager()
    {
        setContentPane(aggiornastatoPanel);
        setTitle("AGGIORNA LISTA-SPESA");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        AGGIORNAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                int idlist = Integer.parseInt(id);
                Shop_listDAO lista = new Shop_listDAO();
                Shop_list aggiornalista = lista.findById(idlist);
                managerDAO manager = new managerDAO();
                manager.aggiornolostato(aggiornalista);
                JOptionPane.showMessageDialog(null, "Lista Aggiornata");
            }
        });
    }
}
