import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Line2D.Double segment2 = new Line2D.Double(590,150,632,150);
        Line2D.Double segment = new Line2D.Double(50,150,90,150);
        Ellipse2D.Double noise2 = new Ellipse2D.Double(602, 120 ,20,20);
        Ellipse2D.Double noise = new Ellipse2D.Double(60, 120 ,20,20);
        Ellipse2D.Double eye4 = new Ellipse2D.Double(627,100,10,10);
        Ellipse2D.Double eye3 = new Ellipse2D.Double(580,100,10,10);
        Ellipse2D.Double eye2 = new Ellipse2D.Double(87,100,10,10);
        Ellipse2D.Double eye1 = new Ellipse2D.Double(40,100,10,10);
        Ellipse2D.Double circle1 = new Ellipse2D.Double(560,70,100,100);
        Ellipse2D.Double circle = new Ellipse2D.Double(20, 70, 100, 100);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(140, 50, 400,150);
        g2.drawString("BENVENUTO", 300, 100);
        g2.drawString("SUL NOSTRO", 298,138);
        g2.drawString("MYSHOP", 310,170);
        g2.draw(segment2);
        g2.draw(segment);
        g2.draw(noise2);
        g2.draw(noise);
        g2.draw(eye4);
        g2.draw(eye3);
        g2.draw(eye2);
        g2.draw(eye1);
        g2.draw(circle1);
        g2.draw(circle);
        g2.draw(ellipse);
    }
}

public class MyShop
{
    public void GUI()
    {
        RectangleComponent component10 = new RectangleComponent();
        RectangleComponent component9 = new RectangleComponent();
        RectangleComponent component8 = new RectangleComponent();
        RectangleComponent component7 = new RectangleComponent();
        RectangleComponent component6 = new RectangleComponent();
        RectangleComponent component5 = new RectangleComponent();
        RectangleComponent component4 = new RectangleComponent();
        RectangleComponent component3 = new RectangleComponent();
        RectangleComponent component = new RectangleComponent();
        RectangleComponent component1 = new RectangleComponent();
        RectangleComponent component2 = new RectangleComponent();
        JFrame frame = new JFrame();
        frame.add(component10);
        frame.add(component9);
        frame.add(component8);
        frame.add(component7);
        frame.add(component6);
        frame.add(component5);
        frame.add(component4);
        frame.add(component3);
        frame.add(component2);
        frame.add(component);
        frame.add(component1);
        frame.setSize(700, 700);
        frame.setTitle("MYSHOP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
