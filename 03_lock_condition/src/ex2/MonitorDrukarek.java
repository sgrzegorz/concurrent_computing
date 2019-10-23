package ex2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorDrukarek {


    private Drukarka[] drukarki;
    private boolean used[];
    int nFreeDrukarki;

    private Lock lock=new ReentrantLock();
    private Condition noAvailable = lock.newCondition();

    MonitorDrukarek(Drukarka []drukarki) {

        this.drukarki =drukarki;

        used = new boolean[drukarki.length];
        for(int i=0;i<drukarki.length;i++){
            used[i] =false;
        }
        nFreeDrukarki =drukarki.length;
    }

    private Drukarka getFreeDrukarka(){
        for(int i=0;i<drukarki.length;i++){
            if(!used[i]){
                nFreeDrukarki --;
                return drukarki[i];
            }
        }
        return null;
    }


    public Drukarka zarezerwuj() {
        lock.lock();

        Drukarka drukarka=getFreeDrukarka();
        while(drukarka==null){
            try { noAvailable.await(); } catch (InterruptedException e) { e.printStackTrace(); }
            drukarka =getFreeDrukarka();
        }
        System.out.println(Thread.currentThread().getName() + " drukarka rezerwuje");

        return drukarka;

    }

    public void zwolnij() {
        System.out.println(Thread.currentThread().getName() + "drukarka  zwalniam");
        nFreeDrukarki++;
        noAvailable.signal();
        lock.unlock();
    }




}
