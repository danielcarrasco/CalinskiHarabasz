package sample.Ayuda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by JJCD on 04/10/15.
 */



public class creditos extends Application{

    Stage window = new Stage();

    public static void main(String [] args){

        launch(args);

    }


    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Creditos");

        File file = new File("src/sample/img/creditos.png");
        Image image = new Image(file.toURI().toString());
        ImageView img_creditos = new ImageView();
        img_creditos.setImage(image);
        img_creditos.setFitHeight(300);
        img_creditos.setFitWidth(400);

        VBox vbox = new VBox(img_creditos);
        Scene scene = new Scene(vbox, 400, 300);
        window.setScene(scene);
        window.show();

    }

}
