package sample;

import java.security.Key;

public class Cipher {
    public static String generateKey(String word, String key) {
        int x = word.length();

        for (int i = 0; ; i++) {
            if (x == i){
                i = 0;
            }
            if (key.length() == word.length()) {
                break;
            }
            key += (key.charAt(i));

        }
        return key;
    }

    public static String encryption(String message, String key) {

        if (key.equals("")) {
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
        return result;
        


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
    }
}