package synchronized_wait;

import java.util.LinkedList;
import java.util.Random;

public class Processor1 {
    private LinkedList <Integer> list = new LinkedList<Integer>();
    private final int LIMIT=0;
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        int value = 0;

        while(true){
            synchronized (lock){
                while(list.size() == LIMIT){
                    lock.wait();
                }

                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException{
        Random random = new Random();

        while(true){

            synchronized (lock){
                System.out.println("List size is" + list.size());
                while(list.size() == 0){
                    lock.wait();
                }
                int value = list.removeFirst();
                System.out.println(";value is "+ value);
                lock.notify();
            }

            Thread.sleep(random.nextInt());
        }
    }



}
