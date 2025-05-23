package Arrays;
import java.util.*;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        
        System.out.println(longestCommonPrefix(strs));
    }

    public  static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        for(String s: strs){
            System.out.println(s);
        }
        StringBuilder stringBuilder = new StringBuilder();

        String first = strs[0];
        String last  = strs[strs.length-1];

        for(int i = 0 ; i < Math.min(first.length(), last.length()) ; i++){
            if(first.charAt(i) == last.charAt(i)){
                stringBuilder.append(first.charAt(i));
            }
            else{
                break;
            }
        }

        return stringBuilder.toString();
    }
}
