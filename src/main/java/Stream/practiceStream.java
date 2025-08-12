package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employees {
    String name;
    double salary;
    Employees(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public double getSalary() { return salary; }
    public String getName() { return name; }
}
public class practiceStream {

    public static void main(String[] args) {


    List<Employees> employees = Arrays.asList(
            new Employees("A", 5000),
            new Employees("B", 8000),
            new Employees("C", 7000),
            new Employees("D", 8000)
    );
    //secondHighest(employees);
    //countWords("apples are very green in color apples");
    List<String> words = Arrays.asList("java", "spring");
    //uniqueChars(words);
        secondMaxSalEmp(employees);
        List<String> names = Arrays.asList("java", "spring", "c", "python", "go");
        sortStrings(names);
}

    // Find the second highest salary from a list of employees using Stream API
    public static void secondHighest(List<Employees> list){

        double secondHigh = list.stream().map(x -> x.getSalary()).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Second - highest salary: "+ secondHigh);
    }

    //Count how many times each word appears in a list
    public static void countWords(String s){

        Map<String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    //Find all unique characters from a list of strings
    public static void uniqueChars(List<String> str){

        String string = str.stream().collect(Collectors.joining(""));
        List<String> ans = Arrays.stream(string.split("")).distinct().toList();
        System.out.println(ans);
    }

    //From a list of employees, find the employee object having the highest salary.
    public static void secondMaxSalEmp(List<Employees> employees){

        Employees e = employees.stream()
                .sorted(Comparator.comparing(x -> x.getSalary())).skip(1).findFirst().get();
        System.out.println(e.getName());

    }

    //Given a list of strings, sort them first by length and then alphabetically.
    public static void sortStrings(List<String> str){

        List<String> ans = str.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).toList();
        System.out.println(ans);
    }

    //From a list of integers, print all duplicate values.
    public static void findDupes(List<Integer> list){

        

    }

}
