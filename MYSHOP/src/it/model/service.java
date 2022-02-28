package it.model;

import java.util.ArrayList;

public class service
{
    ArrayList<String> servizimontaggio = new ArrayList<String>();
    ArrayList<Double> prezzimontaggio = new ArrayList<Double>();
    ArrayList<String> servizitrasporto = new ArrayList<String>();
    ArrayList<Double> prezzitrasporto = new ArrayList<Double>();

    public void insertservicemontaggio(String montaggio)
    {
        servizimontaggio.add(montaggio);
    }

    public void insertpricemontaggio(double montaggiocost)
    {
        prezzimontaggio.add(montaggiocost);
    }

    public void insertservicetrasporto(String trasporto)
    {
        servizitrasporto.add(trasporto);
    }

    public void insertpricetrasporto(double trasportocost)
    {
        prezzitrasporto.add(trasportocost);
    }
//metodi get

    public void getCostitrasporti()
    {
        System.out.println("I COSTI DEI SERVIZI DI TRASPORTO SONO:");
        for (int i = 0; i < prezzitrasporto.size(); i++)
        {
            System.out.println(prezzitrasporto.get(i));
        }
    }

    public void getCategoriatrasporto()
    {
        System.out.println("I SERVIZI DI CATEGORIA TRASPORTO SONO:");
        for (int i = 0; i < servizitrasporto.size(); i++)
        {
            System.out.println(servizitrasporto.get(i));
        }
    }
//metodi set

    public void getCategoriamontaggio()
    {
        System.out.println("I SERVIZI DI CATEGORIA MONTAGGIO SONO:");
        for (int i = 0; i < servizimontaggio.size(); i++)
        {
            System.out.println(servizimontaggio.get(i));
        }
    }

    public void getCostimontaggio()
    {
        System.out.println("I COSTI DEI SERVIZI DI MONTAGGIO SONO:");
        for (int i = 0; i < prezzimontaggio.size(); i++)
        {
            System.out.println(prezzimontaggio.get(i));
        }
    }

    public boolean controllomontaggio(String controll)
    {
        boolean ok;
        ok = false;
        for (int i = 0; i < servizimontaggio.size(); i++)
        {
            if (controll.equals(servizimontaggio.get(i)))
            {
                ok = true;
            }
        }
        return ok;
    }

    public boolean controllotrasporto(String controll)
    {
        boolean ok;
        ok = false;
        for (int i = 0; i < servizitrasporto.size(); i++)
        {
            if (controll.equals(servizitrasporto.get(i)))
            {
                ok = true;
            }
        }
        return ok;
    }

    public void removetrasporto(String remove)
    {
        for (int i = 0; i < servizitrasporto.size(); i++)
        {
            if (remove.equals(servizitrasporto.get(i)))
            {
                servizitrasporto.remove(i);
                prezzitrasporto.remove(i);
            }
        }
    }

    public void removemontaggio(String remove)
    {
        for (int i = 0; i < servizimontaggio.size(); i++)
        {
            if (remove.equals(servizimontaggio.get(i)))
            {
                servizimontaggio.remove(i);
                prezzimontaggio.remove(i);
            }
        }
    }

    public void modifymontag(String inputmont, String montmod, double prezzomod)
    {
        for (int i = 0; i < servizimontaggio.size(); i++)
        {
            if (inputmont.equals(servizimontaggio.get(i)))
            {
                servizimontaggio.set(i, montmod);
                prezzimontaggio.set(i, prezzomod);
            }
        }
    }

    public void modifytraspor(String inputtras, String trasmod, double prezzotr)
    {
        for (int i = 0; i < servizitrasporto.size(); i++)
        {
            if (inputtras.equals(servizitrasporto.get(i)))
            {
                servizitrasporto.set(i, trasmod);
                prezzimontaggio.set(i, prezzotr);
            }
        }
    }
}