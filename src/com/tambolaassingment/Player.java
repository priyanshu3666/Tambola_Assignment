package com.tambolaassingment;

import java.util.HashMap;
import java.util.Map;

class Player implements Runnable {
    private final String name;
    private int hitCounter;
    private TicketChecker ticketChecker;
    private Map<Integer, Boolean> ticket;
    public static boolean housieStatus = false;

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



    void displayticket(Map<Integer, Boolean> ticket) {
        int counter = 0;
        for (Map.Entry<Integer,Boolean> pair: ticket.entrySet()) {
            if ( counter % 5 == 0) {
                System.out.println();
            }
            System.out.format(" %d = %b   ", pair.getKey(), pair.getValue());

            counter++;
        }

    }


    void marker() {
        if (ticket.get(GameExecutor.randomNumberGenerated) == null||!ticket.get(GameExecutor.randomNumberGenerated)){

            Object hit = ticket.replace(GameExecutor.randomNumberGenerated, true);
            if (hit != null) {
                hitCounter++;
                if(hitCounter == 15) {
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
