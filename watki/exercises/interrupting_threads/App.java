package interrupting_threads;

import java.util.Random;
import java.util.SortedMap;

public class App {
    public static void main(String[]args) throws Exception{
        System.out.println("Starting...");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();

                for(int i=0;i<1E8;i++){

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });


        t.start();
        Thread.sleep(500);
        t.interrupt(); //doesnt kill the thread

        t.join();
        System.out.println("Finished...");

    }


}
