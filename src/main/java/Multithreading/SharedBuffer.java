package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    public static final Queue<Integer> buffer = new LinkedList<>();
    public static final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        if(buffer.size() == 5){
            System.out.println("The buffer is full, please wait");
            wait();
        }

        buffer.add(value);
        System.out.println("The value: "+ value+ "  is added in the buffer");
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        if(buffer.isEmpty()){
            System.out.println("The buffer is empty, please wait");
            wait();
        }

        int result = buffer.poll();
        System.out.println("The value: "+result+" is taken out for consumption");
        notify();
        return result;
    }

}
