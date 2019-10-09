package reentrant_lock1;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private int count =0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }

    public void firstThread() throws InterruptedException{
        lock.lock();
        System.out.println("waiting ... ");
        cond.await();
        System.out.println("Woken up!");

        try{
            increment();
        }finally {
            lock.unlock();
        }
    }



    public void secondThread() throws InterruptedException{
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got returned key");

        cond.signal();

        try{
            increment();
        }finally {
            System.out.println("zwalniam locka!");
            lock.unlock(); // dopiero jak zawołam unlock to firstThread może zaskoczyc nawet jescli zawolalem wczesniej signal
        }

    }

}
