package pl.sda.prework_programowanie1;

public class Dog implements Animal{
    private int age;
    private String name;
     static int dogCounter=0;
     private int id;


    public Dog(String name,int age) {
        this.age = age;
        this.name = name;
        dogCounter++;
    }

    public static void getDogCounter() {
        System.out.println("Ilość psów: "+dogCounter);
    }

    public int getId() {
        return id;
    }

    @Override
    public String getVoice() {
        return "Haaaau";
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "I am "+this.name+" and I am "+this.age+" and this is my voice: "+getVoice();
    }
}
