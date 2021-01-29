package main.java;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
     public static void main(String[] args) {
       String contents = new String(Files.readAllBytes(
           Paths.get("../Document/My_CV.pages")), StandardCharsets.UTF_8);
       List<String> words = Arrays.asList(contents.split("\\PL+"));
       
       long count = 0;
       for(String w : words) {
           if(w.length() > 12) {
               count++;
               System.out.println(count);
           }
           count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
       }
    }
}
