package pl.sda.prework_programowanie1;

public class Cat extends Spiece implements Animal{
private int age;
     static int catCounter=0;
     private int id;
     private Person owner;


    public Cat(String firstName, int age, Person owner) {
        super(firstName);
        this.age = age;
        this.owner=owner;
        catCounter++;
    }
    public Cat(String firstName, int age) {
        super(firstName);
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
