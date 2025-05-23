package Strings;

import java.util.Arrays;

//Write a function that reverses a string.
public class ReverseString {

    public static void main(String[] args) {
        String s = "Hello World";

        reverseString(s);
    }

    public static void reverseString(String s){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = s.length()-1 ; i >=0 ; i--){
            stringBuilder.append(s.charAt(i));
        }

        System.out.println(stringBuilder.toString());
    }
}
