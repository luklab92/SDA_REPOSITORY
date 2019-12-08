package pl.sda.zajecia;

public class table {



    static void helloFriends (String[] args) {
        String[] friends ={ "John", "Adam", "Marc"};
        for (int i =0; i<3; i++) {
            System.out.println("Hello " + friends[i]);
        }
    }




    public static void main(String[] args) {
String[] friends ={ "John", "Adam", "Marc"};
        System.out.println(friends.length);

        int[] numbers = {14,8,4};
        //przypisanie wartosciz pozycji 2 na pozycje 0
        numbers[0]= numbers[2];
        numbers[2] = 0;
        for (int i=0; i<numbers.length;i++) {
            System.out.print(numbers[i] +" ");
        }


    }
}
