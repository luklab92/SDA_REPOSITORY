package pl.sda.sortAlgorithms;

import java.util.LinkedList;
import java.util.List;

public class BubbleSort implements SortAlgorithm{
    @Override
    public List<Integer> sort(List<Integer> items) {
        Integer temp;
        List<Integer> list1= new LinkedList<>();
        list1.addAll(items);
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list1.size() - 1; i++) {
                if (list1.get(i) > list1.get(i + 1)) {
                    temp = list1.get(i);
                    list1.set(i, list1.get(i + 1));
                    list1.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return list1;
    }

    @Override
    public String sayHello() {
        return "Bubble sort";
    }
}
