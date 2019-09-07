// WyscigiSN.java:
public class WyscigiSN implements Runnable{
    private int n;
    WyscigiSN(int nr){
        this.n=nr;
    }
    void wyswietl(int i){
        System.out.println("Dobro = "+i);
        System.out.println("Zlo = "+i);
    }
    void zmianaZla(){
        synchronized (this){
            System.out.print("ZLO: ");
            for(int l=0; l<10;l++,++n){
                System.out.print(Thread.currentThread().getName()+": "+n+" ");
            }
            System.out.println(" ");
        }

    }
    void zmianaDobra(){
        synchronized (this){
            System.out.print("DOBRO: ");
            for(int l=0; l<20;l++,--n){
                System.out.print(Thread.currentThread().getName()+": "+n+" ");
            }
            System.out.println(" ");
        }
    }
    public void run(){
        while (!(Thread.interrupted())){
            if ( (Thread.currentThread().getName()).equals("T1")){
                zmianaZla();
            } else
                zmianaDobra();
        }
    }
    public static void main(String args[]){
        WyscigiSN w1= new WyscigiSN(100);
        Thread t1,t2;
        t1= new Thread(w1);
        t2=new Thread(w1);
        t1.setName("T1");
        t2.setName("T2");
        t2.start();
        t1.start();
        try{
            Thread.currentThread().sleep(600);
        } catch (InterruptedException ie){
        }
        t1.interrupt();
        t2.interrupt();
        try{
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ie){
        }
        System.out.println("\n");
        w1.wyswietl(w1.n);
    }
}// koniec public class WyscigiSN