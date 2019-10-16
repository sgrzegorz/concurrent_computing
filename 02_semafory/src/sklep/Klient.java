package sklep;

import java.util.Random;

class Klient extends Thread{
    public Klient(Semafor s){
        this.s = s;
    }

    Semafor s;
    @Override
    public void run() {
        s.decrease();
        System.out.println(Thread.currentThread().getName()+ "zabieram koszyk, zostalo koszykow"+s.flag);
        Random rand = new Random();

        try {
            Thread.sleep(rand.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+"oddaje koszyk, zostalo koszykow" + (s.flag+1));
        s.increase();

    }
}