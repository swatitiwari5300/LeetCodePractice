package Strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountChar {
    public static void main(String[] args) {
        countCharacters("swati");
        System.out.println(fact(5));;
    }

    //Count of Characters in a String
    public static void countCharacters(String s){

        Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

    }

    // Factorial
    public static int fact(int num){

        if(num ==0 || num==1) return 1;
        return num*fact(num-1);

    }

}
