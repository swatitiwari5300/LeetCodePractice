package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayEasyQuestions {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,12,33,45);
        //largestInArray(list);
        //secondLargestNumber(list);
        isSorted(list);
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
}
