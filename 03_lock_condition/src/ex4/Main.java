package ex4;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Kelner k = new Kelner();
        final int pairs=10;
        Osoba osoby[] =new Osoba[2*pairs];
        int id_pary=0;
        for(int i=0;i<2*pairs;i+=2){
            osoby[i] = new Osoba(k,id_pary);
            osoby[i+1] = new Osoba(k,id_pary++);
        }


        k.configure(pairs,osoby);

        for(Osoba o : osoby){
            o.start();
        }

        Thread.sleep(100);

    }




}
