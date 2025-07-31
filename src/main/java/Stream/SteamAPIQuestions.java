package Stream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SteamAPIQuestions {

    static class Employees{
        private String name;
        private int id;
        private String department;
        public double salary;

        public Employees(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    static class Students {
        String name;
        int grade;

        public Students(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }


    public static void main(String[] args) {
        //removeDupChar("sssswert");
        //findSquare(Arrays.asList(1,2,2,3,5,6,7));
        //findLengthOfEachString(Arrays.asList("swati", "somya", "arun", "sdfdgdfdg"));
        List<List<String>> list = List.of(
                List.of("a", "b"),
                List.of("c"),
                List.of("d", "e", "f")
        );
        //flattenTheList(list);
        //partitionNumber(Arrays.asList(1,2,2,3,5,6,7));
        //secondHighest(Arrays.asList(1,2,4,3,5,6,7));
        //frequencyMap("swatitiwari");

        List<String> words = List.of("apple", "banana", "grape");
        //findFirstNonRepeatingChar(words);

        List<Employees> employees = Arrays.asList(
                new Employees(1, "swati", "IT", 23000),
                new Employees(2, "somya", "finance", 34000),
                new Employees(3, "harsh", "Engineering", 33000),
                new Employees(11, "meera", "IT", 63000),
                new Employees(21, "meena", "finance", 44000)
        );

        //groupByDepartment(employees);

        List<Students> students = Arrays.asList(
                new Students("asd", 242),
                new Students("xyz", 553),
                new Students("wer", 100),
                new Students("pok", 123)
        );
        sortBygradeAndName(students);
    }


    //remove duplicate characters from a string
    public static void removeDupChar(String str){

       String ans =  Arrays.stream(str.split("")).distinct().collect(Collectors.joining(""));
        System.out.println(ans);
    }

    //Given a list of integers,
    // how would you return a list of squared values in descending order without duplicates?
    public static void findSquare(List<Integer> list){

        List<Integer> ans = list.stream().map(x -> x*x).distinct().toList();
        System.out.println(ans);
    }

    //Convert a List<String> to a Map<String, Integer>
    // where the key is the string and the value is its length.
    public static void findLengthOfEachString(List<String> list){
        Map<String, Integer> ans = list.stream().collect(Collectors.toMap(x->x, x -> x.length()));
        System.out.println(ans);
    }

    //How do you flatten a List<List<String>> into a single List<String> using streams?
    public static void flattenTheList(List<List<String>> list){
        List<String> ans = list.stream().
                flatMap(l -> l.stream()).toList();

        System.out.println(ans);

    }

    //Given a list of integers, how do you partition them into even and odd numbers using Stream API?
    public static void partitionNumber(List<Integer> list){

       Map<Boolean, List<Integer>> map =  list.stream().collect(Collectors.groupingBy(x -> x%2 == 0));
        System.out.println(map);
    }

    //How do you get the second highest number in a list using streams?
    public static void secondHighest(List<Integer> list){
        Integer ans = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(ans);

    }

    //How would you implement a frequency map of characters in a string using streams?
    public static void frequencyMap(String str){

        Map<String, Long> ans = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(ans);
    }

    //Given a list of words, find the first non-repeating character in the entire list using Stream API.
    public static void findFirstNonRepeatingChar(List<String> words){

    String ans = Arrays.stream(words.stream().collect(Collectors.joining()).split(""))
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).findFirst().get();
        System.out.println(ans);
    }

    //Group a list of employees by department and find the highest salary in each department.
    public static void groupByDepartment(List<Employees> employees){

        Map<String, Optional<Employees>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.department,
                        Collectors.maxBy(Comparator.comparingDouble(emp -> emp.salary))
                ));

        map.entrySet().stream().forEach(m -> {
            System.out.println(m.getKey()+": "+m.getValue().get().salary);
        });

    }

    //Sort a list of students by grade, then by name, using streams and comparators.
    public static void sortBygradeAndName(List<Students> list){

        List<Students> sortedList = list.stream().sorted(Comparator.comparingInt((Students s) -> s.grade)
                .thenComparing((Students s) -> s.name)).toList();
        sortedList.forEach(s -> System.out.println(s.name));

    }


}
