package pl.sda.Books;

public class BookBox<T>  {
    private T book;

    public BookBox (T book) {
        this.book=book;
    }
    public T getBook() {
        return book;
    }
}
