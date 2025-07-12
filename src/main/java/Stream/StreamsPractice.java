package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,2,3,4,16,12,2);
        removeDup(list);
        findDuplicates(list);
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
}
