import java.util.*;
class Imperium extends Thread {
    private String glos;
    Imperium(String s){
        this.glos=s;
    }
    public void set(String s){
        this.glos=s;
    }
    public boolean imperator(){
        String mowca = Thread.currentThread().getName();
        if (mowca.equals(glos)){
            System.out.println("Mówi Imperator !");
            return true;
        }
        return false;
    }// koniec public boolean imperator()
    public void run(){
        while(imperator());
        System.out.println("Koniec pracy Imperium");
    }
}// koniec class Imperium