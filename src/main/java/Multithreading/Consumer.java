package Multithreading;

public class Consumer extends Thread{

    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run(){
        while(true){
            try {
                int result = buffer.consume();
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
