package ex21;

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


    public int MAX_QUEUE;
    String array[];
    boolean verbose;
    int index=0;
    Timer timer = new Timer();


    synchronized void  produce(int n ,String val) throws InterruptedException {
        long start = timer.start();

        int free =  MAX_QUEUE-(index+1);
        while(index == MAX_QUEUE-1 || free < n ) {
            if(verbose)System.out.println(Thread.currentThread()+"PPP");
            wait();
            free =  MAX_QUEUE-(index+1);
        }
        if(verbose)System.out.println(Thread.currentThread()+"P");

        for(int i=0;i<n;i++){

            if(verbose){System.out.println(ANSI_YELLOW_BACKGROUND +"Producer "+ Thread.currentThread().getName() + " produces <" + val + ">" + (i+1)+"/"+n +ANSI_RESET); sleep(4);}
            index++;
            array[index]=val;
        }


        notifyAll();
        timer.stopProd(start);
    }


    synchronized void consume(int n) throws InterruptedException {
        long start = timer.start();

        while(index ==0 || n> index ){
            if(verbose)System.out.println(Thread.currentThread()+"CCC");
            wait();
        }
        if(verbose)System.out.println(Thread.currentThread()+"C");


        for(int i=0;i<n;i++) {

            String val = array[index];
            index--;
            if(verbose){System.out.println(ANSI_BLUE_BACKGROUND + "Consumer " + Thread.currentThread().getName() + " consumes <" + val + "> "+(i+1)+"/"+n + ANSI_RESET);sleep(4);}
        }

        notifyAll();

       timer.stopCons(start);
    }



}
