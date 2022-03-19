package it.view;

import it.DAO.AdminDAO;
import it.DAO.IAdminDAO;
import it.model.Fornitore;
import it.model.service;

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

public class administracionaggiungiservizio extends JFrame {
    private JTextField Nomefield;
    private JTextField Sitoweb;
    private JTextField Citta;
    private JTextField Nazione;
    private JButton CONFERMAButton;
    private JTextField costo;
    private JTextField categoria;
    private JButton sfogliaButton;
    private JTextArea descrizione;
    private JLabel foto;
    private JPanel descr;
    private JTextField name;
    private JPanel aggiungiservicePanel;

    public administracionaggiungiservizio()
    {
        setContentPane(aggiungiservicePanel);
        setTitle("AGGIUNGI SERVIZIO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        CONFERMAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namefornitore = Nomefield.getText();
                String siteweb = Sitoweb.getText();
                String city = Citta.getText();
                String nation = Nazione.getText();
                String nome=name.getText();
                double denaro= Double.parseDouble(costo.getText());
                String descr= descrizione.getText();
                String category=categoria.getText();

                Fornitore newfornitore = new Fornitore(0, namefornitore, siteweb, city, nation);
                service serv=new service(0,  nome, denaro, descr,  null, 404, null, category, newfornitore);
                AdminDAO aggiungiservice = new AdminDAO();

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
                    serv.setImg(bytes);
                    IAdminDAO admin = new AdminDAO();
                    admin.newservice(serv, newfornitore, bytes);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        sfogliaButton.addActionListener(new ActionListener() {
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
