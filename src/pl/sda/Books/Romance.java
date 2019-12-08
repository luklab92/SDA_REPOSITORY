package pl.sda.Books;

public class Romance extends Book{
    protected boolean isForAdult;
    protected static int counterRomance;


    public Romance(int ID,Author author, String title, int yearOfBook, BookKind bookKind, boolean isForAdult) {
        super(ID,author, title, yearOfBook,bookKind);
        this.isForAdult=isForAdult;
        counterRomance++;
    }
public static int getter() {
        return counterRomance;
}

    @Override
    public String toString() {
        if (isForAdult)
        return super.toString()+" - only for Adult";
        else return "Romance - "+super.toString();
    }
}
