package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.model.article;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HomePage_guest extends JFrame{
    private JPanel panel1;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JTable table1;
    private JSplitPane rootpanel;
    private JButton UPDATECATALOGUEButton;


    // da aggiungere il metodo per aggiornare da database
    public HomePage_guest() {

          //  ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT * FROM ARTICLE;");
       IarticleDAO ar=new articleDAO();
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


        }
    }



