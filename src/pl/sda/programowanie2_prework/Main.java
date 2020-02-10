package pl.sda.programowanie2_prework;

public class Main {

    public static void main(String[] args) {
        Point2D firstPoint = new Point2D(15,12);
        System.out.printf("%.2f \n",firstPoint.getDistanceFromCenter());
        System.out.printf("%.2f \n",firstPoint.getDistanceFromPoint(new Point2D(10,8)));
        firstPoint.move(5,3);
        System.out.println(firstPoint);
        ReturnString result = new ReturnString();
        System.out.println(result.buildAString("walaszko-nowicka"));
    }
}
