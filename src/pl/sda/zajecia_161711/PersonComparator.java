package pl.sda.zajecia_161711;
import java.util.*;

public class PersonComparator implements Comparator<Person>{


    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getYearOfBirth()<o2.getYearOfBirth()) return -1;
        else if (o1.getYearOfBirth()==o2.getYearOfBirth())return 0;
        else return 1;
    }
}
