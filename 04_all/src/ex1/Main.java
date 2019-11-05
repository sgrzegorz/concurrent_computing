package ex1;

public class Main {
    public static void main(String[]args){

        int N =3;
        Buffer buf = new Buffer(10);
        Consumer consumers[] = new Consumer[N];
        for(int i=0;i<N;i++){
            consumers[i] =new Consumer(buf);
            consumers[i].start();
            try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }


    }
}
