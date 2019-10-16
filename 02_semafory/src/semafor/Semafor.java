package semafor;

import java.util.function.Consumer;

public class Semafor {

    boolean zamkniete= false;

    synchronized void podnieś(){
        zamkniete=false;
        notifyAll();
    }

    synchronized void opuść(){
        while(zamkniete){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zamkniete=true;

    }

}


