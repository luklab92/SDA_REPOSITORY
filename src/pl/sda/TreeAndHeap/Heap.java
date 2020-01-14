package pl.sda.TreeAndHeap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Heap {
    private List<Integer> ints = new LinkedList<>(
            Arrays.asList(12, 11, 1, 7, 5, 4)
    );
    private int i, j;

    private void swap() {
        int temp = ints.get(i);
        ints.set(i, ints.get(j));
        i=j;
        j=(i-1)/2;
        ints.set(i, temp);
    }


    public void addElement(int elem) {
        //Przed dodaniem elementu do kopca sprawdzamy czy kopiec jest zbudowany poprawnie
        //Jezeli nie to go naprawiamy
        if (!isHeapCorrectFromRoot()) makeHeapCorrectFromRoot();
        //dodajemy element do kopca
        ints.add(elem);
        //obliczamy index rodzica i dziecka
        i = ints.size()-1;
        j = (i - 1) / 2;
        //wykonujemy petle do momentu gdy element bedzie mniejszy od ojca, lub dojdziemy do konca kopca
        while (i > 0 && ints.get(j) < elem) {
            //zamiana
            swap();
        }
        //drukujemy wynik
        print();
    }

    public boolean isHeapCorrectFromRoot() {
        for (int x = 1; x < ints.size(); x++) {
            i = x;
            j = (i - 1) / 2;
            if (ints.get(i) > ints.get(j)) return false;
        }
        return true;
    }

    private void makeHeapCorrectFromRoot() {
        for (int x = 1; x <ints.size(); x++) {
            i = x;
            j = (i - 1) / 2;
            while (i < ints.size() && ints.get(j) < ints.get(i)) {
                swap();
            }
        }
        if (!isHeapCorrectFromRoot()) makeHeapCorrectFromRoot();
    }

    public int returnParent(int x) {
        return ints.get((x - 1) / 2);
    }

    public int returnLeftChild(int x) {
        if (isLeftChildExist(x)) return ints.get((2 * x) + 1);
        return -1;
    }

    public int returnRightChild(int x) {
        if (isRightChildExist(x)) return ints.get((2 * x) + 2);
        return -1;
    }

    public boolean isRightChildExist(int x) {
        return (2 * x + 2) < ints.size() - 1;
    }

    public boolean isLeftChildExist(int x) {
        return (2 * x + 1) < ints.size() - 1;
    }

    public boolean isNodeALeaf(int x) {
        return (2 * x + 2) > ints.size() - 1;
    }

    public void pop() {
        ints.set(0, ints.get(ints.size() - 1));
        ints.remove(ints.size() - 1);
        makeHeapCorrectFromRoot();
    }

    public void print() {
        System.out.println(ints);
    }
}
