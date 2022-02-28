package it.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class HomePage_guest extends JFrame{
    private JPanel panel1;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JTable table1;


    // da aggiungere il metodo per aggiornare da database
    public HomePage_guest() {
        Icon icon1 = new ImageIcon("image/lampadario.jpg");
        Icon icon2 = new ImageIcon("image/sedia.jpg");
        Icon icon3 = new ImageIcon("image/sedia_game.jpg");
        String[] columns = { "Name", "category", "Image"};
        //data for JTable in a 2D table
        Object[][] data = {
                {1, "Thomas", "Alaska",icon1 },
                {2, "Jean", "Arizona", icon2 },
                {3, "Yohan", "California", icon3},

        };
        DefaultTableModel model = new DefaultTableModel(data, columns);

        JTable table = new JTable(model) {
            public Class getColumnClass(int column) {
                return (column == 3) ? Icon.class : Object.class;
            }
        };
        table.setRowHeight(60);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JLabel labelHead = new JLabel("List of employees");
        labelHead.setFont(new Font("Arial", Font.TRUETYPE_FONT,20));
        getContentPane().add(labelHead,BorderLayout.PAGE_START);
        table1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                //Set row height to 60 pixels

            }

        });
    }


}
