package Stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPuzzleAndEdges {

    static class Transaction {
        String userId;
        double amount;

        public Transaction(String userId, double amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }


    public static void main(String[] args) {
        List<String> words = List.of("level", "stream", "noon", "hello", "madam", "world");
        //palindromicWords(words);

        String sentence = "Java Stream API is powerful";
        //reverseEveryWord(sentence);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2, 6);
        //detectDuplicate(numbers);

        List<Transaction> transactions = List.of(
                new Transaction("user1", 250.0),
                new Transaction("user2", 100.0),
                new Transaction("user1", 300.0),
                new Transaction("user3", 400.0),
                new Transaction("user2", 150.0)
        );
        calculateAmountByEachUser(transactions);

    }

    //Find all palindromic words in a list using Stream API.
    public static void palindromicWords(List<String> list){

        List<String> ans = list.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString())).toList();
        System.out.println(ans);

    }

    // Write a Stream-based solution to reverse every word in a sentence
    public static void reverseEveryWord(String sentence){

        String ans = Arrays.stream(sentence.split(" "))
                .map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(ans);

    }

    // Using Stream API, how can you detect if a list has duplicates?
    public static void detectDuplicate(List<Integer> list){

        List<Integer> newList = list.stream().distinct().toList();
        if(list.size() == newList.size()){
            System.out.println(false);
        }else{
            System.out.println(true);
        }

    }

    // Given a list of transactions, calculate the total amount spent by each user
    public static void calculateAmountByEachUser(List<Transaction> transactions){

        transactions.stream()
                .collect(Collectors.groupingBy(x -> x.userId, Collectors.summingDouble(x -> x.amount)))
                .entrySet().forEach(x -> {
                    System.out.println(x.getKey()+": "+x.getValue());
                });

    }
}
