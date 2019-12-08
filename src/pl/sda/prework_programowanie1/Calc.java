package pl.sda.prework_programowanie1;

public class Calc {

    public static double sum (double x, double y) {
        return x+y;
    }

    public static int quotient (int x, int y) {
        int result=0;
        try {
            result =x / y;
        } catch (ArithmeticException e) {
            System.out.println("Don't divide by 0");
        }
        return result;
    }

    public static double product (double x, double y) {
            return x * y;
    }



}
