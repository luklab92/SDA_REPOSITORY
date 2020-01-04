package pl.sda.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ONP {
private Stack temp;
private String expression;
private int x;
private int y;

    public ONP(String expression) {
        this.expression = expression;
        this.temp = new Stack();
    }
private String[] stringToArray() {
        return this.expression.split(" ");
}

private void popElementAndCalculate() {
    x = Integer.parseInt(temp.pop().toString());
    y = Integer.parseInt(temp.pop().toString());
}

    public int ONPcalc () {
        String[] table = stringToArray();
        Pattern p = Pattern.compile("^([1-9]|[1-9][0-9])$");
        for (String s : table) {
            Matcher m = p.matcher(s);
            boolean b = m.matches();
            if (b) {
                temp.push(s);
            } else if (s.equals("*")) {
                popElementAndCalculate();
                temp.push(x * y);
            } else if (s.equals("/")) {
                popElementAndCalculate();
                temp.push(y / x);
            } else if (s.equals("+")) {
                popElementAndCalculate();
                temp.push(x + y);
            } else {
                System.out.println("Błędnie sformułowany ONP");
                break;
            }
        }
        System.out.println(expression);
        return (int) temp.peek();
    }

    //zrobic z zapisu w tradycyjnej notacji do ONP
}
