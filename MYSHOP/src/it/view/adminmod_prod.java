package it.view;

import it.DAO.IproductDAO;
import it.DAO.productDAO;
import it.model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminmod_prod extends JFrame {
    private JTextField idtext;
    private JButton SEARCHButton;
    private JPanel mod_servo;


    public adminmod_prod() {
        setContentPane(mod_servo);
        setTitle("MODIFICA MYSHOP");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IproductDAO pro=new productDAO();
               Product prodotto=pro.findById(Integer.parseInt(idtext.getText()));
                mod_prodotto cf=new mod_prodotto();

                cf.setName_mod(prodotto.getName());
                cf.setDescr_mod(prodotto.getDescr());
                cf.setcat_mod(prodotto.getCategory());
                cf.setcosto_mod(prodotto.getCosto());
                cf.setcorsia_mod(prodotto.getCorsia());
                cf.setsubcat_mod(prodotto.getSottocategoria());
                cf.setscaffi_mod(prodotto.getScaffale());
                cf.setidlast_prod(Integer.parseInt(idtext.getText()));
                cf.setimage_mod(prodotto.getImg(Integer.parseInt(idtext.getText())));
                cf.setVisible(true);
                cf.pack();
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
               // cf.setSize(600,600);

            }
        });

    }

}
