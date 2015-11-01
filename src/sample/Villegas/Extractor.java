package sample.Villegas;

/**
 * Created by v on 31/10/15.
 */

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Extractor {
    //carga archivo
    private File archivo;
    //ller archivo
    private BufferedReader lector;
    //escoger archivo
    private JFileChooser chooser;
    //detalles de archivo
    private FileNameExtensionFilter filter;
    int returnVal;
    int atributos;

    public Extractor() {
        this.archivo = null;
        this.lector=null;
        this.chooser = new JFileChooser("/home/v/Documentos/weka-3-6-13/data");
        this.filter = new FileNameExtensionFilter("Archivos ARFF de Weka", "arff");
        this.chooser.setFileFilter(filter);
        this.atributos = 0;
    }

    public void CargarArchivo(Component parent) throws FileNotFoundException, IOException{
        this.returnVal = chooser.showOpenDialog(parent);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            archivo = chooser.getSelectedFile();
            lector = new BufferedReader(new FileReader(archivo));
            String text = null;
            String comentarios = null;
            String dataSet = null;
            String atributosNoCat = null;
            String atributosCat = null;
            String dominioAC =  null;
            while ((text = lector.readLine()) != null) {

                if((!text.trim().matches("(%|@).*")) && !(text.trim().equals(""))) {
                    if(dataSet==null){
                        dataSet = text + "\n";
                    }else{
                        dataSet += text + "\n";
                    }
                }else{

                    //Comentarios
                    if(text.matches("%+.*")){
                        //System.out.println("Comentario: ");
                        //System.out.println(text.substring(1));
                        if(comentarios==null){
                            comentarios = text.substring(1)+"\n";
                        }else {
                            comentarios += text.substring(1) + "\n";
                        }
                    }

                    //Relation
                    if(text.matches("@(relation|RELATION) +.*")){
                        String sLine;
                        sLine=(text.substring(10)).trim();

                        if(sLine.startsWith("'"))
                            sLine=sLine.substring(1,sLine.length()-1);

                        System.out.println("Relation: "+ sLine);
                    }

                    //Atributos categoricos y no categoricos
                    //categoricos
                    if(text.matches("@(attribute|ATTRIBUTE)+.*\\{+.*\\}")){
                        /*if(atributosCat==null){
                            String[] aux = text.split(" ");
                            String[] aux2 = text.split("\\{");
                            atributosCat = aux[1]+"\n";
                            aux2[1] = aux2[1].replaceAll("\\s","");
                            aux2[1]= aux2[1].substring(0, aux2[1].length()-1);
                            dominioAC = aux2[1] + "\n";
                        }else {
                            String[] aux = text.split(" ");
                            String[] aux2 = text.split("\\{");
                            atributosCat += aux[1]+"\n";
                            aux2[1] = aux2[1].replaceAll("\\s","");
                            aux2[1]= aux2[1].substring(0, aux2[1].length()-1);
                            dominioAC += aux2[1] + "\n";
                            //dominioAC += aux2[1].replaceAll("\\s","") + "\n";
                        }*/

                        String [] sLine = new String [3];
                        Boolean subString = false;
                        Boolean domain = false;
                        int i=0;
                        int sCount=0;
                        do{
                            if (text.charAt(i)=='\'')
                            {
                                subString=!subString;
                            }

                            if (text.charAt(i)=='{')
                            {
                                domain=true;
                            }

                            if (text.charAt(i)=='}')
                            {
                                domain=false;
                            }

                            if((text.charAt(i)==' '||text.charAt(i)=='\t')&& subString!=true && domain!=true && sCount<3)
                            {
                                if((text.charAt(i+1)!=' ')&&(text.charAt(i+1)!='\t'))
                                {
                                    sLine[sCount]=text.substring(0, i);
                                    char charLast = text.charAt(text.length() - 1);
                                    text=text.substring(i+1, text.length()-1);
                                    text+=charLast;
                                    sCount++;
                                    i=-1;
                                }
                            }
                            i++;
                        }while(i<text.length());

                        sLine[0]=sLine[1];
                        sLine[1]="Categorico";
                        sLine[2]=text;

                        for(i=0;i<sLine.length;i++)
                        {
                            sLine[i]=sLine[i].trim();
                        }

                        if(atributosCat == null){
                            //atributosCat = sLine[0] + " " + sLine[1] + " " + sLine[2] + "\n";
                            atributosCat = atributos + " " + sLine[0] + " " + sLine[1] + "\n";
                            //dominioAC = sLine[2] + "\n";
                            sLine[2] = sLine[2].substring(1    , sLine[2].length()-1) + "\n";
                            dominioAC = atributos + " " + sLine[2].replaceAll("\\s", "") + "\n";
                            atributos++;
                        }else{
                            //atributosCat += sLine[0] + " " + sLine[1] + " " + sLine[2] + "\n";
                            atributosCat += atributos + " " + sLine[0] + " " + sLine[1] +"\n";
                            //dominioAC += sLine[2] + "\n";
                            sLine[2] = sLine[2].substring(1    , sLine[2].length()-1) + "\n";
                            dominioAC += atributos + " " + sLine[2].replaceAll("\\s", "") + "\n";
                            atributos++;
                        }

                        }else{
                            //atributos no categoricos
                            if(text.matches("@(attribute|ATTRIBUTE)+.*")){
                                String [] sLine = new String [3];
                                Boolean subString = false;
                                int i=0;
                                int sCount=0;
                                do{
                                    if (text.charAt(i)=='\'')
                                    {
                                        subString=!subString;
                                    }

                                    if((text.charAt(i)==' '||text.charAt(i)=='\t')&& subString!=true)
                                    {
                                        if((text.charAt(i+1)!=' ')&&(text.charAt(i+1)!='\t')&&(sCount<3))
                                        {
                                            sLine[sCount]=text.substring(0, i);
                                            text=text.substring(i + 1, text.length());
                                            sCount++;
                                            i=-1;
                                        }
                                    }
                                    i++;
                                }while(i<text.length()-1);

                                sLine[0]=sLine[1];
                                sLine[1]=text;
                                sLine[2]="Propio del tipo";

                                for(i=0;i<sLine.length;i++)
                                {
                                    sLine[i]=sLine[i].trim();
                                }
                                if(atributosNoCat == null){
                                    atributosNoCat = atributos + " " + sLine[0] + " " + sLine[1] + " " + sLine[2] + "\n";
                                    atributos++;
                                }else{
                                    atributosNoCat += atributos + " " + sLine[0] + " " + sLine[1] + " " + sLine[2] + "\n";
                                    atributos++;
                                }
                            }
                        }
                }
            }

            if(comentarios != null){
                System.out.println("Comentarios: ");
                System.out.println(comentarios);
            }


            if(atributosNoCat != null){
                System.out.println("Atributos no categoricos: ");
                System.out.println(atributosNoCat);
            }


            if(atributosCat != null){
                System.out.println("Atributos categoricos: ");
                System.out.println(atributosCat);
                System.out.println("Dominios Atributos categoricos: ");
                System.out.println(dominioAC);
            }

            if(dataSet != null){
                System.out.println("DataSet: ");
                System.out.println(dataSet.split("\n").length);
            }

            System.out.println("Finalizo lectura");
        }
    }
}
