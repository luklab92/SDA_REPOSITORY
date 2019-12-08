package pl.sda.zajecia_161711;

public abstract class Employee extends Person {
//private double salary;

//public abstract double getSalary();

    public Employee(String firstName, String lastName, int yearOfBirth) {
        super(firstName, lastName, yearOfBirth,Gender.MAN);
        //System.out.println("tworze employee");
    }
    public abstract double getSalary();
    /*@Override
    public void whoAmI () {
        super.whoAmI();
    }*/
}
