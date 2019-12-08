package pl.sda.prework_programowanie1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface PersonRepository {
    List getAll();
    List findByAge(int age);
    Person getById(int id);
    Optional findById(int id);
    List findByPredicate (Predicate<Person> personPredicate);
    List findAllOrderedBy(Comparator<Person>order);
    List getAllIds();
    void foreach(Consumer<Person> person);
}
