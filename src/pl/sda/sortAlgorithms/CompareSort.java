package pl.sda.sortAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CompareSort {

   private List<Long> durationList = new LinkedList<>();
    private List<Integer> testList2 = new LinkedList<>();
    private List<SortAlgorithm> sortAlgorithms = Arrays.asList(new quickSort(), new BubbleSort(), new ChoiceSort(), new HybridSort());
    private List<ResultsOfSorting> ResultsOfSorting = new LinkedList<>();

    private List<Integer> createRandomShuffleList(int a) {
        List<Integer> testList = new LinkedList<>();
        for (int i = 1; i <=a; i++) {
            testList.add(i);
        }
        Collections.shuffle(testList);
        return testList;
    }
    private List<Integer> createReversedList(int a) {
        List<Integer> testList = new LinkedList<>();
        for (int i = 1; i <=a; i++) {
            testList.add(i);
        }
        Collections.reverse(testList);
        return testList;
    }


    public void sortCompare(List<Integer> list) {
        int counter =1;
        for (Integer integer : list) {
            testList2 = createRandomShuffleList(integer);
            for (SortAlgorithm s : sortAlgorithms) {
                //System.out.println(testList2);
                System.out.println(s.sayHello());
                long startTime = System.nanoTime();
                s.sort(testList2);
                //System.out.println(s.sort(testList2));
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000;
                durationList.add(duration);
                System.out.println("Sortowanie trwało: " + duration + "ms");
                System.out.println("Dlugosc listy: "+testList2.size());
                System.out.println();
                ResultsOfSorting result = new ResultsOfSorting(counter,s.sayHello(), duration,testList2.size());
                ResultsOfSorting.add(result);
                counter++;
            }
            printResults();
        }
    }

public List<ResultsOfSorting> getList() {
        return ResultsOfSorting;
}
    private void printResults() {
        for (int i = 0; i <testList2.size(); i++) {
            //System.out.println("Sortowana lista: " + testList2);
            System.out.println("Długość listy: " + testList2.size());
            System.out.println("Najkrótsze sortowanie: " + sortAlgorithms.get(findFastestLongest().get(0)).sayHello() + " " + Collections.min(durationList) + "ms");
            System.out.println("Najdłuższe sortowanie: " + sortAlgorithms.get(findFastestLongest().get(1)).sayHello() + " " + Collections.max(durationList) + "ms");
            System.out.println();
            durationList.clear();
            testList2.clear();
        }
    }

    private List<Integer> findFastestLongest() {
        List<Integer> fastestLongest = new LinkedList<>();
        for (int i = 0; i < durationList.size(); i++) {
            if (durationList.get(i).equals(Collections.min(durationList))) {
                fastestLongest.add(i);
                break;
            }
        }
        for (int i = 0; i < durationList.size(); i++) {
            if (durationList.get(i).equals(Collections.max(durationList))) {
                fastestLongest.add(i);
                break;
            }
        }
        return fastestLongest;
    }
}
