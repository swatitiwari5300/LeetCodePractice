package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {

    /*
    * Given a list of integers, do the following:
    * Predicate: Write a predicate to check if a number is even.
    * Consumer: Create a consumer to print each number squared.
    * Supplier: Create a supplier that returns a random integer between 1 and 100.
    * */

    public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         list.add(12);
         list.add(10);
         list.add(3);
         list.add(5);

        Predicate<Integer> isEven = n -> n%2 == 0;
        Consumer<Integer> printSquare = n -> System.out.println(n*n);
        Supplier<Integer> randomInt = () -> {
            int val = new Random().nextInt(100)+1;
            return val;
        };

        list.stream().filter(isEven).forEach(printSquare);
        System.out.println(randomInt.get());

    }
}
