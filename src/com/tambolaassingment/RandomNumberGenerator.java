package com.tambolaassingment;

import java.util.HashSet;


public class RandomNumberGenerator {
    static int[] arr = new int[91];
    static HashSet<Integer> generatedNumbers = new HashSet<>();
    public static int number_generator() {
        int random_number;
        while (true) {
            random_number = (int) (Math.random() * (90) + 1);
            if (arr[random_number] == 0) {
                arr[random_number] = 1;
                break;
            }
        }
        TambolaBoard.tambolaBoard.replace(random_number,true);
        generatedNumbers.add(random_number);
        System.out.println("\nGenerated number is :" + random_number);
        return random_number;
    }

}



