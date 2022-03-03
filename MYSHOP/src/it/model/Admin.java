package it.model;

import it.model.user;

import javax.swing.*;

public class Admin extends user
{
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
        if(categoria.equals("Mobili") || categoria.equals("Illuminazione") || categoria.equals("Tessile"))
        {
            switch (categoria)
            {
                case "Mobili": System.out.println("Categoria --> " + categoria); break;
                case "Illuminazione": System.out.println("Categoria --> " + categoria); break;
                case "Tessile": System.out.println("Categoria --> " + categoria); break;
            }
        } else
        {
            boolean fatto = false;
            do
            {
                categoria = JOptionPane.showInputDialog("Inserimento non valido. RIPROVARE \n" +
                        "A = Mobili \n" +
                        "B = Illuminazione \n " +
                        "C = Tessile \n " +
                        "(Si scriva il nome)");
                if(categoria.equals("Mobili") || categoria.equals("Illuminazione") || categoria.equals("Tessile"))
                {
                    fatto = true;
                }
            } while (fatto == false);
            System.out.println("Categoria --> " + categoria);
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
        if (sottocategoria.equals("Cucina") || sottocategoria.equals("Soggiorno") ||
                sottocategoria.equals("Camera") || sottocategoria.equals("Tappeti") ||
                sottocategoria.equals("Tende") || sottocategoria.equals("Lampadari") ||
                sottocategoria.equals("Lampada da esterno"))
        {
            switch (sottocategoria)
            {
                case "Cucina": System.out.println("Sottocategoria --> " + sottocategoria); break;
                case "Soggiorno": System.out.println("Sottocategoria --> " + sottocategoria); break;
                case "Camera": System.out.println("Sottocategoria --> " + sottocategoria); break;
                case "Tappeti": System.out.println("Sottocategoria --> " + sottocategoria); break;
                case "Tende": System.out.println("Sottocategoria --> " + sottocategoria); break;
                case "Lampadari": System.out.println("Sottocategoria --> " + sottocategoria); break;
                case "Lampade da esterno": System.out.println("Sottocategoria --> " + sottocategoria); break;
            }
        } else
        {
            boolean fatto = false;
            do {
                sottocategoria = JOptionPane.showInputDialog("Sottocategoria inserita non valida! \n" +
                        "RIPROVARE (Si scriva il nome) \n" +
                        "A = Cucina \n" +
                        "B = Soggiorno \n" +
                        "C = Camera \n" +
                        "D = Tappeti \n" +
                        "E = Tende \n" +
                        "F = Lampadari \n" +
                        "G = Lampade da esterno");
                if (sottocategoria.equals("Cucina") || sottocategoria.equals("Soggiorno") ||
                        sottocategoria.equals("Camera") || sottocategoria.equals("Tappeti") ||
                        sottocategoria.equals("Tende") || sottocategoria.equals("Lampadari") ||
                        sottocategoria.equals("Lampada da esterno")) {
                    fatto = true;
                }
            } while (fatto == false);
            System.out.println("Sottocategoria --> " + sottocategoria);
        }
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
        if (includeart.equals("SI") || includeart.equals("NO"))
        {
            if (includeart.equals("SI"))
            {
                System.out.println("Si includono prodotti? --> " + includeart);
                String number = JOptionPane.showInputDialog("Quanti prodotti vuoi includere?");
                numero = Integer.parseInt(number);
                System.out.println("Numero prodotti inclusi --> " + numero);
                String[] includes = new String[numero];
                for(int i = 0; i < numero; i++)
                {
                    includes[i] = JOptionPane.showInputDialog("Prodotto numero " + (i + 1));
                    System.out.println(includes[i]);
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
            } else
            {
                if (includeart.equals("NO"))
                {
                    System.out.println("Si includono prodotti? --> " + includeart);
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
            }
        } else
        {
            boolean fatto = false;
            do
            {
               includeart = JOptionPane.showInputDialog("Inserimento non valido. RIPROVARE" +
                       "(Si scriva SI o NO)");
               if (includeart.equals("SI") || includeart.equals("NO"))
               {
                   fatto = true;
               }
            } while (fatto == false);
            if (includeart.equals("SI"))
            {
                System.out.println("Si includono prodotti? --> " + includeart);
                String number = JOptionPane.showInputDialog("Quanti prodotti vuoi includere?");
                numero = Integer.parseInt(number);
                System.out.println("Numero prodotti inclusi --> " + numero);
                String[] includes = new String[numero];
                for(int i = 0; i < numero; i++)
                {
                    includes[i] = JOptionPane.showInputDialog("Prodotto numero " + (i + 1));
                    System.out.println(includes[i]);
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
            } else
            {
                if (includeart.equals("NO"))
                {
                    System.out.println("Si includono prodotti? --> " + includeart);
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
            }
        }
    }

    public void InsertService()
    {
        double costo;
        System.out.println("SCELTE EFFETTUATE:");
        String service = JOptionPane.showInputDialog("Scelga la categoria di servizio che vuole inserire: \n" +
                "A = Montaggio \n " +
                "B = Trasporto \n " +
                "(Si scriva il nome");
        if (service.equals("Montaggio") || service.equals("Trasporto"))
        {
            switch (service)
            {
                case "Montaggio": System.out.println("Categoria --> " + service); break;
                case "Trasporto": System.out.println("Categoria --> " + service); break;
            }
        } else
        {
            boolean fatto = false;
            do
            {
                service = JOptionPane.showInputDialog("Inserimento non valido. RIPROVARE \n" +
                        "A = Montaggio \n " +
                        "B = Trasporto \n " +
                        "(Si scriva il nome");
                if (service.equals("Montaggio") || service.equals("Trasporto"))
                {
                    fatto = true;
                }
            } while (fatto == false);
            System.out.println("Categoria --> " + service);
        }
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
        if (response.equals("Montaggio") || response.equals("Trasporto"))
        {
            switch (response)
            {
                case "Montaggio": System.out.println("Si è scelto --> " + response); break;
                case "Trasporto": System.out.println("Si è scelto --> " + response); break;
            }
        } else
        {
            boolean fatto = false;
            do
            {
                response = JOptionPane.showInputDialog("Inserimento non valido. RIPROVARE \n" +
                        "A = Montaggio \n " +
                        "B = Trasporto \n " +
                        "(Si scriva il nome");
                if (response.equals("Montaggio") || response.equals("Trasporto"))
                {
                    fatto = true;
                }
            } while (fatto == false);
            System.out.println("Si è scelto --> " + response);
        }
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
        if (modify.equals("Montaggio") || modify.equals("Trasporto"))
        {
            switch (modify)
            {
                case "Montaggio": System.out.println("Si è scelto --> " + modify); break;
                case "Trasporto": System.out.println("Si è scelto --> " + modify); break;
            }
        } else
        {
            boolean fatto = false;
            do
            {
                modify = JOptionPane.showInputDialog("Inserimento non valido. RIPROVARE \n" +
                        "A = Montaggio \n " +
                        "B = Trasporto \n " +
                        "(Si scriva il nome");
                if (modify.equals("Montaggio") || modify.equals("Trasporto"))
                {
                    fatto = true;
                }
            } while (fatto == false);
            System.out.println("Si è scelto --> " + modify);
        }
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
