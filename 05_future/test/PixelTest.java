import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.junit.Test;
import onethreadonepixel.*;

public class PixelTest {

    @Test
    public void oneThreadOnePixel() throws Exception {
        int k[] ={1,5,8,20,30,50,80};
        for(int i: k){
            calc(i,570);
        }
    }



    public void calc(int nthreads,int MAX_ITER) throws Exception {
        double [] list = new double[10];

        //pierwsze wywolanie inicjalizuje obiekty
        new onethreadonepixel.Mandelbrot(nthreads,MAX_ITER).setVisible(false);

        for(int i=0;i<10;i++){
            long s = System.nanoTime();
            new onethreadonepixel.Mandelbrot(nthreads,MAX_ITER).setVisible(false);
            long e = System.nanoTime();
            list[i]=((double) e-s);
//            System.out.println(list[i]);

        }

        StandardDeviation sd = new StandardDeviation(false);
        sd.evaluate(list);
        Mean mean = new Mean();
        System.out.println("nthreads="+nthreads+"\tmax_iter="+MAX_ITER+"\tmean="+mean.evaluate(list)+"\tsd="+sd.evaluate(list));

    }
}
