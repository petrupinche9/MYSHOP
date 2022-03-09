package it.view;

import javax.swing.*;

public class Manager_gui extends JFrame
{
    private JButton vaiAllaListaDegliButton;
    private JButton vaiAlMagazzinoButton;
    private JPanel managerPanel;

    public Manager_gui()
    {
        setContentPane(managerPanel);
        setTitle("MANAGER GUI");
        setSize(700, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
