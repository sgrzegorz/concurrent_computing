package ex11;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
    Semaphore semaphore;
    Buffer buf;
    int buf_pos=0;
    static Consumer pool[];
    static int N;

    Consumer(Buffer buf){
        this.buf = buf;
    }
    int position = 0;
    public void run() {
        for(;;){

//            try { getPrevious().semaphore.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }

            try { semaphore.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            buf.consume(this);
            //try { semaphore.release(); } catch (InterruptedException e) { e.printStackTrace(); }

            //opuscilem ten element teraz poprzednik moze skonsumowac jeden element wiecej
            getPrevious().semaphore.release();


        }


    }

    Consumer getPrevious()  {
        int i = getMyId();
        int k = (i-1>=0) ? (i-1)% Consumer.N : i-1+ Consumer.N;
//        System.out.println(i + " prev " + k);

        return  pool[k];

    }

    int getMyId()  {
        for(int i=0;i<N;i++){
            if(pool[i]==this){
                return i;
            }
        }
        throw new Error("No id found");
    }



    static void initialiseThreads(int N, Buffer buf){
        if(N >= buf.size) throw new Error("Max number of threads must be smaller than buff size ");
        Consumer.N =N;
        pool = new Consumer[N];
        for(int i=0;i<N;i++){
            pool[i] =new Consumer(buf);
            pool[i].semaphore= new Semaphore(-1);
        }
        pool[0].semaphore = new Semaphore(buf.size-1);
    }


    void doSomething(){
        Random random = new Random();
        try { Thread.sleep(random.nextInt(100)); } catch (InterruptedException e) { e.printStackTrace(); }
    }


}
