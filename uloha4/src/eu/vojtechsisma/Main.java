package eu.vojtechsisma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
        } catch (Exception e) {
            System.err.println("No arguments");
        }
        LinkedList data = readFile(args[0]);
        String input = userInput();

        find(input, data);
    }

    //cteni souboru
    //params
    //  String filename - cesta k souboru
    //returns LinkedList - list slov ze slovniku
    public static LinkedList readFile(String filename) {
        LinkedList dictionary = new LinkedList();
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                dictionary.push(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Chyba pri cteni souboru");
            e.printStackTrace();
        }
        return dictionary;
    }

    //user input
    //returns String - user input
    public static String userInput() {
        System.out.print("Zadej pismena: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //hledani vyskytu
    //params
    //  String input - hledana pismena
    //  LinkedList dictionary - slovnik
    public static void find(String input, LinkedList dictionary) {
        String longest = "";
        for (int i = 0; i < dictionary.size(); i++) {
            boolean passed = true;
            char[] chars = dictionary.get(i).toString().toCharArray();
            for (char j : chars) {
                if (!input.contains(Character.toString(j)) || dictionary.get(i).toString().length() > input.length()) {
                    passed = false;
                }
                //kontrola poctu stejnych znaku
                if (count(input, j) < count(dictionary.get(i).toString(), j)) {
                    passed = false;
                }
            }

            if (passed) {
                if (longest.length() < dictionary.get(i).toString().length())
                    longest = dictionary.get(i).toString();
            }

        }

        if (longest.length() == 0)
            System.out.println("Nenalezeno zadne slovo");
        else
            System.out.println(longest);
    }

    //zjisteni poctu znaku ve slove
    //returns int - pocet znaku
    static int count(String input, char charInput) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == charInput) {
                count++;
            }
        }
        return (count);
    }
}
