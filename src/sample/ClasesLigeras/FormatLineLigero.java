package sample.ClasesLigeras;

import java.util.Arrays;

/**
 * Created by JuanJose on 031 31 10 2015.
 */
public class FormatLineLigero
{
    private String[] dominioClase;

    public FormatLineLigero()
    {
    }

    public String[] getDominioClase()
    {
        return dominioClase;
    }

    public void crearDominioClase (String clase)
    {
        String[] dominioRaw=clase.split("\\{");
        String aux=dominioRaw[1];
        aux=aux.substring(0,aux.length()-1);
        dominioRaw=aux.split("\\,");

        dominioClase=new String[dominioRaw.length];

        for (int i=0; i<dominioRaw.length; i++)
        {
            dominioClase[i]=dominioRaw[i].trim();
        }

    }

    public String[] formatObjeto(String line, boolean ID, int num)
    {

        String[] objetoRaw=line.split(",");
        String[] objetoListo;
        String auxClase;

        for (int i=0; i<objetoRaw.length; i++)
        {
            objetoRaw[i]=objetoRaw[i].trim();
        }

        if(ID)
        {
            objetoListo=new String[objetoRaw.length-2];
            for (int i=0; i<objetoListo.length; i++)
            {
                objetoListo[i]=objetoRaw[i+1];
            }
        }
        else
        {
            objetoListo=new String[objetoRaw.length-1];
            for (int i=0; i<objetoListo.length; i++)
            {
                objetoListo[i]=objetoRaw[i];
            }
        }

        auxClase=objetoRaw[objetoRaw.length-1];
        if(!auxClase.equals("?"))
        {
            for (int i = 0; i < dominioClase.length; i++)
            {
                String[]auxDominio=dominioClase[i].split(",");
                if (auxDominio[0].equals(auxClase))
                {
                    dominioClase[i] += "," + num;
                }
            }
        }
        else
        {
            objetoListo=null;
        }

        return objetoListo;
    }

    public String[] formatDominio(String line,int num)
    {
        String[] dominioRaw=line.split("\\{");
        String aux=dominioRaw[1];
        dominioRaw=aux.split("\\}");
        aux=dominioRaw[0];
        //dominioRaw=aux.split(",");
        //aux=aux.substring(0,aux.length()-1);
        dominioRaw=aux.split("\\,");

        String[] dominioListo=new String[dominioRaw.length+1];
        dominioListo[0]=""+num;

        for (int i=0; i<dominioRaw.length; i++)
        {
            dominioListo[i+1]=dominioRaw[i].trim();
        }

        //System.out.println(Arrays.toString(dominioListo));

        return dominioListo;
    }

}
