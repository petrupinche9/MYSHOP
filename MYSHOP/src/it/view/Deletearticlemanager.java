package it.view;

import it.DAO.articleDAO;
import it.DAO.managerDAO;
import it.model.article;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deletearticlemanager extends JFrame{
    private JTextField idarticle;
    private JButton CONFERMAButton;
    private JPanel deletearticlePanel;

    public Deletearticlemanager()
    {
        setContentPane(deletearticlePanel);
        setTitle("ELIMINA PRODOTTO MANAGER");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idarticle.getText();
                int idarticle = Integer.parseInt(id);
                //aggiungi articolo
                articleDAO add = new articleDAO();
                article addarticle = add.findById(idarticle);
                managerDAO manager = new managerDAO();

                manager.erase_article_from_shop(addarticle, manager.findById(Session.getInstance().getClienteLoggato().getId()));
                JOptionPane.showMessageDialog(null, "Articolo eliminato");

            }
        });
    }
}
