package it;

import it.view.MENU;

public class Principale
{
    public static void main(String[] args)throws Exception
    {

        MENU rf = new MENU();
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setSize(600,400);
    }
}
