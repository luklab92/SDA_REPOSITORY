package pl.sda.sortAlgorithms;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HybridSort implements SortAlgorithm,Comparable {

    @Override
    public List<Integer> sort(List<Integer> items) {
        return sortInner(items);
    }

    private List<Integer> sortInner(List<Integer> myData) {
        List<Integer> items = new LinkedList<>();
        items.addAll(myData);
        List<Integer> smaller;
        List<Integer> greater;
        List<Integer> exactlyPivot;

        if (items.isEmpty() || items.size() == 1) return items;
        int pivot = items.get(items.size() / 2);

        smaller = items.stream()
                .filter(x -> x < pivot)
                .collect(Collectors.toList());
        greater = items.stream()
                .filter(x -> x > pivot)
                .collect(Collectors.toList());
        exactlyPivot = items.stream()
                .filter(x -> x == pivot)
                .collect(Collectors.toList());
        if (smaller.size() != 0 && greater.size() != 0 && (smaller.size() < 123 && greater.size() < 123)) {
            sortChoice(greater);
            sortChoice(smaller);
        }
            return Stream.of(
                    sort(smaller),
                    exactlyPivot,
                    sort(greater)
            ).flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }


    private List<Integer> sortChoice(List<Integer> myData) {

        int index, min;
        for (int i = 1; i < myData.size(); i++) {
            index = i;
            for (int j = i + 1; j < myData.size(); j++) {
                if (myData.get(j) < myData.get(index)) {
                    index = j;
                }

            }
            min = myData.get(index);
            myData.set(index, myData.get(i));
            myData.set(i, min);
        }
        return myData;
    }

    @Override
    public String sayHello() {
        return "Hybrid sort";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

