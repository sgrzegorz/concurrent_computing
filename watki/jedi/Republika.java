class Republika extends Thread {
    private String glos;
    Republika(String s){
        this.glos=s;
    }
    public void set(String s){
        this.glos=s;
    }
    public boolean senat(){
        String mowca = Thread.currentThread().getName();
        System.out.println("Mówi Senat !");
        return true;
    }

    public void run(){
        while(senat());
        System.out.println("Koniec pracy Senatu");
    }
}// koniec class Republika