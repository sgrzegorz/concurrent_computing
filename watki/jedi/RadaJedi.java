class RadaJedi extends Thread {
    private String glos;
    private Imperium imp;
    private Republika rp;
    RadaJedi(String s, Imperium i, Republika r){
        this.glos=s;
        this.imp=i;
        this.rp=r;
    }
    public boolean rada(){
        String mowca = Thread.currentThread().getName();
        if (mowca.equals(glos)){
            System.out.println("Zamach stanu - Rada Jedi u władzy Senatu !");
            imp.set(glos);
            rp.set(glos);
            try{
                sleep(500);

            } catch (InterruptedException ie){
            }
            return false;
        }
        return true;
    }// koniec public boolean imperator()
    public void run(){
        while(rada());
        System.out.println("Koniec pracy Rady");
    }
}// koniec class RadaJedi