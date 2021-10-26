import java.util.*;

class Tambola {
    boolean housie(HashMap player){
        for ( Object key : player.values() ) {
            if(!(boolean) key) {
                return  false;
            }
        }
        return true;
    }

    String checker(HashMap player, HashSet board) {
        Iterator ticketkey = player.keySet().iterator();
        int row = 0;

        while (ticketkey.hasNext()) {
            Object key = ticketkey.next();
            if (!(board.contains(key) && (player.get(key) == "true"))) {
                return "Looser";
            }
            row++;
        }
        return "Winner";
    }



    HashMap<Integer,Boolean> ticketgenerator() {
        var ticket = new HashMap<Integer, Boolean>();
        int min = 1, max = 90;
        while (ticket.size() != 15) {
            ticket.put((int) (Math.random() * (max - min + 1) + min), false);
        }
        return ticket;
    }
    void displayBoard(HashSet board) {
        
        System.out.println(board);
    }


    void displayticket(HashMap ticket) {
        Iterator ticketkey = ticket.keySet().iterator();
        int row = 0;
        while (ticketkey.hasNext()) {
            if (row % 5 == 0) {
                System.out.println();
            }
            int key = (int) ticketkey.next();
            System.out.print(" " + key + " = " + ticket.get(key) + "      ");
            row++;
        }
    }


}