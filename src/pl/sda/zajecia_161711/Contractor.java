package pl.sda.zajecia_161711;

public class Contractor extends Employee{

        double salary;
        double hours=8;

        public double getSalary() {
            return salary*hours;
        }

        public Contractor(String firstName, String lastName, int yearOfBirth, double salary) {
            super(firstName, lastName, yearOfBirth);
            this.salary = salary;
        }
        public void whoAmI (){
            super.whoAmI();
            System.out.print(" i zarabiam "+getSalary());
            System.out.println();
        }
    }
