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
        Cipher cipher = new Cipher();

        String string = "Kalendar";
        String keyword = "KNIX";

        String key = cipher.generateKey(string, keyword);
        String ciphered_text = cipher.cipherText(string, key);

        System.out.println(ciphered_text);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
