package Arrays;

public class RearrangeArray {

    public static void main(String[] args) {

    }
//Given an array of integers, rearrange it such that all negative numbers appear before all positive numbers.
// The order does not matter.
//Using Two Pointers (O(n), In-place)
    public static void rearrange(int[] arr){

        int left = 0, right = arr.length-1;

        while(left <= right){

            if(arr[left] > 0 && arr[right] < 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; right --;
            }else if(arr[left] < 0 && arr[right] < 0){
                left++;
            }else if(arr[left] > 0 && arr[right] > 0){
                right--;
            }else{
                left++;
                right--;
            }

        }

    }
}
