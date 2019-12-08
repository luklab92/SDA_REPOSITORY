package pl.sda.zajecia;

public class minimum {

    static int Minimum(int x, int y) {
        if (x < y) {
            return x;
        } else {
            return y;
        }
    }



    public static void main(String[] args) {
        int x = Minimum(5,5);
        System.out.println(x);
    }
}



