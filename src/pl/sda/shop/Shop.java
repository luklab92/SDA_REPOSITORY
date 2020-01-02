package pl.sda.shop;

import java.util.*;

public class Shop {
    private List<Product> list = new LinkedList<>();
    private int clients;
    private Queue<Person> que = new LinkedList<>();
    private List<Person> rest = new LinkedList<>();
    private Map<Person, Integer> shopping = new HashMap<>();
    private long allTime;
    private List<Integer> prices = new LinkedList<>();
    private List<Integer> countProduct = new LinkedList<>();
    private List<Long> time = new LinkedList<>();

    public Shop() {
    }

    private void addProductsToBasket(int n) {
        for (int i = 0; i < n; i++) {
            list.add(new Product());
        }
        printBasket();
    }

    private void printBasket() {
        for (Product p : list) System.out.println(p);
    }

    private void create() {
        System.out.println("Type count of clients");
        Scanner scanner = new Scanner(System.in);
        clients = scanner.nextInt();
        for (int i = 0; i < clients; i++) {
            que.add(new Person());
        }
        setPersonId();
        for (Person p : que) System.out.println(p.toString());
    }

    private int countPrice(List<Product> list) {
        int sum = 0;
        for (Product product : list) {
            sum += product.getPrice();
        }
        prices.add(sum);
        return sum;
    }

    private void setPersonId() {
        int id = 1;
        for (Person p : que) {
            p.setID(id);
            id++;
        }
    }

    public void cashier() {

        create();
        while (rest.size() != que.size()) {
            long personStartTime = System.nanoTime() / 1000000;
            System.out.println("Type count of products in basket");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println("Client" + que.element().getId() + " bought:");
            addProductsToBasket(n);
            que.add(que.peek());
            Person temp = que.remove();
            rest.add(temp);
            shopping.put(temp, countPrice(list));
            long personEndTime = System.nanoTime() / 1000000;
            long duration = personEndTime - personStartTime;
            System.out.println(shopping + " Time spend to service " + duration + "ms");
            allTime += duration;
            time.add(duration);
            countProduct.add(list.size());
            list.removeAll(list);
            shopping.clear();

        }
        System.out.println();
        System.out.println("Average time to service: " + allTime / clients + "ms");
        for (int i = 0; i < rest.size(); i++) {
            System.out.println("Client" + (i + 1) + " bought " + countProduct.get(i) + " Products and paid: " + prices.get(i) + "$ and spend: " + time.get(i) + "ms");
        }
        //System.out.print("Time need to service [ms]: ");System.out.println(time);
    }

}
