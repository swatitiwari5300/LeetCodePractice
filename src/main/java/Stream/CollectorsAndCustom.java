package Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsAndCustom {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("David", 25),
                new Person("Eve", 40)
        );

        //collectNames(people);
        List<String> words = List.of("apple", "banana", "cherry", "date");
        longestWordUSingReduce(words);
    }

    // Group people by age and collect names as a comma-separated string using Collectors
    public static void collectNames(List<Person> list){

       Map<Integer, String> map = list.stream()
               .collect(Collectors.groupingBy(x -> x.age, Collectors.mapping(x -> x.name, Collectors.joining(","))));
        System.out.println(map);
    }

    //Find the longest word in a list using reduce()
    public static void longestWordUSingReduce(List<String> list){

        String ans = list.stream().reduce((w1,w2) -> w1.length()>=w2.length()?w1:w2).orElse("");
        System.out.println(ans);
    }

}
