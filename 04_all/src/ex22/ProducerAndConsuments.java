package ex22;




public class ProducerAndConsuments {


    public static void main(String [] args){

        int M=100000;
        int nprod =1000;
        int ncons =1000;

        boolean verbose = false;

        Buffer buffer = new Buffer(2*M,verbose);
        Producer producents[] = new Producer[nprod];
        Consumer consumers[] = new Consumer[ncons];

        for (Producer p : producents){
            p = new Producer(buffer);
            p.start();
        }

        for (Consumer c : consumers){
            c=new Consumer(buffer);
            c.start();
        }



        /////////////////////////

        try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Prod\t"+buffer.timer.prod_time/buffer.timer.nprod);
        //System.out.println( "prod=" +buffer.timer.nprod);

        System.out.println("Cons\t"+buffer.timer.cons_time/buffer.timer.ncons);
        //System.out.println("ncons" +buffer.timer.ncons);

    }
}
