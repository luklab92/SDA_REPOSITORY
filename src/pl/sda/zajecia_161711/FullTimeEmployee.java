package pl.sda.zajecia_161711;

public class FullTimeEmployee extends Employee {
    double salary;

    public double getSalary() {
        return salary;
    }

    public FullTimeEmployee(String firstName, String lastName, int yearOfBirth, double salary) {
        super(firstName, lastName, yearOfBirth);
        this.salary = salary;
    }
    public void whoAmI (){
        super.whoAmI();
        System.out.print(" i zarabiam "+getSalary());
        System.out.println();
}
    }
