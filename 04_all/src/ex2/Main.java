package ex11;

public class Main {
    public static void main(String[]args){


        Buffer buf = new Buffer(10);
        Consumer.initialiseThreads(9,buf);

        for(Consumer c : Consumer.pool){
            c.start();
        }



    }
}
