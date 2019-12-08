package pl.sda.Apartament;
import java.util.*;

public class Main {

    public static void main(String[] args) {

Adress appAdress = new Adress("Polna", 5,"Wrocław");
        Adress ownerAdress = new Adress("Szczecinska",5,3,"Wrocław");
Person owner = new Person("Adam","Adamski",ownerAdress.toString());

Room room1 = new Room(35,2);
Room room2 = new Room(12,1);
        Kitchen kitchen = new Kitchen(11,ISOPEN.ZAMKNIĘTA);

List <Space> spaces = new LinkedList<>();
spaces.add(0,room1);

        System.out.println(room1);
        System.out.println(room2);
        System.out.println(kitchen);
        System.out.println();

        Apartament apartament = new Apartament(owner,appAdress);
        apartament.addRoom(25,3);
        apartament.addRoom(22,1);
        apartament.addKitchen(22,ISOPEN.OTWARTA);

        apartament.printInfo();
    }
}