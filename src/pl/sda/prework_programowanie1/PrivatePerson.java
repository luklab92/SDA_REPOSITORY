package pl.sda.prework_programowanie1;

public class PrivatePerson extends Person{

    public PrivatePerson(String firstName, String lastName, String PESELnumber) {
        super(firstName, lastName, PESELnumber);
    }

    @Override
    protected String getNip() {
        return super.getNip();
    }
}
