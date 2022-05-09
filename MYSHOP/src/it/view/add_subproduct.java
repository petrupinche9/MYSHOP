package it.view;

import it.DAO.AdminDAO;
import it.DAO.IAdminDAO;
import it.DAO.IproductDAO;
import it.DAO.productDAO;
import it.model.Produttore;
import it.model.SubProduct;

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

public class add_subproduct extends JFrame {
    private JComboBox category;
    private JComboBox subcategory;
    private JTextField costo;
    private JTextField prod_name;
    private JTextField website;
    private JTextField city;
    private JTextField nation;
    private JButton CONFERMAButton;
    private JButton SFOGLIAButton;
    private JTextField name;
    private JLabel foto;
    private JTextArea descr;
    private JPanel adminprodottoPanel;
    private JTextField idprod;
    private JButton CHIUDIButton;

    public add_subproduct()
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
                SubProduct prod = new SubProduct();
                Produttore p = new Produttore();
                prod.setName(name.getText());
                prod.setDescr(descr.getText());
                prod.setCategory(category.getSelectedItem().toString());
                prod.setSottocategoria(subcategory.getSelectedItem().toString());
                prod.setCosto(Double.parseDouble(costo.getText()));


                //set produttore
                p.setNome(prod_name.getText());
                p.setCitta(city.getText());
                p.setNazione(nation.getText());
                p.setSitoweb(website.getText());
                IproductDAO prodi=new productDAO();
                //set image
                Icon icon = foto.getIcon();
                //  BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = img.createGraphics();
                // g2d.drawImage(img, 0, 0, 50, 50, null);
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
                    admin.newsubproduct(prod, p, bytes,prodi.findById(Integer.parseInt(idprod.getText())));
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
public void setidprod(int id){
        idprod.setText(String.valueOf(id));
}
}




