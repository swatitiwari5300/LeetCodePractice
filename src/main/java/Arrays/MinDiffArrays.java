package Arrays;

import java.math.BigInteger;
import java.util.*;

public class MinDiffArrays {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 1, 3);
        //minDiffArray(list);

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);
        //mergeTwoArrayList(list1,list2);

        findSecMax(Arrays.asList(10, 30, 20, 40, 50));
    }

    //https://leetcode.com/problems/minimum-absolute-difference/description/
    public static void minDiffArray(List<Integer> list) {

        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {

            int diff = list.get(i) - list.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                ans.clear();
                List<Integer> temp = new ArrayList<>();
                temp.add(list.get(i - 1));
                temp.add(list.get(i));
                ans.add(temp);
            } else if (diff == minDiff) {
                List<Integer> temp = new ArrayList<>();
                temp.add(list.get(i - 1));
                temp.add(list.get(i));
                ans.add(temp);
            }

        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    //https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);

        StringBuilder stringBuilder = new StringBuilder();
        String reversed = stringBuilder.append(str).reverse().toString();
        if (reversed.equals(str))
            return true;
        return false;
    }

    //https://leetcode.com/problems/valid-parentheses/
    public static boolean validParentheses(String str) {

        Stack<Character> characterStack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                characterStack.push(ch);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                char top = characterStack.pop();

                if ((top != '(' && ch == ')') ||
                        (top != '{' && ch == '}') ||
                        (top != '[' && ch == ']')) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    //merge two sorted arrayList
    public static void mergeTwoArrayList(List<Integer> list1, List<Integer> list2) {

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            ans.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            ans.add(list2.get(j));
            j++;
        }

        System.out.println(ans);

    }

    //https://leetcode.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        int beg = 0;
        int end = nums.length - 1;
        int mid = (beg + end) / 2;

        while (beg < end) {

            if (target > nums[mid]) {
                beg = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            }
            mid = (beg + end) / 2;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        if (nums[0] > target) return 0;
        return beg;
    }

    //Find max2 from unsorted array
    public static void findSecondMax(List<Integer> list) {
        Optional<Integer> secondMax = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        if (secondMax.isPresent()) {
            System.out.println("Second Max: " + secondMax.get());
        } else {
            System.out.println("Second Max does not exist.");
        }
    }

    ////Find max2 from unsorted array --- withoutStreams
    public static void findSecMax(List<Integer> list) {

        if (list.size() < 2) {
            System.out.println("Second Max is not found");
            return;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : list) {

            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && !(num == max)) {
                secondMax = num;
            }

        }

        System.out.println("Second max: " + secondMax);

    }

    //    https://leetcode.com/problems/plus-one/description/
    public int[] plusOne(int[] digits) {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i : digits){
            stringBuilder.append(i);
        }
        BigInteger bigInt = new BigInteger(stringBuilder.toString());
        bigInt = bigInt.add(BigInteger.ONE);
        String[] arr = String.valueOf(bigInt).split("");

        int[] ans = new int[arr.length];
        int i = 0;
        for(String s: arr){
            ans[i++] = Integer.parseInt(s);
        }

        return  ans;
    }


}
