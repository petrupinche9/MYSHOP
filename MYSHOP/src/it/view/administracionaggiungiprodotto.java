package it.view;

import it.DAO.AdminDAO;
import it.DAO.IAdminDAO;
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

public class administracionaggiungiprodotto extends JFrame {
    private JTextField category;
    private JTextField subcategory;
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

    public administracionaggiungiprodotto()
    {
        setContentPane(adminprodottoPanel);
        setTitle("AGGIUNGI PRODOTTO");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set prodotto
                Product prod = new Product();
                Produttore p = new Produttore();
                prod.setName(name.getText());
                prod.setDescr(descr.getText());
                prod.setCategory(category.getText());
                prod.setSottocategoria(subcategory.getText());
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
                Graphics2D g2d = img.createGraphics();
                icon.paintIcon(null, g2d, 0, 0);
                g2d.dispose();

                byte[] bytes ;
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
                    try {
                        ImageIO.write(img, "png", ios);
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
                administracionaggiungisottoprodotto cf = new administracionaggiungisottoprodotto();
                cf.setVisible(true);
                cf.pack();
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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


            }

    public ImageIcon resize(String imgPath){
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

        }




