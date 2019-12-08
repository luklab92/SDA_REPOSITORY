package pl.sda.zajecia_161711;

public class OrderItemWithPackage extends OrderItem {
    String packageName;
    private double recognizance;

    OrderItemWithPackage() {

    }
    public OrderItemWithPackage(String name, int howMany, double partPrice, String packageName, double recognizance) {
        super(name, howMany, partPrice);
        this.packageName = packageName;
        this.recognizance = recognizance;
    }
    public double getRecognizance () {
        return recognizance;
    }

    public double getValue () {
        return super.getValue() + getRecognizance()*howMany;
    }


    public void print () {
        super.print();
        System.out.print(" "+packageName+" "+getRecognizance());
    }
}
