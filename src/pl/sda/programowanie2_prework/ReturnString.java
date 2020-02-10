package pl.sda.programowanie2_prework;

public class ReturnString {

    private String[] splitText(String inputString) {
    String firstLetterUpper = Character.toUpperCase(inputString.charAt(0)) + inputString.substring(1);
    if (firstLetterUpper.contains(" - ")) return firstLetterUpper.split(" ");
    else return firstLetterUpper.replace("-"," - ").split(" ");

    }

    private String[] firstLetterIsUpper(String inputString) {
        String[] splited = splitText(inputString);
        String[] result = new String[splited.length];
        for (int i = 0; i < splited.length; i++) {
            result[i] = Character.toUpperCase(splited[i].charAt(0)) + splited[i].substring(1);
        }
        return result;
    }
    public String buildAString(String inputString) {
    if (inputString==null) throw new NullPointerException();
    else if (inputString.equals("")) return "";
        else {
            StringBuilder mergedString = new StringBuilder();
            for (String s : firstLetterIsUpper(inputString)) {
                mergedString.append(s).append(" ");
            }
            return mergedString.toString().substring(0, mergedString.length() - 1);
        }
    }
}
