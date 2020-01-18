package pl.sda.sortAlgorithms;

public class ResultsOfSorting {

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

    public int getSortId() {
        return sortId;
    }

    public String getSortName() {
        return SortName;
    }

    public long getSortDuration() {
        return sortDuration;
    }

    public int getSortLenghth() {
        return sortLenghth;
    }
}
