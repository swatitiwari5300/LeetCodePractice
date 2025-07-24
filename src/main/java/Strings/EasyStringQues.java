package Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EasyStringQues {

    public static void main(String[] args) {
/*        reverseAString("Swati");
        countVowelAndConsonants("SwAti");
        compressString("aaabbc");*/

        isPalindrome("swati");
    }


    public static void reverseAString(String s){

        StringBuilder stringBuilder = new StringBuilder();
        String[] strArr = s.split("");
        for(int i = strArr.length-1 ; i >= 0 ; i--){
            stringBuilder.append(strArr[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void countVowelAndConsonants(String str){
        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(x -> {
            if(isVowel(x)) return "Vowel";
            return "Consonant";
        }, Collectors.counting()));

        System.out.println(map);
    }

    public static boolean isVowel(String str){
        str = str.toLowerCase();
        return str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u");
    }

    //Compress a string using character counts
    public static void compressString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(x -> {
                    stringBuilder.append(x.getKey());
                    stringBuilder.append(x.getValue());
                });
        System.out.println(stringBuilder.toString());
    }

    //Check if a String is Palindrome
    public static void isPalindrome(String str){
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = stringBuilder.append(str).reverse().toString();
        if(str.equals(str2)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a palindrome");
        }
    }
}
