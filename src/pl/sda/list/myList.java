package pl.sda.list;

import pl.sda.programowanie1.SortAlgorithm;

import java.util.Comparator;

public interface myList<E> {
    E get(int index);
    void add(E elem);
    void remove(E elem);
    boolean isEmpty();
    int size();
    boolean isSorted(Comparator<E> comparator);
    boolean exist(E elem);
}
