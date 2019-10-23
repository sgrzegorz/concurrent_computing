package ex3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kelner {
    Lock lock1 =new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Condition cond1 = lock1.newCondition();
    Condition cond2 = lock2.newCondition();


    public void chceStolik(){
        lock1.lock();
        lock1.tryLock();

        while
    }

    public void zwalniam(){

    }
}
