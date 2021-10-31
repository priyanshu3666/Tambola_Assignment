package com.tambolaassingment;

public class RandomNumberGenerator {
    static int[] arr = new int[91];

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

        TambolaBoard.board.replace(randomNumber, true);
        System.out.println("\nGenerated number is :" + randomNumber);
        return randomNumber;
    }

}



