public class Walka{
    public static void main(String args[]){
        Imperium im = new Imperium("Imperator");
        Republika rep = new Republika("Senat");
        RadaJedi rj = new RadaJedi("Rada",im,rep);
        im.setName("Imperator");
        rep.setName("Senat");
        rj.setName("Rada");
        im.start();
        rep.start();
        try{
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException ie){
        }
        rj.start();
    }
}//