package pl.sda.zajecia_161711;

import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person>,Comparator<Person>{
    protected String firstName;
    protected String lastName;
    protected int yearOfBirth;
    Gender gender;
    protected String adress;


    public int getYearOfBirth() {
        return yearOfBirth;
    }
    @Override
    public int compareTo(Person p) {
       return this.lastName.compareTo(p.lastName);
        /*if (this.yearOfBirth<p.yearOfBirth) return -1;
        else if (this.yearOfBirth==p.yearOfBirth)return 0;
        else return 1;*/
}

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.yearOfBirth<o2.yearOfBirth) return -1;
        else if (o1.yearOfBirth==o2.yearOfBirth)return 0;
        else return 1;
    }

    public Person() {

        //System.out.println("Tworzę Person");
    }

    public Person(String firstName, String lastName, int yearOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName, int yearOfBirth, Gender gender, String adress) {
        this (firstName, lastName, yearOfBirth, gender);
        this.adress=adress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getAge() {
        int age = LocalDate.now().getYear()-this.yearOfBirth;
        return age;
    }

    public void whoAmI() {
        if (adress !=null) {
            System.out.println("Nazywam się " + firstName + " " + lastName + ", mam " + getAge() + " lat" );
            System.out.println("Mój adres zamieszkania: "+this.adress);
        }else
        System.out.print("Nazywam się " + firstName + " " + lastName + ", mam " + getAge() + " lat" );

    }
    public String toString() {
        if (adress !=null) {
            return"Nazywam się " + firstName + " " + lastName + ", mam " + getAge() + " lat, mój adres zamieszkania: "+this.adress;
        }else
            return "Nazywam się " + firstName + " " + lastName + ", mam " + getAge() + " lat" ;
    }


    public void isAdult(){
        if (getAge()>18) System.out.println("Witamy w monopolowym");
        else System.out.println("Witamy w zabawkowym");
    }
}
