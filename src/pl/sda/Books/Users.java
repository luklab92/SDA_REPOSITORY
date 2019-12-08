package pl.sda.Books;
import pl.sda.zajecia_161711.*;

import java.util.*;

public class Users extends Person {
private int id;

Users() {

}
    public Users(int id, String firstName, String lastName) {
        super(firstName, lastName);
        this.id=id;
    }
    Map<String,Person> userList = new HashMap<>();
    //List<Users> userList = new LinkedList<>();

    public void print() {
        for (Person user: userList.values()) System.out.println(user);
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return this.id+ " "+this.firstName+ " "+this.lastName;
    }

}
