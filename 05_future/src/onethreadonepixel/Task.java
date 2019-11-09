package onethreadonepixel;

import java.util.*;
import java.util.concurrent.Callable;

public class Task implements Callable {

    private final double ZOOM = 150;
    Mandelbrot mandelbrot;
    int x;
    int y;
    private double zx, zy, cX, cY, tmp;


    public Task(Mandelbrot mandelbrot, int x, int y) {
        this.mandelbrot = mandelbrot;
        this.x = x;
        this.y = y;
    }

    @Override
    public Object call() throws Exception {


        zx = zy = 0;
        cX = (x - 400) / ZOOM;
        cY = (y - 300) / ZOOM;
        int iter = mandelbrot.MAX_ITER;
        while (zx * zx + zy * zy < 4 && iter > 0) {
            tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter--;
        }
        return new Pixel(x, y, iter);


    }
}
