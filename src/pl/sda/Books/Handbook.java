package pl.sda.Books;

import java.time.LocalDate;

public class Handbook extends Book{

    protected static int counterHandbook;
    protected int whichClass;

    public Handbook(int ID, Author author, String title, int yearOfBook, BookKind bookKind,int whichClass) {
        super(ID,author, title, yearOfBook,bookKind);
        this.whichClass= whichClass;
        counterHandbook++;
    }

    public static int getter() {
        return counterHandbook;
    }
    @Override
    public boolean isOld() {
        return LocalDate.now().getYear()-this.yearOfBook>maxYear/2;
    }

    @Override
    public String toString() {
            return super.toString()+" for class: "+this.whichClass;
    }
}
