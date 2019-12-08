package pl.sda.zajecia_161711;

public class Dog extends Mammal implements Animal{
    String name;
    public static int counter = 0;

    public Dog() {
        counter++;
    }

    public void sound() {
        System.out.println("Hau Hau ");
    }
}
