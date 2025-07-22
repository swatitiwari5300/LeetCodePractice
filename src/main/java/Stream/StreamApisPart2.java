package Stream;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee{
    String name;
    String department;
    int sal;

    public Employee(String name, String department){
        this.name = name;
        this.department = department;
    }
    public Employee(String name, String department, int sal){
        this.name = name;
        this.department = department;
        this.sal = sal;
    }

    public int getSal(){
        return this.sal;
    }
}

public class StreamApisPart2 {
    public static void main(String[] args) {

        Employee emp1 = new Employee("swati", "IT", 123);
        Employee emp2 = new Employee("Harsh", "Finance", 345);
        Employee emp3 = new Employee("Somya", "IT",12);

        //groupEmp(List.of(emp1, emp2, emp3));

        //secondHighestSalary(List.of(12,2,3,45,23,234,3455));
        //duplicateNumbers(List.of(12,12,3,45,23,45,3455));
        //sortBySalary(List.of(emp1, emp2, emp3));
        //countChars("Swati is nice");
        //longestString("Swati is nice");
        nonNullVal(new ArrayList<>(Arrays.asList(null, "Swati", " ", "hey")));

    }

    //group employees based on departmentName
    public static void groupEmp(List<Employee> list){
        Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(x -> x.department));
        System.out.println(map);
    }

    //second-highest salary
    public static void secondHighestSalary(List<Integer> list){
        Integer i = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(i);
    }

    //Return a list of elements that appear more than once.
    public static void duplicateNumbers(List<Integer> list){

        List<Integer> dups = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue()>1).map(x -> x.getKey()).toList();

        System.out.println(dups);
    }

    //Sort a list of employees by salary in descending order
    public static void sortBySalary(List<Employee> list){

        list = list.stream().sorted(Comparator.comparing(Employee::getSal).reversed()).toList();
        list.stream().forEach(e -> System.out.print(e.name + " "));

    }

    //Count the number of occurrences of each character in a string
    public static void countChars(String str){
        str = str.toLowerCase();
        Map<String, Long> map = Arrays.stream(str.split("")).filter(s -> !s.equals(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    //Find the longest string in a list
    public static void longestString(String str){
        String ans = Arrays.stream(str.split(" ")).max(Comparator.comparing(s -> s.length())).get();
        System.out.println(ans);
    }

    //Remove null values from a list using Stream
    public static void nonNullVal(List<String> list){
        list = list.stream().filter(Objects::nonNull).toList();
        System.out.println(list);
    }
}
