package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    public AnchorPane pane;
    public Button btnEncrypt;
    public Button btnDecrypt;
    public Label lblFilePath;
    public TextFlow txtFileContent;
    public TextField fieldKey;

    public void decryptFile(ActionEvent event) {
        Cipher cipher=new Cipher();
        System.out.println(cipher.decryption(fieldKey.getText(),lblFilePath.getText()));
    }

    public void encryptFile(ActionEvent event) {

        Cipher cipher=new Cipher();
        System.out.println(cipher.encryption(fieldKey.getText(), lblFilePath.getText()));

    }
}
