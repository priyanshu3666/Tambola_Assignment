import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Game extends Thread {
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
        System.out.println(number_generator_arr);
        int removed_element = number_generator_arr.remove(number_generator_arr.size() - 1);
        System.out.println(removed_element);
        return removed_element;
    }


    public static void main(String[] args) throws InterruptedException {
       
    }
}

