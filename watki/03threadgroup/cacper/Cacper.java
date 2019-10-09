package cacper;

class Cacper extends Thread{
    Cacper(ThreadGroup g, String s){
        super(g,s);
    }
    public void run(){
        Zly z = new Zly();
        z.start();
        while(!this.isInterrupted()){
        }

    }
}//koniec class Cacper