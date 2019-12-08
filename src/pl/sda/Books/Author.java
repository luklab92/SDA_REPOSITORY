package pl.sda.Books;

public class Author {
    protected String firstName;
    protected String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String toString () {
        return this.firstName+" "+this.lastName;

    }
}
