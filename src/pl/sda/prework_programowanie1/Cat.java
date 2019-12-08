package pl.sda.prework_programowanie1;

public class Cat implements Animal{
private String name;
private int age;
     static int catCounter=0;
     private int id;


    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        catCounter++;
    }

    public int getId() {
        return id;
    }

    public static void getCatCounter() {
        System.out.println("Ilość kotów: "+catCounter);
    }

    @Override
    public String getVoice() {
        return "Meooow";
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
