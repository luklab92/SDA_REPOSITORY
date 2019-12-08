package pl.sda.wprawki;

import org.w3c.dom.ls.LSOutput;

public class part2 {

static void ex1() {
    int counter  = 10;
    for (int i = 1; i<=counter; i++) {
        System.out.println(i);
    }
}

static void ex2(int counter) {

    for (int i=1; i<=counter; i++) {
        if (i % 2 == 0 && i % 3 == 0) {
            System.out.println(i);
        }
    }
}

static void ex3() {
    int counter = 5;
    for (int i =1; i<=counter; i++) {
        int z=i*i;
        System.out.println("Liczba: "+i+" Liczba podniesiona do kwadratu "+z);
    }
}

static void ex4(int counter) {
    for(int i=1; i<=counter;i++) {
        int z=5*i;
        System.out.println("5 x "+i+" = "+z);
    }
}

static void ex5 (int counter) {
    for (int i=1;i<=counter;i++) {
        int z =5*10*i+i;
        System.out.println("Wynik dla i="+i+" = "+z);
    }
}

static void ex6 () {
    for (int i=0; i<50; i++) {
        if(i%10==0 && i!=0){
            System.out.println();
        }
        System.out.print((i+1)+ " ");
    }
}

    static void ex6a (int breakLine) {
        for (int j = 1; j == breakLine; j++) {
            for (int i = 1; i <= 50; i++) {
                System.out.print((i + 1) + " ");
            }

            System.out.println();
        }
    }

static void ex7 (int counter) {
    int sum = 0;
    for (int i =1; i<=counter;i++) {
        sum += i;
    }
    System.out.println(sum);
    }

    static void ex8 (int counter) {
        int sum = 0;
        for (int i =1; i<=counter;i++) {
            if (i%2 ==0) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    static boolean isPrimeNumber (int counter) {
        for (int i = 2; i <counter; i++) {
            if(counter%i ==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    //liczby od 1 do 10
    System.out.println("Zadanie 1");
    ex1();

    //liczby parzyste i podzielne przez 3 z zakresu
    System.out.println("Zadanie 2");
    ex2(50);

    //liczby od 1 do 5 oraz ich potęgi
    System.out.println("Zadanie 3");
    ex3();

    //liczby ....

    System.out.println("Zadanie 4");
    ex4(17);

        System.out.println("Zadanie 5");
        ex5(6);

        System.out.println("Zadanie 6");
        ex6();

        //nie działa
        System.out.println();
        System.out.println("Zadanie 6a");
        ex6a(9);


        System.out.println();
        System.out.println("Zadanie 7");
        ex7(8);

        System.out.println("Zadanie 8");
        ex8(4);

        System.out.println("zadanie 9");
        System.out.println(isPrimeNumber(4));

    }



}
