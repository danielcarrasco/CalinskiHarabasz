package sample.Clases;


import javafx.collections.ObservableList;
import sample.Registro;

/**
 *Esta clase es la representacion del archivo .arff formateado y listo para su
 * manipulacion y visualizacion
 * @author JuanJose
 */
public class FormatFile {
    private String ruta;
    private String nombre;
    private String comentarios;
    private String relacion;
    private ObservableList<Registro> tAtributos;
    private Cluster datos;

    /**
     *Inicializa algunos valores indispensables para el funcinamiento de la
     * clase
     */
    public FormatFile()
    {
        datos=new Cluster();
        datos.Cluster();
    }


    /**
     *Recibe una cadena que representa la ruta del archivo analizado
     * @param rutaEntrante
     */
    public void setRuta(String rutaEntrante)
    {
        ruta=rutaEntrante;
    }

    /**
     *Recibe una cadena que representa el nombre del archivo analizado
     * @param nombreEntrante
     */
    public void setNombre(String nombreEntrante)
    {
        nombre=nombreEntrante;
    }

    /**
     *Recibe una linea que se anexara al conjunto de comentarios del archivo
     * analizado
     * @param comentarioEntrante
     */
    public void setComentarios(String comentarioEntrante)
    {
        comentarios+=comentarioEntrante;
    }

    /**
     *Recive al atributo relation del archivo analizado
     * @param relacionEntrante
     */
    public void setRelacion(String relacionEntrante)
    {
        relacion=relacionEntrante;
    }

    /**
     *Recibe un objeto con los atributos ya formateados para su poserior
     * plasmado en un objeto jTable
     * @param tablaEntrante
     */
    public void setAtributos(ObservableList<Registro> tablaEntrante)
    {
        tAtributos=tablaEntrante;
    }

    /**
     *Regresa la cadena previamente indicada como la ruta del archivo analizado
     * @return
     */
    public String getRuta()
    {
        return ruta;
    }

    /**
     *Regresa la cadena previamente indicadac como el nombre del archivo
     * analizado
     * @return
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     *Regresa los comentarios extraidos del archivo analizado
     * @return
     */
    public String getComentarios()
    {
        return comentarios;
    }

    /**
     *Regresa la cadena previamente indicada como el nombre del archivo
     * analizado
     * @return
     */
    public String getRelacion()
    {
        return relacion;
    }

    /**
     *Regresa los atributos del archivo analizado listos para ser plasmados en
     * un objeto jTable
     * @return
     */
    public ObservableList<Registro> getAtributos()
    {
        return tAtributos;
    }

    /**
     *Regresa el objeto cluster con todos los datos necesarios para su
     * operacion, por medio de esta clase puede ademas acceder a todos los
     * atributos y funciones publicas del objeto cluster
     * @return
     */
    public Cluster getCluster()
    {
        return datos;
    }
}
