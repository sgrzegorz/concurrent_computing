package cacper;

public class Duch {
    public static void main(String args[]) {
        ThreadGroup zle_duchy = new ThreadGroup("zle_duchy");
        Cacper c = new Cacper(zle_duchy,"cacper");
        c.start();
        try{
            Thread.currentThread().sleep(4000);
        }catch (Exception e){}
        ThreadGroup grupa = Thread.currentThread().getThreadGroup();
        while(grupa.getParent() != null) {
            grupa = grupa.getParent();
        }
        grupa.list();
        c.interrupt();
        try{
            Thread.currentThread().sleep(4000);
        }catch (Exception e){}
        grupa = Thread.currentThread().getThreadGroup();
        while(grupa.getParent() != null) {
            grupa = grupa.getParent();
        }
        grupa.list();
    }
}// koniec public class Duch