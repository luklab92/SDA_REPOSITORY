package pl.sda.Apartament;

public class Space {

    double size;

Space() {

}

Space(double size) {
    this.size=size;
}
public double getArea () {
    return this.size;
}

    public String toString() {
        return "Rozmiar pomieszczenia: "+this.size;
    }
}
