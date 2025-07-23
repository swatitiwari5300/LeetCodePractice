package Strings;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        //findNonRep("swiss");
        //maxFrequencyChar("swiss");
        //sumOfAllNumbers("abc123xyz45");
        //extractDigits("a1b2c3");
        //checkDigitsOnly("14a");
        removeDupes("programming");
        keepDupesOnce("programming");
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

    //Sum of all numbers in a string
    //"abc123xyz45" → 123 + 45 = 168
    public static void sumOfAllNumbers(String str){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(str.split("")).forEach(x -> {
            if(!Character.isDigit(x.charAt(0))){
                stringBuilder.append(" ");
            }else {
                stringBuilder.append(x);
            }
        });
        int sum = Arrays.stream(stringBuilder.toString().split(" "))
                .filter(x -> !x.equals(" ")).filter(x -> !x.equals(""))
                .mapToInt(x -> Integer.parseInt(x)).sum();
        System.out.println(sum);
    }
    //Extract digits and return as integer
    //"a1b2c3" → 123
    public static void extractDigits(String str){
        String ans = Arrays.stream(str.split("")).filter(x -> !x.equals(" "))
                .filter(x -> Character.isDigit(x.charAt(0))).collect(Collectors.joining(""));

        System.out.println(Integer.parseInt(ans));
    }
    //Check if a string contains only digits
    public static void checkDigitsOnly(String str){

        boolean bool = str.chars().allMatch(x -> Character.isDigit(x));

        if(bool){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    //Remove all duplicate characters(not even once the repeating char is present)
    public static void removeDupes(String str){
        String ans = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).collect(Collectors.joining(""));

        System.out.println(ans);
    }
    //Remove all duplicate characters(keeps once)
    public static void keepDupesOnce(String str){
        Set<String> set = new LinkedHashSet<>();
        Arrays.stream(str.split("")).forEach(x -> set.add(x));
        StringBuilder stringBuilder = new StringBuilder();
        for (String ch : set) {
            stringBuilder.append(ch);  // Append each character without brackets or commas
        }
        System.out.println(stringBuilder.toString());
    }


}
