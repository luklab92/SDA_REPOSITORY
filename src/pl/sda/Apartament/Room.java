package pl.sda.Apartament;

public class Room extends Space {
int forHowMany;
    public Room(double size, int forHowMany) {
        super(size);
        this.forHowMany=forHowMany;
    }
    public String toString() {
        return "Rozmiar pokoju: "+this.size+"m2, przeznaczony dla "+this.forHowMany+" osób";
    }
}
