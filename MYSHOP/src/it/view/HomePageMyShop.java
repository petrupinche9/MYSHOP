package it.view;

import javax.swing.*;

public class HomePageMyShop extends JFrame
{
    private JComboBox comboBox1;
    private JPanel HomePage;

    public HomePageMyShop()
    {
        comboBox1.addItem("SELEZIONE PUNTI VENDITA");
        setContentPane(HomePage);
        setTitle("HomePage");
        setSize(700, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
