package pl.sda.zajecia;

public class exercises_zajecia {

        static void drawStars(String name) {

        System.out.println("*****");
            System.out.println(name);
            System.out.println("*****");
            System.out.println();
    }

    static int printSomething(int what)
    {

        return what;
    }
    static double getPi()
    {
        System.out.println("**");
            return 3.14;
    }

    static int square(int x)
    {
           return x*x;
    }

    static int getAge(int myYear)
    {
           return 2019-myYear;

    }

    static void  printHello() {
        int repeat = 3;
        for (int i = 0; i < repeat; i++) {
            System.out.println("Hello World");
        }
    }
        static void sum()
    {
        int x=0;
        int counter = 5;
         for (int i=1; i<=counter;i++) {
             x=x+i;
         }
        System.out.println(x);
    }




    public static void main(String[] args) {
        double pi = getPi();
        int square1 = square(5);
        int square2 = square(43);
        System.out.println(pi);
        System.out.println(square1 + " " + square2);
        drawStars("Lukas");

        int age = getAge(2000);
        System.out.println("Mam: " + age + " lat");

        int age2 = getAge(1995);
        System.out.println("A w tym przypadku mam " + age2 + " lat :)");

        int print1 = printSomething(1);
        int print2 = printSomething(3);
        int print3 = printSomething(5);
        System.out.println(print1);
        System.out.println(print2);
        System.out.println(print3);
        printHello();
        sum();
        int i = 10;

        do {
            System.out.println(i);
            i++;
        }
        while
        (i <= 5);

    }
    }





