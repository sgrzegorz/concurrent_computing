package sklep;


import java.util.Random;

public class Sklep{
    public static void main(String []args) throws InterruptedException {
        int klienci = 20;
        int koszyki = 5;
        Semafor s = new Semafor(5);

        for(int i=0;i<klienci;i++){
            Klient k = new Klient(s);
            k.start();
        }




    }


}
