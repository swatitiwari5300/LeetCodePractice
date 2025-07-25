package Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EasyStringQues {

    public static void main(String[] args) {
/*        reverseAString("Swati");
        countVowelAndConsonants("SwAti");
        compressString("aaabbc");*/

        //isPalindrome("swati");
        //isAnagram("hello", "hell");
        //oneEditAway("helle", "hello");
       // isSubSequence("f", "abc");
        //rearrangedInPalindrome("abc");
        needleHaystackProblem("lo", "hello");

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

    public static void isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            System.out.println("Not an anagram");
            return;
        }
        Map<String, Long> map1 = Arrays.stream(s1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map2 = Arrays.stream(s2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String[] strArr = s2.split("");
        boolean flag = true;
        for(String s : strArr){
            if(!Objects.equals(map2.get(s), map1.get(s))){
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("Anagram");
        }else{
            System.out.println("Not a anagram");
        }
    }

    //Check if two strings are one edit away
    public static void oneEditAway(String s1, String s2) {
    }

    //Check if string is subsequence of another
    public static void isSubSequence(String s1, String s2) {

        int i = 0, j = 0;

        while(j < s2.length() && i < s1.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }

        if(i == s1.length()){
            System.out.println("yes");
        }else {
            System.out.println("No");
        }
    }

    //Check if a string can be rearranged into a palindrome
    //✅ Rules:
    //For even-length strings:
    //All characters must appear an even number of times.
    //For odd-length strings:
    //Only one character can appear an odd number of times.
    //All others must appear an even number of times.
    public static void rearrangedInPalindrome(String str){
        int count = str.length();
        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if(count%2 == 0){
            for(Map.Entry<String, Long> e : map.entrySet()){
                if(e.getValue()%2 != 0){
                    System.out.println("Can not be arranged to a palindrome");
                    return;
                }
            }
            System.out.println("Can be arranged to a palindrome");
        }else{
            int odd = 0;
            for(Map.Entry<String, Long> e : map.entrySet()){
                if(e.getValue()%2 != 0){
                    odd++;
                }
            }
            if (odd == 1){
                System.out.println("Can be arranged to a palindrome");
            }else{
                System.out.println("Can not be arranged to a palindrome");
            }
        }
    }

    //Implement strstr() (or indexOf)
    public static void needleHaystackProblem(String needle, String haystack){
        int n = needle.length();

        for(int i = 0 ; i <= haystack.length()-n ; i++){
            String subString = haystack.substring(i, i+n);
            if(subString.equals(needle)){
                System.out.println("Found!! at: "+ i);
                return;
            }
        }

        System.out.println("Not found");
    }
}
