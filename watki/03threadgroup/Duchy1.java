//na danej platformie Java aktywne sa dwie grupy watkow glowna o nazwie system i potomna o nazwie main

public class Duchy1 {
    public static void main(String args[]) {
        ThreadGroup grupa = Thread.currentThread().getThreadGroup();
        while(grupa.getParent() != null) {
            grupa = grupa.getParent();
        }
        grupa.list();
    }
}// koniec public class Duchy1