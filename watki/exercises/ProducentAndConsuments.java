import java.util.ArrayList;

import java.util.ArrayList;
import java.util.EmptyStackException;

class Buffer{
    ArrayList <String> list = new ArrayList();
    private static final int MAX_QUEUE =10;

    String take(){
        System.out.println(list.size());
        if(list.size() ==0){
            throw new EmptyStackException();
        }
        String val = list.get(list.size()-1);
        list.remove(list.size()-1);
        return val;
    }

    void put(String val){
        if(list.size()-1 == MAX_QUEUE){
            throw new IllegalStateException();
        }
        list.add(val);

    }

}




class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for(int i = 0;  i < 10000;   i++) {
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

        for(int i = 0;  i < 10000;   i++) {
            buffer.put("message "+i);
        }

    }
}



public class ProducentAndConsuments {
    public static void main(String [] args){
        Buffer buffer = new Buffer();
        buffer.put("1");
    }
}
