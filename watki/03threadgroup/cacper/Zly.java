package cacper;

class Zly extends Thread{
    Zly(){
        super();
        setName("Zly_demon");
//setDaemon(true);
    }
    public void run(){
        while(!this.isInterrupted()){
        }
    }
}// koniec class Zly