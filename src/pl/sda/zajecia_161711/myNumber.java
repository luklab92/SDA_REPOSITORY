package pl.sda.zajecia_161711;

public class myNumber {
    public int number;


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
        if (number<0) {
            System.out.println("podana wartosc jest mniejsza od 0");
        }
        this.number=0;
    }



    public boolean isEven() {
        return this.number%2==1;
    }
    public int add(int number) {
        this.number +=number;
        return this.number;
    }

   public myNumber(int number) {
        this.number=number;
    }


}
