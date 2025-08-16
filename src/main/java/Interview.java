import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Interview {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(10);

        reverseList(list);
    }

    public static void reverseList(List<Integer> list) {
        List<Integer> ans = IntStream.range(0, list.size())
                .mapToObj(i -> list.get(list.size() - 1 - i))
                .toList();

        System.out.println(ans);
    }

    //Find the second largest number in a list
    public static void secondLargest(List<Integer> list){
        Integer secondLargest = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondLargest);
    }

    //Count frequency of each element
    public static void 
    //Remove duplicates and preserve order

    //Find all even numbers and square them

    //Find the longest string in a list

    //Reverse words in a sentence


//Longest Substring Without Repeating Characters in a string.


/*@Query("select e from employee e join employee m on e.manager_id = m.employee_id");
List<Employee> findEmp())*/

}
