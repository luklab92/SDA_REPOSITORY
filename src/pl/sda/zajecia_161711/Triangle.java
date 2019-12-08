package pl.sda.zajecia_161711;

public class Triangle implements Shape {
    private int length;
    private int heigth;
    public Triangle(int length, int heigth) {
        this.length = length;
        this.heigth = heigth;
    }
    public double getArea () {
        return this.length*this.heigth/2;
    }
    public void whoAmI () {
        System.out.print("Triangle ");
    }
    public void print() {
        whoAmI();
        System.out.println(": "+getArea()+" ");
    }
}
