package pl.sda.prework_programowanie1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Person extends Spiece{
    private String lastName;
    private String PESELnumber;
    private int id;


    public Person(String firstName,String lastName, String PESELnumber) {
        super(firstName);
        this.lastName = lastName;
        this.PESELnumber = PESELnumber;
    }


    public int getId() {
        return id;
    }

    protected int setID (int id) {
        this.id = id;
        return id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.getFirstName());
    }


    @Override
    public String toString() {
        return this.getId()+" "+this.getFirstName() + " " + this.lastName + " " + getAgeFromPESEL();
    }

    protected String getNip() {
        return getPesel();
    }

    public String getPesel() {
        return PESELnumber;
    }

    public int getAgeFromPESEL() {
        int yearOfBirth = 1900+Integer.parseInt(getPesel().split("")[0]+getPesel().split("")[1]);
        if ((Integer.parseInt(getPesel().split("")[0]))>2) return LocalDate.now().getYear() -yearOfBirth;
        return LocalDate.now().getYear() - (yearOfBirth+100);
    }
    public boolean isOlder (int age) {
        return (getAgeFromPESEL()>age);
    }

    public String getLastName() {
        return lastName;
    }
}