public class Los {
    public static void main(String args[]) {
        Ciemnosc zlo = new Ciemnosc();
        Jasnosc dobro = new Jasnosc(zlo);
        zlo.ustawC(dobro);
        zlo.start();
        dobro.start();
    }
}