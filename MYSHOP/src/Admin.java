import javax.swing.*;
import java.util.Scanner;

public class Admin
{
    Scanner in = new Scanner(System.in);
    boolean confronta, confronta2, confronta3, confronta4, confronta5, confronta6, confronta7;
    boolean confronta8, confronta9, confronta10, confronta11, confronta12;
    private double costodouble;
    private String newproduct;
    private int numero, corsia, scaffale;
    private String[] includes = new String[numero];
    public void Insertitem()
    {
        String categoria = JOptionPane.showInputDialog("Scelga la categoria di articoli che desidera inserire: \n" +
                "A = Mobili \n" +
                "B = Illuminazione \n " +
                "C = Tessile \n " +
                "(Si scriva il nome)");
        confronta = categoria.equals("Mobili");
        confronta2 = categoria.equals("Illuminazione");
        confronta3 = categoria.equals("Tessile");
        if (confronta == false && confronta2 == false || confronta3 == false)
        {
            do
            {
                categoria = JOptionPane.showInputDialog("Categoria inserita non valida! \n " +
                        "RIPROVARE (Si scriva il nome)");
                confronta = categoria.equals("Mobili");
                confronta2 = categoria.equals("Illuminazione");
                confronta3 = categoria.equals("Tessile");
            } while (confronta == false && confronta2 == false || confronta3 == false);
        }
        String sottocategoria = JOptionPane.showInputDialog("Scelga ora una sottocategoria: \n" +
                        "A = Cucina \n" +
                        "B = Soggiorno \n" +
                        "C = Camera \n" +
                        "D = Tappeti \n" +
                        "E = Tende \n" +
                        "F = Lampadari \n" +
                        "G = Lampade da esterno \n" +
                        "(Si scriva il nome)");
        confronta4 = categoria.equals("Cucina");
        confronta5 = categoria.equals("Soggiorno");
        confronta6 = categoria.equals("Camera");
        confronta7 = categoria.equals("Tappeti");
        confronta8 = categoria.equals("Tende");
        confronta9 = categoria.equals("Lampadari");
        confronta10 = categoria.equals("Lampade da esterno");
        if (confronta4 == false && confronta5 == false && confronta6 == false && confronta7 == false &&
                confronta8 == false && confronta9 == false && confronta10 == false)
        {
            do
            {
                sottocategoria = JOptionPane.showInputDialog("Sottocategoria inserita non valida! \n" +
                        "RIPROVARE (Si scriva il nome)");
                confronta4 = categoria.equals("Cucina");
                confronta5 = categoria.equals("Soggiorno");
                confronta6 = categoria.equals("Camera");
                confronta7 = categoria.equals("Tappeti");
                confronta8 = categoria.equals("Tende");
                confronta9 = categoria.equals("Lampadari");
                confronta10 = categoria.equals("Lampade da esterno");
            } while (confronta4 == false && confronta5 == false && confronta6 == false && confronta7 == false &&
                    confronta8 == false && confronta9 == false && confronta10 == false);
        }
        newproduct = JOptionPane.showInputDialog("Inserisca il prodotto:");
        String costo = JOptionPane.showInputDialog("Inserisca il costo del prodotto");
        costodouble = Double.parseDouble(costo);
        String question = JOptionPane.showInputDialog("Inserisca il numero di corsia");
        corsia = Integer.parseInt(question);
        String question2 = JOptionPane.showInputDialog("Inserisca il numero di scaffale");
        scaffale = Integer.parseInt(question2);
        String includeart = JOptionPane.showInputDialog("Vuole includere altri articoli in questo prodotto? \n" +
                "(Rispondere con SI o NO)");
        confronta11 = includeart.equals("SI");
        confronta12 = includeart.equals("NO");
        if (confronta11 == false && confronta12 == false)
        {
            do
            {
                includeart = JOptionPane.showInputDialog("Risposta non valida: RIPROVARE!! \n" +
                        "(Rispondere con SI o NO");
                confronta11 = includeart.equals("SI");
                confronta12 = includeart.equals("NO");
            } while (confronta11 == false && confronta12 == false);
        }
        if (confronta11 == true && confronta12 == false)
        {
            String number = JOptionPane.showInputDialog("Quanti articoli vuole inserire?");
            numero = Integer.parseInt(number);
            System.out.println("Inserisca gli articoli che vuole includere:");
            for (int i = 0; i < numero; i++)
            {
                includes[i] = in.next();
            }
        }
        String nomeproduttore = JOptionPane.showInputDialog("Inserisca ora i dati del produttore: \n" +
                "Inserisca il NOME");
        String sitowebproduttore = JOptionPane.showInputDialog("Inserisca il SITOWEB");
        String cittàproduttore = JOptionPane.showInputDialog("Inserisca la CITTÀ");
        String nazioneproduttore = JOptionPane.showInputDialog("Inserisca la NAZIONE");
    }
    boolean confronta13, confronta14;
    private int costo;
    public void InsertService()
    {
        String service = JOptionPane.showInputDialog("Scelga la categoria di servizio che vuole inserire: \n" +
                "A = Montaggio \n " +
                "B = Trasporto \n " +
                "(Si scriva il nome");
        confronta13 = service.equals("Montaggio");
        confronta14 = service.equals("Trasporto");
        if (confronta13 == false && confronta14 == false)
        {
            do
            {
                service = JOptionPane.showInputDialog("Inserimento non valido! \n" +
                        "RIPROVARE (Si scriva il nome");
                confronta13 = service.equals("Montaggio");
                confronta14 = service.equals("Trasporto");
            } while (confronta13 == false && confronta14 == false);
        }
        String prezzo = JOptionPane.showInputDialog("Inserisca il costo del servizio");
        costo = Integer.parseInt(prezzo);
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
