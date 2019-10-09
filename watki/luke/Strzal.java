class Strzal {
    private String strzelec = "nikt";
    private String tratata[]={ "PIF","PAF"};
    private int i=0;
    public synchronized boolean strzal(String wrog) {
        String kto = Thread.currentThread().getName();
        if (strzelec.compareTo("POKOJ") == 0)
            return false;
        if (wrog.compareTo("POKOJ") == 0) {
            strzelec = wrog;
            notifyAll();
            return false;
        }
        if (strzelec.equals("nikt")) {
            strzelec = kto;
            return true;
        }
        if (kto.equals(strzelec)) {
            System.out.println(tratata[i]+"! ("+strzelec+")");
            strzelec = wrog;
            i=1-i; // i na zmiane bedzie rowne zero lub 1
            notifyAll();
        } else {
            try {
                long zwloka = System.currentTimeMillis();
                wait(200);
                if ((System.currentTimeMillis() - zwloka) > 200) {
                    System.out.println("Tu "+kto+", czekam na ruch osobnika:"+ strzelec);

                }
            } catch (InterruptedException ie) {
            }
        }
        return true;
    }
}//koniec class Strzal