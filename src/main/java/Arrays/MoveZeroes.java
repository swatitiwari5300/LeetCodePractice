package Arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums){

        int left = 0;
        int right = 0;

        int temp;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                right ++;
            }
            else{
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++; right++;
            }
        }

        Arrays.stream(nums).forEach(a -> System.out.print(a+ " "));
    }
}
