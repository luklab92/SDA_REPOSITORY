package pl.sda.zajecia_161711;

public class Cow implements Animal{

    public static int counter = 0;

    public Cow() {
        counter++;
    }
    public void sound() {
        System.out.print("Muuuuuu ");
    }
}
