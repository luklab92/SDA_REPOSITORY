package pl.sda.Apartament;
import java.util.*;

public class Apartament extends Person{
private Person owner;
private Adress adress;
private List <Space> spaces;


    Apartament() {}
    public Apartament(Person owner,Adress adress) {
        this.owner = owner;
        this.adress = adress;
        this.spaces = new LinkedList<>();  // trzeba utworzyc liste bo jak nie utworzymy to bedzie null
    }

    public void addRoom(double size, int forHowMany) {
        Space room = new Room (size, forHowMany);
        /*if (this.spaces == null)
        this.spaces = new LinkedList<>();*/
        this.spaces.add(room);

    }
    public void addKitchen(double size, ISOPEN isOpen) {
        Space kitchen = new Kitchen(size, isOpen);
        /*if (this.spaces == null)
            this.spaces = new LinkedList<>();*/
        this.spaces.add(kitchen);

    }

        public void printInfo () {
            System.out.println("Właściciel: "+this.owner);
            System.out.println("Adres: "+this.adress);
            System.out.println("Liczba pomieszczeń: "+spaces.size());
            for (Space element:spaces) {
                System.out.println(element);
            }


}

}
