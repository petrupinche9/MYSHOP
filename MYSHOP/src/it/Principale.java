package it;

import it.view.MENU;

import javax.swing.*;

public class Principale
{
    public static void main(String[] args)throws Exception
    {
        JOptionPane.showMessageDialog(null, DbConnection.getInstance().isConnesso());
        MENU rf = new MENU();
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
      //  rf.setSize(500,400);
        rf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
