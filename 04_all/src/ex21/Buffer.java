package ex21;

import static java.lang.Thread.sleep;

class Buffer{


    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";


    public int MAX_QUEUE =10;
    String array[] = new String[MAX_QUEUE];
    int index=0;


    synchronized void  produce(int n ,String val) throws InterruptedException {

        int free =  MAX_QUEUE-(index+1);
        while(index == MAX_QUEUE-1 || free < n ) {
            System.out.println(Thread.currentThread()+"PPP");
            wait();
            free =  MAX_QUEUE-(index+1);
        }
        System.out.println(Thread.currentThread()+"P");

        for(int i=0;i<n;i++){
            sleep(4);
            System.out.println(ANSI_YELLOW_BACKGROUND +"Producer "+ Thread.currentThread().getName() + " produces <" + val + ">" + (i+1)+"/"+n +ANSI_RESET);
            index++;
            array[index]=val;
        }

        notifyAll();
    }


    synchronized void consume(int n) throws InterruptedException {
        while(index ==0 || n> index ){
            System.out.println(Thread.currentThread()+"CCC");
            wait();
        }
        System.out.println(Thread.currentThread()+"C");


        for(int i=0;i<n;i++) {
            sleep(4);
            String val = array[index];
            index--;
            System.out.println(ANSI_BLUE_BACKGROUND + "Consumer " + Thread.currentThread().getName() + " consumes <" + val + "> "+(i+1)+"/"+n + ANSI_RESET);
        }

        notifyAll();


    }



}
