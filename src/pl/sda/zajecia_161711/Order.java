package pl.sda.zajecia_161711;
import java.util.*;

public class Order extends OrderItemWithPackage {
    List<OrderItem>items;
    int currentPosition = 0;
    public int numberOfPositions;


    public Order() {
        items = new LinkedList<>();
    }

    public void add(OrderItem item) {
        if (!item.isCorrect()) {
            System.out.println("nie dodano bo niepoprawny");
        }
        else
        items.add(currentPosition,item);
    }
    public void showItems() {
        for (OrderItem e:items){
            e.print();
        }
    }

    public double getValue() {
        double sum=0;
        for(OrderItem e:items){
            if(e!=null)
            sum+=e.getValue();
        }
        return sum;
    }

}




