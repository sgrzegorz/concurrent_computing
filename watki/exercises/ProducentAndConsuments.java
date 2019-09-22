import java.util.ArrayList;

class Buffer{
    ArrayList list = new ArrayList();


    void take(){
        list.get(list.size());
    }

    void put(int val){
        list.add(val);

    }

}



class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for(int i = 0;  i < ILOSC;   i++) {
            String message = buffer.take();
        }

    }
}


class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for(int i = 0;  i < ILOSC;   i++) {
            buffer.put("message "+i);
        }

    }
}



public class ProducentAndConsuments {
    public static void main(String [] args){
        Buffer buffer = new Buffer();
        Buffer.put(1);
    }
}
