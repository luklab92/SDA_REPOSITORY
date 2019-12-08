package pl.sda.zajecia_161711;

public class Cat implements Animal,Movable{
public static int counter = 0;

public Cat() {
    counter++;
}
    public void sound() {
        System.out.println("Meow ");
    }
    public void move(){
        System.out.println("Porusza sie na łapach");
    }
}
