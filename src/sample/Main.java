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
        primaryStage.setTitle("Vigenere Cipher");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();

        MyFile myFile = new MyFile("src/data.txt", "src");

        System.out.println(new Cipher().encryption("src/data.txt", "Zebra"));
        System.out.println(new Cipher().decryption("Zebra", "src/data_encrypt.txt"));


    }

    public static void main(String[] args) {
        launch(args);
    }
}
