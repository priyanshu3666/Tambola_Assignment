package com.tambolaassingment;

import java.io.File;

public class GameExecutor implements  Runnable{

    static int randomNumberGenerated=0;
    final static String filepath = "C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt";


    @Override
    public void run() {
        while(!Player.housieStatus) {
            randomNumberGenerated = RandomNumberGenerator.number_generator();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args)  {
        File f = new File(filepath);
        if (f.exists()) {
            f.delete();
        }
        System.out.println("Let's Begin the Tambola game \n");
        var board = new TambolaBoard();
        GameExecutor gameExecutor = new GameExecutor();
        Thread gameExecutorThread = new Thread(gameExecutor);
        Player player1 = new Player("Priyanshu",0);
        Player player2 = new Player("Yansh",1);
        Thread player1thread = new Thread(player1);
        Thread player2thread = new Thread(player2);
        gameExecutorThread.start();
        player1thread.start();
        player2thread.start();
        }
    }

