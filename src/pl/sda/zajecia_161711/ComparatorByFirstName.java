package pl.sda.zajecia_161711;

import java.util.Comparator;

public class ComparatorByFirstName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.firstName.compareTo(p2.firstName);
    }
}
