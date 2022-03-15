package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.model.article;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePage_guest extends JFrame{
    private JPanel panel1;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JTable TableModelarticoli;
    private JSplitPane rootpanel;
    private JComboBox shop;
    private JComboBox comboBox1;


    // da aggiungere il metodo per aggiornare da database
    public HomePage_guest() {
        setContentPane(panel1);
        setTitle("MYSHOP");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
          //  ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM ARTICLE;");
       /*IarticleDAO ar=new articleDAO();
        ArrayList<article> res=ar.findAll();
        JOptionPane.showMessageDialog(null,res);
            String columns[] = { "ID", "Name", "Age" };
        String[][] data = new String[100][10];

        for(int i=0;i<res.size();i++) {
                int id=res.get(i).getId();
                String nom = res.get(i).getName();
                String descr = res.get(i).getDescr();
                double costo=res.get(i).getCosto();
                data[i][0] = id + "";
                data[i][1] = nom;
                data[i][2] = descr;
                data[i][3] = String.valueOf(costo);
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane();
            JFrame f = new JFrame("Populate JTable from Database");
            JPanel panel = new JPanel();

      panel.add(pane);
      f.add(panel);
      f.setSize(500, 250);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
*/


      //go to login page
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MENU mf = new MENU();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setExtendedState(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        SIGNUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                REGISTRAZIONE rf = new REGISTRAZIONE();
                rf.setVisible(true);
                rf.pack();
                rf.setLocationRelativeTo(null);
                rf.setExtendedState(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });


    }
     class TableModelarticoli extends AbstractTableModel {

        IarticleDAO ar=new articleDAO();
        ArrayList<article> articoli=ar.findAll();

        public TableModelarticoli(ArrayList<article> articoli) {
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
                case 0: return p.getName();
                case 1: return p.getImg(p.getId());
                case 2: return p.getDescr();
                case 3: return p.getCosto();
                case 4: return p.getCategory();
                case 5: return p.getEval();
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
            String[] colonne = {"Nome","Foto","descrizione","Costo","Categoria","Stars"};
            return colonne[columnIndex];
        }
    }
    }



