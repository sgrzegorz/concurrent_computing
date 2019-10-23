package ex2;


import java.util.Random;

public class Main {
//    for (Producer p : producents){
//        p = new Producer(buffer);
//        p.start();
//    }


    public static void main(String[] args) throws InterruptedException {
        int nDrukarek=3;
        Drukarka drukarki[]=new Drukarka[nDrukarek];
        for(int i=0;i<nDrukarek;i++){
            drukarki[i]= new Drukarka(i);
        }

        MonitorDrukarek md = new MonitorDrukarek(drukarki);
        Thread.sleep(100);


        for(int i=0;i<10;i++){
            Watek w = new Watek(md);
            w.start();
        }
    }




}
