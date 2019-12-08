package pl.sda.prework_programowanie1;

import java.util.Comparator;

public class PatientComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
