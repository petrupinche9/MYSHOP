package it.view;

import it.model.article;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class HomePage_guest extends JFrame{
    private JPanel panel1;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JTable table1;
    private JSplitPane rootpanel;


    // da aggiungere il metodo per aggiornare da database
    public HomePage_guest() {
        class TableModelarticle extends AbstractTableModel {

            private ArrayList<article> articoli;

            public TableModelarticle(ArrayList<article> articoli) {
                this.articoli = articoli;
            }

            @Override
            public int getRowCount() {
                return articoli.size();
            }

            @Override
            public int getColumnCount() {
                return 7;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                article p = articoli.get(rowIndex);

                //BINDING
                switch(columnIndex) {
                   // case 0: return p.getFoto();
                    case 1: return p.getName();
                    case 2: return p.getDescr();
                    case 3: return p.getCosto();
                   /* case 3: return p.getCosto();
                    case 4: return p.getNumPostiOccupati();
                    case 5: return DateUtil.stringFromDate(p.getDataInizio());
                    case 6: return DateUtil.stringFromDate(p.getDataFine());*/
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

              /*  switch (columnIndex) {
                    case 5: p.setDataInizio(DateUtil.dateTimeFromString((String)value)); break;
                    case 6: p.setDataFine(DateUtil.dateTimeFromString((String)value)); break;
                }*/

                //TODO richiamare il metodo di business modificaPrenotazione che chiamera il DAO per update sql

            }
        }
    }


}
