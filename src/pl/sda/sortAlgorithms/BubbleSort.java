package pl.sda.sortAlgorithms;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort implements SortAlgorithm{
    @Override
    public <E>List<E> sort(List<E> items, Comparator<E> comparator) {
        E temp;
        List<E> list1 = new LinkedList<>(items);
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list1.size() - 1; i++) {
                if (comparator.compare(list1.get(i),list1.get(i + 1))>0) {
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
