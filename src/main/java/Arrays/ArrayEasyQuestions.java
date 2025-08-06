package Arrays;

import java.util.*;

public class ArrayEasyQuestions {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,12,33,45);
        //largestInArray(list);
        //secondLargestNumber(list);
        //isSorted(list);
        //reverseAnArray(new int[]{1,5,6,9,12});

        int[] arr = {1, 2, 4, 5};
        //findMissing(arr, 5);
        removeDupes(new int[]{1,5,6,9,12,5});
    }


    public static void largestInArray(List<Integer> array){
        Integer value = array.stream().max(Comparator.naturalOrder()).get();
        System.out.println(value);
    }

    public static void secondLargestNumber(List<Integer> list){
        Integer value = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(value);
    }

    //Check if array is sorted
    public static void isSorted(List<Integer> list){
        boolean notSorted = false;
        for(int i = 0 ; i < list.size()-1 ; i++){
            if(list.get(i) > list.get(i+1)){
                notSorted = true;
                break;
            }
        }
        if(notSorted){
            System.out.println("Not Sorted");
        }else{
            System.out.println("Sorted");
        }
    }

    //Reverse an array
    public static void reverseAnArray(int[] list){
        int beg = 0;
        int last = list.length-1;
        int temp = 0;
        while(beg<last){
            temp = list[beg];
            list[beg] = list[last];
            list[last] = temp;
            beg++;last--;
        }
        System.out.println(Arrays.toString(list));
    }

    //Find the missing number in range 1 to N
    public static void findMissing(int[] arr, int n){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int ans = ((n*(n+1))/2)-sum;
        System.out.println(ans);
    }

    //Remove duplicates from sorted array
    public static void removeDupes(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        System.out.println(Arrays.toString(set.toArray()));
    }
}
