package pl.sda.zajecia;
import java.time.*;

import java.time.Year;
import java.util.Scanner;

public class Main {

    static void drawStar() {
        System.out.println("*");
    }

    public static void main(String[] args) {
        drawStar();
       /* int n = 10;
        Scanner scan = new Scanner(System.in);
        System.out.println("Jak masz na imię?");
        String firstName = scan.nextLine();
        System.out.println("Ile masz lat?");
        String age= scan.nextLine();
        System.out.println("Hello " + firstName);
        System.out.println("Masz " + Integer.parseInt(age) + " lat");
        System.out.println("Za " + n +" lat " + firstName +" będzie miał " + (Integer.parseInt(age)+10) +" lat");
        */



int a = 10;
int pole = a*a;
int obwod = 4*a;
// Obliczenie pola o obwodu kwadratu o boku a
        System.out.println("Dla boku wynoszącego " + a);
System.out.println("Pole wynosi: " + (pole));
        System.out.println("Pole wynosi: " + (obwod));

        /* int myYear = 1992;
        int now = Date(java.time.Year());
        int x = now-year;
        System.out.println(x); */

        int myYear = 2001;
        int age = 2019 - myYear;
        int brakujacy = 18-age;
        System.out.println(age);
        if (age>18) {
            System.out.println("Jestem pełnoletni");
        }
        else if (age == 18) {
            System.out.println("Masz 18 lat");
        }
        else {
            System.out.println("Jestes niepelnoletni");
            int brak  = 18-age;
            System.out.println("Brakuje Ci " + brakujacy + " lat");
            }



        }



	/*System.out.println("Hello " + imie);
        System.out.println(imie +" ma " + wiek + " lat");
        System.out.println("Za " + n +" lat " + imie +" będzie miał " + (wiek+10) +" lat");*/

    }


