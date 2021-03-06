package sample;

/**
 * Created by JJCD on 30/09/15.
 */

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import sample.Ayuda.creditos;
import sample.Ayuda.sobreApp;
import sample.Clases.*;
import sample.algoritmoCalinskiHarabaz.CalcularAlgoritmoCH;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;


public class Controller extends Window implements Initializable{

    public TextField txt0;
    public TextField txt1;
    public TextField txt2;
    public TextField txt3;
    public TextField txt4;
    public TextArea txtArea0;
    public TextArea txtArea1;
    public TextArea txtArea2;
    public TableView<Registro> tb;
    public TableColumn<Registro, String> tb_nombre;
    public TableColumn<Registro, String> tb_tipo;
    public TableColumn<Registro, String> tb_dominio;
    public ImageView img_escudo;
    public ChoiceBox<String> choice;
    public Button btn_aplicar;
    public Button btn_borrar;
    public Tab tab_coment;
    public Tab tab_registros;
    public Tab tab_cluster;
    public Label lbl0;
    public Label lbl1;
    public FormatFile formato;
    public Integer val;




    public void controllerC(){

        txt0.clear();
        txt1.clear();
        txt2.clear();
        txt3.clear();
        txt4.clear();
        txtArea1.clear();
        txtArea0.clear();
        txtArea2.clear();
        formato = null;
        lbl1.setText("");
        lbl0.setVisible(false);
        lbl1.setVisible(false);
        val = 0;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("src/sample/img/uaeh.png");
        Image image = new Image(file.toURI().toString());
        img_escudo.setImage(image);
    }

    public void cargarButton(){


        controllerC();

        tb_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tb_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tb_dominio.setCellValueFactory(new PropertyValueFactory<>("dominio"));


        Extractor archivo=new Extractor();


        formato=archivo.exatraer(this);

        if(formato!=null){
            txtArea2.setText("");

            txt0.setText(formato.getRuta());
            txt1.setText(formato.getNombre());
            txt2.setText(formato.getRelacion());
            txt3.setText(""+formato.getCluster().getNumTotalAtributos());
            txt4.setText(""+formato.getCluster().getNumRegistros());
            tb.setItems(formato.getAtributos());
            txtArea0.setText(formato.getComentarios());

            Iterator it=formato.getCluster().getRegistros().iterator();
            while(it.hasNext())
                txtArea1.appendText(it.next() + "\n");

            txtArea2.setText(formato.getCluster().getClusterInfo());

            //Activar boton Aplicar indice
            btn_aplicar.setDisable(false);
            btn_borrar.setDisable(false);

            //Activar choiceBox
            choice.setDisable(false);
            choice.getItems().add("Índice Calinski-Harabasz");
            choice.setValue("Índice Calinski-Harabasz");
            //Activar pestañas
            tab_registros.setDisable(false);
            tab_coment.setDisable(false);
            tab_cluster.setDisable(false);


        }

    }

    public void aplicarIndice(){

        Normalizar registrosN= new Normalizar();

        CalcularAlgoritmoCH resultadoFinal=new CalcularAlgoritmoCH();
        Double resultado;

        resultado = resultadoFinal.calcularAlgoritmo(registrosN.Discretizar(formato.getCluster().getRegistros(),formato.getCluster().getRelacionDominioAtributo()), formato.getCluster().getRelacionRegistroCluster(), val);
        val = 1;
        lbl1.setText(resultado+"");
        lbl0.setVisible(true);
        lbl1.setVisible(true);
    }
    public void borrar(){
        BorrarRegistro rrt = new BorrarRegistro();
        int x=tb.getSelectionModel().getFocusedIndex();


        formato.getCluster().setRegistros(rrt.elimnarAtributo(x, formato.getCluster().getRegistros()));
        if(formato.getCluster().getRelacionDominioAtributo().size()>0) {
            formato.getCluster().setRelacionDominioAtributo(rrt.elimnarDominio(x, formato.getCluster().getRelacionDominioAtributo()));
        }

        rrt.borrarTablaGrafica(tb);

    }

    public void creditos(){

        new creditos().start(new Stage());

    }

    public void aboutApp(){

        new sobreApp().start(new Stage());

    }

    public void cerrarApp(){

        System.exit(0);

    }

}
