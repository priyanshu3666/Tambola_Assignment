package com.tambolaassingment;

import java.util.HashMap;
import java.util.Iterator;

class Player implements Runnable {
    private  int totalCount= 0;
    public static boolean housieStatus = false;
    private final String name;
    private TicketChecker ticketChecker;
    private HashMap<Integer, Boolean> ticket;

    public Player(String name, TicketChecker ticketChecker) {
        this.name = name;
        this.ticketChecker = ticketChecker;

        ticket = new HashMap<>();
        int min = 1;
        int max = 90;
        while (ticket.size() != 15) {
            ticket.put((int) (Math.random() * (max - min + 1) + min), false);
        }

    }
    

    void displayticket(HashMap<Integer, Boolean> ticket) {
        Iterator<Integer> ticketKey = ticket.keySet().iterator();
        int row = 0;
        while (ticketKey.hasNext()) {
            if (row % 5 == 0) {
                System.out.println();
            }
            row++;
            int key = ticketKey.next();
            System.out.print(" " + key + " = " + ticket.get(key) + "      ");
        }
    }

    void marker() {
        if (ticket.get(GameExecutor.randomNumberGenerated) == null||!ticket.get(GameExecutor.randomNumberGenerated)){

            Object hit = ticket.replace(GameExecutor.randomNumberGenerated, true);
            if (hit != null) {
                totalCount++;
                if(totalCount == 15) {
                    housieStatus =true;
                }
                System.out.println("\n" + name + " got a match in ticket : " + GameExecutor.randomNumberGenerated);
                displayticket(ticket);
            }
        }
    }

    public void run() {

        while (!housieStatus) {
            marker();
            if (housieStatus) {
                System.out.println("\nHey, its housie ,Please ask checker to check\n ");
                ticketChecker.tickerChecker(ticket, TambolaBoard.board, name);
            }
            try {
                Thread.currentThread().sleep(3002);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
