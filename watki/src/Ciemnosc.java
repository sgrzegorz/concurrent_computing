import java.util.Random;

class Ciemnosc extends Thread {
    Thread c;
    public void ustawC(Thread td){
        this.c=td;
    }
    public void run(){
        int n=0;
        Random r = new Random(12345678L);
        boolean b = false;

        do{
            if( !(this.isInterrupted())){
                n = r.nextInt();
                System.out.println("Ciemność ");
            } else {
                n=200000000;
                b=true;
            }
        }while(n<200000000);
        if(b){
            System.out.println(this+" jestem przerwany, kończę pracę");
        } else {
            if (c.isAlive()) {
                Thread t = Thread.currentThread();
                System.out.println("Tu wątek "+t+" Ciemność");
                System.out.println("Zatrzymuję wątek: "+c);
                c.interrupt();
            } else {
                Thread t = Thread.currentThread();
                System.out.println("Tu wątek "+t+" jestem jedyny ");
            }
            System.out.println("KONIEC: Ciemność");
        }
    }
}// koniec class Ciemnosc