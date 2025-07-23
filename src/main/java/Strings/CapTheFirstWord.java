package Strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapTheFirstWord {
    public static void main(String[] args) {
        String str = "my name is abcd";
        convert(str);
    }

    public static void convert(String str){

        str = Arrays.stream(str.split(" "))
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println(str);
    }
}
