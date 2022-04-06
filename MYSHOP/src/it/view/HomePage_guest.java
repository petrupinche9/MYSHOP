package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.model.article;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EventObject;

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
    JButton button = new JButton();

    // da aggiungere il metodo per aggiornare da database
    public HomePage_guest() {

        setSize(700,700);
        setContentPane(panel1);
        //TableCellRenderer tableRenderer = TableModelarticoli.getDefaultRenderer(JButton.class);
       // TableModelarticoli.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        // TableModelarticoli.add(scrollpane);
        TableModel model = new it.view.JTableButtonModel() {

            IarticleDAO arte = new articleDAO();
            ArrayList<article> articolo = arte.findAll();

           public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", "BUY"};
           public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class, Integer.class, String.class};

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
            public boolean isCellEditable(EventObject e){
                return true;
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
                        final JLabel desc = new JLabel();
                        desc.setText(ar.getDescr());
                        desc.addMouseListener(new MouseListener() {
                            public void mouseClicked(MouseEvent e) {
                                JOptionPane pane = new JOptionPane(ar.getDescr(), JOptionPane.INFORMATION_MESSAGE);
                                JDialog dialog = pane.createDialog(null, "Title");
                                dialog.setModal(false);
                                dialog.setVisible(true);

                                new Timer(3000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        dialog.setVisible(false);
                                    }
                                }).start();

                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {

                            }

                            @Override
                            public void mouseExited(MouseEvent e) {

                            }

                        });
                        return ar.getDescr();
                    case 3:
                        return ar.getCosto();
                    case 4:
                        return ar.getCategory();
                    case 5:
                        return ar.getEval();
                    //Adding button and creating click listener
                    case 6:
                        Action search = new AbstractAction() {

                            public void actionPerformed(ActionEvent e) {
                                JTable table = (JTable) e.getSource();
                                int modelRow = Integer.parseInt(e.getActionCommand());
                                System.out.println("Search action for row: " + modelRow);

                                // do some processing here
                                // tb.searchMore(modelRow);
                            }
                        };
                        button.setAction(search);
                        button.setText("COMPRA");
                        return button;

                    default:
                        return "Error";
                }
            }
        };

        TableModelarticoli.setRowHeight(100);
        TableModelarticoli.setModel(model);
        ButtonColumn buttonColumn = new ButtonColumn(TableModelarticoli, button.getAction(), TableModelarticoli.getColumnCount()-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

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
    static class ButtonRenderer extends JButton implements TableCellRenderer
    {
        public ButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "COMPRA" : value.toString());
            return this;
        }
    }
    class ButtonEditor extends DefaultCellEditor
    {
        private String label;

        public ButtonEditor(JCheckBox checkBox)
        {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column)
        {
            label = (value == null) ? "COMPRA" : value.toString();
            button.setText(label);
            return button;
        }
        public Object getCellEditorValue()
        {
            return new String(label);
        }
    }
   /* class JTableButtonRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;

        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Component)
                return (Component) value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }*/

}





