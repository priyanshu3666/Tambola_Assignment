import java.util.*;

class Tambola {
    boolean housie(HashMap player) {
        for (Object key : player.values()) {
            if (!(boolean) key) {
                return false;
            }
        }
        System.out.println("Hey, its housie. Ask Checker to check ");
        return true;
    }

    String checker(HashMap player, HashSet board) {
        Iterator ticketkey = player.keySet().iterator();

        while (ticketkey.hasNext()) {
            Object key = ticketkey.next();
            if (!(board.contains(key) && (boolean) (player.get(key)))) {
                return "Looser";
            }
        }
        return "Winner";
    }

    HashMap<Integer, Boolean> ticketgenerator() {
        var ticket = new HashMap<Integer, Boolean>();
        int min = 1, max = 90;
        while (ticket.size() != 15) {
            ticket.put((int) (Math.random() * (max - min + 1) + min), false);
        }
        return ticket;
    }

    void displayBoard(HashSet board) {
        System.out.print("The Tambola board");
        int row = 0;
        for (var value : board) {
            if (row % 30 == 0) {
                System.out.println();
            }
            row++;
            if (10 > (int) value) {
                System.out.print("  " + value + " ");
            } else {
                System.out.print(" " + value + " ");
            }
        }
        System.out.println();

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
}