package pl.sda.sortAlgorithms;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HeapSort implements SortAlgorithm{

    private int i,j;

private <E>boolean isHeapCorrectFromRoot(List<E> ints, Comparator<E> comparator) {
        for (int x = 1; x < ints.size(); x++) {
            i = x;
            j = (i - 1) / 2;
            if (comparator.compare(ints.get(i),ints.get(j))>0) return false;
        }
        return true;
    }

    private <E>void swap(List<E> ints) {
        E temp = ints.get(i);
        ints.set(i, ints.get(j));
        i=j;
        j=(i-1)/2;
        ints.set(i, temp);
    }

    private <E>void makeHeapCorrectFromRoot(List<E> ints,Comparator<E> comparator) {
        for (int x = 1; x <ints.size(); x++) {
            i = x;
            j = (i - 1) / 2;
            while (i < ints.size() && comparator.compare(ints.get(j),ints.get(i))<0) {
                swap(ints);
            }
        }
        if (!isHeapCorrectFromRoot(ints,comparator)) makeHeapCorrectFromRoot(ints,comparator);
    }

    @Override
    public <E> List<E> sort(List<E> ints, Comparator<E> comparator){
        List<E> listToSort = new LinkedList<>();
        List<E> tempList = new LinkedList<>(ints);
        while (ints.size()>0) {
            makeHeapCorrectFromRoot(ints,comparator);
            listToSort.add(ints.get(0));
            ints.set(0, ints.get(ints.size() - 1));
            ints.remove(ints.size() - 1);
        }
        ints.addAll(tempList);
        return listToSort;
    }

    @Override
    public String sayHello() {
        return "I am heapSort";

    }
    }
