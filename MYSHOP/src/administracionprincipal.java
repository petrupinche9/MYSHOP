import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//crea punti vendita
class Ascoltatore3 implements ActionListener
{
    public void actionPerformed(ActionEvent h)
    {
        JButton b = (JButton)h.getSource();
        System.out.println("Creazione punti vendita");
    }
}
//classe di modifica
class Ascoltatore2 implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();
        administracion ad = new administracion();
    }
}

class Ascoltatore implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
        HomePageMyShop shop = new HomePageMyShop();
    }
}

public class administracionprincipal extends JFrame
{
    private JButton vaiAlMyShopButton;
    private JButton vaiAllaClasseDiButton;
    private JButton creaPuntiVenditaButton;
    private JPanel administracionprincipal;
    Ascoltatore listener = new Ascoltatore();
    Ascoltatore2 listener2 = new Ascoltatore2();
    Ascoltatore3 listener3 = new Ascoltatore3();

    public administracionprincipal()
    {
        setContentPane(administracionprincipal);
        setTitle("GESTIONE MYSHOP");
        vaiAlMyShopButton.addActionListener(listener);
        vaiAllaClasseDiButton.addActionListener(listener2);
        creaPuntiVenditaButton.addActionListener(listener3);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
