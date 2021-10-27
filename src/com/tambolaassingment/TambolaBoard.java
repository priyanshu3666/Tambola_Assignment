package com.tambolaassingment;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class TambolaBoard extends Thread {
    static HashMap<Integer, Boolean> tambolaboard = new HashMap<>();

    public TambolaBoard() {
        for (int num = 1; num < 91; num++) {
            tambolaboard.put(num, false);
        }
    }


    public void displayBoard(HashMap<Integer, Boolean> board) {
        Iterator<Integer> boardkey = board.keySet().iterator();
        int row = 0;
        while (boardkey.hasNext()) {
            if (row % 10 == 0) {
                System.out.println();
            }
            row++;
            var key = boardkey.next();
            if (key < 10) {
                System.out.print("  " + key + " = " + board.get(key) + "      ");
            } else {
                System.out.print(" " + key + " = " + board.get(key) + "      ");
            }
        }
    }

    void generatedNumberFileReader() throws IOException {
        String filepath = "C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt";

        String generatred_number = "";
        File file = new File(filepath);
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(streamReader);
        while (br.ready()) {
            generatred_number = br.readLine();
        }
        tambolaboard.replace(Integer.parseInt(generatred_number), true);
    }

    @Override
    public void run() {
        try {
            generatedNumberFileReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



