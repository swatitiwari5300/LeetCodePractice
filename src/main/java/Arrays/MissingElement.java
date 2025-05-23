package Arrays;

import java.util.Arrays;

public class MissingElement {

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1,2,3,4,5,6};

        //missingEle(n, arr);
        missingEle(arr);
    }

    //When the total number of elements is given
    public static void missingEle(int n, int[] arr){
        int expectedSum = n*(n+1)/2;
        int actualSum = Arrays.stream(arr).sum();

        int missingElement = expectedSum-actualSum;
        System.out.println(missingElement);
    }

    //When the total number of elements is not given
    public static void missingEle(int[] arr){
        //since we know one element is missing then by finding the no of elements present in the arr and adding 1
        int n = arr.length+1;
        missingEle(n, arr);
    }
}
