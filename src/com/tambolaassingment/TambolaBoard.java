package com.tambolaassingment;

import java.util.HashMap;
import java.util.Map;


public class TambolaBoard {
    static Map<Integer, Boolean> board = new HashMap<>();

    public TambolaBoard() {
        for (int num = 1; num < 91; num++) {
            board.put(num, false);
        }
    }

    public void displayBoard(Map<Integer, Boolean> board) {
        int counter = 0;
        for (Map.Entry<Integer,Boolean> pair: board.entrySet()) {
            if ( counter % 10 == 0) {
                System.out.println();
            }
            if  (pair.getKey()<10){
                System.out.format("  %d = %b   ", pair.getKey(), pair.getValue());
            }
            else {
                System.out.format(" %d = %b   ", pair.getKey(), pair.getValue());
            }
            counter++;
        }
    }


}





