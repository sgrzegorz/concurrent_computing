package ex3;


public class Main {
//    for (Producer p : producents){
//        p = new Producer(buffer);
//        p.start();
//    }


    public static void main(String[] args) throws InterruptedException {
        Para md = new Para(3);
        Thread.sleep(100);
        for(int i=0;i<10;i++){
            Watek w = new Watek(md);
            w.start();
        }
    }




}
