package pl.sda.sortAlgorithms;

import java.util.Comparator;
import java.util.List;


public interface SortAlgorithm {
    <E>List<E> sort(List<E> items, Comparator<E> comparator) ;
    String sayHello();
}
