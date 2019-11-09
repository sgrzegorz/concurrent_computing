import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Operation implements Callable {
    int x;
    int y;
    Mandelbrot mandelbrot;

    public Operation(Mandelbrot m, int x,int y){
        this.x =x;
        this.y=y;
    }

    @Override
    public Object call() throws Exception {
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


    }
}
