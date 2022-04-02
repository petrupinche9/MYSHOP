package it.view;

import it.DAO.AdminDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionelimina extends JFrame{

    private JButton ELIMINAARTICOLOButton;
    private JTextField idtext;
    private JPanel administracioneliminaPanel;

    public administracionelimina()
    {
        setContentPane(administracioneliminaPanel);
        setTitle("ELIMINA ARTICOLO");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ELIMINAARTICOLOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminDAO delete = new AdminDAO();
                delete.erase_article(Integer.parseInt(idtext.getText()));
            }
        });
    }
}
