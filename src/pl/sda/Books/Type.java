package pl.sda.Books;

public class Type extends Book {
    protected static int restCounter;

    public Type(int ID, Author author, String title, int yearOfBook,BookKind bookKind) {
        super(ID, author, title, yearOfBook,bookKind);
        restCounter++;
    }
    public static int getter() {
        return restCounter;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
