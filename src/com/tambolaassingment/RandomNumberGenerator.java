package com.tambolaassingment;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class RandomNumberGenerator extends Thread {
    int[] arr = new int[91];

    public int number_generator() {
        int random_number;
        while (true) {
            random_number = (int) (Math.random() * (90) + 1);
            if (arr[random_number] == 0) {
                arr[random_number] = 1;
                break;
            }
        }
        System.out.println("\nGenerated number is :" + random_number);
        return random_number;
    }

    @Override
    public void run() {

        String filepath = "C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt";
        try {
            FileWriter fileWriter = new FileWriter(filepath, true);
            fileWriter.write(number_generator() + "\n");
            fileWriter.close();
            sleep(1000);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}



