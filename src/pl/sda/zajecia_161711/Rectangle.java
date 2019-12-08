package pl.sda.zajecia_161711;


public class Rectangle implements Shape {

    /*int width;
    int length;
    Rectangle() {
        System.out.println("hello");
    }

    Rectangle (int width, int length) {
        System.out.println("Tworze obiekt z parametrami");
        this.width=width;
        this.length=length;
    }
    public Rectangle(int side) {
        width=side;
        length=side;
        System.out.println("bok kwadratu = "+side);
    }*/
    public int width;
    public int length;
    public int area;
    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }
    public double getArea () {
        return width*length;
    }
    public void whoAmI () {
        System.out.print("Rectangle ");

    }
    public void print() {
        whoAmI();
        System.out.println(": "+getArea()+" ");
    }

}

