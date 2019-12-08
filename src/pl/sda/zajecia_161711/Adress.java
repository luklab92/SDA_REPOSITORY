package pl.sda.zajecia_161711;

public class Adress {
    private String road;
    private int homeNumber;
    private int apartmentNumber;
    private String city;

    Adress () {
    }

    public Adress(String road, int homeNumber, int apartmentNumber, String city) {
        this.road = road;
        this.homeNumber = homeNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        // System.out.println(this.road+ " "+this.homeNumber+ "/"+this.apartmentNumber+" "+this.city);
    }

    public Adress(String road, int homeNumber, String city) {
        this.road = road;
        this.homeNumber = homeNumber;
        this.city = city;
        // System.out.println(this.road+ " "+this.homeNumber+" "+this.city);
    }

    public String toString() {
        if (this.apartmentNumber!=0)
            return this.road+ " "+this.homeNumber+ "/"+this.apartmentNumber+" "+this.city;
        return this.road+ " "+this.homeNumber+" "+this.city;
    }


    public int getApartmentNumber() {
        return this.apartmentNumber;
    }

    public void print () {
        //System.out.println(this.road+ " "+this.homeNumber+ "/"+this.apartmentNumber+" "+this.city);
    }
}

