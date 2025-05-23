package Strings;

import java.util.Arrays;

public class ReverseCharArray {

    public static void main(String[] args) {
        char[] charArray = {'h', 'e', 'l', 'l', 'o'};

        reverseCharsInplace(charArray);
        System.out.println(charArray);
    }

    public static void reverseChars(char[] charArray){

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : charArray){
            stringBuilder.append(c);
        }

        System.out.println(stringBuilder.reverse().toString());
    }

    //inplace
    public static void reverseCharsInplace(char[] charArray){
        char temp;
        int left = 0;
        int right = charArray.length-1;

        while(left<right){
            temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

    }
}
