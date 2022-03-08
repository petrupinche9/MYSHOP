package it.view;

import it.DAO.AdminDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administracionelimina extends JFrame{
    private JTextField textField1;
    private JButton ELIMINAARTICOLOButton;
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
                String txtid = textField1.getText();
                int id = Integer.parseInt(txtid);
                AdminDAO delete = new AdminDAO();
                delete.erase_article(id);
            }
        });
    }
}
