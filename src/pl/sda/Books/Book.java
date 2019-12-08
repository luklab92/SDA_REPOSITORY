package pl.sda.Books;

import java.time.LocalDate;

public class Book {
    Author author;
    private String title;
    protected int yearOfBook;
    protected BookKind bookKind;
    private static int counter;
    protected int maxYear = 10;
    private int ID;
    private boolean isBorrowed;
    private int bookID= 0;
    protected int pagesCount;
    protected boolean hasHardCover;
    protected String ISBNnumber ;


Book (){

    }
    public Book(int ID,Author author, String title, int yearOfBook, BookKind bookKind) {
        this.author = author;
        this.title = title;
        this.yearOfBook = yearOfBook;
        this.bookKind=bookKind;
        this.ID=ID;
       // this.bookID=bookID;
        counter++;
    }


    public Book(int ID,Author author, String title, int yearOfBook, BookKind bookKind, int pagesCount, boolean hasHardCover, String ISBNnumber) {
        this.author = author;
        this.title = title;
        this.yearOfBook = yearOfBook;
        this.bookKind = bookKind;
        this.maxYear = maxYear;
        this.ID = ID;
        this.bookID = bookID;
        this.pagesCount = pagesCount;
        this.hasHardCover = hasHardCover;
        this.ISBNnumber = ISBNnumber;
    }

    public int getYearOfBook() {
        return yearOfBook;
    }

    public Author getAuthor() {
        return author;
    }

    public String getISBNnumber() {
        return ISBNnumber;
    }

    public boolean isHasHardCover(){
    return hasHardCover;
}

    public BookKind getBookKind() {
        return bookKind;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public static int getter() {
        return counter;
    }
    public int setID (int id) {
    this.bookID = id;
    return bookID;
    }
    public int getBookID () {
    return bookID;
    }

    public String getAuthorLastName() {
        return author.lastName;
    }
    public String getAuthorFirstName() {
        return author.firstName;
    }

    public String getTitle() {
        return title;
    }


    public int getID() {
    return ID;
}

public boolean isBorrowed() {
    return isBorrowed;
}
    public void  setBorrowed(boolean borrowed) {
        isBorrowed=borrowed;
    }

    public int setUserNumber (int id) {
    return id;
    }

    public boolean isOld() {
        return (LocalDate.now().getYear()-this.yearOfBook>maxYear);
    }

    public String print() {
         return " author - " +this.author + ", title - " + this.title;
    }

    public String toString() {
        if (isOld()) return "Number of Book "+this.ID+" // old // author - "+this.author + ", title - " + this.title;
return "Numer książki: "+this.ID+" author - "+this.author + ", title - " + this.title;

    }
}
