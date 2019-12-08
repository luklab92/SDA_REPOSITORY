package pl.sda.zajecia_161711;
import org.w3c.dom.ls.LSOutput;

import  java.util.*;

public class PhoneBook {


    private Map<String,String> phoneNumbers;

    public PhoneBook() {
        this.phoneNumbers = new HashMap<>() {
        };
    }
    public void addNumber (String phone, String number) {
        if (number.length()==9 && !this.phoneNumbers.containsKey(phone))
        phoneNumbers.put(phone,number);
    }
    public void getPhoneNumber () {
        System.out.println(this.phoneNumbers);

    }
    public String getNumbers(String name) {
        return this.phoneNumbers.get(name);
    }
    /*public boolean hasNumber (String number) {
         return this.phoneNumbers.containsValue(number);
    }*/
    public boolean hasNumber (String number) {
        boolean isFound = false;
        for (String p:this.phoneNumbers.keySet()) {
            String value = this.phoneNumbers.get(p);
            if (value == number) isFound=true;
        }
        return isFound;
    }
}
