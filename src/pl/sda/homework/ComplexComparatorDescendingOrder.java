package pl.sda.homework;
import java.util.*;

public class ComplexComparatorDescendingOrder implements Comparator<Complex> {
    @Override
    public int compare(Complex o1, Complex o2) {
        if (o2.getReal() < o1.getReal()) {
            return -1;
        } else if (o2.getReal() > o1.getReal()) {
            return 1;
        } else {
            if (o2.getImaginary() < o1.getImaginary()) {
                return -1;
            } else if (o2.getImaginary() == o1.getImaginary()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
