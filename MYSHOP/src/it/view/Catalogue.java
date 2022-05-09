package it.view;

import it.DAO.IarticleDAO;
import it.DAO.articleDAO;
import it.DbConnection;
import it.model.article;
import it.util.Session;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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
    private JButton UPDATEButton;
    private JButton ILMIOPROFILOButton;
    private IarticleDAO arte = new articleDAO();
    private ArrayList<article> articolo = arte.findAll();
    private ArrayList<article> lista=new ArrayList<article>();
     listaspesa c=new listaspesa();


            public Catalogue() {

                              // TableModelarticoli = new JTable(rowData, colonne);
                cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
                c.setVisible(true);
                c.setSize(600,600);
                c.setLocation(5,100);
               c.setArticolo(lista);

                TableModel model = new JTableButtonModel() {

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
                        int row = TableModelarticoli.getSelectedRow();//get mouse-selected row
                        int col = TableModelarticoli.getSelectedColumn();//get mouse-selected col
                        //int[] newEntry = new int[]{row,col};//{row,col}=selected cell
                      // JOptionPane.showMessageDialog(null,"Search action for row: " + row+" & col "+col);

                        if(col==2)
                            showdescr(row,col);

                        if(col==6)
                            add_to_shoplist(row);

                        if(col==5)
                            show_comments(row);
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
                        c.dispose();
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
                UPDATEButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        c.setshop(comboBox_shop.getSelectedItem().toString());
                        article artico=new article();

                        articolo.clear();
                        ArrayList<String[]> art = DbConnection.getInstance().eseguiQuery("SELECT * FROM articolo WHERE Point_shop_idPoint_shop=(SELECT idPoint_shop FROM Point_shop WHERE Shopname='"+comboBox_shop.getSelectedItem().toString()+"'); ");
                        for (String[] riga : art) {
                            artico=arte.findById(Integer.parseInt(riga[0]));
                            articolo.add(artico);
                        }
                        refresh_list(articolo);

                    }
                });

                ILMIOPROFILOButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userprofile cf=new userprofile();
                    }
                });
            }

    public void showdescr(int row,int col){
        String descr= (String) TableModelarticoli.getValueAt(row, col);
        JOptionPane.showMessageDialog(null,descr);

    }
public void show_comments(int row){
    article newart=new article();
    articleDAO dao=new articleDAO();
    String descr= (String) TableModelarticoli.getValueAt(row, 2);
    String name= (String) TableModelarticoli.getValueAt(row, 0);
    ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Name='"+name+"' && description='"+descr+"' ;");
    if(res.size()==1) {
        String[] riga = res.get(0);
    }
}
    public void add_to_shoplist(int row){
                article newart=new article();
                articleDAO dao=new articleDAO();
        String descr= (String) TableModelarticoli.getValueAt(row, 2);
        String name= (String) TableModelarticoli.getValueAt(row, 0);
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Name='"+name+"' && description='"+descr+"' ;");
if(res.size()==1){
    String[] riga= res.get(0);
    newart=dao.findById(Integer.parseInt(riga[0]));
    ArrayList<String[]> shop = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Name='"+name+"' && description='"+descr+"' && Point_shop_idPoint_shop=null ;");

    if(shop.size()==1){
        Object[] options = {"SI",
                "NO",
        };
        int n = JOptionPane.showOptionDialog(null,
                "ARTICOLO NON DISPONIBILE IN MAGAZZINO "
                        + "PREFERISCI PRENOTARLO?",
                "MYSHOP",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        if(n==1)
            lista.add(newart);

}else{
        lista.add(newart);
    }

        c.refresh_list(lista);
        c.revalidate();
        c.repaint();
    }

}
    public void refresh_list(ArrayList<article> articolonew){
        articolo=articolonew;
        TableModel model = new JTableButtonModel() {

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
                int row = TableModelarticoli.getSelectedRow();//get mouse-selected row
                int col = TableModelarticoli.getSelectedColumn();//get mouse-selected col
                //int[] newEntry = new int[]{row,col};//{row,col}=selected cell
                // JOptionPane.showMessageDialog(null,"Search action for row: " + row+" & col "+col);

                if(col==2)
                    showdescr(row,col);

              //  if(col==6)
                 //   add_to_shoplist(row);

                if(col==5)
                    show_comments(row);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(TableModelarticoli, null, TableModelarticoli.getColumnCount()-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);



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
                    case 2:
                        final JLabel desc = new JLabel(COLUMN_NAMES[columnIndex]);
                        desc.setText(ar.getDescr());
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
                                        "Button clicked for row " + rowIndex);
                            }
                        });
                        return button;
                    default:
                        return "Error";
                }
            }
        }








