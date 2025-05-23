package Arrays;
/*Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
        Then return the number of unique elements in nums.*/
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
    }

    public static int removeDupes(int[] nums){

        int count = 1;
        int k = 1;

        for(int  i = 1 ; i < nums.length ; i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                count++;
                k++;
            }
        }
        return count;
    }

}
