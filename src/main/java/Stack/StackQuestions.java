package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackQuestions {

    public static void main(String[] args) {
        String s = "programming";
        findDuplicates(s);
    }


    public static void findDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();

        for(char ch : s.toCharArray()){

            if(seen.contains(ch)){
                duplicates.add(ch);
            }else{
                stack.add(ch);
                seen.add(ch);
            }
        }
        String stackString = stack.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(""));
        String duplicateString = duplicates.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(""));

        System.out.println("Duplicates: "+ duplicateString);
        System.out.println("Unique: "+ stackString);
    }
}
