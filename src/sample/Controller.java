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
import javax.swing.*;

public class Controller {

    public AnchorPane pane;
    public Button btnEncrypt;
    public Button btnDecrypt;
    public Label lblFilePath;
    public TextFlow txtFileContent;
    public TextField fieldKey;

    public void openFileChooser(){ //copied, mine was bugging

        JFileChooser fileChooser = new JFileChooser("C:\\Users\\ledgo\\IdeaProjects\\VigenerCipher\\src\\sample");
        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getParent());
            System.out.println(selectedFile.getName());
            lblFilePath.setText(selectedFile.getAbsolutePath());

            ReadFile readed = new ReadFile(selectedFile.getParent(),selectedFile.getAbsolutePath());
            String message=readed.loadFile(selectedFile.getAbsolutePath());

            System.out.println("________PLAIN TEXT________");
            System.out.println(message);
            System.out.println("__________CIPHER__________");
            //System.out.println(cipher.encrypt(selectedFile.getAbsolutePath(),"data"));

        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }

    public void decryptFile(ActionEvent event) {
        Cipher cipher=new Cipher();
        System.out.println(cipher.decryption(fieldKey.getText(),lblFilePath.getText()));
    }

    public void encryptFile(ActionEvent event) {

        Cipher cipher=new Cipher();
        System.out.println(cipher.encryption(fieldKey.getText(), lblFilePath.getText()));

    }
}
