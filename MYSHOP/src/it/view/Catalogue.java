package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.model.article;
import it.util.Session;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Catalogue extends JFrame{
    private JPanel panel1;
    private JComboBox comboBox_shop;
    private JComboBox comboBox_cat;
    private JLabel cliente;
    private JButton LOGOUTButton;
    private JTable TableModelarticoli;
    private JScrollPane scrollpane;


        /*setContentPane(panel1);
        setTitle("MYSHOP");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
    */
        /*String[] colonne = {"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars"};

        ArrayList<article> articolo;
        IarticleDAO ar=new articleDAO();
        articolo=ar.findAll();

        article[][] rowData = new article[ articolo.size() / colonne.length ][ colonne.length ];

        for (int i = 0; i < rowData.length; i++) {

            for (int j = 0; j < rowData[i].length; j++) {
                rowData[i][j] = articolo.get(i * colonne.length + j);
            }

        }

        TableModelarticoli = new JTable(rowData, colonne);

        add(scrollpane);

*/


            public Catalogue() {

                              // TableModelarticoli = new JTable(rowData, colonne);
                cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
                setContentPane(panel1);
                TableCellRenderer tableRenderer;
                TableModelarticoli = new JTable(new JTableButtonModel());
                tableRenderer = TableModelarticoli.getDefaultRenderer(JButton.class);
                TableModelarticoli.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
                TableModelarticoli.add(scrollpane);
                IarticleDAO arte = new articleDAO();
                ArrayList<article> articolo = arte.findAll();
//    Comment this code to add table dynamically
                JTableButtonModel model = new JTableButtonModel();
                TableModelarticoli.setModel(model);
               // scrollpane = new JScrollPane(TableModelarticoli);
                setTitle("MYSHOP");
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                pack();
                setLocationRelativeTo(null);
                setVisible(true);

                LOGOUTButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Session.getInstance().setClienteLoggato(null);
                        MENU mf = new MENU();
                        mf.setVisible(true);
                        mf.pack();
                        mf.setLocationRelativeTo(null);
                        mf.setExtendedState(JFrame.EXIT_ON_CLOSE);
                        dispose();

                    }
                });
            }


}
        class JTableButtonRenderer implements TableCellRenderer {
            private TableCellRenderer defaultRenderer;
            public JTableButtonRenderer(TableCellRenderer renderer) {
                defaultRenderer = renderer;
            }
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof Component)
                    return (Component)value;
                return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }

        class JTableButtonModel extends AbstractTableModel implements TableModel {
            IarticleDAO arte = new articleDAO();
            private ArrayList<article> articolo = arte.findAll();

            public static final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", ""};
            public static final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, BufferedImage.class, String.class, double.class, String.class, Integer.class, JButton.class};

            @Override
            public int getColumnCount() {
                return COLUMN_NAMES.length;
            }

            @Override
            public int getRowCount() {
                return articolo.size();
            }

            @Override
            public String getColumnName(int columnIndex) {
                return COLUMN_NAMES[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return COLUMN_TYPES[columnIndex];
            }

            @Override

            public Object getValueAt(int rowIndex, final int columnIndex) {
                //Adding components


                article ar = articolo.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return ar.getName();
                    case 1:
                        return ar.getImg();
                    case 2:
                        return ar.getDescr();
                    case 3:
                        return ar.getCosto();
                    case 4:
                        return ar.getCategory();
                    case 5:
                        return ar.getEval();
                    //Adding button and creating click listener
                    case 6:
                        final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
                        button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
                                        "Button clicked for row ");
                            }
                        });
                        return button;
                    default:
                        return "Error";
                }
            }
        }







