import javax.swing.*;
import java.awt.*;

public class Principale
{
    public static void main(String[] args)
    {
        MENU interfaccia = new MENU();
        boolean confronta1, confronta2, confronta3;
        String scelta = JOptionPane.showInputDialog("Benvenuto nel nostro MyShop \n" +
                "Sei Amministratore, Manager oppure Utente?");
        confronta1 = scelta.equals("Amministratore");
        confronta2 = scelta.equals("Manager");
        confronta3 = scelta.equals("Utente");
        if (confronta1 == false && confronta2 == false && confronta3 == false)
        {
            do
            {
                scelta = JOptionPane.showInputDialog("Il nome inserito non è valido! \n" +
                        "RIPROVARE");
                confronta1 = scelta.equals("Amministratore");
                confronta2 = scelta.equals("Manager");
                confronta3 = scelta.equals("Utente");
            } while (confronta1 == false && confronta2 == false && confronta3 == false);
        }
        if (scelta.equals("Utente"))
        {
            interfaccia.GUI();
        }
    }
}
