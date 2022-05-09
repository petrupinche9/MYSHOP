package it.view;

import it.DAO.IarticleDAO;
import it.DAO.ShopDAO;
import it.DAO.Shop_listDAO;
import it.DAO.articleDAO;
import it.DbConnection;
import it.business.ShoplistBusiness;
import it.model.Point_shop;
import it.model.Shop_list;
import it.model.article;
import it.model.user;
import it.util.DateUtil;
import it.util.Session;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;

public class listaspesa  extends JFrame {
    private JTable TableModelarticoli;
    private JLabel cliente;
    private JPanel panel1;
    private JButton FINALIZZASPESAButton;
    private JButton CLEARArticlesButton;
    private JLabel pointshop;
    private JButton RECUPERASHOPLISTButton;
    private Shop_list lista;
    private int row,col;
    private IarticleDAO arte = new articleDAO();
    private ArrayList<article> articolo = arte.findAll();


    public listaspesa() {
        articolo.clear();
        TableModel model = new JTableButtonModel() {
            public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria","Category"};
            public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class};

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
            public boolean isCellEditable(EventObject e) {
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
                        final JLabel eli = new JLabel();
                        eli.setText("ELIMINA");
                        return ar.getDescr();

                    default:
                        return "Error";
                }
            }
        };

        TableModelarticoli.setModel(model);
        TableModelarticoli.setRowHeight(100);



        // scrollpane = new JScrollPane(TableModelarticoli);
        cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
        setTitle("MYSHOP");
        setContentPane(panel1);
        setSize(700, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        CLEARArticlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                articolo.clear();
                refresh_list(articolo);
            }
        });
        FINALIZZASPESAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           // METODO BUSINESS PER:
                // 1-GENERAZIONE LISTA IN PDF E INVIO PER EMAIL
                user cliente=Session.getInstance().getClienteLoggato();
                ArrayList<String[]> search = DbConnection.getInstance().eseguiQuery("SELECT idPoint_shop FROM Point shop WHERE Shopname='"+pointshop.getText()+"';");

                if(search.size()==1) {
                    String[] riga = search.get(0);
                    ShopDAO dao = new ShopDAO();
                    Point_shop shoppo=dao.findById(Integer.parseInt(riga[0]));
                    int total_price=0;
                    for (int i = 0; i < articolo.size(); i++) {
                        total_price+=articolo.get(i).getCosto();
                    }
                    Date today = new Date();
                    String data= DateUtil.stringFromDate(today);

                    Shop_list lista_della_spesa= new Shop_list(0,cliente,shoppo,articolo,"non pagata",total_price,data);
                    ShoplistBusiness.getInstance().inviashoplist(lista_della_spesa);
                }else {
                    JOptionPane.showMessageDialog(null,"ERROR ");
                }

                //Shop_list listaspesa=new Shop_list(,,articolo,);
               // ShoplistBusiness.getInstance().inviashoplist();
                //TODO 3-UPDATE STATO LISTA IN PAGATA


            }
        });

        RECUPERASHOPLISTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = JOptionPane.showInputDialog("INSERISCA LA MATRICOLA DELLA SHOPLIST DESIDERATA", 0);
                Shop_listDAO daolist=new Shop_listDAO();
                Shop_list newlist=daolist.findById(Integer.parseInt(m));
                refresh_list(newlist.getArticoli());
            }
        });
    }

    public void showdescr ( int row, int col){
        String descr = (String) TableModelarticoli.getValueAt(row, col);
        JOptionPane.showMessageDialog(null, descr);
    }

    public void setshop(String shop){
        pointshop.setText(shop);
    }

    //AGGIUNGE/RIMUOVE ARTICOLO DALLA LISTA
    public void refresh_list(ArrayList<article> articolonew){
          articolo=articolonew;
        TableModel model = new JTableButtonModel() {
            public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Category"};
            public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class};

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
            public boolean isCellEditable(EventObject e) {
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

                    default:
                        return "Error";
                }
            }
        };


        TableModelarticoli.setRowHeight(100);
        TableModelarticoli.setModel(model);



    }

   /* //ELIMINA ARTICOLO DALLA LISTA
    public void erase_from_list(int row){
        articleDAO dao=new articleDAO();
        String descr= (String) TableModelarticoli.getValueAt(row, 2);
        String name= (String) TableModelarticoli.getValueAt(row, 0);
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Name='"+name+"' && description='"+descr+"' ;");
        if(res.size()==1) {
            String[] riga = res.get(0);
            article erase=dao.findById(Integer.parseInt(riga[0]));
            articolo.remove(erase);
            refresh_list(articolo);
        }

    }
*/
    public void setArticolo(ArrayList<article> articolo) {
        this.articolo = articolo;
    }
}
/*
abstract class JTableButtonModel extends AbstractTableModel implements TableModel {
    IarticleDAO arte = new articleDAO();
    private ArrayList<article> articolo = arte.findAll();

    public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria"};
    public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class};

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
                final JLabel desc = new JLabel();
                desc.setText(ar.getDescr());
                return ar.getDescr();
            case 3:
                return ar.getCosto();
            case 4:
                return ar.getCategory();

            default:
                return "Error";
        }
    }
};
}*/


