import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Game extends Thread {
    static FileWriter fileWriter;
    static ArrayList<Integer> number_generator_arr = new ArrayList<>(90);

    Game() {
        int num = 1;
        while (num != 91) {
            number_generator_arr.add(num);
            num = num + 1;
        }
    }
    int random_number_generator() {
        Collections.shuffle(number_generator_arr);
        int removed_element = number_generator_arr.remove(number_generator_arr.size() - 1);
        System.out.println("\nThe Generated NUmber is : " + removed_element + "\n");
        return removed_element;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        File f = new File("C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt");
        if (f.exists()) {
            f.delete();
        }
        fileWriter = new FileWriter("C:\\Users\\Priyanshu Shukla\\IdeaProjects\\Tambola_Assignment\\src\\RanNoStore.txt"
                , true);
        Game game_obj = new Game();
        Tambola tam_obj = new Tambola();
        HashSet<Integer> board = new HashSet<Integer>();
        HashMap player1 = tam_obj.ticketgenerator();
        tam_obj.displayticket(player1);
        while (true) {
            if (tam_obj.housie(player1)) {
                System.out.println("Wait he is checking ...........");
                if (tam_obj.checker(player1, board) == "Winner") {
                    System.out.println("Congratulations!!! Player won the Game , he hits housie");
                } else {
                    System.out.println("Sorry! ,Player Loose the game");
                }
                break;
            }
            int random_number = game_obj.random_number_generator();
            String str = random_number + "\n";
            try {
                fileWriter.write(str);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            board.add(random_number);
            var match = player1.replace(random_number, true);
            if (match != null) {
                System.out.println("\n You got a match. it is  :" + random_number + "\n");
            }
            tam_obj.displayBoard(board);
            tam_obj.displayticket(player1);
            System.out.println();
            sleep(1);
        }
        fileWriter.close();


    }
}

