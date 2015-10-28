package sample;

/**
 * Created by JJCD on 30/09/15.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Índice Calinski-Harabasz");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 890, 496));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
