package sample;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Cipher {
    public String encryption(String location, String key) { //copied mine wasn't working as assigned. You can see previous tries at the bottom of the class.

        StringBuilder sb = new StringBuilder();
        String cipherKey = key.toLowerCase();
        int keyPos = 0;

        if (cipherKey.charAt(keyPos) < 65) {
            return "Nope.";
        }

        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(location), StandardCharsets.UTF_8));
            int character;
            while ((character = read.read()) != -1) {

                if ((char) character >= 65 && (char) character <= 90) {
                    char keyletter = (char) (character + ((cipherKey.charAt(keyPos)) - 97));
                    if ((int) keyletter > 90) {
                        keyletter -= 26;
                    }
                    sb.append(keyletter);

                } else if ((char) character >= 97 && (char) character <= 122) {
                    char keyletter = (char) (character + ((cipherKey.charAt(keyPos)) - 97));
                    if ((int) keyletter > 122) {
                        keyletter -= 26;
                    }
                    sb.append(keyletter);

                } else if ((char) character == 32) {
                    sb.append((char) character);
                    keyPos--;
                }
                keyPos++;

                if (keyPos >= cipherKey.length()) {
                    keyPos = 0;
                }
            }
            read.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data_encrypt.txt"));
            bw.write(sb.toString());
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }



    public String decryption(String key, String location) {
        if (key.equals("")) {
            return "Please enter the password";
        }
        StringBuilder sb = new StringBuilder();
        String keyword = key.toLowerCase();
        int keyPos = 0;

        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(location), StandardCharsets.UTF_8));
            int character;
            while ((character = read.read()) != -1) {
                if (keyword.charAt(keyPos) < 97) {
                    return "Wrong input";
                }
                if ((char) character >= 65 && (char) character <= 90) {
                    char ch = (char) (character - ((keyword.charAt(keyPos)) - 97));
                    if ((int) ch < 65) {
                        ch += 26;
                    }
                    sb.append(ch);
                } else if ((char) character >= 97 && (char) character <= 122) {
                    char keyletter = (char) (character - ((keyword.charAt(keyPos)) - 97));
                    if ((int) keyletter < 97) {
                        keyletter += 26;
                    }
                    sb.append(keyletter);
                } else if ((char) character == 32) {
                    sb.append((char) character);
                    keyPos--;
                }
                keyPos++;
                if (keyPos >= keyword.length()) {
                    keyPos = 0;
                }
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data_decrypt.txt"));
            bw.write(sb.toString());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}

/*if (key.equals("")) {
            return "Enter key.";
        }

        String result = "";
        message = message.toLowerCase();


        for (int i = 0, j = 0; i < message.length(); i++) {

            char letter = message.charAt(i);

            if ( letter >= 65 && letter <= 90) {
                result += (char)(((letter - 65) + (key.charAt(j)-65)) % 26 + 65);
                System.out.println(result);
                j = ++j % key.length();

            } else if (letter >= 97 && letter <= 122) {
                result += (char)(((letter - 97) + (key.charAt(j)-97)) % 26 + 97);
                j = ++j % key.length();


            } else if (letter == 32 || (letter >= 48 && letter <= 57)) {


            }

        }
        return result;*/



        /*for (int i = 0; i < plaintext.length() ; i++) {
            if (plaintext.charAt(i) > 96 || plaintext.charAt(i) < 123) {
                int convert = (plaintext.charAt(i) + key.charAt(i)) % 26;
                convert += 'a';
                message += (char) convert;
            } else if (plaintext.charAt(i) > 64 || plaintext.charAt(i) < 91) {
                int convert = (plaintext.charAt(i) + key.charAt(i)) % 26;
                convert += 'A';
                message += (char) convert;
        } else {
                return null;
            }
        }*/