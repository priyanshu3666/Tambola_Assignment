package com.tambolaassingment;

import java.util.HashMap;
import java.util.Iterator;

public class Checker {
    static void checker(HashMap<Integer,Boolean> ticket, HashMap<Integer, Boolean> board, String player_name) {
        System.out.println("Wait Checker is Checking........ ... .... .. ");
        Iterator<Integer> ticketkey = ticket.keySet().iterator();
        while (ticketkey.hasNext()) {
            Object key = ticketkey.next();
            if (!(board.get(key).equals(ticket.get(key)))) {
                System.out.println("Sorry!! " + player_name + " loose the Game \n  Game Over ");
                System.exit(0);
            }
        }
        System.out.println("!!!!Congratulation!!!!\n  " + player_name + "  won the Game");
        System.exit(0);
    }

}
