package pl.sda.shop;

import java.util.*;

public class PriorityShop {
    private List<Product> list = new LinkedList<>();
    private int clients;
    private Queue<Person> que = new LinkedList<>();
    private List<Person> rest = new LinkedList<>();
    private long allTime;
    private List<Integer> prices = new LinkedList<>();
    private List<Integer> countProduct = new LinkedList<>();
    private List<Long> time = new LinkedList<>();
    private List<Integer> countProductOrder = new LinkedList<>();
    private List<Integer> pricesInOrder = new LinkedList<>();



    private void serviceMenu() {
        int x = 0;
        //createQueue

        while (x < clients) {
            int n = (int) (Math.random() * (30) + 1);
            assert que.peek() != null;
            System.out.println("Client" + que.peek().getId() + " bought:");
            for (int i = 0; i < n; i++) {
                list.add(new Product());
                System.out.println(list.get(i));
            }
            assert que.peek() != null;
            que.peek().setList(list);
            countProduct.add(list.size());
            countPrice();
            list.clear();
            x++;
        }

        x = 0;
        while (x < clients) {
            long personStartTime = System.nanoTime();
            myPriorityQueue();
            long personEndTime = System.nanoTime();
            long duration = (personEndTime - personStartTime) / 1000;
            allTime += duration;
            time.add(allTime);
            x++;
        }
    }

    private void createQue() {
        for (int i = 0; i < clients; i++) {
            que.add(new Person());
            setPersonId();
        }

    }

    private void create() {
        System.out.println("Type count of clients");
        Scanner scanner = new Scanner(System.in);
        clients = scanner.nextInt();
        createQue();
        for (Person p : que) System.out.println(p.toString());
    }

    private void countPrice() {
        int sum = 0;
        assert que.peek() != null;
        for (Product forPerson : que.peek().getList()) {
                sum += forPerson.getPrice();
            }
            prices.add(sum);
            que.add(que.poll());
        }

    private void setPersonId() {
        int id = 1;
        for (Person p : que) {
            p.setID(id);
            id++;
        }
    }

    private void myPriorityQueue() {
        int index;
        int min = Collections.min(countProduct);
        for (int i = 0; i < countProduct.size(); i++) {
            if (countProduct.get(i) == min) {
                index = i;
                for (int j = 0; j < index; j++) {
                    que.add(que.poll());
                }
                rest.add(que.remove());
                pricesInOrder.add(prices.remove(index));
                countProductOrder.add(countProduct.remove(index));
                break;
            }
        }
    }

    public void cashier() {
        create();
        serviceMenu();
        System.out.println();
        System.out.println("Average time to service: " + allTime / clients + "ms");
        for (int i = 0; i < clients; i++) {

            System.out.println("Client" + (rest.get(i).getId()) + " bought " + countProductOrder.get(i) + " Products, paid: " + pricesInOrder.get(i) + "$ and spend: " + time.get(i) + "ms to get serviced");
        }
    }
}
