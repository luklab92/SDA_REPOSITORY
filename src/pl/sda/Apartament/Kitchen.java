package pl.sda.Apartament;

public class Kitchen extends Space{
    ISOPEN isOpen;


    public Kitchen(double size, ISOPEN isOpen) {
        super(size);
        this.isOpen=isOpen;
    }

    boolean isOpen (ISOPEN isOpen) {
        return (isOpen(ISOPEN.OTWARTA));
    }

    @Override
    public String toString() {
        return "Rozmiar kuchni: "+this.size+"m2, kuchnia jest "+this.isOpen;
    }
}
