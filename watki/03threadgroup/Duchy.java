public class Duchy {
    public static void main(String args[]) {
        ThreadGroup grupa = Thread.currentThread().getThreadGroup();
        while(grupa.getParent() != null) {
            grupa = grupa.getParent();
        }
        Thread[] watki = new Thread[grupa.activeCount()];

        grupa.enumerate(watki);
        for (int k = 0; k < watki.length; k++) {
            System.out.println(watki[k]);
        }
    }
}// koniec public class Duchy