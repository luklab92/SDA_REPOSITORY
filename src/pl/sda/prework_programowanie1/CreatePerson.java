package pl.sda.prework_programowanie1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CreatePerson {
    private String firstName;
    private String lastName;
    private String PESELnumber;
    private List<Person> persons = new LinkedList<>();


    public CreatePerson(String firstName, String lastName, String PESELnumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESELnumber = PESELnumber;
        this.persons = persons;
    }

    public String getFirstName() {
        return firstName;
    }

    protected String getNip() {
        return getPesel();
    }

    public String getPesel() {
        return PESELnumber;
    }

    public String getLastName() {
        return lastName;
    }
}
