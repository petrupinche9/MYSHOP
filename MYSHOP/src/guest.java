import javax.swing.*;

public class guest
{
    MENU grafica = new MENU();
    public void visitaShop()
    {
        grafica.setVisible(true);
    }
    public void registrazione()
    {
        boolean confronta, confronta1, confronta3, confronta4, confronta5, confronta6, confronta7, confronta8;
        boolean confronta2, controll;
        String nome = JOptionPane.showInputDialog("Benvenuto nella fase di registrazione! \n" +
                "(Nell'eventualità di inserimento errato, ti verrà chiesto alla fine della procedura di confermare " +
                        "o meno i tuoi dati). \n" +
                "Inserisci il tuo NOME");
        String cognome = JOptionPane.showInputDialog("Inserisci il tuo COGNOME");
        String mail = JOptionPane.showInputDialog("Inserisci la tua E-MAIL");
        String telefono = JOptionPane.showInputDialog("Inserisci il tuo NUMERO DI TELEFONO");
        String età = JOptionPane.showInputDialog("Inserisci la tua ETÀ");
        String residenza = JOptionPane.showInputDialog("Inserisci la tua RESIDENZA");
        String professione = JOptionPane.showInputDialog("Inserisci la tua PROFESSIONE");
        String conferma = JOptionPane.showInputDialog("I tuoi dati sono: \n" +
                "NOME: " + nome +
                "\n COGNOME: " + cognome +
                "\n E-MAIL: " + mail +
                "\n TELEFONO: " + telefono +
                "\n ETÀ: " + età +
                "\n RESIDENZA: " + residenza +
                "\n PROFESSIONE: " + professione +
                "\n Vuoi confermare i dati inseriti (Rispondi con SI o NO");
        confronta = conferma.equals("SI");
        confronta1 = conferma.equals("NO");
        if (confronta == false && confronta1 == false)
        {
            do
            {
                conferma = JOptionPane.showInputDialog("!RISPOSTA INSERITA NON VALIDA! \n" +
                        "Riepilogo dati: \n" +
                        "NOME: " + nome +
                        "\n COGNOME: " + cognome +
                        "\n E-MAIL: " + mail +
                        "\n TELEFONO: " + telefono +
                        "\n ETÀ: " + età +
                        "\n RESIDENZA: " + residenza +
                        "\n PROFESSIONE: " + professione +
                        "\n Vuoi confermare i dati inseriti (Rispondi con SI o NO");
                confronta = conferma.equals("SI");
                confronta1 = conferma.equals("NO");
            } while (confronta == false && confronta1 == false);
        }
        if (confronta1 == true && confronta == false)
        {
            String controllo = JOptionPane.showInputDialog("Cosa desideri modificare?");
            confronta2 = controllo.equals("NOME");
            confronta3 = controllo.equals("COGNOME");
            confronta4 = controllo.equals("E-MAIL");
            confronta5 = controllo.equals("TELEFONO");
            confronta6 = controllo.equals("ETÀ");
            confronta7 = controllo.equals("RESIDENZA");
            confronta8 = controllo.equals("PROFESSIONE");
            if (confronta2 == false && confronta3 == false && confronta4 == false && confronta5 == false
            && confronta6 == false && confronta7 == false && confronta8 == false)
            {
                do
                {
                    controllo = JOptionPane.showInputDialog("ERRORE: INSERIMENTO NON VALIDO. \n" +
                            "Cosa desideri modificare? (Digitare quello che si vuole modificare in MAIUSCOLO)");
                    confronta2 = controllo.equals("NOME");
                    confronta3 = controllo.equals("COGNOME");
                    confronta4 = controllo.equals("E-MAIL");
                    confronta5 = controllo.equals("TELEFONO");
                    confronta6 = controllo.equals("ETÀ");
                    confronta7 = controllo.equals("RESIDENZA");
                    confronta8 = controllo.equals("PROFESSIONE");
                } while (confronta2 == false && confronta3 == false && confronta4 == false && confronta5 == false
                        && confronta6 == false && confronta7 == false && confronta8 == false);
            }
            if (confronta2 == true)
            {
                nome = JOptionPane.showInputDialog("Inserisci il nuovo NOME");
            }
            if (confronta3 == true)
            {
                cognome = JOptionPane.showInputDialog("Inserisci il nuovo COGNOME");
            }
            if (confronta4 == true)
            {
                mail = JOptionPane.showInputDialog("Inserisci la nuova E-MAIL");
            }
            if (confronta5 == true)
            {
                telefono = JOptionPane.showInputDialog("Inserisci il nuovo NUMERO DI TELEFONO");
            }
            if (confronta6 == true)
            {
                età = JOptionPane.showInputDialog("Inserisci la nuova ETÀ");
            }
            if (confronta7 == true)
            {
                residenza = JOptionPane.showInputDialog("Inserisci la nuova RESIDENZA");
            }
            if (confronta8 == true)
            {
                professione = JOptionPane.showInputDialog("Inserisci la nuova PROFESSIONE");
            }
            String nuovo = JOptionPane.showInputDialog("RIEPILOGO DATI MODIFICATO: \n" +
                    "NOME: " + nome +
                    "\n COGNOME: " + cognome +
                    "\n E-MAIL: " + mail +
                    "\n TELEFONO: " + telefono +
                    "\n ETÀ: " + età +
                    "\n RESIDENZA: " + residenza +
                    "\n PROFESSIONE: " + professione +
                    "\n Digitare OK per continuare");
            controll = nuovo.equals("OK");
            if (controll == false)
            {
                do
                {
                    nuovo = JOptionPane.showInputDialog("ERRORE: Digita OK");
                    controll = nuovo.equals("OK");
                } while (controll == false);
            }
            System.out.println("Grazie per esserti registrato. Sarai automaticamente inviato sul nostro MySHOP");
            grafica.GUI();
        }
        if (confronta == true && confronta1 == false)
        {
            System.out.println("Grazie per esserti registrato. Sarai automaticamente inviato sul nostro MySHOP");
            grafica.GUI();
        }
    }
}
