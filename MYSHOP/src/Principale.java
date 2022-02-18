import javax.swing.*;
import java.awt.*;

class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("BENVENUTO NEL NOSTRO", 200, 50);
        g2.drawString("MY SHOP", 250, 70);
    }
}

public class Principale
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,400);
        frame.setTitle("MYSHOP DI MATTEO E ALESSIO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectangleComponent component = new RectangleComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
