package pl.sda.programowanie1;

public class Recursion {

    public static boolean findRecursion(int[] values, int findValue) {
        return findRecursion(values,findValue,0);
    }
    private static boolean findRecursion(int[] values, int findValue, int startValue) {
        if (startValue == values.length || startValue < 0) return false;
        if (findValue == startValue) return true;
        else return findRecursion(values, findValue, ++startValue);
    }

  public static int fibonacci (int number) {
        if (number<0) throw new IllegalArgumentException();
        if (number ==0) return 0;
        if (number ==1) return 1;
        else return fibonacci(number-1)+fibonacci(number-2);
  }

        public static int silnia (int number) {
if (number <0) throw new IllegalArgumentException();
if (number ==0) return 1;
if (number ==1) return 1;
else return silnia(number-1)*number;
  }
}