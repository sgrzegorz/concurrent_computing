package ex1;

import java.util.Random;

public class Consumer extends Thread{
    Consumer(Buffer buf){
        this.buf = buf;
    }
    int position = 0;
    Buffer buf;
    public void run() {
        for(;;){
            buf.consume(this);
        }

    }

    void doSomething(){
        Random random = new Random();
        try { Thread.sleep(random.nextInt(100)); } catch (InterruptedException e) { e.printStackTrace(); }
    }

}
