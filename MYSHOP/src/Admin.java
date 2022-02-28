import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends user
{
    boolean confronta, confronta2, confronta3, confronta4, confronta5, confronta6, confronta7;
    boolean confronta8, confronta9, confronta10, confronta11, confronta12, confronta13, confronta14;
    boolean confronta15, confronta16;
    private String newproduct;
    private int numero, corsia, scaffale;
    private double costodouble, costodouble2;

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
        double costo;
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
        if (service.equals("Montaggio"))
        {
            service inseriscimontaggio = new service();
            String servizio = JOptionPane.showInputDialog("Inserisca il servizio di Montaggio");
            inseriscimontaggio.insertservicemontaggio(servizio);
            System.out.println("Servizio inserito --> " + servizio);
            String prezzo = JOptionPane.showInputDialog("Inserisca il costo del servizio di Montaggio");
            System.out.println("Costo --> " + prezzo + "€");
            costodouble2 = Double.parseDouble(prezzo);
            inseriscimontaggio.insertpricemontaggio(costodouble2);
            System.out.println("SERVIZIO DI MONTAGGIO INSERITO CON SUCCESSO");
        }
        if (service.equals("Trasporto"))
        {
            service inseriscitrasporto = new service();
            String servizio2 = JOptionPane.showInputDialog("Inserisca il servizio di Trasporto");
            inseriscitrasporto.insertservicetrasporto(servizio2);
            System.out.println("Servizio inserito --> " + servizio2);
            String prezzo = JOptionPane.showInputDialog("Inserisca il costo del servizio di Trasporto");
            System.out.println("Costo --> " + prezzo + "€");
            costo = Double.parseDouble(prezzo);
            inseriscitrasporto.insertpricetrasporto(costo);
            System.out.println("SERVIZIO DI MONTAGGIO INSERITO CON SUCCESSO");
        }
    }

    public void DeleteService()
    {
        System.out.println("SCELTE EFFETTUATE:");
        String response = JOptionPane.showInputDialog("Si scelga la categoria del servizio che si intende eliminare \n" +
                "A = Montaggio \n " +
                "B = Trasporto \n " +
                "(Si scriva il nome");
        confronta13 = response.equals("Montaggio");
        confronta14 = response.equals("Trasporto");
        if (confronta13 == false && confronta14 == false)
        {
            do
            {
                response = JOptionPane.showInputDialog("La scelta inserita non è valida! RIPROVARE \n" +
                        "A = Montaggio \n " +
                        "B = Trasporto \n " +
                        "(Si scriva il nome");
                confronta13 = response.equals("Montaggio");
                confronta14 = response.equals("Trasporto");
            } while (confronta13 == false && confronta14 == false);
        }
        System.out.println("Si è scelto --> " + response);
        if (response.equals("Montaggio"))
        {
            boolean controllo;
            service montaggio = new service();
            montaggio.getCategoriamontaggio();
            String deletemontaggio = JOptionPane.showInputDialog("Quale servizio di MONTAGGIO si desidera eliminare?");
            controllo = montaggio.controllomontaggio(deletemontaggio);
            if (controllo == false)
            {
                do
                {
                    deletemontaggio = JOptionPane.showInputDialog("Il servizio inserito non è presente in elenco! \n" +
                            "PREGO RIPROVARE");
                    controllo = montaggio.controllomontaggio(deletemontaggio);
                } while (controllo == false);
            }
            if (controllo == true)
            {
                montaggio.removemontaggio(deletemontaggio);
                JOptionPane.showMessageDialog(null,"Servizio MONTAGGIO rimosso con successo!");
            }
        }
        if (response.equals("Trasporto"))
        {
            boolean controllo2;
            service trasporto = new service();
            trasporto.getCategoriatrasporto();
            String deletetrasporto = JOptionPane.showInputDialog("Quale servizio di TRASPORTO si desidera eliminare?");
            controllo2 = trasporto.controllotrasporto(deletetrasporto);
            if (controllo2 == false)
            {
                do
                {
                    deletetrasporto = JOptionPane.showInputDialog("Il servizio inserito non è presente in elenco! \n" +
                            "PREGO RIPROVARE");
                    controllo2 = trasporto.controllotrasporto(deletetrasporto);
                } while (controllo2 == false);
            }
            if (controllo2 == true)
            {
                trasporto.removetrasporto(deletetrasporto);
                JOptionPane.showMessageDialog(null, "Servizio TRASPORTO rimosso con successo");
            }
        }
    }

    public void ModificationService()
    {
        System.out.println("SCELTE EFFETTUATE:");
        String modify = JOptionPane.showInputDialog("Quale categoria di servizio si intende modificare? \n" +
                "A = Montaggio \n" +
                "B = Trasporto \n" +
                "(Si scriva il nome)");
        confronta15 = modify.equals("Montaggio");
        confronta16 = modify.equals("Trasporto");
        if (confronta15 == false && confronta16 == false)
        {
            do
            {
                modify = JOptionPane.showInputDialog("La scelta inserita non è valida! RIPROVARE \n" +
                        "A = Montaggio \n" +
                        "B = Trasporto \n" +
                        "(Si scriva il nome)");
                confronta15 = modify.equals("Montaggio");
                confronta16 = modify.equals("Trasporto");
            } while (confronta15 == false && confronta16 == false);
        }
        System.out.println("Si è scelto --> " + modify);
        if (modify.equals("Montaggio"))
        {
            boolean controllo3;
            service montaggio2 = new service();
            montaggio2.getCategoriamontaggio();
            String modifymontaggio = JOptionPane.showInputDialog("Quale servizio di MONTAGGIO si desidera modificare?");
            controllo3 = montaggio2.controllomontaggio(modifymontaggio);
            if (controllo3 == false)
            {
                do
                {
                    modifymontaggio = JOptionPane.showInputDialog("Il servizio inserito non è presente in elenco! \n" +
                            "PREGO RIPROVARE");
                    controllo3 = montaggio2.controllomontaggio(modifymontaggio);
                } while (controllo3 == false);
            }
            if (controllo3 == true)
            {
                String newname = JOptionPane.showInputDialog("Inserire nuovo nome \n" +
                        "(Se non si intende modificare il nome lo si riscriva");
                String newprice = JOptionPane.showInputDialog("Inserire nuovo prezzo \n " +
                        "(Se non si intende modificare il prezzo lo si riscriva");
                double modprezzo = Double.parseDouble(newprice);
                montaggio2.modifymontag(modifymontaggio, newname, modprezzo);
                JOptionPane.showMessageDialog(null, "Servizio modificato con successo");
            }
        }
        if (modify.equals("Trasporto"))
        {
            boolean controllo4;
            service trasporto2 = new service();
            trasporto2.getCategoriatrasporto();
            String modifytrasporto = JOptionPane.showInputDialog("Quale servizio di TRASPORTO si desidera modificare?");
            controllo4 = trasporto2.controllotrasporto(modifytrasporto);
            if (controllo4 == false)
            {
                do
                {
                    modifytrasporto = JOptionPane.showInputDialog("Il servizio inserito non è presente in elenco! \n" +
                            "PREGO RIPROVARE");
                    controllo4 = trasporto2.controllotrasporto(modifytrasporto);
                } while (controllo4 == false);
            }
            if (controllo4 == true)
            {
                String newname2 = JOptionPane.showInputDialog("Inserire nuovo nome \n" +
                        "(Se non si intende modificare il nome lo si riscriva");
                String newprice2 = JOptionPane.showInputDialog("Inserire nuovo prezzo \n" +
                        "(Se non si intende modificare il prezzo lo si riscriva");
                double modprezzo2 = Double.parseDouble(newprice2);
                trasporto2.modifytraspor(modifytrasporto, newname2, modprezzo2);
                JOptionPane.showMessageDialog(null, "Servizio modificato con successo");
            }
        }
    }

    public void DeleteItem()
    {

    }

    public void ModificationItem()
    {

    }
}
