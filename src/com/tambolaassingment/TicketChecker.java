package com.tambolaassingment;


import java.util.Map;

public class TicketChecker {
    void tickerChecker(Map<Integer, Boolean> ticket, Map<Integer, Boolean> board, String playerName) {
        System.out.println("Wait tickerChecker is Checking........ ... .... ... ");
        for (Map.Entry<Integer, Boolean> pair : ticket.entrySet()) {
            if (!(board.get(pair.getKey()).equals(ticket.get(pair.getKey())))) {
                System.out.println("Sorry!! " + playerName + " loose the Game \n  Game Over ");
                System.exit(0);
            }
            System.out.println("!!!!Congratulation!!!!\n  " + playerName + "  won the Game");
            System.exit(0);
        }
    }
}

