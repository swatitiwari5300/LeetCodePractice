import java.util.*;

class Student implements Comparable<Student>{

    String name;
    int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString(){
        return "name: "+this.name+" and age: "+ this.age;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {

        if(this.age > o.age) return 1;
        else if (this.age == o.age) return 0;
        return -1;
    }
}
public class prep {

    public static void main(String[] args) {
        //compareStrings();
        //compareStudents();
        compareStudentsUsingComparable();
    }


    //Comparator for sorting the Integers on the basis of last digit of the number
    public static void comparator(){

        List<Integer> list = new ArrayList<>();
        list.add(83);
        list.add(51);
        list.add(22);
        list.add(74);

        //normal sorting in ascending order
        Collections.sort(list);
        System.out.println(list);

        //sort on the basis of last digit of the integer
        Comparator<Integer> com = new Comparator<Integer> (){

            @Override
            public int compare(Integer i, Integer j){
                if(i%10 > j%10){
                    return 1;
                }
                return -1;
            }

        };

        Collections.sort(list, com);
        System.out.println(list);

    }

    public static void compareStudentsUsingComparable(){

        List<Student> list = new ArrayList<>();
        list.add(new Student("Swati", 34));
        list.add(new Student("Somya", 12));
        list.add(new Student("Harsh", 44));

        Collections.sort(list);
        System.out.println(list);
    }


    //Sorting the List of String on the basis of Length of each String in the list
    public static void compareStrings(){

        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() > o2.length()) return 1;
                return -1;
            }
        };

        List<String> list = new ArrayList<>();
        list.add("ass");
        list.add("assssssss");
        list.add("a");

        Collections.sort(list, com);
        System.out.println(list);
    }

    //Sort the Students based on Student age using comparator
    public static void compareStudents(){
        Comparator<Student> com = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age > o2.age) return 1;
                else if (o1.age == o2.age) return 0;
                return -1;
            }
        };

        List<Student> list = new ArrayList<>();
        list.add(new Student("Swati", 34));
        list.add(new Student("Somya", 12));
        list.add(new Student("Harsh", 44));

        Collections.sort(list, com);
        System.out.println(list);
    }

}
