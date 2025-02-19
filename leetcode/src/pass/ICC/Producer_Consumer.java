package pass.ICC;
import java.util.*;

public class Producer_Consumer {
    
    public static void main(String[] args) throws Exception 
    {
        List<Integer> buffer = new ArrayList<>(1);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable{
    private final List<Integer> buffer;

    public Producer(List<Integer> buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int value = 0;
        while (true){
            synchronized (buffer){
                while (buffer.size() == 1){
                    try {
                        buffer.wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                buffer.add(value);

                System.out.println("produced " + value);
                
                value++;
                buffer.notifyAll();
            }
        }
    }
}


class Consumer implements Runnable{
    private final List<Integer> buffer;

    public Consumer(List<Integer> buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        while (true){
            synchronized (buffer){
                while (buffer.isEmpty()){
                    try {
                        buffer.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    int value = buffer.remove(0);

                    System.out.println("consumed " + value);

                    buffer.notifyAll();
                }
            }
        }
    }
}