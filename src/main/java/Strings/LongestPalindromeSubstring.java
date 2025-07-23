package Strings;

import java.util.List;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String str = "noon level rar naman";
        findLongestPalindromeSubstring(str);
    }

    public static void findLongestPalindromeSubstring(String str){
        String[] strArray = str.split(" ");
        int maxLength = 0;
        String ans = "";
        for(String s : strArray){
            if(isPalindrome(s)){
                if(s.length()>maxLength){
                    maxLength = s.length();
                    ans = s;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean isPalindrome(String str){
        String rev = new StringBuilder(str).reverse().toString();
        return rev.equals(str);
    }
}
