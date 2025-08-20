package Maps;

import java.util.*;

public class MapQuestions {

    public static void main(String[] args) {
        mapOfMap();
    }

    public static void mapOfMap(){

        Map<Integer , Map<Integer, String>> mapOfMap = new HashMap<>();
        Map<Integer, String> valueMap = new HashMap<>();

        valueMap.put(1, "student1");
        valueMap.put(2, "student2");
        valueMap.put(3, "student3");

        mapOfMap.put(123, valueMap);


        mapOfMap.entrySet().stream().forEach( m -> {

            Integer outerKey = m.getKey();
            Map<Integer, String> map = m.getValue();

            map.entrySet().stream().forEach(v -> {
                System.out.println("key: "+ v.getKey()+" value: "+ v.getValue());
            });


        });

    }
}
