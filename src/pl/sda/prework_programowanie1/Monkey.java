package pl.sda.prework_programowanie1;

public class Monkey extends Spiece implements Animal{
    private int age;
     private static int monkeyCounter=0;
     private int id;
     private Person owner;

    public Monkey(String firstName,int age,Person owner) {
        super(firstName);
        this.age = age;
        this.owner=owner;
        monkeyCounter++;
    }
    public Monkey(String firstName,int age) {
        super(firstName);
        this.age = age;
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
        return this.getFirstName();
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        if (owner!=null)
        return "I am "+this.getFirstName()+" and I am "+this.age+" and this is my voice: "+getVoice()+", owner - "+owner.getFirstName()+" "+owner.getLastName();
        return "I am "+this.getFirstName()+" and I am "+this.age+" and this is my voice: "+getVoice();
    }
}
