package pl.sda.Books;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<Book> borrowedBooks = new ArrayList<>();
    private String password = "abc123";
    private List<Users> userList;
    private int actualUserId=0;
    private Map<String,Users>bookToUser = new HashMap<>();
   // private Map<Integer,Person> users;


    //KONSTRUKTORY

    public Library(List<Book> books) {
        this.books = books;
        this.userList = new LinkedList<>();
    }

    // LISTA UZYTKOWNIKOW I LISTA KSIAZEK


    private void myUserList (){
        Users firstUser = new Users(1,"Agnieszka","Labusek");
        Users secondUser = new Users(2,"Marek","Marecki");
        Users thirdUser = new Users(3,"Magda", "Mończyk");
        Users fourthUser = new Users(4,"John","Brooks");
        userList.add(firstUser);
        userList.add(secondUser);
        userList.add(thirdUser);
        userList.add(fourthUser);
    }


    //PRINT DESCRIPTIONS
    private void printOptions() {
        System.out.println("/////// WYBIERZ OPCJĘ ///////");
        System.out.println("1. Wyświetl wszystkie książki");
        System.out.println("2. Wyświetl wszystkie podręczniki");
        System.out.println("3. Wyświetl wszystkie książki dla danej klasy");
        System.out.println("4. Wypożycz");
        System.out.println("5. Cofnij");
        System.out.println();
        System.out.println("Podaj odpowiednią wartość");
    }

    private void printLibralistInfo() {
        System.out.println("/////// WYBIERZ OPCJĘ ///////");
        System.out.println("1. Wyświetl wszystkie książki");
        System.out.println("2. Wyświetl wszystkie wypożyczone książki");
        System.out.println("3. Wyświetl wszystkie książki dostępne do wypożyczenia");
        System.out.println("4. Usuń stare książki");
        System.out.println("5. Dodaj użytkownika");
        System.out.println("6. Cofnij");
    }

    private void printChoice() {
        System.out.println("/////// WYBIERZ OPCJĘ ///////");
        System.out.println("1 - User mode");
        System.out.println("2 - Libralist mode");
        System.out.println("9 - Exit");
    }


    private void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void addUser(int nr, String firstName, String lastName) {
        Users user = new Users(nr,firstName,lastName);
        this.userList.add(user);
    }

    private void addUserToLibrary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kolejne ID użytkownika: ");
        int id;
        id = scanner.nextInt();
        if (id!=userList.size()+1) System.out.println("Podaj poprawne ID");
        else {
            System.out.println("Podaj Imię użytkownika: ");
            scanner.nextLine();
            String first = scanner.nextLine();
            //scanner.nextLine();
            System.out.println("Podaj nazwisko użytkownika: ");
            String last = scanner.nextLine();
            addUser(id, first, last);
            System.out.println("Aktualna lista użytkowników");
            printUsers();
            System.out.println();
        }
    }

    private void printBooks() {
        for (Book book : books) {
            if (book.bookKind == BookKind.HANDBOOK) {
                System.out.println(book);
            }
        }
    }

    private void printBorrowed() {
        for (Book book : borrowedBooks)
            System.out.println(book);
    }


    private void printBorrowedByUser() {
        for (Book book : borrowedBooks)
            bookToUser.put(book.print(),userList.get(book.getBookID()-1));
        System.out.println(bookToUser);
            //System.out.println(userList.get(book.getBookID()-1) +"   :     "+book);
    }

    private void printHandBookforClass(int classNumber) {
        int counter = 0;
        for (Book book : books) {
            if (book.bookKind == BookKind.HANDBOOK && ((Handbook) book).whichClass == classNumber) {
                counter++;
                System.out.println(book);
            }
        }
        if (counter == 0) System.out.println("Brak podręczników dla klasy " + classNumber);
    }

    private void checkHandBook() {
        System.out.println("Podaj numer klasy");
        try {
            Scanner scanner = new Scanner(System.in);
            int classNumber = scanner.nextInt();
            if (classNumber < 1 || classNumber > 12) System.out.println("podaj prawidłową klasę");
            else printHandBookforClass(classNumber);
        } catch (InputMismatchException ex) {
            System.out.println("Podaj liczbę");
        }
    }

    private void setBookBorrowed(int bookNumber) {
        for (Book book : books) {
            if (book.getID() == bookNumber) {
                book.setBorrowed(true);
                borrowedBooks.add(book);
                book.setID(actualUserId);
            }
        }
    }

    private void printAvailableBooks() {
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        printAvailableBooks();
        try {
            System.out.println("Podaj nr książki");
            Scanner scanner = new Scanner(System.in);
            int bookNumber = scanner.nextInt();
            setBookBorrowed(bookNumber);
            System.out.println("Wypożyczone książki: ");
            printBorrowed();
        } catch (InputMismatchException ex) {
            System.out.println("niepoprawny numer");
        }
    }

    private void removeOld () {
        books.removeIf(Book::isOld);
    }

    private void choiceUser () {
        int typeID;
        printUsers();
        System.out.println("9 Exit");
        System.out.println("Podaj numer czytelnika");
        Scanner scanner = new Scanner(System.in);
        typeID = scanner.nextInt();
            if (typeID!=9) {
            for (Users user : userList) {
                if (typeID == user.getId()) {
                    actualUserId = typeID;
                    System.out.println("Jesteś: " + user);
                }
            }userMenu();
            }
            choiceMenu();
    }

   private boolean typePassword()  {
       System.out.println("Podaj hasło");
       Scanner scanner = new Scanner(System.in);
       String typed = scanner.nextLine();
       return (typed.equals(password));
   }
    private void printUsers() {
        if (userList.size()==0) myUserList();

        for (Users us:userList) System.out.println(us);
    }

    //MENU
    public void choiceMenu () {
        int choice = 0;

        while (choice!=9) {
            printChoice();
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        choiceUser();
                        break;
                    case 2:
                        while(!typePassword()) System.out.println("Podaj prawidłowe hasło");
                        libraristMenu();
                        break;
                    case 9:
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

    private void userMenu() {
        int firstLine = 0;
        while (firstLine != 5) {
        printOptions();
        Scanner scanner = new Scanner(System.in);
        firstLine = scanner.nextInt();
            switch (firstLine) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    printBooks();
                    break;
                case 3:
                    checkHandBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("podaj odpowiednią wartość");
            }
        }
    }

    private void libraristMenu() {
        int yourType = 0;

        while (yourType != 6) {
            printLibralistInfo();
            try {
                Scanner scanner = new Scanner(System.in);
                yourType = scanner.nextInt();


                switch (yourType) {
                    case 1: printAllBooks();
                        break;
                    case 2:
                        printBorrowedByUser();
                        break;
                    case 3: printAvailableBooks();
                        break;
                    case 4: removeOld();
                        break;
                    case 5:
                        printUsers();
                        addUserToLibrary();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Podaj odpowiednią liczbę");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Podaj liczbę");
            }
        }
    }
}
