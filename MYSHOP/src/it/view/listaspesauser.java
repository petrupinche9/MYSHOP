package it.view;

import it.DAO.*;
import it.DbConnection;
import it.model.Shop_list;
import it.model.article;
import it.util.Session;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EventObject;

public class listaspesauser  extends JFrame {
    private JTable TableModelarticoli;
    private JLabel cliente;
    private JPanel panel1;
    private JButton FINALIZZASPESAButton;
    private JButton CLEARArticlesButton;
    private JLabel pointshop;
    private JButton RECUPERASHOPLISTButton;
    private Shop_list lista;
    private int row,col;
    private ArrayList<article> articolo=new ArrayList<article>();
    private article artico;
    private IarticleDAO arte;

    public listaspesauser() {

        ArrayList<String[]> art = DbConnection.getInstance().eseguiQuery("SELECT * FROM articolo INNER JOIN Shop_list AS shop ON Shop_list_idShop_list=shop.idShop_list" +
                " INNER JOIN Cliente AS cl ON shop.Cliente_idCliente=cl.idCliente " +
                " INNER JOIN user as us ON cl.user_iduser=us.iduser " +
                " WHERE us.username='"+Session.getInstance().getClienteLoggato().getUsername()+"' && us.passwd='"+Session.getInstance().getClienteLoggato().getPassword()+"'; ");
        for (String[] riga : art) {
            artico=arte.findById(Integer.parseInt(riga[0]));
            articolo.add(artico);
        }
        refresh_list(articolo);
        cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
        TableModel model = new JTableButtonModel() {


            public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", "Commenta"};
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
                        return ar.getEval();
                    case 6:
                        final JLabel commenta = new JLabel("COMMENTA");
                        return commenta.getText();

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
                if(col==5)
                    showcomm(row);

                if(col==6)
                    comment(row);

            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(TableModelarticoli, search, TableModelarticoli.getColumnCount()-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);


        // scrollpane = new JScrollPane(TableModelarticoli);
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
                ArrayList<String[]> art = DbConnection.getInstance().eseguiQuery("SELECT * FROM articolo INNER JOIN Shop_list AS shop ON Shop_list_idShop_list=shop.idShop_list" +
                        "INNER JOIN Cliente AS cl ON shop.Cliente_idCliente=cl.idCliente " +
                        "INNER JOIN user as us ON cl.user_iduser=us.iduser " +
                        "WHERE us.username='"+Session.getInstance().getClienteLoggato().getUsername()+"' && us.passwd='"+Session.getInstance().getClienteLoggato().getPassword()+"'; ");
                for (String[] riga : art) {
                    artico=arte.findById(Integer.parseInt(riga[0]));
                    articolo.add(artico);
                }
                refresh_list(articolo);
            }
        });
        /*
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



            }
        });*/

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

    public void showcomm(int row){
        article newart=new article();
        articleDAO dao=new articleDAO();
        String descr= (String) TableModelarticoli.getValueAt(row, 2);
        String name= (String) TableModelarticoli.getValueAt(row, 0);
        ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Name='"+name+"' && description='"+descr+"' ;");
        if(res.size()==1) {
            String[] riga = res.get(0);
            comments c=new comments();
            c.setId_article(Integer.parseInt(riga[0]));
        }
    }
    public void setshop(String shop){
        pointshop.setText(shop);
    }
    //AGGIUNGE/RIMUOVE ARTICOLO DALLA LISTA
    public void refresh_list(ArrayList<article> articolonew){
          articolo=articolonew;
        TableModel model = new JTableButtonModel() {


            public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", "Commenta"};
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
                        return ar.getEval();
                    case 6:
                        final JLabel commenta = new JLabel("COMMENTA");
                        return commenta.getText();

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
                    comment(row);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(TableModelarticoli, search, TableModelarticoli.getColumnCount()-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);


    }

    public void comment(int row){
        articleDAO dao=new articleDAO();
        userDAO cliente=new userDAO();
        String descr= (String) TableModelarticoli.getValueAt(row, 2);
        String name= (String) TableModelarticoli.getValueAt(row, 0);
        /*String s = (String)JOptionPane.showInputDialog(
                null,
                "INSERISCI UN COMMENTO",
                "REVIEW",
                JOptionPane.PLAIN_MESSAGE,
               null,
                null,
                "commenta..");*/
        JFrame frame =new JFrame();
        String[] items = {"1", "2", "3", "4", "5"};
        JComboBox<String> combo = new JComboBox<>(items);
        JTextField comm = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(combo);
        panel.add(new JLabel("Inserisci Commento:"));
        panel.add(comm);
        int result = JOptionPane.showConfirmDialog(frame, panel, "REVIEW",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ArrayList<String[]> res = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo WHERE Name='"+name+"' && description='"+descr+"' ;");
            if(res.size()==1){
                String[] riga= res.get(0);
                article newart=dao.findById(Integer.parseInt(riga[0]));
                article.comments review=new article.comments();
                review.setFeedback(Integer.parseInt(combo.getSelectedItem().toString()));
                review.setText(comm.getText());
                review.setArticle_id(Integer.parseInt(riga[0]));
                review.setUser(Session.getInstance().getClienteLoggato());
                cliente.newcomment(newart,review.getUser(), review);
                //cliente.newcomment(newart,Session.getInstance().getClienteLoggato(), review.getFeedback(), comm.getText());
            }
        } else {
            System.out.println("Cancelled");
        }


}


abstract class JTableButtonModel2 extends AbstractTableModel implements TableModel {
    IarticleDAO arte = new articleDAO();
    private ArrayList<article> articolo = arte.findAll();

    public final String[] COLUMN_NAMES = new String[]{"Nome", "Foto", "descrizione", "Costo", "Categoria", "Stars", ""};
    public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, BufferedImage.class, String.class, double.class, String.class, Integer.class, JButton.class};

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
}}


