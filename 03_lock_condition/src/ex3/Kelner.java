package ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kelner {
    Lock lock1 =new ReentrantLock();
    Osoba osoby[];
    Condition cond = lock.newCondition();


    Lock lock = new ReentrantLock();
    int id_pary=-1;

    Condition cond1 = lock1.newCondition();
    Condition condA = lock1.newCondition();
    Condition condB = lock1.newCondition();
    Condition cond = lock.newCondition();

    int flag

    public void setOsoby(Osoba []o){
        this.osoby = osoby;
    }


    public void chceStolik(Osoba o,int id_pary){

        lock.lock();
        this.id_pary = id_pary;
        while(this.id_pary!=id_pary){

            try { cond.await(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        this.id_pary = id_pary;

        cond.signal();
        lock.unlock();


        lock1.lock();


        cond1.await();
        cond1.signal();




    }

    public void zwalniam(Osoba o,int id_pary){
        cond1.signal();
        lock1.unlock();
    }
}
