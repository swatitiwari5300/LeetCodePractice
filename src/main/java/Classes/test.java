package Classes;
import java.util.*;

public class test {

    public static void main(String[] args) {
        String s = "aaabbddaaaaaddbb";
        //longestPalString(s);
        List<String> list = new ArrayList<>();
        list.add("naman");
        list.add("anand");
        list.add("swati");
        list.add("Anshul");
        findNameWithA(list);
    }

    public static void findNameWithA(List<String> list){

        List<String> ans = list.stream().filter(a -> a.charAt(0) == 'a' || a.charAt(0) == 'A').toList();
        System.out.println(ans);
    }

    public static void longestPalString(String str){

        if(str.length() <= 1){
            System.out.println(str);
            return;
        }

        String ans = "";
        for(int i = 1 ; i < str.length() ; i++){

            int beg = i;
            int end = i;

            while(str.charAt(beg) == str.charAt(end)){
                beg--;
                end++;
                if (beg <0 || end== str.length() ){
                    break;
                }
            }

            String pal = str.substring(beg+1, end);
            if(pal.length() > ans.length()){
                ans = pal;
            }

            beg = i-1;
            end = i;

            while(str.charAt(beg) == str.charAt(end)){
                beg--; end++;
                if(beg < 0 || end == str.length()){
                    break;
                }
            }

            pal = str.substring(beg+1, end);

            if(pal.length() > ans.length()){
                ans = pal;
            }

        }

        System.out.println(ans);
    }
}

//select salary from employees order by salary desc limit 1 offset 2;
