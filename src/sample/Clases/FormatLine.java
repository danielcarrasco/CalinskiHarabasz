package sample.Clases;

import java.util.ArrayList;

/**
 *Esta es una clase que se encarga de tomar una cadena de el archivo y
 * formatearla para ser mas manejable en futuros usos
 * @author JuanJose
 */
public class FormatLine {

    /**
     *Constructor de la clase, no hace nada en especial
     */
    public FormatLine(){}

    /**
     *formatAttribueCategorical recibe una cadena identificada como la
     * declaracion de un atributo categorico y la prepara para su uso
     * @param line
     * @return
     */
    public String[] formatAttributeCategorical(String line)
    {
        String [] sLine = new String [3];
        Boolean subString = false;
        Boolean domain = false;
        int i=0;
        int sCount=0;
        do{
            if (line.charAt(i)=='\'')
            {
                subString=!subString;
            }

            if (line.charAt(i)=='{')
            {
                domain=true;
            }

            if (line.charAt(i)=='}')
            {
                domain=false;
            }

            if((line.charAt(i)==' '||line.charAt(i)=='\t')&& subString!=true && domain!=true && sCount<3)
            {
                if((line.charAt(i+1)!=' ')&&(line.charAt(i+1)!='\t'))
                {
                    sLine[sCount]=line.substring(0, i);
                    char charLast = line.charAt(line.length() - 1);
                    line=line.substring(i+1, line.length()-1);
                    line+=charLast;
                    sCount++;
                    i=-1;
                }
            }
            i++;
        }while(i<line.length());

        sLine[0]=sLine[1];
        sLine[1]="Categorico";
        sLine[2]=line;

        for(i=0;i<sLine.length;i++)
        {
            sLine[i]=sLine[i].trim();
        }

        return sLine;
    }

    /**
     *formatAttribute recibe una cadena identificada como la declaracion de un
     * atributo no categorico y la prepara para su uso
     * @param line
     * @return
     */
    public String[] formatAttribute(String line)
    {
        String [] sLine = new String [3];
        Boolean subString = false;
        int i=0;
        int sCount=0;
        do{
            if (line.charAt(i)=='\'')
            {
                subString=!subString;
            }

            if((line.charAt(i)==' '||line.charAt(i)=='\t')&& subString!=true)
            {
                if((line.charAt(i+1)!=' ')&&(line.charAt(i+1)!='\t')&&(sCount<3))
                {
                    sLine[sCount]=line.substring(0, i);
                    line=line.substring(i+1, line.length());
                    sCount++;
                    i=-1;
                }
            }
            i++;
        }while(i<line.length()-1);

        sLine[0]=sLine[1];
        sLine[1]=line;
        sLine[2]="Propio del tipo";

        for(i=0;i<sLine.length;i++)
        {
            sLine[i]=sLine[i].trim();
        }

        return sLine;
    }

    /**
     * formatComent recibe una cadena identificada como comentario y le da el
     * formato para su visualizacion
     * @param line
     * @return
     */
    public String formatComment(String line)
    {
        String sLine;

        sLine="\n"+(line.substring(1));
        return sLine;
    }

    /**
     *formatRelation recibe una cadena identificada como la declaracion del
     * atributo relation y le da formato para su visualizacion
     * @param line
     * @return
     */
    public String formatRelation(String line)
    {
        String sLine;

        sLine=(line.substring(10)).trim();

        if(sLine.startsWith("'"))
            sLine=sLine.substring(1,sLine.length()-1);

        return sLine;
    }

    /**
     *formatData recibe una cadena de valores identificada como los datos de un
     * registro y la prepara para su uso posterior
     * @param line
     * @param ID
     * @return
     */
    public ArrayList <String> formatData(String line, Boolean ID)
    {
        String [] sLine;
        ArrayList <String> registro= new ArrayList<>();

        sLine=line.split(",");

        for (int i=0;i<sLine.length;i++)
        {
            registro.add(i,sLine[i].trim());
        }

        if(ID)
        {
            registro.remove(0);
        }

        return registro;
    }
}
