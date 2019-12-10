/*
package pl.sda.prework_programowanie1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OverallRepo<T> implements SpiecesRepository{
    List<T> spieces = new LinkedList<T>();

    @Override
    public List<T> getAll() {
        return spieces;
    }

    */
/*@Override
    public List findByAge(int age) {
        List<Person> foundByAge = new LinkedList<>();
        for (T p: persons)
            if (p.getAgeFromPESEL()>age)
                foundByAge.add(p);
        return foundByAge;
    }*//*


   */
/* @Override
    public Person getById(int id) {
        T pp=null;
        try {
            for (T p : spieces)
                if (id == p.getId())
                    pp=p;
        } catch (NullPointerException e) {
            System.out.println("Podaj poprawne ID");
        }
        return pp;
    }*//*


    @Override
    public Optional<T> findById(int id) {
        T pp=null;
        try{
            for (T p: spieces)
                if (p.getId()==id)
                    pp=p;
        }
        catch (NullPointerException e) {
            System.out.println("Nie ma podanego ID");
        }
        return Optional.ofNullable(pp);
    }

    @Override
    public List<T> findByPredicate(Predicate<T> personPredicate) {
        return spieces.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<T> findAllOrderedBy(Comparator<T> order) {
        return spieces.stream()
                .sorted(order)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getAllIds() {
        List<Long> ids=new LinkedList<>();
        for(Spiece p: spieces)
            ids.add((long) p.getId());
        ids.sort(Comparator.naturalOrder());
        return ids;
    }

    @Override
    public void foreach(Consumer person) {
        spieces.forEach(System.out::println);
    }









   */
/* @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public List<Person> findByAge(int age) {
        List<Person> foundByAge = new LinkedList<>();
        for (Person p: persons)
            if (p.getAgeFromPESEL()>age)
                foundByAge.add(p);
        return foundByAge;
    }

    @Override
    public Person getById(int id) {
        Person pp=null;
        try {
            for (Person p : persons)
                if (id == p.getId())
                    pp=p;
        } catch (NullPointerException e) {
            System.out.println("Podaj poprawne ID");
        }
        return pp;
    }

    @Override
    public Optional<Person> findById(int id) {
        Person pp=null;
        try{
            for (Person p: persons)
                if (p.getId()==id)
                    pp=p;
        }
        catch (NullPointerException e) {
            System.out.println("Nie ma podanego ID");
        }
        return Optional.ofNullable(pp);
    }

    @Override
    public List<Person> findByPredicate(Predicate<Person> personPredicate) {
        return persons.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findAllOrderedBy(Comparator<Person> order) {
        return persons.stream()
                .sorted(order)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getAllIds() {
        List<Long> ids=new LinkedList<>();
        for(Person p:persons)
            ids.add((long) p.getId());
        ids.sort(Comparator.naturalOrder());
        return ids;
    }

    @Override
    public void foreach(Consumer<Person> person) {
        persons.forEach(System.out::println);
    }*//*

}
*/
