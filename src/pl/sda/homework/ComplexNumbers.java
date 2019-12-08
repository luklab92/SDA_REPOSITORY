package pl.sda.homework;

import java.util.*;

public class ComplexNumbers{


    public void complexNumbers() {
        List<Complex> complexList = new LinkedList<>();
        while (true) {
            System.out.println("Podaj część rzeczywistą i urojoną");
            Scanner scanner = new Scanner(System.in);
            int real = scanner.nextInt();
            int imaginary = scanner.nextInt();
            if (real==0 && imaginary ==0)break;
            Complex complex = new Complex(real,imaginary);
            complexList.add(complex);
        }
        Complex sum = new Complex(0,0);
        for (Complex comp:complexList) {
            sum = Complex.sum(sum,comp);
        }
        System.out.println(sum);
        Collections.sort(complexList,new ComplexComparatorDescendingOrder());
        System.out.println(complexList);
    }
    public void uniqueComplexNumbers() {
            Set<Complex> uniqueList = new HashSet<>();
            while (true) {
                System.out.println("Podaj część rzeczywistą i część urojoną");
                Scanner scanner = new Scanner(System.in);
                int real = scanner.nextInt();
                int imaginary = scanner.nextInt();
                if (real==0 && imaginary ==0) break;
                Complex complex = new Complex(real,imaginary);
              if (!uniqueList.add(complex)) System.out.println("Podana liczba juz istnieje");
                }
            Complex sum = new Complex(0,0);
            for (Complex comp:uniqueList) {
                sum = Complex.sum(sum,comp);
            }
            System.out.println(sum);
            System.out.println(uniqueList);
        }
    }
