package pl.sda.wprawki;

import java.util.Scanner;

public class part1 {

    public static void exercise1(int a, int b) {
        int sum = a + b;
        int diff = a - b;
        System.out.println("Suma a i bwynosi: "+sum + " różnica wynosi: " + diff);
    }

    public static void exercise2(int a, int b) {
        if (a * a == b) {
            System.out.println("BINGO");
        } else {
            System.out.println("iloczyn nie jest równy liczbie B");
        }
    }

    public static void exercise3(int age) {
        if (age > 18) {
            System.out.println("Witamy w monopolowym");
        }
        else {
            System.out.println();
        }
    }

    static void exercise4(int a) {
        if (a > 0) {
            System.out.println("Liczba a jest dodatnia");
            if (a < 10) {

                System.out.println("Liczba a jest mała");

            } else if (a > 100) {
                System.out.println("Liczba a jest duża");
            }
        } else if (a == 0) {
            System.out.println("Liczba a jest zerem");
        } else {
            System.out.println("Liczba a jest ujemna");
        }
    }

    static void exercise5(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                System.out.println(dayOfWeek + " = Niedziela");
                break;
            case 2:
                System.out.println(dayOfWeek + " = Poniedziałek");
                break;
            case 3:
                System.out.println(dayOfWeek + " = Wtorek");
                break;
            case 4:
                System.out.println(dayOfWeek + " = Sroda");
                break;
            case 5:
                System.out.println(dayOfWeek + " = Czwartek");
                break;
            case 6:
                System.out.println(dayOfWeek + " = Piatek");
                break;
            case 7:
                System.out.println(dayOfWeek + " = Sobota");
                break;

        }
    }

    static void ex6(int valA, int valB) {
        if ((valB == 1 || valB == 3 || valB == 5 || valB == 6 || valB == 8 || valB == 10 || valB == 12) && valA <= 31) {
            System.out.println("Data jest do ułożenia");
        } else if (valB == 2 && valA <= 28) {
            System.out.println("Data jest do ułożenia");
        } else if ((valB == 4 || valB == 7 || valB == 9 || valB == 11) && valA <= 30) {
            System.out.println("Data jest do ułożenia");
        } else {
            System.out.println("nie można");
        }
    }

    static boolean ex7(int actualYear) {
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Podaj rok");
        //String actualYear = scan.nextLine();

        // zapisac osobno dla czytelnosci kodu
        boolean isDivided4 = actualYear % 4 == 0;
        boolean isDivided100 = actualYear % 100 == 0;
        boolean isDivided400 = actualYear % 400 == 0;
        return isDivided4 && !isDivided100 || isDivided400;
    }

    static void ex8(int a, int b) {
        double value = a * b;
        if (value > 1000) {
            value = value * 0.9;
            System.out.println("Wartość ze zniżką wynosi: " + value);
        } else {
            System.out.println("Wartość bez zniżki wynosi: " + value);
        }
    }

    static void ex9(int x, int y, int z) {
        if (x == y && x == z) {
            System.out.println("Żadna liczba nie jest najmniejsza");
        } else {
            if (x <= y && x <= z) {
                if (x == y) {
                    System.out.println("X oraz Y jest najmniejsze");
                } else if (x == z) {
                    System.out.println("X oraz Z jest najmniejsze");
                } else {
                    System.out.println("X jest najmniejsze");
                }
            } else if (y <= x && y <= z) {
                if (y == z) {
                    System.out.println("Y oraz Z jest najmniejsze");
                } else {
                    System.out.println("Y jest najmniejsze");
                }
            } else if (z <= y && z <= x) {
                System.out.println("Z jest najmniejsze");
            } else {
                System.out.println("Żadna liczba nie jest najmniejsza");
            }
        }
    }

    static void ex10(double courses, double absent) {

        double freq = absent / courses;
        if (freq > 0.75) {
            System.out.println("Frekwencja wynosi: "+freq*100+"%, możesz przystąpic do egzaminu");
        } else {
            System.out.println("Frekwencja wynosi: "+freq*100+"%, nie możesz przystąpić do egzaminu");
        }
    }

    public static void main(String[] args) {

        //roznica a i b
        System.out.println("Zadanie nr 1: ");
        exercise1(20, 100);

        //a - bok kwadratu, b- liczba
        System.out.println("Zadanie nr 2: ");
        exercise2(15,25);

        //czy osoba w wieku a jest pelnoletnia
        System.out.println("Zadanie nr 3: ");
        exercise3(18);

        //jaka jest liczba a
        System.out.println("Zadanie nr 4: ");
        exercise4(32);

        //wypisz odpowiadajacy liczbie 1-7 dzien tygodnia
        System.out.println("Zadanie nr 5: ");
        exercise5(6);

        //sprwadzenie czy a-dzien miesiaca, b-miesiac jest poprawne
        System.out.println("Zadanie nr 6: ");
        ex6(30, 2);

        //czy rok a jest przetepny
        System.out.println("Zadanie nr 7: ");
        System.out.println(ex7(2000));

        //a-cena jednostkowa, b-ilosc, sprawdzenie czy przysluguje znizka
        System.out.println("Zadanie nr 8: ");
        ex8(77, 12);

        //najmniejsza spośród liczb a,b,c
        System.out.println("Zadanie nr 9: ");
        ex9(12, 13, 11);

        //a-liczba zajec, b-ilosc obecnosci, czy student moze przystapic do egzaminu
        System.out.println("Zadanie nr 10: ");
        ex10(50, 36);
    }
}













