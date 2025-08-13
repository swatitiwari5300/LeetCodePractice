package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayPractice {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,8,10};
        //secondLargestNumber(a);
       // secLargest(a);
        stringPalindrome("naman");
    }

    //Second-largest number from an array
    public static void secondLargestNumber(int[] arr){

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int a : arr){

            if(a > largest){
                secondLargest = largest;
                largest = a;
            }else if(secondLargest <  a && a!= largest){
                secondLargest = a;
            }

        }
        System.out.println(secondLargest);

    }

    //Second-largest number from an array via streams
    public static void secLargest(int[] arr){

        int val = Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .distinct().skip(1).findFirst().get();

        System.out.println(val);
    }

    //String palindrome
    public static void stringPalindrome(String str){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        String reversedString = stringBuilder.reverse().toString();
        System.out.println(str.equals(reversedString));

    }


}
