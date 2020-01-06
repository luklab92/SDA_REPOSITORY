package pl.sda.shop;

import org.apache.commons.lang3.RandomStringUtils;

public class Product {
    private String name;
    private int price;

    Product() {
        this.name = RandomStringUtils.randomAlphabetic(1).charAt(0) + RandomStringUtils.randomAlphabetic(5, 10).substring(1);
        this.price = (int) (Math.random() * 100 + 10);
    }

    public String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
