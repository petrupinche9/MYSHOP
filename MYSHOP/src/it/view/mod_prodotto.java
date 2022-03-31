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
import java.io.*;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class mod_prodotto extends JFrame {
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
    private JButton SFOGLIAButton;
    private JTextField name;
    private JLabel foto;
    private JTextArea descr;
    private JPanel modifica_prod;
    private JTextField idlastprod;
    private JLabel lastid;
    private JButton CHIUDIButton;
    private JButton provaFotoButton;

    public mod_prodotto() {
        setContentPane(modifica_prod);
        setTitle("MODIFICA PRODOTTO");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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


                //set image
                Icon icon = foto.getIcon();
                BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), TYPE_INT_ARGB);
                Graphics2D g2d = img.createGraphics();
                icon.paintIcon(null, g2d, 0, 0);
                g2d.dispose();
                //convert to byte
                byte[] bytes;
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
                    admin.mod_prodotti(prod, Integer.parseInt(idlastprod.getText()));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        SFOGLIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filtering files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
                file.addChoosableFileFilter(filter);
                int res = file.showSaveDialog(null);
                //if the user clicks on save in Jfilechooser
                if (res == JFileChooser.APPROVE_OPTION) {
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

    public ImageIcon resize(String imgPath){
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    //set public
    public void setName_mod(String nome){
name.setText(nome);
    }
    public void setidlast_prod(int id){idlastprod.setText(String.valueOf(id));}
    public void setDescr_mod(String description) {
      descr.setText(description);
    }
    public void setcat_mod(String categoria){
        category.setText(categoria);
    }
    public void setsubcat_mod(String subcat){
        subcategory.setText(subcat);
    }
    public void setcosto_mod(double cost){
      costo.setText(String.valueOf(cost));
    }
    public void setcorsia_mod(int corsi){
        corsia.setText(String.valueOf(corsi));
    }
    public void setscaffi_mod(int scaffi){
        scaffale.setText(String.valueOf(scaffi));
    }
    public void  setimage_mod(byte[] img) {

        InputStream in = new ByteArrayInputStream(img);
        try {
            BufferedImage imgFromDb = ImageIO.read(in);
            ImageIcon image = new ImageIcon(imgFromDb);
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(foto.getWidth(), foto.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            foto.setIcon(newImage);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}




