package it;

import it.view.MENU;

import javax.swing.*;

public class Principale
{
    public static void main(String[] args)throws Exception
    {
        JOptionPane.showMessageDialog(null, DbConnection.getInstance().isConnesso());
        MENU rf = new MENU();
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setSize(600,400);
    }
}
