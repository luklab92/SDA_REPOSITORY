package pl.sda.programowanie1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercises_adam {
public static int pascal(int n, int k) {
    if (k > n) throw new IllegalArgumentException();
    if (k <= 0 || n <= 0) throw new IllegalArgumentException();
    if (k == n || k == 1) return 1;
    else {
        return pascal(n, k - 1) * (n-k+1)/k;
    }
}

public static void printPascal(int n) {
   //deklaracja pierwszej wartosci trojkata pascala
    int value =1;

    //VISUALITY

   int val2=1;
    for (int i = 1; i <=n/2; i++) {
        val2=val2*(n-(i)+1)/(i);
    }
    System.out.println(val2);
   String space ="";
   if (val2>10) space ="  ";
   if (val2>100) space ="   ";
   if (val2>1000) space ="    ";
   if (val2>10000) space ="     ";

               for (int i = 0; i <=n; i++) {
        System.out.print(space);
    }

              ////TROJKAT

    System.out.print(1);
    System.out.println();
   for (int i=1;i<n;i++) {
       value=1;
       for (int j = i; j <n; j++) {
           System.out.print(space);
       }
       System.out.print(space+1);
       for (int j = 1; j < i; j++) {
           if (i==n || j==1) value =1;
           value=value*(i-j+1)/(j);
           System.out.print(space+value);
       }
       System.out.print(space+1);
       System.out.println();
   }
}
public static int factorial(int a, int n){
    if (n==0) return 1;
    if (n<0) throw new IllegalException();
    return factorial(a,n-1)*a;
}
public static double actualBallance(int years, double percent, int zeroBallance) {
    if (years==0) return zeroBallance;
    if (years<0) throw new IllegalException();
    return actualBallance(years-1,percent/100,zeroBallance)+Math.pow((1+percent/100),years);
}

}

