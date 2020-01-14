package pl.sda.myStructureImplementation;

import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ONP {

    private Stack<Integer> temp;
    private String expression;
    private int x;
    private int y;

    public ONP(String expression) {
        this.expression = expression;
        this.temp = new Stack<>();
    }

    private String[] stringToArray() {
        return this.expression.split(" ");
    }

    private void popElementAndCalculate() {
        x = Integer.parseInt(temp.pop().toString());
        y = Integer.parseInt(temp.pop().toString());
    }

    int ONPCalculation() {
        String[] table = stringToArray();
        Pattern p = Pattern.compile("^([1-9]|[1-9][0-9])$");
        for (String s : table) {
            Matcher m = p.matcher(s);
            boolean b = m.matches();
            if (b) {
                temp.push(Integer.parseInt(s));
            } else if (s.equals("*")) {
                popElementAndCalculate();
                temp.push(mathOperation((x, y) -> x * y));
            } else if (s.equals("/")) {
                popElementAndCalculate();
                temp.push(mathOperation((x, y) -> y / x));
            } else if (s.equals("+")) {
                popElementAndCalculate();
                temp.push(mathOperation(Integer::sum));
            } else if (s.equals("-")) {
                popElementAndCalculate();
                temp.push(mathOperation((x, y) -> x - y));
            } else {
                System.out.println("Błędnie sformułowany ONP");
                break;
            }
        }
        System.out.println(expression);
        return temp.peek();
    }

    private int mathOperation(BiFunction<Integer, Integer, Integer> func) {
        try {
            return func.apply(x, y);
        } catch (Exception e) {
            System.out.println("Błędnie sformułowany ONP");
        }
        return 0;
    }

    //zrobic z zapisu w tradycyjnej notacji do ONP
}
