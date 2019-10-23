package ex2;


import java.util.Random;

public class Main {
//    for (Producer p : producents){
//        p = new Producer(buffer);
//        p.start();
//    }


    public static void main(String[] args) throws InterruptedException {
        MonitorDrukarek md = new MonitorDrukarek(3);
        Thread.sleep(100);
        for(int i=0;i<10;i++){
            Watek w = new Watek(md);
            w.start();
        }
    }




}
