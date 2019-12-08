/*
package pl.sda.Books;
import java.sql.SQLOutput;
import java.util.*;

public class Librarist{

    private List<Book> books;
    Library lib = new Library();


    public Librarist() {
    }

    public Librarist(List<Book> books) {
        this.books = books;
    }

public void printLibralisInfo() {
    System.out.println("1. Wyświetl wszystkie książki");
    System.out.println("2. Wyświetl wszystkie wypożyczone książki");
    System.out.println("3. Wyświetl wszystkie książki dostępne do wypożyczenia");
    System.out.println("4. Usuń stare książki");
    System.out.println("5. Dodaj użytkownika");
    System.out.println("6. Koniec");

}

    public void printAll() {
        for (Book book : books) {
            System.out.println(book);
        }

    }
        public void printAllBorrowedBooks(){

            lib.printBorrowed();
            System.out.println(lib.borrowedBooks.size());


        }
        public void libraristMenu () {
            int yourType =0;

                while (yourType != 6) {
                    printLibralisInfo();
                    try {
                        Scanner scanner = new Scanner(System.in);
                        yourType = scanner.nextInt();
                    switch (yourType) {
                        case 1:
                            printAll();
                            break;
                        case 2: printAllBorrowedBooks();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            return;
                        default:
                            System.out.println("Podaj odpowiednią liczbę");
                    }
                }
                      catch (InputMismatchException ex) {
                        System.out.println("Podaj liczbę");
                    }
                }


    }


}
*/
