package pl.sda.sortAlgorithms;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class quickSort implements SortAlgorithm{


    @Override
    public <E>List<E> sort (List<E> items, Comparator<E> comparator) {
            return sortInner(items,comparator);
        }

    private <E>List<E> sortInner(List<E> myData, Comparator<E> comparator) {
        List<E> items = new LinkedList<>(myData);
        if (items.isEmpty() || items.size()==1) return items;
        E pivot = items.get(items.size()/2);
        List<E> smaller = items.stream()
                .filter(x-> comparator.compare(x,pivot)<0)
                .collect(Collectors.toList());
        List<E> greater = items.stream()
                .filter(x-> comparator.compare(x,pivot)>0)
                .collect(Collectors.toList());
        List<E> exactlyPivot = items.stream()
                .filter(x-> comparator.compare(x,pivot)==0)
                .collect(Collectors.toList());
        return Stream.of(
                sort(smaller,comparator),
                exactlyPivot,
                sort(greater,comparator)
        ).flatMap(Collection::stream)
                .collect(Collectors.toList());

    }
    /*public List<String> sortStringInner(List<String> myData, Comparator<String> comparator) {
        List<String> items= new LinkedList<>();
        items.addAll(myData);
        if (items.isEmpty() || items.size()==1) return items;
        String pivot = items.get(items.size()/2);
        List<Integer> smaller = items.stream()
                .filter(x-> {int result = comparator.compare(x,pivot);
                return result ==0;
                })
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

    }*/

    @Override
    public String sayHello() {
        return "Quick sort";
    }
}
