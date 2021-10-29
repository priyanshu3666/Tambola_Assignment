package com.tambolaassingment;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

class Player implements Runnable {
    public static  boolean housieStatus = false;
    private boolean  printedOnce = true;
    private  int totalCountNumbersPlayer0 = 0;
    private  int totalCountNumbersPlayer1 = 0;
    private final int playerId;
    private final String name;
    private final HashMap<Integer,Boolean> ticket;
    final String filepath = "C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt";

    public Player(String name,int playerId) {
        this.name = name;
        this.playerId=playerId;
        ticket = new HashMap<>();
        int min = 1, max = 90;
        while (ticket.size() != 15) {
            ticket.put((int) (Math.random() * (max - min + 1) + min), false);
        }

    }

    void displayticket(HashMap<Integer,Boolean> ticket) {
        Iterator<Integer> ticketkey = ticket.keySet().iterator();
        int row = 0;
        while (ticketkey.hasNext()) {
            if (row % 5 == 0) {
                System.out.println();
            }
            row++;
            int key =  ticketkey.next();
            System.out.print(" " + key + " = " + ticket.get(key) + "      ");
        }
    }


    void marker() throws IOException {


        var hit = ticket.replace(GameExecutor.randomNumberGenerated, true);
        if (hit != null) {
            printedOnce = !printedOnce;
            if(playerId==1)
            totalCountNumbersPlayer1++;
            else{
                totalCountNumbersPlayer0++;
            }
            System.out.println("\n" + name + " got a match in ticket : " + GameExecutor.randomNumberGenerated);
            displayticket(ticket);
        }
    }

    public void run() {

        while(totalCountNumbersPlayer1 !=15 || totalCountNumbersPlayer0 != 15) {
            try {
                Thread.currentThread().join(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                marker();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (totalCountNumbersPlayer0 == 15 ||totalCountNumbersPlayer1 ==15) {
                System.out.println("\nHey, its housie ,Please ask checker to check\n ");
                housieStatus = true;
            }
            if (housieStatus) {
                try {
                    FileWriter fileWriter = new FileWriter(filepath, true);
                    fileWriter.write(RandomNumberGenerator.generatedNumbers.toString());
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                Checker.checker(ticket, TambolaBoard.tambolaBoard, name);
            }

        }
    }
}
