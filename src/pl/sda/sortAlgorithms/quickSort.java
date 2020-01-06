package pl.sda.sortAlgorithms;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class quickSort implements SortAlgorithm{


    @Override
    public List<Integer> sort (List<Integer> items) {
            return sortInner(items);
        }

    private List<Integer> sortInner(List<Integer> myData) {
        List<Integer> items= new LinkedList<>();
        items.addAll(myData);
        if (items.isEmpty() || items.size()==1) return items;
        int pivot = items.get(items.size()/2);
        List<Integer> smaller = items.stream()
                .filter(x-> x <pivot)
                .collect(Collectors.toList());
        List<Integer> greater = items.stream()
                .filter(x-> x >pivot)
                .collect(Collectors.toList());
        List<Integer> exactlyPivot = items.stream()
                .filter(x-> x ==pivot)
                .collect(Collectors.toList());
        return Stream.of(
                sort(smaller),
                exactlyPivot,
                sort(greater)
        ).flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    @Override
    public String sayHello() {
        return "Quick sort";
    }
}
