package Strings;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        //findNonRep("swiss");
        maxFrequencyChar("swiss");

    }

    public static void findNonRep(String str){

        String ans = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() ==1).map(x -> x.getKey()).findFirst().get();

        System.out.println(ans);
    }

    public static void maxFrequencyChar(String str){
        String ans = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");

        System.out.println(ans);

    }


}
