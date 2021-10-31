package com.tambolaassingment;

import java.util.HashMap;
import java.util.Iterator;


public class TambolaBoard {
    static HashMap<Integer, Boolean> board = new HashMap<>();

    public TambolaBoard() {
        for (int num = 1; num < 91; num++) {
            board.put(num, false);
        }
    }

    public void displayBoard(HashMap<Integer, Boolean> board) {
        Iterator<Integer> boardKey = board.keySet().iterator();
        int counter = 0;
        while (boardKey.hasNext()) {
            if (counter % 10 == 0) {
                System.out.println();
            }
            counter++;
            var key = boardKey.next();
            if (key < 10) {
                System.out.print("  " + key + " = " + board.get(key) + "      ");
            } else {
                System.out.print(" " + key + " = " + board.get(key) + "      ");
            }
        }
    }


}





