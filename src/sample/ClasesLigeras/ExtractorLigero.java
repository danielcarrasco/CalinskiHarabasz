package sample.ClasesLigeras;

import javafx.stage.FileChooser;
import sample.Controller;

import java.io.*;

/**
 * Created by JuanJose on 031 31 10 2015.
 */
public class ExtractorLigero
{
    private File archivo;
    private BufferedReader lector;
    private FileChooser chooser;
    private int nObjteos;
    private int nAtributos;
    private int nCategoricos;
    private String [][] objetos;
    private String [][] dominios;
    private String clase;
    private FormatLineLigero fLinea;
    private boolean IDFlag;
    private boolean claseCategorica;
    private ClusterLigero cluster;

    public ExtractorLigero()
    {
        this.archivo=null;
        this.lector=null;
        this.chooser=new FileChooser();
        this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivo de Formato Atributo-Relacion","*.arff"));
        this.nObjteos=0;
        this.nAtributos=0;
        this.fLinea=new FormatLineLigero();
        this.IDFlag=false;
        this.claseCategorica=false;

    }

    private void dimencionar() throws IOException
    {

        lector=new BufferedReader(new FileReader(archivo));
        String text;

        while ((text=lector.readLine())!=null)
        {
            text=text.trim();
            if((!text.matches("(%|@).*")) && !(text.equals("")))
            {
                if(!text.endsWith("?"))
                {
                    nObjteos++;
                }
            }
            else
            {
                if (text.startsWith("@attribute") || text.startsWith("@ATTRIBUTE"))
                {
                    nAtributos++;
                    if(text.matches("@(attribute|ATTRIBUTE)+.*\\{+.*\\}+.*"))
                    {
                        nCategoricos++;
                        clase=text;
                        claseCategorica=true;
                    }
                    else
                    {
                        claseCategorica=false;
                    }
                }
            }
        }

    }

    public ClusterLigero extraer(Controller parent) throws IOException
    {
        archivo=chooser.showOpenDialog(parent);

        dimencionar();
        objetos =new String[nObjteos][];
        dominios=new String[nCategoricos][];
        fLinea.crearDominioClase(clase);


        cluster=new ClusterLigero(nObjteos,nAtributos);

        lector = new BufferedReader(new FileReader(archivo));
        String text;

        int contadorObjetos=0;
        int contadorAtributos=0;
        int contadorDominios=0;

        while((text=lector.readLine())!=null)
        {
            text=text.trim();
            if((!text.matches("(%|@).*")) && !(text.equals("")))
            {
                String[] aux=fLinea.formatObjeto(text,IDFlag,contadorObjetos);
                if (aux!=null)
                {
                    objetos[contadorObjetos]=aux;
                    contadorObjetos++;
                }
            }
            else
            {
                if(text.matches("@attribute Instance_number numeric+.*"))
                {
                    IDFlag=true;
                }
                else
                {
                    if(text.matches("@(attribute|ATTRIBUTE)+.*\\{+.*\\}+.*"))
                    {
                        dominios[contadorDominios]=fLinea.formatDominio(text,contadorAtributos);
                        contadorAtributos++;
                        contadorDominios++;
                    }
                    else
                    {
                        if(text.matches("@(attribute|ATTRIBUTE)+.*"))
                        {
                            contadorAtributos++;
                        }
                    }
                }
            }
        }
        cluster.setObjetos(objetos);
        cluster.setClusterCategorico(claseCategorica);
        cluster.setIdFlag(IDFlag);
        cluster.setRelacionAtributoDominio(dominios);
        cluster.setTotalAtributos(nAtributos);
        cluster.setTotalObjetos(nObjteos);
        cluster.setDominioClase(fLinea.getDominioClase());
        cluster.setRuta(archivo.getPath());
        cluster.setNombre(archivo.getName());

        return cluster;
    }


}
