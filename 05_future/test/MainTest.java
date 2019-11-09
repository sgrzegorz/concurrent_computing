import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {




    @Test
    public void numberOfCoresAndThreads() throws Exception {
        int iter[]={10,50,70,100,300,700,1500,2000,3000,6000};
        for(int i: iter){
            calc(1,100,i);
            calc(8,100,i);
            calc(16,100,i);
            System.out.println("---");
        }
    }


    @Test
    public void theSameAmountTaskThreads() throws Exception {
        int k[] ={1,5,8,20,30,80,140,170,500,800};
        for(int i: k){
            calc(i,i,570);
        }
    }

    @Test
    public void tenTimesMoreTasksThanThread() throws Exception {
        int k[] ={1,5,8,20,30,80};
        for(int i: k){
            calc(i,10*i,570);
        }
    }



    public void calc(int nthreads, int ntasks,int MAX_ITER) throws Exception {
        double [] list = new double[10];

        //pierwsze wywolanie inicjalizuje obiekty
        new Mandelbrot(nthreads,ntasks,MAX_ITER).setVisible(false);

        for(int i=0;i<10;i++){
            long s = System.nanoTime();
            new Mandelbrot(nthreads,ntasks,MAX_ITER).setVisible(false);
            long e = System.nanoTime();
            list[i]=((double) e-s);
//            System.out.println(list[i]);

        }

        StandardDeviation sd = new StandardDeviation(false);
        sd.evaluate(list);
        Mean mean = new Mean();
        System.out.println("nthreads="+nthreads+"\tntasks="+ntasks+"\tmax_iter="+MAX_ITER+"\tmean="+mean.evaluate(list)+"\tsd="+sd.evaluate(list));

    }
}