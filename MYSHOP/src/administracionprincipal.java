import javax.swing.*;
import java.awt.*;


public class administracionprincipal extends JFrame
{
    private JButton vaiAlMyShopButton;
    private JButton vaiAllaClasseDiButton;
    private JButton creaPuntiVenditaButton;
    private JPanel administracionprincipal;

    public administracionprincipal()
    {
        setContentPane(administracionprincipal);
        setTitle("GESTIONE MYSHOP");
        setSize(300, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
