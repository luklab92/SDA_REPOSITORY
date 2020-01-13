package pl.sda.sortAlgorithms;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HybridSort implements SortAlgorithm {

    @Override
    public <E>List<E> sort(List<E> items, Comparator<E> comparator) {
        return sortInner(items,comparator);
    }

    private <E>List<E> sortInner(List<E> myData, Comparator<E> comparator) {
        List<E> items = new LinkedList<>(myData);
        List<E> smaller;
        List<E> greater;
        List<E> exactlyPivot;

        if (items.isEmpty() || items.size() == 1) return items;
        E pivot = items.get(items.size() / 2);

        smaller = items.stream()
                .filter(x -> comparator.compare(x,pivot)<0)
                .collect(Collectors.toList());
        greater = items.stream()
                .filter(x -> comparator.compare(x,pivot)>0)
                .collect(Collectors.toList());
        exactlyPivot = items.stream()
                .filter(x -> comparator.compare(x,pivot)==0)
                .collect(Collectors.toList());
        if (smaller.size() != 0 && greater.size() != 0 && (smaller.size() < 123 && greater.size() < 123)) {
            sortChoice(greater,comparator);
            sortChoice(smaller,comparator);
        }
            return Stream.of(
                    sort(smaller,comparator),
                    exactlyPivot,
                    sort(greater,comparator)
            ).flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }


    private <E>List<E> sortChoice(List<E> myData, Comparator<E> comparator) {

        int index;
        E min;
        for (int i = 1; i < myData.size(); i++) {
            index = i;
            for (int j = i + 1; j < myData.size(); j++) {
                if (comparator.compare(myData.get(j),myData.get(index))<0) {
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

}

