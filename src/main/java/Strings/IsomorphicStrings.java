package Strings;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egs", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
            return  false;

        Map<String, Integer> map1 = new HashMap<>();
        Arrays.stream(s.split("")).forEach(a -> {
            if(map1.containsKey(a)){
               map1.put(a, map1.get(a)+1);
            }else{
                map1.put(a, 1);
            }
        });

        Map<String, Integer> map2 = new HashMap<>();
        Arrays.stream(t.split("")).forEach(b -> {
            if(map2.containsKey(b)){
                map2.put(b, map2.get(b)+1);
            }else{
                map2.put(b, 1);
            }
        });

        for(int  i = 0 ; i < s.length() ; i++){
            if(!(map1.get(String.valueOf(s.charAt(i))).equals(map2.get(String.valueOf(t.charAt(i))))))
                return false;
        }

        return true;
    }
}
