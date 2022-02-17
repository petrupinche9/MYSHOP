import java.util.Scanner;

public class service
{
    private String risposta;
    Scanner in = new Scanner(System.in);
    private int costo;
    public void InsertService()
    {
        System.out.println("Scelga la categoria di servizi che desidera inserire (si scriva il nome): ");
        System.out.println("A = Montaggio");
        System.out.println("B = Trasporto");
        do
        {
            if (risposta==null)
            {
                risposta = in.next();
            }
            else
            {
                System.out.println("Risposta non valida: RIPROVARE");
                risposta = in.next();
            }
        } while(risposta.equals("Montaggio") || risposta.equals("Trasporto"));
        System.out.print("Inserisca il costo del servizio (inserire un numero)");
        costo = in.nextInt();
    }
    public void DeleteService()
    {

    }
    public void ModificationService()
    {

    }
}
