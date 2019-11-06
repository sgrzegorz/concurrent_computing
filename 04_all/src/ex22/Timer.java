package ex22;

public class Timer {
    long cons_time = 0;
    long nprod =0;
    long ncons =0;
    long prod_time = 0;

    long start(){
        return System.nanoTime();
    }

    void stopProd(long start){
        long end = System.nanoTime();
        prod_time+=(end-start);
        nprod++;
    }

    void stopCons(long start){
        long end = System.nanoTime();
        cons_time+=(end-start);
        ncons++;
    }


}
