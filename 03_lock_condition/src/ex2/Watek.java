package ex2;




import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Watek extends Thread {
    static int zad_id=0;
    MonitorDrukarek md;
    static Lock zad_id_lock =new ReentrantLock();

    public Watek(MonitorDrukarek md) {
        this.md = md;
    }

    private String utworzZadanieDoWydruku(){
        zad_id_lock.lock();
        zad_id++;
        zad_id_lock.unlock();
        return "zadanieDoWydruku" +zad_id;
    }

    public void run() {

        for(;;) {
            String zadanieDoWydruku = utworzZadanieDoWydruku();

            Drukarka drukarka =md.zarezerwuj();
            drukarka.drukuj(zadanieDoWydruku);
            md.zwolnij();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}