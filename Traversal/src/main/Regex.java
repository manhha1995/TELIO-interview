package main;

import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        String[] arr = new String[] {"(", "(", ")", ",", ")"};
        for(int i = 0; i < arr.toString().length(); i++) {
            Pattern pattern = Pattern.compile("\\(,");
            pattern.matcher(arr[i]);
            System.out.println(arr[i]);
        }
    }
}
