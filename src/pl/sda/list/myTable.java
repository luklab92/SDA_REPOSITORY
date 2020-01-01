package pl.sda.list;

import pl.sda.programowanie1.SortAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class myTable<E> implements myList<E> {
    private int size = 0;
    private int defaultSize= 10;
    private Object element[];

    public myTable() {
element = new Object[defaultSize];
    }


    //METODY Z INTEFEJSU
    public void add(E e) {
    if (size == element.length)
    grow();
    else element[size++] = e;
    }

        private void grow () {
        int newSize = element.length + 1;
        element = Arrays.copyOf(element,newSize);
        }

public E get(int i) {
        if (i>size || i<0) throw new IndexOutOfBoundsException();
return (E) element[i];
    }

    public void remove(E e) {
        for (int i = 0; i <element.length; i++) {
            if (element[i]==e)
                element[i]=null;
        }
    }
    public boolean isEmpty() {
        for (int i = 0; i <=size; i++) {
            if (element[i] != null) return false;
        }
        return true;
    }
    public int size() {
        int counter=0;
        for (int i = 0; i <=size; i++) {
            if (element[i] != null)
                counter++;
        }
        return counter;
    }

    @Override
    public boolean isSorted(Comparator<E> comparator){
       return (comparator.compare((E)element,(E)element)) > 0;
}
    public boolean exist(E e) {
        for (int i = 0; i <=size; i++) {
            if (element[i] == e)
                return true;
        }
        return false;
    }

    //POZOSTAŁE METODY

    public void printAll() {
        for (int i = 0; i <element.length; i++) {
            if (element[i] != null)
            System.out.print(element[i]+" ");
        }
        System.out.println();
    }


}
