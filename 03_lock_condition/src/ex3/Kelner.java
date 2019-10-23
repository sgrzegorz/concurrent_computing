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


    Lock stolik =new ReentrantLock();
    Condition cond3 =  lock.newCondition();


    public void configure(int npairs,Osoba []osoby){
        this.osoby = osoby;
        cond = new Condition[npairs];
        for(int i=0;i<npairs;i++) cond[i] = lock.newCondition();

        obecni = new int[npairs];
        for(int i=0;i<npairs;i++) obecni[i] =0;

    }


    boolean stolik_zarezerwowany=false;
    public void chceStolik(Osoba o)  {


        lock.lock();

        if(obecni[o.id_pary]==0){
            obecni[o.id_pary]++;
            System.out.println("i");
            while(obecni[o.id_pary] == 1 ){
                try { cond[o.id_pary].await(); } catch (InterruptedException e) { e.printStackTrace(); }
            }

            while(stolik_zarezerwowany){
                try { cond2.await(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            System.out.println("hhhhhh");
            stolik_zarezerwowany=true;
            cond[o.id_pary].signal();

        }else {
            System.out.println("j");
            cond[o.id_pary].signal();

            try { cond[o.id_pary].await(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println(Thread.currentThread().getName() + " siadam przy stoliku");

        lock.unlock();


    }

    int przy_stoliku = 2;
    public void zwalniam(Osoba o){
        lock.lock();

        przy_stoliku--;
        if(przy_stoliku==0){
            //posprzataj
            obecni[o.id_pary] =0;
            przy_stoliku=2;
            stolik_zarezerwowany=false;
            cond2.signal();

        }
        System.out.println(Thread.currentThread().getName() + " opuszczam stolik");

        lock.unlock();

    }
}
