package sklep;

public class Semafor {
    public Semafor(int i){
        maxFlag = i;
        flag = i;
    }

    int maxFlag;
    int flag;


    synchronized void decrease(){
        while(flag<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag--;

    }

    synchronized void increase(){
//        while(flag>maxFlag){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        flag++;
        notifyAll();

    }



}


