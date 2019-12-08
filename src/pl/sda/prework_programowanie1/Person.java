package pl.sda.prework_programowanie1;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Person implements PersonRepository{
    private String firstName;
    private String lastName;
    private String PESELnumber;
    public List<Person> persons;
    private List<Person> findByAge=new LinkedList<>();
    private List<Long> getIds=new LinkedList<>();
    private int id;

    public Person() {
    }


    public Person(String firstName, String lastName, String PESELnumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESELnumber = PESELnumber;
        //this.id=id;
    }
    public Person(List<Person> persons) {
        this.persons = persons;
    }


    private int setID (int id) {
        this.id = id;
        return id;
    }

    public int getId() {
        return id;
    }

    public void automaticalSetId() {
        id =1;
        for(Person p:persons) {
            p.setID(id);
            id++;
        }
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public List<Person> findByAge(int age) {
        for (Person p: persons)
            if (p.getAgeFromPESEL()>age)
                findByAge.add(p);
        return findByAge;
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
        return persons;
    }

    @Override
    public List<Long> getAllIds() {
        for(Person p:persons)
            getIds.add((long) p.getId());
        getIds.sort(Comparator.naturalOrder());
        return getIds;
    }

    @Override
    public void foreach(Consumer<Person> person) {
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person prePerson = (Person) o;
        return Objects.equals(lastName, prePerson.firstName);
    }*/

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    public List<Integer> countSex() {
        List<Integer> list = new LinkedList<>();
        int counterMan=0;
        int counterWoman=0;
        for(Person p:persons)
            if(p.firstName.endsWith("a")) counterWoman++;
            else counterMan++;
        list.add(counterMan);
        list.add(counterWoman);
        return list;
    }
    public void printCount() {
        System.out.println("Liczba mężczyzn: "+countSex().get(0)+", liczba kobiet: "+countSex().get(1));
    }

    @Override
    public String toString() {
        return this.getId()+" "+this.firstName + " " + this.lastName + " " + getAgeFromPESEL();
    }

    protected String getNip() {
        return getPesel();
    }

    public String getPesel() {
        return PESELnumber;
    }
    public boolean isPESELnumberCorrect() throws InvalidPeselException {
        String pesel=getPesel();
        int sum=0;
        int[] weights = {9,7,3,1,9,7,3,1,9,7};
        for (int i = 0; i <pesel.length()-1 ; i++) {
            sum+= (Integer.parseInt(pesel.split("")[i])*weights[i]);
        }
        int value = sum%10;
        if (value==Integer.parseInt(pesel.split("")[10])) return true;
        else throw new InvalidPeselException();
    }
    public int getAgeFromPESEL() {
        int yearOfBirth = 1900+Integer.parseInt(getPesel().split("")[0]+getPesel().split("")[1]);
        if ((Integer.parseInt(getPesel().split("")[0]))>2) return LocalDate.now().getYear() -yearOfBirth;
        return LocalDate.now().getYear() - (yearOfBirth+100);
    }
    public boolean isOlder (int age) {
        return (getAgeFromPESEL()>age);
    }

    public void printOlderThan(int age) {
        for (Person p: persons)
            if (p.getAgeFromPESEL()>age)
                System.out.println(p.toString());
    }

    public String getLastName() {
        return lastName;
    }

}