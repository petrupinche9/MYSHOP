package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.model.article;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomePage_guest extends JFrame {
    private JPanel panel1;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JTable TableModelarticoli;
    private JComboBox comboBox_shop;
    private JComboBox comboBox_cat;
    private JScrollPane scrollpane;
    private JSplitPane rootpanel;
    private JComboBox shop;
    private JComboBox comboBox1;


    // da aggiungere il metodo per aggiornare da database
    public HomePage_guest() {

        setContentPane(panel1);
        TableCellRenderer tableRenderer;
        tableRenderer = TableModelarticoli.getDefaultRenderer(JButton.class);
        TableModelarticoli.setDefaultRenderer(JButton.class, new it.view.JTableButtonRenderer(tableRenderer));
        // TableModelarticoli.add(scrollpane);
        TableModel model = new it.view.JTableButtonModel() {

            IarticleDAO arte = new articleDAO();
            ArrayList<article> articolo = arte.findAll();

            final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", ""};
            final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class, Integer.class, JButton.class};

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
                        byte[] img = ar.getImg();
                        final JLabel foto = new JLabel(COLUMN_NAMES[columnIndex]);
                        foto.setSize(100, 100);
                        InputStream in = new ByteArrayInputStream(img);
                        try {
                            BufferedImage imgFromDb = ImageIO.read(in);
                            ImageIcon image = new ImageIcon(imgFromDb);
                            Image im = image.getImage();
                            Image myImg = im.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon newImage = new ImageIcon(myImg);
                            foto.setIcon(newImage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return foto.getIcon();
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
        };
        TableModelarticoli.setRowHeight(100);
        TableModelarticoli.setModel(model);
//    Comment this code to add table dynamically


        // scrollpane = new JScrollPane(TableModelarticoli);
        setTitle("MYSHOP");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

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

    class JTableButtonRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;

        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Component)
                return (Component) value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    class JTableButtonModel extends AbstractTableModel implements TableModel {
        IarticleDAO arte = new articleDAO();
        private ArrayList<article> articolo = arte.findAll();

         final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", ""};
         final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, BufferedImage.class, String.class, double.class, String.class, Integer.class, JButton.class};

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
}





