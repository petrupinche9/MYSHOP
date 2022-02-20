import javax.swing.*;
import java.util.Scanner;

public class Admin
{
    Scanner in = new Scanner(System.in);
    private String risposta;
    private String risposta2;
    private String risposta3;
    private String newproduct;
    private int numero;
    private String[] includes = new String[numero];
    private double costo;
    private String nomeproduttore;
    private String sitowebproduttore;
    private String cittàproduttore;
    private String nazioneproduttore;
    public void Insertitem()
    {
        System.out.println("Scelga la categoria di articoli che desidera inserire (si scriva il nome): ");
        System.out.println("A = Mobili");
        System.out.println("B = Illuminazione");
        System.out.println("C = Tessili");
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
        } while(risposta.equals("Mobili") || risposta.equals("Illuminazione") || risposta.equals("Tessili"));
        System.out.println("Scelga ora una sottocategoria fra quelle elecante (si scriva il nome): ");
        System.out.println("A = Cucina");
        System.out.println("B = Soggiorno");
        System.out.println("C = Camera");
        System.out.println("D = Tappeti");
        System.out.println("E = Tende");
        System.out.println("F = Lampadari");
        System.out.println("G = Lampade da esterno");
        do
        {
            if (risposta2==null)
            {
                risposta2 = in.next();
            }
            else
            {
                System.out.println("Risposta non valida: RIPROVARE");
                risposta2 = in.next();
            }
        } while(risposta2.equals("Cucina") || risposta2.equals("Soggiorno") || risposta2.equals("Camera")
                || risposta2.equals("Tappeti") || risposta2.equals("Tende") || risposta2.equals("Lampadari")
                || risposta2.equals("Lampade da esterno"));
        System.out.println("Ha scelto " + risposta + " -> " + risposta2);
        newproduct = JOptionPane.showInputDialog("Inserisca il prodotto:");
        System.out.print("Il prodotto inserito è " + newproduct + ".");
        System.out.print("Qual è il costo del prodotto da Lei inserito? (Inserisca un numero)");
        costo = in.nextDouble();
        System.out.print("Vuole includere altri prodotti? (Rispondere con Si o No)");
        do
        {
            if (risposta3==null)
            {
                risposta3 = in.next();
            }
            else
            {
                System.out.println("Risposta non valida: RIPROVARE");
                risposta3 = in.next();
            }
        } while(risposta3.equals("Si") || risposta3.equals("No"));
        if (risposta3.equals("Si"))
        {
            System.out.println("Quanti articoli vuole includere? (Rispondere con un numero)");
            numero = in.nextInt();
            System.out.println("Scriva gli articoli che vuole includere");
            for (int i = 0; i < numero; i++)
            {
                includes[i] = in.next();
            }
        }
        System.out.println("Inserisca ora i dati del produttore dell'articolo da Lei inserito:");
        System.out.print("Nome: ");
        nomeproduttore = in.next();
        System.out.print("Sito Web: ");
        sitowebproduttore = in.next();
        System.out.print("Città: ");
        cittàproduttore = in.next();
        System.out.print("Nazione: ");
        nazioneproduttore = in.next();
    }
    private String risposta4;
    private int costo2;
    public void InsertService()
    {
        System.out.println("Scelga la categoria di servizi che desidera inserire (si scriva il nome): ");
        System.out.println("A = Montaggio");
        System.out.println("B = Trasporto");
        do
        {
            if (risposta4==null)
            {
                risposta4 = in.next();
            }
            else
            {
                System.out.println("Risposta non valida: RIPROVARE");
                risposta4 = in.next();
            }
        } while(risposta4.equals("Montaggio") || risposta4.equals("Trasporto"));
        System.out.print("Inserisca il costo del servizio (inserire un numero)");
        costo2 = in.nextInt();
    }
    public void DeleteService()
    {

    }
    public void ModificationService()
    {

    }
    public void DeleteItem()
    {

    }
    public void ModificationItem()
    {

    }
}
