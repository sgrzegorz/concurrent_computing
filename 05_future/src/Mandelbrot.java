import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;




public class Mandelbrot extends JFrame  {


    private BufferedImage I;
    int nthreads =10;
    int ntasks=1;



    public Mandelbrot() throws Exception {
        super("Mandelbrot Set");



        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);


        List<TaskRange> ranges = calculateRanges(getWidth(),ntasks);
        ExecutorService pool = Executors.newFixedThreadPool(nthreads);

        Set<Future<List<Pixel>>> pixels= new HashSet<>();
        for(TaskRange range :ranges){
            pixels.add(pool.submit(new Task(this, range)));
        }

        for(Future<List<Pixel>> pixelArray: pixels){
            for(Pixel p: pixelArray.get()){
//                System.out.println(p.x + " " +p.y);
                I.setRGB(p.x, p.y, p.iter | (p.iter << 8));
            }
        }


    }

    //calculate k buckets on range [0,n)
    private List<TaskRange> calculateRanges(int n, int k ){
        if(k>n || k<=0) throw new Error("incorrect bucket size or range");


        int minimalBucketSize =n/k;
        int nWiderBuckets = n%k;

        List<TaskRange> ranges = new ArrayList<>();

        int cutStart =0;
        for (int i = 0; i < ntasks; i++) {
            int cutEnd;
            if(nWiderBuckets>0){
                cutEnd = cutStart+minimalBucketSize+1;
                nWiderBuckets--;

            }else{
                cutEnd = cutStart+minimalBucketSize;
            }

            ranges.add(new TaskRange(cutStart,cutEnd));

            System.out.println(i+" <"+cutStart+","+ cutEnd+")");

            cutStart=cutEnd;

        }

        return ranges;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }


}