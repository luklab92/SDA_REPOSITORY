package pl.sda.Books;

public class Shelf extends Book{
    public Book[] books;

    public Shelf(Book[] books) {
        this.books = books;
    }

    public void printInfo () {
        for (Book element: books) {
            System.out.println(element);
        }
    }
    /*public void printOld () {
        for (Book element:books) {
            if (element.isOld()) {
                System.out.println(element);
                }
            }
        }*/
}
