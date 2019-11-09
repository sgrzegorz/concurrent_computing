import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;


public class Mandelbrot extends JFrame implements Callable {

    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private double zx, zy, cX, cY, tmp;

    private BufferedImage I;
    int nthreads =10;



    public Mandelbrot() {
        super("Mandelbrot Set");

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {

                    Operation o = new Operation(this, x,y);



                I.setRGB(x, y, iter | (iter << 8));


            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }


    @Override
    public Object call() throws Exception {

    }
}