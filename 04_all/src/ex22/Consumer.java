package ex22;



import java.util.Random;

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    public void run() {

        for(;;) {
            try {
                buffer.consume(randomNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    int randomNumber(){
        Random random = new Random();
        return random.nextInt(buffer.MAX_QUEUE/2);
    }
}
