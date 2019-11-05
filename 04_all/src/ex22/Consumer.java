package ex22;

import ex21.Buffer;

import java.util.Random;

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    public void run() {

        for(int i = 0;  i < 10000;   i++) {
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
