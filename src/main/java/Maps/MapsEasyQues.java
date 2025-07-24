package Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapsEasyQues {

    public static void main(String[] args) {
        containsDuplicates(new int[]{1,5,6,9,12,5});
    }

    //Count frequency of elements in array
    public static void countFrequency(int[] arr){
        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }

    //Check if array contains duplicates
    public static void containsDuplicates(int[] arr){
        boolean val = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(x -> x.getValue()>1);

        if(val){
            System.out.println("Contains Dupes");
        }else {
            System.out.println("No Dupes");
        }
    }

}
