package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.DbConnection;
import it.model.article;
import it.util.Session;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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

public class Catalogue extends JFrame{
    private JPanel panel1;
    private JComboBox comboBox_shop;
    private JComboBox comboBox_cat;
    private JLabel cliente;
    private JButton LOGOUTButton;
    private JTable TableModelarticoli;
    private JScrollPane scrollpane;



            public Catalogue() {

                              // TableModelarticoli = new JTable(rowData, colonne);

                cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
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
                                final JLabel compra = new JLabel("BUY");
                                return compra.getText();

                            default:
                                return "Error";
                        }
                    }
                };

                TableModelarticoli.setRowHeight(100);
                TableModelarticoli.setModel(model);

                Action search = new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                        // JTable table = (JTable) e.getSource();
                        int modelRow = Integer.parseInt(e.getActionCommand());
                        JOptionPane.showMessageDialog(null,"Search action for row: " + modelRow);

                        // do some processing here
                        // tb.searchMore(modelRow);
                    }
                };
                ButtonColumn buttonColumn = new ButtonColumn(TableModelarticoli, search, TableModelarticoli.getColumnCount()-1);
                buttonColumn.setMnemonic(KeyEvent.VK_D);


               // scrollpane = new JScrollPane(TableModelarticoli);
                setTitle("MYSHOP");
                setContentPane(panel1);
                setSize(700,700);
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
                comboBox_shop.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        comboBox_shop.removeAllItems();
                        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT Shopname FROM Point_shop");

                        for (String[] riga : res) {
                            comboBox_shop.addItem(riga[0]);
                        }
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

        abstract class JTableButtonModel extends AbstractTableModel implements TableModel {
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

            public abstract boolean isCellEditable(EventObject e);

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
                    case 2:final JLabel desc = new JLabel(COLUMN_NAMES[columnIndex]);
                        desc.setText(ar.getDescr());
                        desc.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
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
                        JButton button = new JButton(COLUMN_NAMES[columnIndex]);
                        button.setText("COMPRA");
                        button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
                                        "Button clicked for row "+rowIndex);
                            }
                        });
                        return button;
                    default:
                        return "Error";
                }
            }
        }
// TODO: CREARE LISTENER PER ZOOM DESCRIZIONE E INIZIARE DEVELOP DELLA LISTA DELLA SPESA








