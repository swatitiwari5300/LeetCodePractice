package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,2,3,4,16,12,2);
        removeDup(list);
        findDuplicates(list);
        secondHighest(list);
        groupStringByLength("Swati Tiwari is a coder");
        frequencyOfEachChar("Swati Tiwari is a coder");
        partitionNumberOddEven(List.of(1, 2, 3, 4, 5, 6));
        countWords("java stream api is powerful");
    }

    //Problem: Remove duplicates from a list of integers.
    public static void removeDup(List<Integer> list){
        list = list.stream().distinct().toList();
        System.out.println(list);
    }

    //Problem: Find duplicates from a list of integers.
    public static void findDuplicates(List<Integer> list){
        List<Integer> ans = new ArrayList<>();
        ans = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(m -> m.getValue()>2).map(m -> m.getKey()).toList();
        System.out.println(ans);
    }

    //Problem: Find the second-Highest number
    public static void secondHighest(List<Integer> list){
        Integer ans = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(ans);
    }

    //Problem: Group Strings by Their Length
    public static void groupStringByLength(String str){
        Map<Integer, List<String>> ans = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(ans);
    }

    //Problem: Frequency of Each Character in a String
    public static void frequencyOfEachChar(String str){
        Map<String, Long> ans = Arrays.stream(str.split(""))
                .filter(s -> !s.equals(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(ans);
    }

    //Problem: Partition Numbers into Even and Odd
    public static void partitionNumberOddEven(List<Integer> list){
        Map<Boolean, List<Integer>> ans = list.stream().collect(Collectors.partitioningBy(n -> n%2==0));
        System.out.println(ans);
    }

    //Problem: Count Words in a Sentence
    public static void countWords(String str){
        Long ans = Arrays.stream(str.split(" ")).count();
        System.out.println(ans);
    }
}
