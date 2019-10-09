import java.util.Random;

class Jasnosc extends Thread {
    Thread j;
    Jasnosc(Thread j){
        this.j=j;
    }
    public void run(){
        int n=0;
        boolean b = false;
        Random r = new Random();
        do{
            if( !(this.isInterrupted())){
                n = r.nextInt();
                System.out.println("Jasność");
            } else {
                n=200000000;
                b=true;
            }
        }while(n<200000000);
        if(b){
            System.out.println(this+" jestem przerwany, kończę pracę");
        } else {
            Thread t = Thread.currentThread();
            System.out.println("Tu wątek "+t+" Jasność");
            System.out.println("Zatrzymuję wątek: "+j);
            j.interrupt();
            System.out.println("KONIEC: Jasność");
        }
    }
}// koniec class Jasnosc