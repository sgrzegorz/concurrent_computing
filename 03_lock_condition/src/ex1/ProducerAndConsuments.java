package ex1;


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





    }
}
