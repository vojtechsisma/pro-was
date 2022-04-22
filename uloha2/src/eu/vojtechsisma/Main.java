package eu.vojtechsisma;

import java.io.File;
import java.text.Normalizer;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
        } catch (Exception e) {
            System.err.println("No arguments");
        }
        readDir(args[0]);
    }

    //Cteni slozek/souboru
    //params
    //  String path - cesta ke slozce
    public static void readDir(String path) {
        File folder = new File(path);
        File[] list = folder.listFiles();

        try {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isFile()) {
                    //soubor
                    System.out.println(path + "/" + list[i].getName() + " → " + toAscii(list[i].getName()));
                } else if (list[i].isDirectory()) {
                    //slozka
                    readDir(path + "/" + list[i].getName());
                    System.out.println(path + "/" + list[i].getName() + " → " + toAscii(list[i].getName()));
                }
            }
        } catch (Exception e) {
            System.err.println("Chyba pri cteni souboru, mozna soubor neexistuje :(");
        }
    }

    //prevod do ascii znaku (zbaveni diakritiky)
    //returns String - retezec s nahrazenymi znaky
    private static String toAscii(final String input) {
        return Normalizer
                .normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
