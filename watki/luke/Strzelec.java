class Strzelec implements Runnable {
    Strzal s;
    String wrogPubliczny;
    public Strzelec(String wrog, Strzal st) {
        s = st;
        wrogPubliczny = wrog;
    }
    public void run() {
        while (s.strzal(wrogPubliczny)) ;
    }
}// koniec class Strzelec