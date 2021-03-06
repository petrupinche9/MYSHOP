package it.view;

import it.DAO.AdminDAO;
import it.DAO.IAdminDAO;
import it.DbConnection;
import it.model.Product;
import it.model.Produttore;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class administracionaggiungiprodotto extends JFrame {

    private JTextField costo;
    private JTextField corsia;
    private JTextField scaffale;
    private JTextField prod_name;
    private JTextField website;
    private JTextField city;
    private JTextField nation;
    private JButton CONFERMAButton;
    private JButton AGGIUNGISOTTOPRODOTTOButton;
    private JButton SFOGLIAButton;
    private JTextField name;
    private JLabel foto;
    private JTextArea descr;
    private JPanel adminprodottoPanel;
    private JButton CHIUDIButton;
    private JComboBox<String> category;
    private JComboBox<String> subcategory;

    public administracionaggiungiprodotto()
    {
        setContentPane(adminprodottoPanel);
        setTitle("AGGIUNGI PRODOTTO");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        category.addItem("MOBILI");
        category.addItem("ILLUMINAZIONE");
        category.addItem("TESSILI");

        subcategory.addItem("CUCINA");
        subcategory.addItem("SOGGIORNO");
        subcategory.addItem("CAMERA");
        subcategory.addItem("CUCINA");
        subcategory.addItem("TAPPETI");
        subcategory.addItem("TENDE");
        subcategory.addItem("LAMPADARI");
        subcategory.addItem("LAMPADARI DA ESTERNO");

        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set prodotto
                Product prod = new Product();
                Produttore p = new Produttore();
                prod.setName(name.getText());
                prod.setDescr(descr.getText());
                prod.setCategory(category.getSelectedItem().toString());
                prod.setSottocategoria(subcategory.getSelectedItem().toString());
                prod.setCosto(Double.parseDouble(costo.getText()));
                prod.setScaffale(Integer.parseInt(scaffale.getText()));
                prod.setCorsia(Integer.parseInt(corsia.getText()));

                //set produttore
                p.setNome(prod_name.getText());
                p.setCitta(city.getText());
                p.setNazione(nation.getText());
                p.setSitoweb(website.getText());

                //set image
                Icon icon = foto.getIcon();
                BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                // BufferedImage img = new BufferedImage(150, 50, BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = img.createGraphics();
                g2d.drawImage(img, 0, 0, 50, 50, null);
                icon.paintIcon(null, g2d, 0, 0);
                g2d.dispose();

                //convert to bytes
                byte[] bytes ;
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
                    try {
                        ImageIO.write(img, "jpg", ios);
                        baos.flush();
                        // Set a flag to indicate that the write was successful
                    } finally {
                        ios.close();
                    }
                    bytes = baos.toByteArray();
                    prod.setImg(bytes);
                    IAdminDAO admin = new AdminDAO();
                    admin.newproduct(prod, p, bytes);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });


        AGGIUNGISOTTOPRODOTTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add_subproduct cf = new add_subproduct();

                Product prod = new Product();
                Produttore p = new Produttore();
                prod.setName(name.getText());
                prod.setDescr(descr.getText());
                prod.setCategory(category.getSelectedItem().toString());
                prod.setSottocategoria(subcategory.getSelectedItem().toString());
                prod.setCosto(Double.parseDouble(costo.getText()));
                prod.setScaffale(Integer.parseInt(scaffale.getText()));
                prod.setCorsia(Integer.parseInt(corsia.getText()));

                //set produttore
                p.setNome(prod_name.getText());
                p.setCitta(city.getText());
                p.setNazione(nation.getText());
                p.setSitoweb(website.getText());

                ArrayList<String[]> check = DbConnection.getInstance().eseguiQuery("SELECT idarticolo FROM articolo INNER JOIN product AS p ON idarticolo=p.articolo_idarticolo " +
                        "WHERE name='"+prod.getName()+"'  AND p.corsia='"+prod.getCorsia()+"' AND p.scaffale='"+prod.getScaffale()+"';");

                if(check.size()==1) {
                    String[] riga = check.get(0);
                    cf.setVisible(true);
                    cf.pack();
                    cf.setLocationRelativeTo(null);
                    cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    cf.setidprod(Integer.parseInt(riga[1]));
                    cf.setSize(600,600);
                }else {
                    JOptionPane.showMessageDialog(null,"PRODOTTO PRINCIPALE NON TROVATO ");
                }

            }
        });

        SFOGLIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filtering files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
                file.addChoosableFileFilter(filter);
                int res = file.showSaveDialog(null);
                //if the user clicks on save in Jfilechooser
                if(res == JFileChooser.APPROVE_OPTION){
                    File selFile = file.getSelectedFile();
                    String path = selFile.getAbsolutePath();
                    foto.setIcon(resize(path));
                }
            }
        });


        CHIUDIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private BufferedImage getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, Transparency.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
    public ImageIcon resize(String imgPath){
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

        }




