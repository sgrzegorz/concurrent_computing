package ex4;

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
    Condition czekaNaStolik =lock.newCondition();

    Lock stolik =new ReentrantLock();
    Condition cond3 =  lock.newCondition();


    public void configure(int npairs, Osoba[]osoby){
        this.osoby = osoby;
        cond = new Condition[npairs];
        for(int i=0;i<npairs;i++) cond[i] = lock.newCondition();

        obecni = new int[npairs];
        for(int i=0;i<npairs;i++) obecni[i]=0;

    }

    int przy_stoliku =0;
    public void chceStolik(Osoba o)  {


        lock.lock();
        obecni[o.id_pary]++;

        if( obecni[o.id_pary]==1){
            try { cond[o.id_pary].await(); } catch (InterruptedException e) { e.printStackTrace(); }

        }else {
            if(przy_stoliku>0) try { czekaNaStolik.await(); } catch (InterruptedException e) { e.printStackTrace(); }
            przy_stoliku = 2;
            cond[o.id_pary].signal();
        }

        System.out.println(o.id_pary +" para "+ Thread.currentThread().getName() + " siadam przy stoliku");

        lock.unlock();


    }


    public void zwalniam(Osoba o){
        lock.lock();

        przy_stoliku--;
        if(przy_stoliku==0){
            czekaNaStolik.signal();
            obecni[o.id_pary] =0;
            przy_stoliku=2;


        }
        System.out.println(o.id_pary +" para "+Thread.currentThread().getName() + " opuszczam stolik");

        lock.unlock();

    }
}
