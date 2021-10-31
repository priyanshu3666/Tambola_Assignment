package com.tambolaassingment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TicketChecker {
    void tickerChecker(Map<Integer, Boolean> ticket, Map<Integer, Boolean> board, String playerName) {
        System.out.println("Wait tickerChecker is Checking........ ... .... ... ");
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
