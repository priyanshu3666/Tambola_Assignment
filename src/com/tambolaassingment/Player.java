package com.tambolaassingment;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

class Player extends Thread {
    public boolean housiestatus = false;
    private final String name;
    private final HashMap ticket;

    public Player(String name) {
        this.name = name;
        ticket = new HashMap<Integer, Boolean>();
        int min = 1, max = 90;
        while (ticket.size() != 15) {
            ticket.put((int) (Math.random() * (max - min + 1) + min), false);
        }
    }

    public HashMap getTicket() {
        return ticket;
    }

    public String getPlayerName() {
        return name;
    }

    public boolean getHousieStatus() {
        return housiestatus;
    }

    void displayticket(HashMap ticket) {
        Iterator ticketkey = ticket.keySet().iterator();
        int row = 0;
        while (ticketkey.hasNext()) {
            if (row % 5 == 0) {
                System.out.println();
            }
            row++;
            int key = (int) ticketkey.next();
            System.out.print(" " + key + " = " + ticket.get(key) + "      ");
        }
    }


    boolean housie(HashMap ticket) {
        for (Object key : ticket.values()) {
            if (!(boolean) key) {
                return false;
            }

        }
        System.out.println("\nHey, its housie. Ask Checker to check\n ");
        return true;
    }

    void generatedNumberReader() throws IOException {
        String filepath = "C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt";
        String generatred_number = "";
        try {
            File file = new File(filepath);
            InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(streamReader);
            while (br.ready()) {
                generatred_number = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        var hit = ticket.replace(Integer.parseInt(generatred_number), true);
        if (hit != null) {
            System.out.println("\n" + name + " got a match in ticket : " + generatred_number);
            displayticket(ticket);
        }
    }

    public void run() {
        try {
            generatedNumberReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        housiestatus = housie(ticket);
        if (housiestatus) {
            Checker.checker(ticket, TambolaBoard.tambolaboard, name);
        }
    }


}
