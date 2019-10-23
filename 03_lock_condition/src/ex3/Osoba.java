package ex3;

import java.util.Random;

public class Osoba extends Thread{
    Kelner kelner;
    int id_pary;


    Osoba(Kelner kelner,int id_pary){
        this.kelner = kelner;
        this.id_pary = id_pary;
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
            kelner.chceStolik(this, id_pary);
            jedzenie();
            kelner.zwalniam(this, id_pary);

        }

    }


}
