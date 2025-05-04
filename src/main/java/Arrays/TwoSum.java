package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,4,5,6};
        twoSum(arr, 7);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map);

        for(int i = 0 ; i < nums.length ; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i){
                ans[0] = i;
                ans[1] = map.get(complement);
            }
        }
        System.out.println(ans[0]+", "+ans[1]);
        return ans;
    }
}
