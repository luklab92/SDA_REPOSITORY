package pl.sda.shop;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class Person{
    private String name;
    private String surname;
    private int age;
    private int id;
    private List<Product> list;

    public Person() {
        this.name = RandomStringUtils.randomAlphabetic(5);
        this.surname = RandomStringUtils.randomAlphabetic(5);
        int max = 10;
        int min = 1;
        int range = max - min;
        this.age = (int) (Math.random() * 20 * range) /10;

    }
    public void setList (List<Product> list) {
        this.list = list;
    }
    public int getNumberOfProducts() {
        return list.size();
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
    public List<Product> getList() {
        return list;
    }

    public int setID (int id) {
        this.id = id;
        return id;
    }

}
