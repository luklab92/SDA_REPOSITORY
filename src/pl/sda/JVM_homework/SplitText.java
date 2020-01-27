package pl.sda.JVM_homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class SplitText {

    private String read() throws FileNotFoundException {
        StringBuilder text= new StringBuilder();
        Scanner scanner = new Scanner(new File("C:\\program\\result.txt"));
        while (scanner.hasNextLine()) {
            text.append(" ").append(scanner.nextLine());
        }
        return text.toString();
    }

    private List<String> SplitAndAddToSortedList() throws FileNotFoundException {
        String text = read();
        List<String> tempList = new ArrayList<>(Arrays.asList(text.toLowerCase().split("[, !;?.@'\"-/|>\\s\\r\\n]")));
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).equals("")) tempList.remove(i);
            if (tempList.get(i).length() <= 2) tempList.remove(i);
        }
        return tempList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<Strings> ReturnSortedResult() throws FileNotFoundException {
    List<String> temp2 = SplitAndAddToSortedList();
        List<Strings> tempx = new LinkedList<>();
        int counter = 1;
        for (int i = 0; i <temp2.size()-1; i++) {
            if (temp2.get(i+1).equals(temp2.get(i))) {
                counter++;
                }
            else {
                Strings s = new Strings(temp2.get(i),counter);
                counter =1;
                tempx.add(s);
            }
            }
        return tempx.stream()
                .sorted(Strings::compareTo)
                .limit(5)
                .collect(Collectors.toList());
    }
}
