package pl.sda.programowanie2_prework;

public class Point2D {
private double x;
private double y;

    public Point2D() {
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getDistanceFromCenter() {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    public double getDistanceFromPoint(Point2D point){
        return (Math.sqrt(Math.pow(x-point.getX(),2)+Math.pow(y-point.getY(),2)));
    }

    public void move(double deltaX, double deltaY) {
        setX(x+deltaX);
        setY(y+deltaY);
    }
}
