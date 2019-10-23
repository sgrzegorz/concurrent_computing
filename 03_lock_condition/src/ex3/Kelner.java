package ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kelner {
    Lock lock =new ReentrantLock();
    Condition cond [];
    Osoba osoby[];
    int obecni[];
    boolean flag =false;
    Condition cond2 = lock.newCondition();
    int przy_stoliku = 2;


    public void configure(int npairs,Osoba []osoby){
        this.osoby = osoby;
        cond = new Condition[npairs];
        for(int i=0;i<npairs;i++) cond[i] = lock.newCondition();

        obecni = new int[npairs];
        for(int i=0;i<npairs;i++) obecni[i] =0;

    }


    public void chceStolik(Osoba o)  {
        int id_pary = o.getIdPary();

        lock.lock();
        while(flag){
            try { cond2.await(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        obecni[id_pary]++;
        while(obecni[id_pary] == 2 ){
            try { cond[o.id_pary].await(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        flag = true; //jak thread jest tutaj to jego partner stoi w kolejce 2 linijki wyżej

        cond[id_pary].signal();

        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " siadam przy stoliku");

    }


    public void zwalniam(Osoba o){
        przy_stoliku--;
        if(przy_stoliku==0){
            //posprzataj
            obecni[o.getIdPary()] =0;
            przy_stoliku=2;
            flag=false;
            cond2.signalAll();
        }
        System.out.println(Thread.currentThread().getName() + " opuszczam stolik");

    }
}
