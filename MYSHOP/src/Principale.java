import javax.swing.*;
import java.awt.*;

public class Principale
{
    public static void main(String[] args)
    {
        guest utente = new guest();
        MENU interfaccia = new MENU();
        boolean confronta1, confronta2, confronta3, confronta4, confronta5;
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
            String risposta = JOptionPane.showInputDialog("Salve \n" +
                    "Grazie per aver scelto il nostro MyShop. Speriamo sia di tuo gradimento \n" +
                    "Sei un utente registrato? (Rispondi con SI o NO)");
            confronta4 = risposta.equals("SI");
            confronta5 = risposta.equals("NO");
            if (confronta4 == false || confronta5 == false)
            {
                do
                {
                    risposta = JOptionPane.showInputDialog("ATTENZIONE!!! \n" +
                            "Inserimento non valido! \n" +
                            "RIPROVARE");
                    confronta4 = risposta.equals("SI");
                    confronta5 = risposta.equals("NO");
                } while (confronta4 == false && confronta5 == false)
            }
            if (risposta.equals("SI"))
            {
                utente.visitaShop();
            } else
            {
                String risposta2 = JOptionPane.showInputDialog("Vuoi effettuare la registrazione? " +
                        "(Rispondi con SI o NO)");
                if (risposta2.equals("NO"))
                {
                    utente.visitaShop();
                } else
                {
                    utente.registrazione();
                }
            }
        }
    }
}
