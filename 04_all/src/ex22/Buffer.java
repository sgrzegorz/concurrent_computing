package ex22;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.nanoTime;
import static java.lang.Thread.sleep;

class Buffer{


    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Buffer(int MAX_QUEUE,boolean verbose) {
        this.MAX_QUEUE = MAX_QUEUE;
        array = new String[MAX_QUEUE];
        this.verbose = verbose;
    }


    Lock lock = new ReentrantLock();
    Condition cons = lock.newCondition();
    Condition rcons = lock.newCondition();
    Condition prod = lock.newCondition();
    Condition rprod = lock.newCondition();
    boolean freefirstcons = true;
    boolean freefirstprod = true;

    public int MAX_QUEUE;
    String array[];
    int index=0;
    Timer timer = new Timer();


    boolean verbose;


    void  produce(int n ,String val) throws InterruptedException {
        lock.lock();
        long start = timer.start();

        while(!freefirstprod){
            rprod.await();
        }


        while(index == MAX_QUEUE-1|| MAX_QUEUE-(index+1) < n ){
            prod.await();
        }


       if(verbose)System.out.println(Thread.currentThread()+"P");

        for(int i=0;i<n;i++){

         if(verbose){  System.out.println(ANSI_YELLOW_BACKGROUND +"Producer "+ Thread.currentThread().getName() + " produces <" + val + ">" + (i+1)+"/"+n +ANSI_RESET); sleep(4);}
            index++;
            array[index]=val;
        }


        freefirstprod =true;
        rprod.signal();
        cons.signal();


        timer.stopProd(start);
        lock.unlock();

    }


    void consume(int n) throws InterruptedException {
        lock.lock();
        long start = timer.start();

        while(!freefirstcons){
            rcons.await();
        }


        while(index ==0||n> index ){
            cons.await();
        }


        for(int i=0;i<n;i++) {

            String val = array[index];
            index--;
            if(verbose){ System.out.println(ANSI_BLUE_BACKGROUND + "Consumer " + Thread.currentThread().getName() + " consumes <" + val + "> "+(i+1)+"/"+n + ANSI_RESET);sleep(4);}
        }

        freefirstcons=true;
        rcons.signal();;
        prod.signal();

        timer.stopCons(start);
        lock.unlock();
    }





}
