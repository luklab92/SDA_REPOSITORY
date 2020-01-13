package pl.sda.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Heap {
    private List<Integer> ints = new LinkedList<>(
            Arrays.asList(12, 11, 9, 8, 10, 22, 3, 6, 7, 9, 3, 5, 4)
    );

    public void addElement(int elem) {
        //Przed dodaniem elementu do kopca sprawdzamy czy kopiec jest zbudowany poprawnie
        //Jezeli nie to go naprawiamy
        if (!isHeapCorrect()) makeHeapCorrect();
        //dodajemy element do kopca
        ints.add(elem);
        //obliczamy index elementu
        int i = ints.size() - 1;
        //obliczamy index rodzica
        int j = (i - 1) / 2;
        //wykonujemy petle do momentu gdy element bedzie mniejszy od ojca, lub dojdziemy do konca kopca
        while (i > 0 && ints.get(j) < elem) {
            int temp = ints.get(i);
            ints.set(i, ints.get(j));
            i = j;
            j = (i - 1) / 2;
            ints.set(i, temp);
        }
        //drukujemy wynik
        print();
    }

    public boolean isHeapCorrect() {
        for (int x = ints.size(); x > 0; x--) {
            int i = x - 1;
            int j = (i - 1) / 2;
            if (ints.get(i) > ints.get(j)) return false;
        }
        return true;
    }

    public void makeHeapCorrect() {
        for (int x = ints.size(); x > 0; x--) {
            int i = x - 1;
            int j = (i - 1) / 2;
            while (i > 0 && ints.get(j) < ints.get(i)) {
                int temp = ints.get(i);
                ints.set(i, ints.get(j));
                i = j;
                j = (i - 1) / 2;
                ints.set(i, temp);
            }
        }
    }

    public void print() {
        System.out.println(ints);
    }
}
