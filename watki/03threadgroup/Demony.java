//Demony.java
public class Demony extends Thread{
    public void run(){
        while(!Thread.interrupted()){
        }
    }
    public static void main(String args[]) {
        Demony d = new Demony();
        d.setName("DEMON");
        d.setDaemon(true);
        d.start();
        ThreadGroup grupa = Thread.currentThread().getThreadGroup();
        while(grupa.getParent() != null) {
            grupa = grupa.getParent();
        }
        Thread[] watki = new Thread[grupa.activeCount()];
        grupa.enumerate(watki);
        for (int k = 0; k < watki.length; k++) {
            if (watki[k].isDaemon()) System.out.println("Demon: "+watki[k]);
        }

        d.interrupt();
    }
}// koniec public class Demony