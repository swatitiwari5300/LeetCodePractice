package Multithreading;

public class Producer extends Thread{

    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int i = 0;
        try {
            while(true){
                buffer.produce(i++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
