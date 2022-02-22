import javax.swing.*;

public class Principale
{
    public static void main(String[] args)
    {
        guest utente = new guest();
        boolean confronta1, confronta2, confronta3, confronta4, confronta5, confronta6, confronta7;
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
                        "RIPROVARE: sei Amministratore, Manager oppure Utente? ");
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
            if (confronta4 == false && confronta5 == false)
            {
                do
                {
                    risposta = JOptionPane.showInputDialog("ATTENZIONE!!! \n" +
                            "Inserimento non valido! \n" +
                            "RIPROVARE: Sei un utente registrato? (Rispondi con SI o NO)");
                    confronta4 = risposta.equals("SI");
                    confronta5 = risposta.equals("NO");
                } while (confronta4 == false && confronta5 == false);
            }
            if (risposta.equals("SI"))
            {
                MENU menu = new MENU();
            } else
            {
                String risposta2 = JOptionPane.showInputDialog("Vuoi effettuare la registrazione? " +
                        "(Rispondi con SI o NO)");
                confronta6 = risposta2.equals("SI");
                confronta7 = risposta2.equals("NO");
                if (confronta6 == false && confronta7 == false)
                {
                    do
                    {
                        risposta2 = JOptionPane.showInputDialog("ATTENZIONE!!! \n" +
                                "Inserimento non valido! \n" +
                                "RIPROVARE: Vuoi effettuare la registrazione? (Rispondi con SI o NO)");
                        confronta6 = risposta2.equals("SI");
                        confronta7 = risposta2.equals("NO");
                    } while(confronta6 == false && confronta7 == false);
                }
                if (risposta2.equals("NO"))
                {
                    utente.visitaShop();
                } else
                {
                    REGISTRAZIONE registrazione = new REGISTRAZIONE();
                }
            }
        }
    }
}
