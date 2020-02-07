package sample;

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

    public static String cipherText(String plaintext, String key) {
        String text = "";


        for (int i = 0; i < plaintext.length() ; i++) {
            if (plaintext.charAt(i) > 96 || plaintext.charAt(i) < 123) {
                int convert = (plaintext.charAt(i) + key.charAt(i)) % 26;
                convert += 'a';
                text += (char) convert;

            } else if (plaintext.charAt(i) > 64 || plaintext.charAt(i) < 91) {
                int convert = (plaintext.charAt(i) + key.charAt(i)) % 26;
                convert += 'A';
                text += (char) convert;
        } else {
                return null;
            }
        }
        return text;
    }
}