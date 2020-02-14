package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFile {
    private String source;

    public MyFile(String source) {
        this.source = source;
    }

    public String readFile(String sourceFile) {
            String data = "";
            try {
                File myFile = new File(sourceFile);
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return data;
        }

        public void writeToFile(String sourceFile, String file) throws IOException {
            try {
                File newFile = new File(file);
                FileWriter fw = new FileWriter(newFile);
                fw.write(readFile(sourceFile));
                fw.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
