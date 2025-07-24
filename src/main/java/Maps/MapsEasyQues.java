package Maps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapsEasyQues {

    public static void main(String[] args) {
        //containsDuplicates(new int[]{1,5,6,9,12,5});
        //int[] arr = {4, 2, 4, 3, 2, 1, 3, 3};
        //firstRepeatingEle(arr);
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        //groupElementsOfSameFrequency(arr);

        int[] arr1 = {1, 1, 2};
        int[] arr2 = {1, 2, 2};
        checkArraysEqual(arr1, arr2);

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

    //Find first repeating element
    public static void firstRepeatingEle(int[] arr){
        Integer ans = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue()>1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(ans);
    }

    //Group elements with same frequency
    public static void groupElementsOfSameFrequency(int[] arr){
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    //Check if two arrays are equal using hashing
    public static void checkArraysEqual(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            System.out.println("Not equal");
            return;
        }

        Map<Integer, Long> map1 = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> map2 = Arrays.stream(arr2).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(int i : arr1){
            if(!map2.containsKey(i) || !Objects.equals(map1.get(i), map2.get(i))){
                System.out.println("Not equal");
                return;
            }
        }
        System.out.println("Equal");
    }

}
