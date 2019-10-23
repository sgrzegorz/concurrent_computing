package ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kelner {
    Lock lock =new ReentrantLock();
    Condition cond1 = lock.newCondition();
    Condition cond [];
    Osoba osoby[];
    int obecni[];

    Lock stolik = new ReentrantLock();


    public void configure(int npairs,Osoba []osoby){
        this.osoby = osoby;
        cond = new Condition[npairs];
        for(int i=0;i<npairs;i++) cond[i] = lock.newCondition();

        obecni = new int[npairs];
        for(int i=0;i<npairs;i++) obecni[i] =0;

    }


    public void chceStolik(Osoba o){
        int id_pary = o.getIdPary();

        lock.lock();
        cond1.await();

        obecni[id_pary]++;
        while(obecni[id_pary] == 1 ){

            try { cond[o.id_pary].await(); } catch (InterruptedException e) { e.printStackTrace(); }
        }


        cond[id_pary].signal();
        stolik.lock();
        lock.unlock();





    }

    public void zwalniam(Osoba o){
        obecni[o.getIdPary()]--;
        if(obecni[o.getIdPary()]==0) stolik.unlock();
    }
}
