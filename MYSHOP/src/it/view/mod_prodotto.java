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

    public mod_prodotto()
    {
        setContentPane(modifica_prod);
        setTitle("AGGIUNGI PRODOTTO");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                  //convert to byte
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

        setLayout(null);
        setLocationRelativeTo(null);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
    public void  setimage_mod(byte[] img) throws IOException {

        InputStream is = new ByteArrayInputStream(img);
        BufferedImage newBi = ImageIO.read(is);
        Icon icon = foto.getIcon();
        Graphics2D g2d = newBi.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
    }
}




