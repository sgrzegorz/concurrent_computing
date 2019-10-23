package ex3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Para {

    private int M;
    private Drukarka[] drukarki;
    private Lock[] locks;
//    Condition conds[] = new

    Para(int M) {
        this.M = M;
        drukarki = new Drukarka[M];
        locks = new ReentrantLock[M];

        for (int i = 0; i < M; i++) {
            locks[i] = new ReentrantLock();
            drukarki[i] = new Drukarka(i);
        }
    }

    public Drukarka zarezerwuj(int i) {
        locks[i].lock();
        System.out.println(Thread.currentThread().getName() + " drukarka nr:"+ i +" rezerwuje");

        return drukarki[i];
    }

    public void zwolnij(int i) {
        System.out.println(Thread.currentThread().getName() + "drukarka nr:"+ i +" zwalniam");
        locks[i].unlock();
    }

    public int getM() {
        return M;
    }



}
