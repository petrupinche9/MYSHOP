package it.view;

import it.DAO.IarticleDAO;
import it.DAO.IcommentsDAO;
import it.DAO.articleDAO;
import it.DAO.commentsDAO;
import it.model.Shop_list;
import it.model.article;
import it.util.Session;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.EventObject;

public class comments extends JFrame {
    private JTable TableModelarticoli;
    private JLabel cliente;
    private JPanel panel1;
    private JButton FINALIZZASPESAButton;
    private JButton CLEARArticlesButton;
    private JLabel pointshop;
    private JButton RECUPERASHOPLISTButton;
    private Shop_list lista;
    private int row,col;
    private int id_article;
    private IcommentsDAO comdao=new commentsDAO();
    private ArrayList<article.comments> comments=comdao.findById_article(id_article);
    private article artico;
    private IarticleDAO arte;

    public comments() {


        cliente.setText(Session.getInstance().getClienteLoggato().getUsername());
        TableModel model = new JTableButtonModel() {


            public final String[] COLUMN_NAMES = new String[]{"Username", "Stars", "Commento"};
            public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class};

            @Override
            public int getColumnCount() {
                return COLUMN_NAMES.length;
            }

            @Override
            public int getRowCount() {
                return comments.size();
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


                article.comments ar = comments.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return ar.getUser().getUsername();
                    case 1:
                        final JLabel stars = new JLabel();
                        stars.setText(String.valueOf(ar.getFeedback()));
                        return ar.getFeedback();
                    case 2:
                        final JLabel comm = new JLabel();
                        comm.setText(ar.getText());
                        return ar.getText();

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




       }

    public void showdescr ( int row, int col){
        String descr = (String) TableModelarticoli.getValueAt(row, col);
        JOptionPane.showMessageDialog(null, descr);
    }


    //AGGIUNGE/RIMUOVE ARTICOLO DALLA LISTA
    public void refresh_list(ArrayList<article.comments> articolonew){
        comments.clear();
          comments=articolonew;
        TableModel model = new JTableButtonModel() {


            public final String[] COLUMN_NAMES = new String[]{"Username", "Stars", "Commento"};
            public final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, ImageIcon.class, String.class, double.class, String.class};

            @Override
            public int getColumnCount() {
                return COLUMN_NAMES.length;
            }

            @Override
            public int getRowCount() {
                return comments.size();
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


                article.comments ar = comments.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return ar.getUser().getUsername();
                    case 1:
                        final JLabel stars = new JLabel();
                        stars.setText(String.valueOf(ar.getFeedback()));
                        return ar.getFeedback();
                    case 2:
                        final JLabel comm = new JLabel();
                        comm.setText(ar.getText());
                        return ar.getText();

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

            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(TableModelarticoli, search, TableModelarticoli.getColumnCount()-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);


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
}
public void setId_article(int id_article){
        this.id_article=id_article;
}}


