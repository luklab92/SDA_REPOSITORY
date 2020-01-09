package pl.sda.sortAlgorithms;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;
import java.util.List;

public class ResultsOfSorting<E> {

    private int sortId;
    private String SortName;
    private long sortDuration;
    private int sortLenghth;

    public ResultsOfSorting(int sortId, String SortName, long sortDuration, int sortLenghth) {
        this.sortId=sortId;
        this.sortDuration=sortDuration;
        this.sortLenghth=sortLenghth;
        this.SortName=SortName;
    }


    @Override
    public String toString() {
        return "ResultsOfSorting{" +
                "sortId=" + sortId +
                ", SortName='" + SortName + '\'' +
                ", sortLenghth=" + sortLenghth +
                ", sortDuration=" + sortDuration;

    }
}
