package pl.sda.shop;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Person {
    private String name;
    private String surname;
    private int age;
    private int min=1;
    private int max=10;
    private int range=max-min;
    private int id;

    public Person() {
        this.name = RandomStringUtils.randomAlphabetic(5);
        this.surname = RandomStringUtils.randomAlphabetic(5);
        this.age = (int) (Math.random() * 20 * range) /10;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client"+getId()+" FirstName: "+name+" LastName: "+surname;
    }

    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }

    public int setID (int id) {
        this.id = id;
        return id;
    }


}
