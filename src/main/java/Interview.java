import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Interview {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(10);

        reverseList(list);
    }

    public static void reverseList(List<Integer> list) {
        List<Integer> ans = IntStream.range(0, list.size())
                .mapToObj(i -> list.get(list.size() - 1 - i))
                .toList();

        System.out.println(ans);
    }

    //Find the second largest number in a list
    public static void secondLargest(List<Integer> list){
        Integer secondLargest = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondLargest);
    }

    //Count frequency of each element
    public static void countFreq(List<String> list){

        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    //Remove duplicates and preserve order
    public static void removeDupes(List<Integer> list){
        list = list.stream().distinct().toList();
        System.out.println(list);
    }

    //Find all even numbers and square them
    public static void findEvenAndSquare(List<Integer> list){
        list = list.stream().filter(x -> x%2 == 0)
                .map(x -> x*x).toList();
        System.out.println(list);
    }

    //Find the longest string in a list
    public static void longestString(List<String> list){

        String ans = list.stream().max(Comparator.comparingInt(x -> x.length())).get();
        System.out.println(ans);
    }

    //Reverse words in a sentence
    public static void reverseWords(String str){
        String ans = Arrays.stream(str.split(" "))
                .map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(ans);

    }

    //Partition numbers into even and odd
    public static void groupEvenAndOdds(List<Integer> list){

        Map<Boolean, List<Integer>> map = list.stream()
                .collect(Collectors.partitioningBy(x -> x%2 == 0));
        System.out.println(map);
    }

    //Find all numbers starting with digit 1
    public static void numberStartingWithOne(List<Integer> list){
        list = list.stream()
                .filter(x -> String.valueOf(x).startsWith("1"))
                .toList();
        System.out.println(list);
    }

    //Find the sum of squares of first 5 natural numbers
    public static void sumOfSquare(){
        int sum = IntStream.rangeClosed(1,5)
                .map(x -> x*x)
                .sum();
        System.out.println(sum);
    }

    //Find common elements between two lists
    public static void commonElements(List<Integer> list1, List<Integer> list2){

        List<Integer> ans = list1.stream()
                .filter(x -> list2.contains(x)).toList();
        System.out.println(ans);
    }


//Longest Substring Without Repeating Characters in a string.


/*@Query("select e from employee e join employee m on e.manager_id = m.employee_id");
List<Employee> findEmp())*/

}
