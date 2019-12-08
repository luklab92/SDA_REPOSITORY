package pl.sda.homework;

import org.w3c.dom.ls.LSOutput;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.*;

public class homework4 {

    static void myLittleString(String text) {
        String[] exceptions = {"a", "e", "i", "o", "s", "4", "3", "1", "0", "$"};
        String[] tableOfText = text.toLowerCase().split("");
        System.out.println("Original text: " + text);
        for (int i = 0; i < exceptions.length / 2; i++) {
            for (int j = 0; j < tableOfText.length; j++) {
                if (tableOfText[j].equals(exceptions[i])) {
                    tableOfText[j] = exceptions[i + exceptions.length / 2];
                } else if (tableOfText[j].equals(exceptions[i + exceptions.length / 2])) {
                    tableOfText[j] = exceptions[i];
                }
            }
        }
        for (String element : tableOfText) {
            System.out.print(element);
        }
    }

    static void stats(String text) {

        //podzial wpisanego tekstu na wyrazy
        String[] splited = text.split(" ");

        //obliczenie najdluzszego slowa
        int longest = 0;
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].length() > longest) {
                longest = splited[i].length();
            }
        }

        //deklaracja tablicy o rozmiarze rownym dlugosci najdluzszego wyrazu
        Integer[] lengthOf = new Integer[longest + 1];
        int lengthOfTable = lengthOf.length;

        //nadanie wartosci elementom tablicy =0
        for (int i = 0; i < lengthOf.length; i++) {
            lengthOf[i] = 0;
        }

        //obliczenie ilosci wyrazow o poszczegolnej dlugosci
        for (int i = 0; i < splited.length; i++) {
            for (int j = 0; j < lengthOf.length; j++) {
                if (splited[i].length() == j) {
                    lengthOf[j] = lengthOf[j] + 1;
                }
            }
        }

        //deklaracja tablicy zawierajacej slowa o danej dlugosci + oraz wypisanie żądanego wyniku
        String[][] table = new String[lengthOfTable][lengthOfTable];
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++) {
                if (splited[i].length() == j) {
                    table[i][j] = splited[i];
                }
            }
        System.out.println();
        for (int i = 1; i < lengthOfTable; i++) {
            for (int j = 0; j < lengthOfTable; j++) {
                if (lengthOf[i] != 0) /*- zadanie z gwiazdka */
                    if (table[i][j] != null) {
                        System.out.print("Długość - " + i + " ");
                        {
                            for (int k = 0; k < splited.length; k++) {
                                if (splited[k].length() == i) {
                                    System.out.print(splited[k] + " ");
                                }
                            }
                        }
                        System.out.print("- liczba słów: " + lengthOf[i]);
                        System.out.println();
                    }
            }
        }
    }

    static void fibonacci(int numbers) {
        int[] fiboNumbers = new int[numbers + 1];
        fiboNumbers[0] = 0;
        fiboNumbers[1] = fiboNumbers[0] + 1;
        for (int i = 2; i < numbers + 1; i++) {
            fiboNumbers[i] = fiboNumbers[i - 1] + fiboNumbers[i - 2];
            System.out.print(fiboNumbers[i] + " ");
        }
    }

    static boolean isPESELTrue(int[] PESEL) {
        int sum=0;
        int[] weights = {9,7,3,1,9,7,3,1,9,7};
        if(PESEL.length==11) {
            for (int i = 0; i < PESEL.length-1; i++) {
                sum = sum + PESEL[i] * weights[i];
            }
        }
return sum%10==PESEL[PESEL.length-1];
    }

    static void weight (int[] PESEL) {
        int[] control= new int[PESEL.length-1];
        int[] weights = {9,7,3,1,9,7,3,1,9,7};
        for (int i = 0; i <PESEL.length-1; i++) {
            control[i]=PESEL[i]*weights[i];
        }
        for (int element:control) {
            System.out.print(element+ " ");
        }
    }

    public static void main(String[] args) {
        myLittleString("4$14");
        System.out.println();
        System.out.println();
        stats("ala i ola bb cc mają koty moj abc ssssa aaa222ddd");
        fibonacci(40);
        System.out.println();
        int[] PESELNUMBER = {9,2,0,4,1,0,0,4,2,9,3};
        System.out.println(isPESELTrue(PESELNUMBER));
        weight(PESELNUMBER);
    }
}
