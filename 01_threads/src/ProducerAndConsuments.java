import java.util.ArrayList;

import java.util.ArrayList;
import java.util.EmptyStackException;




import static java.lang.Thread.sleep;

class Buffer{


    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";


    private final int MAX_QUEUE =10;
    String array[] = new String[MAX_QUEUE];
    int index=0;


    synchronized void  produce(String val) throws InterruptedException {
        while(index == MAX_QUEUE-1){
            wait();
        }
        sleep(4);
        System.out.println(ANSI_YELLOW_BACKGROUND +"Producer "+ Thread.currentThread().getName() + " produces <" + val + ">" + ANSI_RESET);
        index++;
        array[index]=val;
        notifyAll();
    }


    synchronized void consume() throws InterruptedException {
        while(index ==0){
            wait();
        }
        sleep(4);
        String val = array[index];
        index--;
        System.out.println(ANSI_BLUE_BACKGROUND +"Consumer " + Thread.currentThread().getName()+ " consumes <" + val + "> "+ ANSI_RESET);
        notifyAll();


    }


}




class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    public void run() {

        for(int i = 0;  i < 10000;   i++) {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}



class Producer extends Thread {
    static int message_id=0;
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for(int i = 0;  i < 10000;   i++) {
            try {
                synchronized (Producer.class)
                {

                    buffer.produce("message_"+message_id);
                    message_id++;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}



public class ProducerAndConsuments {


    public static void main(String [] args){
        Buffer buffer = new Buffer();

        Producer producents[] = new Producer[5];

        Consumer consumers[] = new Consumer[5];

        for (Producer p : producents){
            p = new Producer(buffer);
            p.start();
        }

        for (Consumer c : consumers){
            c=new Consumer(buffer);
            c.start();
        }


        System.out.println("Finished");


    }
}
