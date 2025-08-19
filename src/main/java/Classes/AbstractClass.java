package Classes;

 class Car{
     int a = 10;
     void drive(){
         System.out.println(a);
    }

    void playMusic(){
        System.out.println("Music is Playing");
    }
}

class WagonR extends Car{
    int a = 20;
    @Override
    void drive(){
        System.out.println(a);
    }


    @Override
    void playMusic(){
        System.out.println("WagonR is playing music");
    }
}

public class AbstractClass {
    public static void main(String[] args) {

        Car c = new WagonR();
        c.drive();

    }
}
