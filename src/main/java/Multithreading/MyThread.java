package Multithreading;

public class MyThread implements Runnable{
    @Override
    public void run() {
        //task for thread....
        for(int  i = 0 ; i < 11 ; i++){
            System.out.println("value of id: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        //create object of my thread class

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);

        thread.start();
    }
}
