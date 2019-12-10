package pl.sda.prework_programowanie1;

import java.util.regex.Pattern;

public class Pesel {
    private final String value;


    public Pesel(String value) {
        this.value = value;
    }


    public static boolean peselValidator (String value) {
                if (value == null) throw new InvalidPeselException();
                if (!isOnlyNumber(value)) throw new InvalidPeselException();
                if (!isPESELnumberCorrect(value)) throw new InvalidPeselException();
        return true;
    }

    private static boolean isOnlyNumber(String value) {
        if (value.length()!=11) throw new InvalidPeselException();
        Pattern pattern = Pattern.compile("\\D");
        if (pattern.matcher(value).matches()) throw new InvalidPeselException();
        return true;
        }

        private static boolean isPESELnumberCorrect(String value) {
        int sum=0;
        int[] weights = {9,7,3,1,9,7,3,1,9,7};
        for (int i = 0; i <value.length()-1 ; i++) {
            sum+= (Integer.parseInt(value.split("")[i])*weights[i]);
        }
        int result = sum%10;
        return (result==Integer.parseInt(value.split("")[10]));
    }
    }
