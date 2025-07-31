package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPIs {

    //Main method to call all the relevant methods based on the use case
    public static void main(String[] args) {
        //occurrenceOfEachWord("I am learning Streams API in Java Java");
        //findWordsWithNVowels("I am learning Streams API in Java", 2);
        //splitOddEven(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        //occurrenceOfEachCharacter("Mississippi");
        //arrangeInOrder(new int[]{45,12,4,2,67,3});
       // System.out.println("odd sum of {1,3,4,5,6}: "+ findSumOdd(new int[]{1,3,4,5,6}));
        //System.out.println("distinct sum of {1,1,3,4,5,5,6}: "+ findDistinctSum(new int[]{1,1,3,4,5,5,6}));
        //findDistinctCharacter("Hello World");
        findFirstRepeatingCharacter("Hello Wolrd");
    }


    //Q - given the sentence find the occurrence of each word
    public static void occurrenceOfEachWord(String str) {

        Map<String, Long> map = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }

    //Q - given a sentence find the words with specified number of vowels
    public static void findWordsWithNVowels(String str, int n) {
        Arrays.stream(str.split(" "))
                .filter(s -> checkNVowels(s, n))
                .forEach(System.out::println);
    }

    public static boolean checkNVowels(String str, int vowel) {
        long count = Arrays.stream(str.split("")).filter(s -> checkVowel(s.toLowerCase())).count();
        
        return (int) count == vowel;
    }

    public static boolean checkVowel(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }

    //Q - given a list of integers divided into two lists, one list for odd and one list for even.
    public static void splitOddEven(int[] arr){

        List<Integer> list = Arrays.stream(arr).boxed().toList();

        List<List<Integer>> seperatedList = list.stream()
                .collect(Collectors.groupingBy(x -> x%2 ==0, Collectors.toList()))
                .entrySet().stream().map(x -> x.getValue()).toList();

        System.out.println(seperatedList);

    }

    //Q - Given a word, find the occurrence of each character
    public static void occurrenceOfEachCharacter(String s){

        Map<String, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

    }

    //Q - Arrange the numbers in Descending/Ascending Order
    public static void arrangeInOrder(int[] arr){

        List<Integer> list = Arrays.stream(arr).boxed().toList();

        List<Integer> asc = list.stream().sorted().toList();
        List<Integer> desc = list.stream().sorted(Comparator.reverseOrder()).toList();

        System.out.println(asc);
        System.out.println(desc);

    }

    //Q - find the sum of all odd numbers from the array
    public static int findSumOdd(int[] arr){
        int sum = Arrays.stream(arr).filter(x-> x%2 !=0).sum();

        return sum;
    }

    //Q - find the sum of unique elements from the array
    public static int findDistinctSum(int[] arr){
        return Arrays.stream(arr).distinct().sum();
    }

    //Q- find the first character in the string that occurred only once.
    public static void findDistinctCharacter(String str){
        String ch = Arrays.stream(str.split("")).filter(x -> str.indexOf(x) == str.lastIndexOf(x))
                .findFirst().get();
        System.out.println(ch);
    }

    //Q - find the first repeating character in the String
    public static void findFirstRepeatingCharacter(String str){
        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), () -> new LinkedHashMap<>(), Collectors.counting()));
        String s = map.entrySet().stream().filter(m -> m.getValue()>1).findFirst().get().getKey();
        System.out.println(s);
    }
}
