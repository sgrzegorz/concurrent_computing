package ex22;


import ex21.Buffer;
import ex21.Consumer;
import ex21.Producer;


public class ProducerAndConsuments {


    public static void main(String [] args){
        Buffer buffer = new Buffer();

        Producer producents[] = new Producer[5];

        Consumer consumers[] = new Consumer[5];

        for (Producer p : producents){
            p = new Producer(buffer);
            p.start();
        }

        for (Consumer c : consumers){
            c=new Consumer(buffer);
            c.start();
        }


        System.out.println("Finished");


    }
}
