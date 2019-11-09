package onethreadonepixel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;


public class Mandelbrot extends JFrame {


    int nthreads = 10;
    int ntasks = 1;
    int MAX_ITER = 570;
    private BufferedImage I;


    public Mandelbrot(int nthreads, int MAX_ITER) throws Exception {
        super("Mandelbrot Set");
        this.ntasks = ntasks;
        this.nthreads = nthreads;
        this.MAX_ITER = MAX_ITER;


        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);


        ExecutorService pool = Executors.newFixedThreadPool(nthreads);

        Set<Future<Pixel>> pixels = new HashSet<>();

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                pixels.add(pool.submit(new Task(this, x, y)));
            }
        }


        for (Future<Pixel> pixel : pixels) {
            Pixel p = pixel.get();
            I.setRGB(p.x, p.y, p.iter | (p.iter << 8));

        }


    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }


}