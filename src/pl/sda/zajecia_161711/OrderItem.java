package pl.sda.zajecia_161711;

public class OrderItem {
    private String name;
     protected int howMany;
    private double partPrice;


    public OrderItem() {

    }
    public OrderItem(String name,int howMany, double partPrice) {
        this.howMany=howMany;
        this.partPrice=partPrice;
        this.name=name;
    }

    public double getValue () {
        return howMany*partPrice;

    }
    boolean isCorrect () {
        return (this.howMany>0 && this.partPrice>0);
    }
    public void print () {
        if (this.isCorrect())
            System.out.println();
        System.out.print(this.name+ " " + this.partPrice +"zł za "+this.howMany + " sztuk "+ getValue());
    }

}
