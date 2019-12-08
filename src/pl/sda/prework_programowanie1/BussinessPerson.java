package pl.sda.prework_programowanie1;

public class BussinessPerson extends Person {
private String NIPnumber;
    public BussinessPerson(String firstName, String lastName, String PESELnumber,String NIPnumber) {
        super(firstName, lastName, PESELnumber);
        this.NIPnumber=NIPnumber;
    }

    @Override
    protected String getNip() {
        return NIPnumber;
    }
}
