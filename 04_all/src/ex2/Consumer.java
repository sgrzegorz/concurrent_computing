package ex2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
    Buffer buf;
    static Consumer pool[];
    static int N;

    Consumer(Buffer buf){
        this.buf = buf;
    }


    public void run() {

            for(;;){
                int rn = randomNumber();
                if(buf.nelem >= rn){
                    buf.consume(this, rn);
                }


            }

    }



    static void initialiseThreads(int N,Buffer buf){
        Consumer.N =N;
        pool = new Consumer[N];
        for(int i=0;i<N;i++){
            pool[i] =new Consumer(buf);
        }
    }


    int randomNumber(){
        Random random = new Random();
        return random.nextInt(buf.size/2);
    }

}
