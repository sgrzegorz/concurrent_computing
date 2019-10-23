package ex3;

import java.util.Random;

public class Osoba extends Thread{
    Kelner kelner;
    Osoba(Kelner kelner){
        this.kelner = kelner;
    }

    void wlasneSprawy(){
        Random random = new Random();
        int i = random.nextInt(60);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void jedzenie(){
        Random random = new Random();
        int i = random.nextInt(400);
        try {
            System.out.println(Thread.currentThread().getName()+ " jem");
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        for(;;) {
            wlasneSprawy();
            kelner.chceStolik();
            jedzenie();
            kelner.zwalniam();

        }

    }



    forever{
        wlasne sprawy;
        Kelner.chce_stolik(j);
        jedzenie;
        Kelner.zwalniam();
    }
}
