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
    public void Insertitem()
    {
        System.out.println("SCELTE EFFETTUATE:");
        String categoria = JOptionPane.showInputDialog("Scelga la categoria di articoli che desidera inserire: \n" +
                "A = Mobili \n" +
                "B = Illuminazione \n " +
                "C = Tessile \n " +
                "(Si scriva il nome)");
        confronta = categoria.equals("Mobili");
        confronta2 = categoria.equals("Illuminazione");
        confronta3 = categoria.equals("Tessile");
        if (confronta == false && confronta2 == false && confronta3 == false)
        {
            do
            {
                categoria = JOptionPane.showInputDialog("Categoria inserita non valida! \n " +
                        "RIPROVARE (Si scriva il nome) \n" +
                                "A = Mobili \n" +
                                "B = Illuminazione \n " +
                                "C = Tessile");
                confronta = categoria.equals("Mobili");
                confronta2 = categoria.equals("Illuminazione");
                confronta3 = categoria.equals("Tessile");
            } while (confronta == false && confronta2 == false && confronta3 == false);
        }
        System.out.println("Categoria --> " + categoria);
        String sottocategoria = JOptionPane.showInputDialog("Scelga ora una sottocategoria: \n" +
                        "A = Cucina \n" +
                        "B = Soggiorno \n" +
                        "C = Camera \n" +
                        "D = Tappeti \n" +
                        "E = Tende \n" +
                        "F = Lampadari \n" +
                        "G = Lampade da esterno \n" +
                        "(Si scriva il nome)");
        confronta4 = sottocategoria.equals("Cucina");
        confronta5 = sottocategoria.equals("Soggiorno");
        confronta6 = sottocategoria.equals("Camera");
        confronta7 = sottocategoria.equals("Tappeti");
        confronta8 = sottocategoria.equals("Tende");
        confronta9 = sottocategoria.equals("Lampadari");
        confronta10 = sottocategoria.equals("Lampade da esterno");
        if (confronta4 == false && confronta5 == false && confronta6 == false && confronta7 == false &&
                confronta8 == false && confronta9 == false && confronta10 == false)
        {
            do
            {
                sottocategoria = JOptionPane.showInputDialog("Sottocategoria inserita non valida! \n" +
                        "RIPROVARE (Si scriva il nome) \n" +
                                "A = Cucina \n" +
                                "B = Soggiorno \n" +
                                "C = Camera \n" +
                                "D = Tappeti \n" +
                                "E = Tende \n" +
                                "F = Lampadari \n" +
                                "G = Lampade da esterno");
                confronta4 = sottocategoria.equals("Cucina");
                confronta5 = sottocategoria.equals("Soggiorno");
                confronta6 = sottocategoria.equals("Camera");
                confronta7 = sottocategoria.equals("Tappeti");
                confronta8 = sottocategoria.equals("Tende");
                confronta9 = sottocategoria.equals("Lampadari");
                confronta10 = sottocategoria.equals("Lampade da esterno");
            } while (confronta4 == false && confronta5 == false && confronta6 == false && confronta7 == false &&
                    confronta8 == false && confronta9 == false && confronta10 == false);
        }
        System.out.println("Sottocategoria --> " + sottocategoria);
        newproduct = JOptionPane.showInputDialog("Inserisca il prodotto:");
        System.out.println("Nuovo Prodotto --> " + newproduct);
        String costo = JOptionPane.showInputDialog("Inserisca il costo del prodotto");
        System.out.println("Costo nuovo prodotto --> " + costo + "€");
        costodouble = Double.parseDouble(costo);
        String question = JOptionPane.showInputDialog("Inserisca il numero di corsia");
        System.out.println("Numero di corsia --> " + question);
        corsia = Integer.parseInt(question);
        String question2 = JOptionPane.showInputDialog("Inserisca il numero di scaffale");
        System.out.println("Numero di scaffale --> " + question2);
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
        System.out.println("Si includono prodotti? --> " + includeart);
        if (confronta11 == true && confronta12 == false)
        {
            String number = JOptionPane.showInputDialog("Quanti prodotti vuoi includere?");
            numero = Integer.parseInt(number);
            System.out.println("Numero prodotti inclusi --> " + numero);
            String[] includes = new String[numero];
            for(int i = 0; i < numero; i++)
            {
                includes[i] = JOptionPane.showInputDialog("Prodotto numero " + (i + 1));
                System.out.println(includes[i]);
            }
        }
        String nomeproduttore = JOptionPane.showInputDialog("Inserisca ora i dati del produttore: \n" +
                "Inserisca il NOME");
        System.out.println("Nome del Produttore --> " + nomeproduttore);
        String sitowebproduttore = JOptionPane.showInputDialog("Inserisca il SITOWEB");
        System.out.println("Sitoweb del Produttore --> " + sitowebproduttore);
        String cittàproduttore = JOptionPane.showInputDialog("Inserisca la CITTÀ");
        System.out.println("Città del Produttore --> " + cittàproduttore);
        String nazioneproduttore = JOptionPane.showInputDialog("Inserisca la NAZIONE");
        System.out.println("Nazione del Produttore --> " + nazioneproduttore);
    }

    public void InsertService()
    {
        boolean confronta13, confronta14;
        int costo;
        System.out.println("SCELTE EFFETTUATE:");
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
                        "RIPROVARE (Si scriva il nome) \n" +
                        "A = Montaggio \n " +
                        "B = Trasporto \n " +
                        "(Si scriva il nome");
                confronta13 = service.equals("Montaggio");
                confronta14 = service.equals("Trasporto");
            } while (confronta13 == false && confronta14 == false);
        }
        System.out.println("Categoria --> " + service);
        String prezzo = JOptionPane.showInputDialog("Inserisca il costo del servizio");
        System.out.println("Costo --> " + prezzo + "€");
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
