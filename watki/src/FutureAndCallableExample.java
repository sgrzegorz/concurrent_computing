import java.util.concurrent.*;

 class Kot implements Callable{

    @Override
    public Kot call() throws Exception {
        return new Kot();
    }
}

public class FutureAndCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        Kot k = new Kot();

        System.out.println("Submitting Callable");
        Future<Kot> future = executorService.submit(k);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        Kot result = future.get();
        System.out.println(result);

        executorService.shutdown();
    }

}