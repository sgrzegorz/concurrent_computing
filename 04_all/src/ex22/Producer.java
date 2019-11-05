package ex22;

import ex21.Buffer;

import java.util.Random;

class Producer extends Thread {
    static int message_id=0;
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    int randomNumber(){
        Random random = new Random();
        return random.nextInt(buffer.MAX_QUEUE/2);
    }

    public void run() {

        for(int i = 0;  i < 10000;   i++) {
            try {
                synchronized (ex21.Producer.class)
                {

                    buffer.produce(randomNumber(),"message_"+message_id);
                    message_id++;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
