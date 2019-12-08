package pl.sda.homework;
import java.io.Serializable;
import java.util.*;

public class Complex implements Comparable<Complex>, Serializable {
    private int real;
    private int imaginary;
    private static int counter =0;

    @Override  // funkcja toString klasy obiekt powoduje wydrukowanie obiektu bez koniecznosci rozdzielenia go na czesci
    public String toString() {
        if( this.imaginary>=0)
        return this.real + "+" + this.imaginary + "i";
        return this.real + "" + this.imaginary + "i";
    }

public int getReal() {
        return real;
}


    public Complex(int real, int imaginary) {
        this.counter++;
        //System.out.println("licznik= "+counter);
        this.real = real;
        this.imaginary = imaginary;

    }

    @Override
    public int compareTo(Complex c) {
        if (this.real>c.real) return 1;
        else if (this.real ==c.real) return 0 ;
        else {
            if (this.imaginary > c.imaginary) return 1;
            else if (this.imaginary == c.imaginary) return 0;
            else return -1;
        }
    }

    /*public static int getSImaginary () {
        int i=-1;
        System.out.print("imaginary part: ");
        return i;
    }*/

    public int getImaginary() {
        return imaginary;
    }

    public void print() {
        if( this.imaginary>0)
        System.out.println(this.real + "+" + this.imaginary + "i");
        else if (this.imaginary<0)    System.out.println(this.real + "" + this.imaginary + "i");

        else
            System.out.println(this.real);
    }

    public boolean isEqualTo (Complex c){
        return this.real==c.real && this.imaginary==c.imaginary;
    }


    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return real == complex.real &&
                imaginary == complex.imaginary;
    }

    public static Complex sum(Complex z1, Complex z2, Complex z3) {
        int realPart = z1.real + z2.real+z3.real;
        int imaginaryPart = z1.imaginary + z2.imaginary+z3.imaginary;
        return new Complex(realPart, imaginaryPart);

    }
    public static Complex sum(Complex z1, Complex z2) {
        int realPart = z1.real + z2.real;
        int imaginaryPart = z1.imaginary + z2.imaginary;
        return new Complex(realPart, imaginaryPart);

    }
    public static Complex sum(Complex... complexes) {
        int realPart = 0;
        int imaginaryPart=0;
        for (Complex c:complexes) {
            realPart+=c.real;
            imaginaryPart+=c.imaginary;
        }
        //int imaginaryPart = z1.imaginary + z2.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    public static Complex diff(Complex z1,Complex z2) {
        int realPart = z1.real - z2.real;
        int imaginaryPart = z1.imaginary - z2.imaginary;
        Complex result = new Complex(realPart, imaginaryPart);
        return result;
    }



}
