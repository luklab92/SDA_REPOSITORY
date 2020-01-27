package pl.sda.JVM_homework;

public class Strings implements Comparable<Strings> {

    private String name;
    private int value;

    public Strings(String name, int value) {
        this.name = name;
        this.value = value;
    }


    @Override
    public String toString() {
        return name + " "+ value;
    }


    @Override
    public int compareTo(Strings strings) {
        return Integer.compare(strings.value,this.value);
    }
}
