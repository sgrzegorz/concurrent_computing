package interrupting_threads;

import java.util.Random;
import java.util.concurrent.*;

public class App1 {

    public static void main(String[]args) throws Exception{
        System.out.println("Starting...");

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> fu = exec.submit(new Callable<Void>() {
            public Void call(){
                Random random = new Random();

                for(int i=0;i<1E8;i++) {

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }

                return null;
            }
        });

        exec.shutdown();

        Thread.sleep(500);
//        fu.cancel(true);
        exec.shutdownNow();

        exec.awaitTermination(1,TimeUnit.DAYS);

        System.out.println("Finished...");

    }

}
