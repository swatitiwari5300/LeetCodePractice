package Classes;

import java.util.Objects;

class Person{

    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Person person)) return false;
        return age == ((Person) o).age && Objects.equals(name, ((Person) o).name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

}

public class hashcodeAndEquals {

    public static void main(String[] args) {
        Person p1 = new Person("Somya", 16);
        Person p2 = new Person("Somya", 16);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
