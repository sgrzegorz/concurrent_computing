import java.util.*;
import java.util.concurrent.Callable;

public class Task implements Callable {

    Mandelbrot mandelbrot;
    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private double zx, zy, cX, cY, tmp;
    TaskRange range;


    public Task(Mandelbrot mandelbrot, TaskRange range){
       this.mandelbrot = mandelbrot;
       this.range = range;
    }

    @Override
    public Object call() throws Exception {
        List<Pixel> pixels= new ArrayList<>();
        for (int x = range.begin; x < range.end; x++) {
            for (int y = 0; y < mandelbrot.getHeight(); y++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                pixels.add(new Pixel(x,y,iter));

            }
        }

        return pixels;


    }
}
