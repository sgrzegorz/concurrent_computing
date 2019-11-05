package ex2;

import java.util.Random;

public class Producer extends Thread  {
    Buffer buf;
    static Producer pool[];
    static int N;

    Producer(Buffer buf){
        this.buf = buf;
    }


    public void run() {
        for(;;){

            buf.produce(this,randomNumber());

        }
    }



    static void initialiseThreads(int N,Buffer buf){
        Producer.N =N;
        pool = new Producer[N];
        for(int i=0;i<N;i++){
            pool[i] =new Producer(buf);
        }
    }


    int randomNumber(){
        Random random = new Random();
        return random.nextInt(buf.size/2); }
}

