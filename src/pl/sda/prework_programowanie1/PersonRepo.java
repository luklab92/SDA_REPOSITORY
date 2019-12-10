package pl.sda.prework_programowanie1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonRepo implements SpiecesRepository<Person>{
    private List<Person> persons;


    public PersonRepo(List<Person> persons) {
        this.persons = persons;
    }

    public void automaticalSetId() {
      int id =1;
        for(Person p:persons) {
            p.setID(id);
            id++;
        }
    }

    private List<Integer> countSex() {
        List<Integer> list = new LinkedList<>();
        int counterMan=0;
        int counterWoman=0;
        for(Person p:persons)
            if(p.getFirstName().endsWith("a")) counterWoman++;
            else counterMan++;
        list.add(counterMan);
        list.add(counterWoman);
        return list;
    }
    public void printCount() {
        System.out.println("Liczba mężczyzn: "+countSex().get(0)+", liczba kobiet: "+countSex().get(1));
    }

    public void printOlderThan(int age) {
        for (Person p: persons)
            if (p.getAgeFromPESEL()>age)
                System.out.println(p.toString());
    }



    @Override
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
    }
}