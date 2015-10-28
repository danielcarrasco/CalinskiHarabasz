package sample.Clases;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import sample.Controller;
import sample.Registro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *Esta clase nos permite trabajar directamente con el archivo
 * @author JuanJose
 */
public class Extractor {
    private File archivo;
    private BufferedReader lector;
    private FileChooser chooser;
    int reg,atr;
    private ArrayList registros;
    ObservableList<Registro> model; //Observer de TableView

    private FormatLine fLinea;
    private FormatFile fArchivo;
    private Boolean ID;
    private Cluster implementacion;

    /**
     *Inicializar valores
     */
    public Extractor()
    {
        this.archivo = null;
        this.lector=null;
        this.chooser = new FileChooser();
        this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos ARFF de Weka", "*.arff"));
        this.reg=0;
        this.atr=0;
        this.model = FXCollections.observableArrayList();
        this.fLinea=new FormatLine();
        this.fArchivo= new FormatFile();
        this.registros=new ArrayList<List<String>>();
        this.ID=false;
        this.implementacion=new Cluster();
    }

    /**
     * Busqueda del archivo y obtencion de sus principales secciones
     * @param parent
     */
    public FormatFile exatraer(Controller parent){

        try {
            archivo = chooser.showOpenDialog(parent);

            if(!archivo.equals(null))
            {

                //Extraer ruta del archivo
                fArchivo.setRuta(archivo.getPath());
                //Extraer nombre del archivo
                fArchivo.setNombre(archivo.getName());
                lector = new BufferedReader(new FileReader(archivo));
                String text;
                implementacion.Cluster();

                while ((text = lector.readLine()) != null)
                {
                    //extraer comentarios del archivo
                    if(text.matches("%+.*"))
                        fArchivo.setComentarios(fLinea.formatComment(text));
                    //extraer atributo relation
                    if(text.matches("@(relation|RELATION) +.*"))
                        fArchivo.setRelacion(fLinea.formatRelation(text));


                    //Identificar si se tiene un atributo ID
                    if(text.matches("@attribute Instance_number numeric+.*"))
                    {
                        ID=true;
                        fArchivo.getCluster().idDetected(text);
                    }else
                    {
                        //extraer datos de atributos categoricos
                        if(text.matches("@(attribute|ATTRIBUTE)+.*\\{+.*\\}"))
                        {
                            String row []=fLinea.formatAttributeCategorical(text);
                            model.add(new Registro(row[0], row[1], row[2]));
                            fArchivo.getCluster().setClusterCategorico(true);
                            fArchivo.getCluster().addDominio(text, atr);
                            atr++;
                        }else
                        {
                            //extraer datos de atributos no categoricos
                            if(text.matches("@(attribute|ATTRIBUTE)+.*"))
                            {
                                String row []=fLinea.formatAttribute(text);
                                fArchivo.getCluster().setClusterCategorico(false);
                                model.add(new Registro(row[0], row[1], row[2]));
                                atr++;
                            }
                        }
                    }

                    //extraer los registros
                    if((!text.trim().matches("(%|@).*")) && !(text.trim().equals(""))){
                        registros.add(reg, fLinea.formatData(text,ID));
                        reg++;
                    }
                }

            }
            model.remove(model.size()-1);
            fArchivo.setAtributos(model);
            fArchivo.getCluster().setNumAtributos(atr-1);
            fArchivo.getCluster().setNumRegistros(reg);
            fArchivo.getCluster().setRegistros(registros);
            fArchivo.getCluster().DominioAtributoRemoveCluster();
            fArchivo.getCluster().setRelacionRegistroCluster();
            fArchivo.getCluster().getRelacionDominioAtributo();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (lector != null)
                {
                    lector.close();
                }
            } catch (IOException e)
            {
            }
        }

        return fArchivo;

    }

}

