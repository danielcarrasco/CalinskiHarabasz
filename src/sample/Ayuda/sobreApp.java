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



public class sobreApp extends Application{

    Stage window = new Stage();

    public static void main(String [] args){

        launch(args);

    }


    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Sobre la Aplicación");

        File file = new File("src/sample/img/sobreApp.png");
        Image image = new Image(file.toURI().toString());
        ImageView img_app = new ImageView();
        img_app.setImage(image);
        img_app.setFitHeight(222);
        img_app.setFitWidth(400);

        VBox vbox = new VBox(img_app);
        Scene scene = new Scene(vbox, 400, 222);
        window.setScene(scene);
        window.show();

    }

}
