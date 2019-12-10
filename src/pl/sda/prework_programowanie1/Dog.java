package pl.sda.prework_programowanie1;

public class Dog extends Spiece implements Animal{
    private int age;
     static int dogCounter=0;
     private int id;
     private Person owner;


    public Dog(String firstName,int age, Person owner) {
        super(firstName);
        this.age = age;
        this.owner=owner;
        dogCounter++;
    }
    public Dog(String firstName,int age) {
        super(firstName);
        this.age = age;
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
        return this.getFirstName();
    }

    @Override
    public Person getOwner() {
        return getOwner();
    }

    @Override
    public String toString() {
        if (owner!=null)
        return "I am "+this.getFirstName()+" and I am "+this.age+" and this is my voice: "+getVoice()+", owner - "+owner.getFirstName()+" "+owner.getLastName();
        return "I am "+this.getFirstName()+" and I am "+this.age+" and this is my voice: "+getVoice();
    }
}
