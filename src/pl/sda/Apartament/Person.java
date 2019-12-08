package pl.sda.Apartament;

public class Person {
protected String firstName;
protected String lastName;
protected String adress;
    Person() {

    }
    Person(String firstName, String lastName, String adress) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.adress=adress;
    }
    public String toString (){
        return this.firstName+" "+this.lastName;
    }
}
