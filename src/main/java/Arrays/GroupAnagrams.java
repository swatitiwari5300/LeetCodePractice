package Arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String sortedString = new String(charArray);

            if(!map.containsKey(sortedString)){
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedString, list);
            }else{
                map.get(sortedString).add(sortedString);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;

    }
}
