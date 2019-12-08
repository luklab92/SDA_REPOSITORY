package pl.sda.Books;

public class Biography extends Book{
protected boolean isAuto;
protected static int counterBiography;


    public Biography(int ID,Author author, String title, int yearOfBook, BookKind bookKind,boolean isAuto) {
        super(ID,author, title, yearOfBook,bookKind);
        this.isAuto = isAuto;
        counterBiography++;
    }

    public static int getter() {
        return counterBiography;
    }


    @Override
    public String toString() {
        /*if (isAuto)
            return "Biography - "+super.toString()+" - autobiography";
        else return "Biography - "+super.toString();*/
        String info= super.toString();
        return isAuto ? info+=" autobiography":" biography";
    }


}



