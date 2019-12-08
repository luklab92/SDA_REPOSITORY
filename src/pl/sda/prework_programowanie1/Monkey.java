package pl.sda.prework_programowanie1;

public class Monkey implements Animal{
    private int age;
    private String name;
     private static int monkeyCounter=0;
     private int id;

    public Monkey(String name,int age) {
        this.age = age;
        this.name = name;
        monkeyCounter++;
    }

    public static void getMonkeyCounter() {
        System.out.println("Ilość małp: "+monkeyCounter);
    }

    public int getId() {
        return id;
    }

    @Override
    public String getVoice() {
        return "Monkey Donkey";
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
