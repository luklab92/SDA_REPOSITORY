package pl.sda.homework;
public class homework2 {
    static int isModulo (double valA, double valB) {
        double valC = valA/valB;
        double full = (int)valC;
        double rest = valC-full;
        if(rest==0) {
           return (int)rest;
        }
        return (int)Math.round((rest*valB));
    }

    static boolean isPalindrome (String text) {
        String[] everyLetter = text.replace(" ", "").toLowerCase().split("");
        String s = String.join("", everyLetter);
        for (int j = 0; j < everyLetter.length/2; j++) {
             if (s.charAt(j) != s.charAt(s.length()-j-1)){
                    System.out.println(everyLetter[j] + ' ' +  everyLetter[everyLetter.length-1-j]);
                    return false;
                }
        }
        return true;
    }

    static double force(int a, int b) {
        double c = a;
        if (b < 0) {
         c=1/c;
            for (int i = 1; i <-b; i++) {
                c/=a;
            }
        }
        else if (b == 0) {
            return 1;
        }
        else {
            for (int i = 1; i < b; i++) {
                c *= a;
            }
        }
        return c;
    }
    public static void main(String[] args) {
int modulo = isModulo(19,6);
        System.out.println(modulo);

        System.out.println(isPalindrome("ab c b b cba"));

        System.out.println(force(3,2));

    }
}