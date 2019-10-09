public class Wojna {
    public static void main(String args[]) {
        Strzal st = new Strzal();
        Thread luke = new Thread(new Strzelec("Vader", st));
        Thread vader = new Thread(new Strzelec("Luke",st));
        luke.setName("Luke");
        vader.setName("Vader");
        luke.start();
        vader.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ie) {
        }
        st.strzal("POKOJ");
        System.out.println("Nastał pokój!!!");
    }
}// koniec public class Wojna