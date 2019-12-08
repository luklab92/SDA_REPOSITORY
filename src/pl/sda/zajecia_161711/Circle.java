package pl.sda.zajecia_161711;

public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    public double getArea () {
        return Math.PI*this.radius*this.radius;
    }
    public void whoAmI () {
        System.out.print("Circle ");
    }
    public void print() {
        whoAmI();
        System.out.printf(": %.2f",getArea());
        System.out.println();

    }

}
