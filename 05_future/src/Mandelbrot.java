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
    int ntasks=91;



    public Mandelbrot() throws Exception {
        super("Mandelbrot Set");



        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);


        List<TaskRange> ranges = calculateRanges(getWidth());
//        ExecutorService pool = Executors.newFixedThreadPool(nthreads);
//
//        Set<Future<List<Pixel>>> pixels= new HashSet<>();
//        for(TaskRange range :ranges){
//            pixels.add(pool.submit(new Task(this, range)));
//        }
//
//        for(Future<List<Pixel>> pixelArray: pixels){
//            for(Pixel p: pixelArray.get()){
////                System.out.println(p.x + " " +p.y);
//                I.setRGB(p.x, p.y, p.iter | (p.iter << 8));
//            }
//        }


    }

    private List<TaskRange> calculateRanges(int k ){

        int cutStart = 0;
        double width = ((double) k )/ntasks;
        System.out.println(width);
        int cutWidth = (int) Math.ceil(width);
        List<TaskRange> ranges = new ArrayList<>();

        for (int i = 0; i < ntasks; i++) {

            int cutEnd = cutStart+cutWidth;


            if(i == ntasks-1 && cutEnd>k) cutEnd = k;


            ranges.add(new TaskRange(cutStart,cutEnd));
            System.out.println(i+" ("+cutStart+","+ cutEnd+")");

            cutStart=cutEnd;

        }

        return ranges;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }


}