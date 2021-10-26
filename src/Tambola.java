import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Tambola {

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