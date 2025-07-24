package Maps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapsEasyQues {

    public static void main(String[] args) {
        //containsDuplicates(new int[]{1,5,6,9,12,5});
        //int[] arr = {4, 2, 4, 3, 2, 1, 3, 3};
        //firstRepeatingEle(arr);
        //int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        //groupElementsOfSameFrequency(arr);

/*        int[] arr1 = {1, 1, 2};
        int[] arr2 = {1, 2, 2};
        checkArraysEqual(arr1, arr2);*/
/*        int[] arr1 = {};
        int[] arr2 = {1, 2, 3};

        findCommonElements(arr1, arr2);*/

        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;

        fidSubArr(arr, target);

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

    //Find intersection of two arrays
    public static void findCommonElements(int[] arr1, int[] arr2){

        Map<Integer, Long> map1 = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> map2 = Arrays.stream(arr2).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int[] shortArr = arr1.length<arr2.length?arr1:arr2;
        List<Integer> list = new ArrayList<>();
        for(int i : shortArr){
            if(map1.containsKey(i) && map2.containsKey(i)){
                list.add(i);
            }
        }
        System.out.println(list);
    }

    //Find subarray with given sum - All Positive numbers
    public static void fidSubArr(int[] arr, int target){

        int start = 0, end = 0, sum = 0;
        while(end < arr.length){

            sum += arr[end];
            while(start < end && sum > target){
                sum -= arr[start];
                start++;
            }
            if(sum == target){
                System.out.println("start index: "+start + " end index: "+end);
                return;
            }

            end++;
        }
        System.out.println("No subarray found.");
    }

}
