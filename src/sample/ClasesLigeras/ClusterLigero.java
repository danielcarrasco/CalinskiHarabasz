package sample.ClasesLigeras;

import java.util.Arrays;

/**
 * Created by JuanJose on 031 31 10 2015.
 */
public class ClusterLigero
{
    private String [][] objetos;
    private String [][] RelacionObjetoClase;
    private String [][] RelacionAtributoDominio;
    private boolean     clusterCategorico;
    private boolean     idFlag;
    private int         totalAtributos;
    private int         totalObjetos;
    private String Ruta;
    private String Nombre;

    public ClusterLigero(int nObjetos,int nAtributos)
    {
        this.objetos = new String[nObjetos][nAtributos];
        RelacionObjetoClase = null;
        RelacionAtributoDominio = null;
        this.totalAtributos = nAtributos;
        this.totalObjetos = nObjetos;
        this.idFlag = false;
        this.clusterCategorico = false;
    }

    public String[][] getObjetos()
    {
        return objetos;
    }

    public void setObjetos(String[][] objetos)
    {
        this.objetos = objetos;
    }

    public void setClusterCategorico(boolean clusterCategorico)
    {
        this.clusterCategorico = clusterCategorico;
    }

    public void setIdFlag(boolean idFlag)
    {
        this.idFlag = idFlag;
    }

    public void setTotalAtributos(int totalAtributos)
    {
        this.totalAtributos = totalAtributos;
    }

    public void setTotalObjetos(int totalObjetos)
    {
        this.totalObjetos = totalObjetos;
    }

    public void setDominioClase(String []dominioClase)
    {
        RelacionObjetoClase= new String[dominioClase.length][];
        for (int i=0; i<dominioClase.length;i++)
        {
            RelacionObjetoClase[i]=dominioClase[i].split(",");
        }
    }

    public String[][] getRelacionAtributoDominio()
    {

        return RelacionAtributoDominio;
    }

    public void setRelacionAtributoDominio(String[][] relacionAtributoDominio)
    {
        RelacionAtributoDominio = relacionAtributoDominio;
    }

    public void mostrarCluster()
    {
        System.out.println("Transformacion terminada - Resultados:");
        System.out.println("Numero de Atributos (sin contar clase ni ID):"+totalAtributos);
        System.out.println("Numero de objetos procesados: "+totalObjetos);
        System.out.println("Clase categorica: "+clusterCategorico);
        System.out.println("ID detectado: "+idFlag);

        System.out.println("Atributos detectados:");
        for (int i=0;i<RelacionAtributoDominio.length; i++)
        {
            System.out.println(Arrays.toString(RelacionAtributoDominio[i]));
        }
        System.out.println("Rlacion objeto-clase:");
        for (int i=0;i<RelacionObjetoClase.length; i++)
        {
            System.out.println(Arrays.toString(RelacionObjetoClase[i]));
        }
        System.out.println("Objetos detectados:");
        for (int i=0;i<objetos.length; i++)
        {
            System.out.println(Arrays.toString(objetos[i]));
        }
    }

    public int getTotalAtributos() {
        return totalAtributos;
    }

    public int getTotalObjetos() {
        return totalObjetos;
    }

    public String[][] getRelacionObjetoClase() {
        return RelacionObjetoClase;
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRuta() {
        return Ruta;
    }

    public String getNombre() {
        return Nombre;
    }
}
