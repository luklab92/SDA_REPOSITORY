package pl.sda.zajecia_161711;

public class Person2 {

    public String firstName;
    public  String lastName;
    public  int dateOfBirth;
    public  char gender;
    public  String town;
    public  String adress;

        public Person2() {
    }
        public Person2(String firstName, String lastName, int dateOfBirth, char gender, String town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.town = town;

    }

    public void printInfo () {
        System.out.print(firstName+" ");
        System.out.println(lastName);
        System.out.println(dateOfBirth);
        System.out.println(gender);
        System.out.println(town);
        System.out.println(adress);

    }

}
