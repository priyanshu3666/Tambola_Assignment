package com.tambolaassingment;

import java.io.File;
import java.io.IOException;

class GameExecutor extends Thread {
    public static void main(String[] args) throws IOException, InterruptedException {
        String filepath = "C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt";
        File f = new File(filepath);
        if (f.exists()) {
            f.delete();
        }
        System.out.println("Let's Begin the Tambola game \n");
        RandomNumberGenerator numbergenerator = new RandomNumberGenerator();
        TambolaBoard board = new TambolaBoard();
        Player player1 = new Player("Priynashu");
        Player player2 = new Player("Yansh");
        while (true) {
            Thread numbergeneratorthread = new Thread(numbergenerator);
            Thread player1thread = new Thread(player1);
            Thread player2thread = new Thread(player2);
            numbergeneratorthread.start();
            numbergeneratorthread.join();
            board.generatedNumberFileReader();
            player1thread.start();
            player1thread.join();
            player2thread.start();
            player2thread.join();
        }
    }
}

