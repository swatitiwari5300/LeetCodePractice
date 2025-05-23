package Strings;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        reverse(s);
    }


    public static void reverse(String s){
        String[] sArray = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for(String str : sArray){
            ans.append(new StringBuilder(str).reverse().toString());
            ans.append(" ");
        }
        System.out.println(ans.toString().trim());
    }
}
