package main.java;

import java.io.Console;

public class plusMinus {
     public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        Console console = System.console();
        console.readLine("Hello World");

        int[] arr = new int[] {-4, 3, -9, 0, 4, 1};
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            if( arr[i] > 0) {
                count_1 ++;
               
            } else if (arr[i] == 0) {
                count_2 ++;               
            } else {
            count_3 ++;           
            }            
        }
        System.out.println(count_1);
        System.out.println(count_2);
        System.out.println(count_3);
        System.out.println((float)count_1/n);
        System.out.println((float)count_2/n);
        System.out.println((float)count_3/n);
    }
}