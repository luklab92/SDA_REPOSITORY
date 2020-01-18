package pl.sda.sortAlgorithms;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class CompareSort {

    private List<ResultsOfSorting> resultsOfSorting = new LinkedList<>();

    private List<Integer> createRandomShuffleList(int a) {
        List<Integer> testList = new LinkedList<>();
        for (int i = 1; i <= a; i++) {
            testList.add(i);
        }
        Collections.shuffle(testList);
        return testList;
    }

    private List<String> createRandomStringLIst(int a) {
        List<String> testList = new LinkedList<>();
        for (int i = 0; i < a; i++) {
            testList.add(RandomStringUtils.randomAlphabetic(5, 10));
        }
        return testList;
    }

    public List<ResultsOfSorting> sortStringCompare(List<Integer> list) {
        List<SortAlgorithm> sortAlgorithms = asList(new quickSort(), new BubbleSort(), new ChoiceSort(), new HybridSort(), new HeapSort());
        int counter = 1;
        List<ResultsOfSorting> resultList = new LinkedList<>();
        List<String> testStringList;
        for (Integer integer : list) {
            testStringList = createRandomStringLIst(integer);
            System.out.println("Sortowana lista: " + testStringList);
            for (SortAlgorithm s : sortAlgorithms) {
                System.out.println(s.sayHello());
                long startTime = System.nanoTime();
                s.sort(testStringList, String::compareTo);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000;
                //durationList.add(duration);
                ResultsOfSorting res = new ResultsOfSorting(counter, s.sayHello(), duration, getList().size());
                System.out.println("Sortowanie trwało: " + duration + "ms");
                System.out.println("Dlugosc listy: " + testStringList.size() + "\n");
                ResultsOfSorting result = new ResultsOfSorting(counter, s.sayHello(), duration, testStringList.size());
                resultsOfSorting.add(result);
                counter++;
                resultList.add(res);
            }
            printStringResults();
        }
        return resultList;
    }

    public void sortCompare(List<Integer> list) {
        List<SortAlgorithm> sortAlgorithms = asList(new quickSort(), new BubbleSort(), new ChoiceSort(), new HybridSort(), new HeapSort());
        List<Integer> testList2 = new LinkedList<>();
        int counter = 1;
        for (Integer integer : list) {
            testList2 = createRandomShuffleList(integer);
            System.out.println("Sortowana lista: " + testList2);
            for (SortAlgorithm s : sortAlgorithms) {
                System.out.println(s.sayHello());
                long startTime = System.nanoTime();
                System.out.println(s.sort(testList2, Integer::compareTo));
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000;
                System.out.println("Sortowanie trwało: " + duration + "ms");
                System.out.println("Dlugosc listy: " + testList2.size());
                System.out.println();
                ResultsOfSorting result = new ResultsOfSorting(counter, s.sayHello(), duration, testList2.size());
                resultsOfSorting.add(result);
                counter++;
            }
            printResults();
        }
    }

    public List<ResultsOfSorting> getList() {
        return resultsOfSorting;
    }

    private void printResults() {
        //System.out.println("Sortowana lista: " + testList2);
        System.out.println("Długość listy: " + getList().size());
        System.out.println("Najkrótsze sortowanie: " + findIndexOfFastestLongest().get(0).getSortName() + " " + findIndexOfFastestLongest().get(0).getSortDuration() + "ms");
        System.out.println("Najdłuższe sortowanie: " + findIndexOfFastestLongest().get(1).getSortName() + " " + findIndexOfFastestLongest().get(1).getSortDuration() + "ms");
        System.out.println();
        findIndexOfFastestLongest().clear();
    }

    private void printStringResults() {
        //System.out.println("Sortowana lista: " + testList2);
        System.out.println("Długość listy: " + getList().size());
        System.out.println("Najkrótsze sortowanie: " + findIndexOfFastestLongest().get(0).getSortName() + " " + findIndexOfFastestLongest().get(0).getSortDuration() + "ms");
        System.out.println("Najdłuższe sortowanie: " + findIndexOfFastestLongest().get(1).getSortName() + " " + findIndexOfFastestLongest().get(1).getSortDuration() + "ms");
        System.out.println();
        findIndexOfFastestLongest().clear();
    }

    private List<ResultsOfSorting> findIndexOfFastestLongest() {
        List<ResultsOfSorting> fastestLongest = new LinkedList<>();
        ResultsOfSorting min = resultsOfSorting.get(resultsOfSorting.size() - 1);
        for (int i = resultsOfSorting.size() - 4; i < resultsOfSorting.size(); i++) {
            if (resultsOfSorting.get(i).getSortDuration() < min.getSortDuration()) {
                min = resultsOfSorting.get(i);
            }
        }
        ResultsOfSorting max = resultsOfSorting.get(resultsOfSorting.size() - 1);
        for (int i = resultsOfSorting.size() - 4; i < resultsOfSorting.size(); i++) {
            if (resultsOfSorting.get(i).getSortDuration() > max.getSortDuration()) {
                max = resultsOfSorting.get(i);
            }
        }
        fastestLongest.add(min);
        fastestLongest.add(max);

        return fastestLongest;
    }
}
