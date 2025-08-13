package Multithreading;

class PrintNumbers{

    private int maxNumber = 10;
    private int number = 0;
    private boolean isEven = true;


    public synchronized void printEven() {
        while(number < maxNumber) {
            if (isEven) {
                System.out.println("Evenn Number: " + number++);
                isEven = false;
                notify();
            } else if (!isEven) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void printOdd() {

        while(number < maxNumber){
            if(!isEven){
                System.out.println("Odd number: "+ number++);
                isEven = true;
                notify();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}


public class PrintEvenOdds {

    public static void main(String[] args) {
        PrintNumbers printer = new PrintNumbers();

        Thread evenThread = new Thread(() -> printer.printEven());
        Thread oddThread = new Thread(() -> printer.printOdd());

        evenThread.start();
        oddThread.start();
    }

}
