public class Widzenie {
    public static void main(String args[]) {
        System.out.println("Maksymalny priorytet wątku = " + Thread.MAX_PRIORITY);
        System.out.println("Minimalny priorytet wątku = " + Thread.MIN_PRIORITY);
        System.out.println("Normalny priorytet wątku = " + Thread.NORM_PRIORITY + "\n");
        Ciemnosc zlo = new Ciemnosc();
        Jasnosc dobro = new Jasnosc(zlo);
        zlo.setName("zlo");
        zlo.setPriority(4);
        dobro.setName("dobro");
        dobro.setPriority(6);
        zlo.ustawC(dobro);
        zlo.start();
        dobro.start();
    }
}