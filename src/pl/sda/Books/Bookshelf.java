package pl.sda.Books;

import java.util.*;

public class Bookshelf {

    private List<Book> books;

    public Bookshelf() {
        this.books = new LinkedList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public void printInfo() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void printDistintNames() {
        Set<String> names = new HashSet<>();
        for (Book b : this.books) {
            names.add(b.getAuthorLastName());
        }

        for (String name : names) {
            System.out.println(name);
        }
    }

    public List<Book> getAllRomance() {
        return getAll(BookKind.ROMANCE);
    }
    public List<Book> getAllHandbook() {
        return getAll(BookKind.HANDBOOK);
    }
    public List<Book> getAllBiography() {
        return getAll(BookKind.BIOGRAPHY);
    }
    public List<Book> getAllRestType() {
        return getAll(BookKind.ANOTHER);
    }

        public List<Book> getAll (BookKind kind){

            List<Book> result = new LinkedList<>();

            for (Book b : books) {
                if (b.bookKind == kind) {
                    result.add(b);
                }
            }
            return result;
        }
    }

