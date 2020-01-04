package pl.sda.shop;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Person implements Comparable<Person>{
    private String name;
    private String surname;
    private int age;
    private int min=1;
    private int max=10;
    private int range=max-min;
    private int id;
    private int numberOfProducts;

    public Person() {
        PriorityShop sh = new PriorityShop();
        this.name = RandomStringUtils.randomAlphabetic(5);
        this.surname = RandomStringUtils.randomAlphabetic(5);
        this.age = (int) (Math.random() * 20 * range) /10;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client"+getId()+" FirstName: "+name+" LastName: "+surname;
    }
public int getNumberOfProducts() {return numberOfProducts;}
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


    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.numberOfProducts, p.numberOfProducts);
    }
}
