package com.tambolaassingment;

import java.util.HashSet;


public class RandomNumberGenerator {
    static int[] arr = new int[91];
    static HashSet<Integer> generatedNumbers = new HashSet<>();
    private RandomNumberGenerator() {
    }

    public static int numberGenerator() {
        int randomNumber;
        while (true) {
            randomNumber = (int) (Math.random() * 90 + 1);
            if (arr[randomNumber] == 0) {
                arr[randomNumber] = 1;
                break;
            }
        }

        generatedNumbers.add(randomNumber);
        System.out.println("\nGenerated number is :" + randomNumber);
        return randomNumber;
    }

}



