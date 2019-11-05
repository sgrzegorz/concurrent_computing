package ex11;

public class Main {
    public static void main(String[]args){


        Buffer buf = new Buffer(3);
        Consumer.initialiseThreads(5,buf);

        for(Consumer c : Consumer.pool){
            c.start();
        }



    }
}
