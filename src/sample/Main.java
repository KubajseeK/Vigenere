package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        MyFile myFile = new MyFile();
        myFile.writeToFile("data.txt", "data_encrypt.txt");
        System.out.println(Cipher.encrypt("Piatok je 15820", "ABCDE"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
