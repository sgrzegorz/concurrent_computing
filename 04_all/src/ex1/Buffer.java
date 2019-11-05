package ex1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    public Buffer(int size){
        this.size = size;
        for(int i=0;i<size;i++){
            locks[i] = new ReentrantLock();
            conds[i]= locks[i].newCondition();
            free[i]=true;
        }
    }
///////////////////////////////////////////
    int size=10;
    Condition conds [] = new Condition[size];
    boolean free[] = new boolean[size];
    int array[] = new int[size];
    Lock locks [] = new ReentrantLock[size];


    public void consume(Consumer c){
        locks[c.position].lock();
        c.doSomething();
        if(free[(c.position+1)%size]){

        }else{
            try { conds[c.position].await(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println((-1)%10);
        int previous =  (c.position-1>=0) ? (c.position-1)%size : c.position-1+size;
        conds[previous].signal();

        locks[c.position].unlock();

    }

}
