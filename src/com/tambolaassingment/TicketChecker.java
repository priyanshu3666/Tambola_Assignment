package com.tambolaassingment;

import java.util.HashMap;
import java.util.Iterator;

public class TicketChecker {
    void tickerChecker(HashMap<Integer, Boolean> ticket, HashMap<Integer, Boolean> board, String playerName) {
        System.out.println("Wait tickerChecker is Checking........ ... .... .. ");
        Iterator<Integer> ticketkey = ticket.keySet().iterator();
        while (ticketkey.hasNext()) {
            Object key = ticketkey.next();
            if (!(board.get(key).equals(ticket.get(key)))) {
                System.out.println("Sorry!! " + playerName + " loose the Game \n  Game Over ");
                System.exit(0);
            }
        }
        System.out.println("!!!!Congratulation!!!!\n  " + playerName + "  won the Game");
        System.exit(0);
    }

}
