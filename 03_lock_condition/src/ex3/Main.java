package ex3;




public class Main {
//    for (Producer p : producents){
//        p = new Producer(buffer);
//        p.start();
//    }


    public static void main(String[] args) throws InterruptedException {
        Kelner k = new Kelner();
        final int pairs=10;
        Osoba osoby[] =new Osoba[2*pairs];
        int id_pary=0;
        for(int i=0;i<2*pairs;i++){
            osoby[i] = new Osoba(k,id_pary);
            osoby[i+1] = new Osoba(k,id_pary++);
        }

        System.out.println(osoby[0].id_pary);
        System.out.println(osoby[1].id_pary);
        System.out.println(osoby[2].id_pary);
        System.out.println(osoby[3].id_pary);
//
//        k.setOsoby(osoby);
//
//        for(Osoba o : osoby){
//            o.start();
//        }
//
//        Thread.sleep(100);

    }




}
