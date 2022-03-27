package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.DbConnection;
import it.model.article;
import it.util.Session;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Catalogue extends JFrame{
    private JPanel panel1;
    private JComboBox comboBox_shop;
    private JComboBox comboBox_cat;
    private JTable TableModelarticoli;
    private JLabel cliente;
    private JButton LOGOUTButton;

    public Catalogue() {

        setContentPane(panel1);
        setTitle("MYSHOP");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
    class TableModelarticoli extends AbstractTableModel {

        IarticleDAO ar = new articleDAO();
        ArrayList<article> articoli = ar.findAll();

        public TableModelarticoli(ArrayList<article> articoli) {
            this.articoli = articoli;
        }

        @Override
        public int getRowCount() {
            return articoli.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            article p = articoli.get(rowIndex);

            //BINDING
            switch (columnIndex) {
                case 0:
                    return p.getName();
                case 1:
                    return p.getImg(p.getId());
                case 2:
                    return p.getDescr();
                case 3:
                    return p.getCosto();
                case 4:
                    return p.getCategory();
                case 5:
                    return p.getEval();
            }

            return "-";
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return (columnIndex > 4);
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            article p = articoli.get(rowIndex);

           /* switch (columnIndex) {
                case 5: p.setDataInizio(DateUtil.dateTimeFromString((String)value)); break;
                case 6: p.setDataFine(DateUtil.dateTimeFromString((String)value)); break;
            }*/

            //TODO richiamare il metodo di business modificaPrenotazione che chiamera il DAO per update sql

        }

        @Override
        public String getColumnName(int columnIndex) {
            String[] colonne = {"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars"};
            return colonne[columnIndex];
        }
    }


        comboBox_cat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {// updates to the Swing GUI must be done on EDT
                        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Shopname FROM Point_shop");
                        if (res.size() == 1) {
                            for (int i = 0; i < res.size(); ++i) {
                                String[] riga = res.get(0);
                                comboBox_cat.addItem(riga[i]);
                            }
                        }
                    }
                });
            }
        });

        comboBox_shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {// updates to the Swing GUI must be done on EDT
                        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM Point_shop");
                        if (res.size() == 1) {
                            for (int i = 0; i < res.size(); ++i) {
                                String[] riga = res.get(0);
                                comboBox_shop.addItem(riga[i]);
                            }
                        }

                    }
                });
            }
        });
        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session.getInstance().setClienteLoggato(null);
                dispose();
                MENU mf = new MENU();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}

