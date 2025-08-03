package Arrays;

import java.util.*;

public class MinDiffArrays {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,1,3);
        minDiffArray(list);
    }

    //https://leetcode.com/problems/minimum-absolute-difference/description/
    public static void minDiffArray(List<Integer> list){

        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        Collections.sort(list);

        for(int i = 1 ; i < list.size() ; i++){

            int diff = list.get(i) - list.get(i-1);
            if(diff < minDiff){
                minDiff = diff;
                ans.clear();
                List<Integer> temp = new ArrayList<>();
                temp.add(list.get(i-1));
                temp.add(list.get(i));
                ans.add(temp);
            }else if( diff == minDiff){
                List<Integer> temp = new ArrayList<>();
                temp.add(list.get(i-1));
                temp.add(list.get(i));
                ans.add(temp);
            }

        }
        for(int i  = 0 ; i< ans.size() ; i++) {
            System.out.println(ans.get(i));
        }
    }

    //https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int num){
        String str = String.valueOf(num);

        StringBuilder stringBuilder = new StringBuilder();
        String reversed = stringBuilder.append(str).reverse().toString();
        if(reversed.equals(str))
            return true;
        return false;
    }

    //https://leetcode.com/problems/valid-parentheses/
    public static boolean validParentheses(String str){

        Stack<Character> characterStack = new Stack<>();

        for(char ch : str.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '['){
                characterStack.push(ch);
            }else {
                if(characterStack.isEmpty()){
                    return false;
                }
                char top = characterStack.pop();

                if((top != '(' && ch == ')') ||
                        (top != '{' && ch == '}') ||
                        (top != '[' && ch == ']')){
                    return  false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    //merge two sorted arrayList

}
