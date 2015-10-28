package sample.Clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *La clase Cluster contiene todos los elementos formateados y listos para la
 * malipulacion de los registros analizados
 * @author JuanJose
 */
public class Cluster {
    private ArrayList<ArrayList> registros;
    private ArrayList<ArrayList> relacionRegistroCluster;
    private ArrayList relacionDominioAtributo;
    private FormatLine fl;
    private int totalAtributos;
    private int totalRegistros;
    private int a;
    private boolean idFlag;
    private boolean clusterCategorico;
    private String idField;

    /**
     *Inicializa valores indispensables para el funcionamiento de la clase
     */
    public void Cluster()
    {
        this.registros=new ArrayList<>();
        this.relacionDominioAtributo=new ArrayList<>();
        this.relacionRegistroCluster=new ArrayList<>();
        this.fl= new FormatLine();
        this.a=0;
        totalAtributos=0;
        totalRegistros=0;
        idFlag=false;
    }

    /**
     *Esta funcion debe de ser invocada para indicar al Cluster que se cuenta
     * con un atributo ID que sera trado de forma especial
     * @param id
     */
    public void idDetected(String id)
    {
        idFlag=true;
        idField=id;
    }

    /**
     *Si se ha detectado un ID se puede obtener la declaracion de dicho atributo
     * por medio de esta clase
     * @return
     */
    public String getID()
    {
        return idFlag?idField:"Sin campo de ID";
    }

    /**
     *Permite agregar uno por uno los atributos nominales y sus dominios para su
     * uso en la discretizacion de datos de ser necesaria
     * @param line
     * @param num
     */
    public void addDominio(String line,int num)
    {
        fl=new FormatLine();

        ArrayList<String> dominioFormato=new ArrayList<>();
        String dominio=fl.formatAttributeCategorical(line)[2];
        dominio=dominio.substring(1, dominio.length()-1);
        String[] elementoDominio=dominio.split(",");

        dominioFormato.add(""+num);

        for(int i=0; i<elementoDominio.length;i++)
        {
            dominioFormato.add(elementoDominio[i].trim());
        }

        relacionDominioAtributo.add(a, dominioFormato.clone());
        a++;
    }

    public void setRelacionDominioAtributo(ArrayList<List<String>> relacionDominioAtributoEntrante)
    {
        relacionDominioAtributo= (ArrayList) relacionDominioAtributoEntrante.clone();
    }

    /**
     *Regresa un objeto ArrayList<ArayList<String>> con la relacion de los
     * atributos categoricos con sus dominios
     * @return
     */
    public ArrayList<ArrayList<String>> getRelacionDominioAtributo()
    {
        return (ArrayList<ArrayList<String>>) relacionDominioAtributo.clone();

    }

    public void setClusterCategorico(Boolean v)
    {
        clusterCategorico=v;
    }

    /**
     *Cuando se termina de añadir el ultimo atributo es necesario invocar este
     * metodo para eliminar el atriduto Cluster de la estructura de atributos en
     * caso de ser detectado
     */
    public void DominioAtributoRemoveCluster()
    {
        if (clusterCategorico)
        {
            relacionDominioAtributo.remove(relacionDominioAtributo.size()-1);
        }
    }

    /**
     *Analiza los registros obtenidos y su atributo cluster para generar un
     * listado de los elementos que pertenecen a cada cluster
     */
    public void setRelacionRegistroCluster()
    {
        ArrayList<String> auxRegistro;
        ArrayList<String> auxRelacion;
        Boolean find=false;
        int reg=0;

        Iterator itRegistros=registros.iterator();
        while (itRegistros.hasNext())
        {
            auxRegistro = (ArrayList<String>) itRegistros.next();
            String registroCluster = auxRegistro.get(auxRegistro.size()-1);
            Iterator itRelacion=relacionRegistroCluster.iterator();
            while (itRelacion.hasNext())
            {
                auxRelacion=(ArrayList<String>) itRelacion.next();
                if(auxRelacion.get(0).equals(registroCluster))
                {
                    auxRelacion.add(reg+"");
                    find=true;
                }
            }
            if(!find)
            {
                ArrayList <String> nuevoCluster=new ArrayList<>();
                nuevoCluster.add(registroCluster);
                nuevoCluster.add(reg+"");
                relacionRegistroCluster.add((ArrayList) nuevoCluster.clone());
            }
            reg++;
            find=false;
            auxRegistro.remove(auxRegistro.size()-1);
        }

    }



    /**
     *Recibe el objeto con la informacion de los registros del archivo
     * @param registrosEntrantes
     */
    public void setRegistros(ArrayList<List<String>> registrosEntrantes)
    {
        registros= (ArrayList<ArrayList>) registrosEntrantes.clone();
    }

    /**
     *Regresa el apuntador al objeto con la informacion de los registros
     * analizados
     * @return
     */
    public ArrayList<ArrayList> getRegistros()
    {
        return registros;
    }

    /**
     *Regresa el objeto con la relacion entre las distintas particiones del
     * cluster y los registros que caen en ellas
     * @return
     */
    public ArrayList<ArrayList> getRelacionRegistroCluster()
    {
        return relacionRegistroCluster;
    }

    /**
     *Una vez modificado contadoss los atributos esta funcion permite integrar
     * el total de ellos al cluster
     * @param nAtributosEntrante
     */
    public void setNumAtributos(int nAtributosEntrante) {
        totalAtributos=nAtributosEntrante;
    }

    /**
     *Regresa el valor de toral de atributos previamente insertado
     * @return
     */
    public int getNumTotalAtributos() {
        return totalAtributos;
    }

    /**
     *Permite ingresar el numero de registros del archivo analizado
     * @param nRegistrosEntrante
     */
    public void setNumRegistros(int nRegistrosEntrante) {
        totalRegistros=nRegistrosEntrante;
    }

    /**
     *Reggresa el total de registros previemente indicado
     * @return
     */
    public int getNumRegistros() {
        return totalRegistros;
    }

    public String getClusterInfo()
    {
        String info;

        info ="\n\tCampo id detectado: \n\t\t"+getID();
        info+="\n------------------------------\n\tGrupos del cluster detectados :";

        Iterator it=relacionRegistroCluster.iterator();
        ArrayList<String> aux;
        while (it.hasNext())
        {
            aux=(ArrayList<String>) it.next();
            info+="\n\tRegistros mienbros del grupo "+aux.get(0)+":\n\t\t[";
            for (int i=1;i<aux.size();i++)
            {
                info+=" "+aux.get(i);
            }
            info+=" ]";
        }

        info+="\n------------------------------\n\tAtributos categoricos detectados :";
        it=relacionDominioAtributo.iterator();
        while (it.hasNext())
        {
            aux=(ArrayList<String>) it.next();
            info+="\n\tDominio del atributo numero "+aux.get(0)+":\n\t\t[";
            for (int i=1;i<aux.size();i++)
            {
                info+=" "+aux.get(i);
            }
            info+=" ]";
        }

        return info;
    }


}