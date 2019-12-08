package pl;


import pl.sda.prework_programowanie1.Person;
import pl.sda.programowanie1.Recursion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            int[] values = {1, 2, 3, 4, 5};
            System.out.println(Recursion.findRecursion(values, 6));

            while (true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Podaj liczbę ciągu");
                    int fiboNumber = sc.nextInt();
                    try {
                            System.out.println(Recursion.fibonacci(fiboNumber));
                    } catch (IllegalArgumentException ex) {
                            System.out.println("Podaj wieksze od 0");
                            break;
                    }
                    Person person = new Person();
                    
            }
            System.out.println(Recursion.silnia(7));


    }
}