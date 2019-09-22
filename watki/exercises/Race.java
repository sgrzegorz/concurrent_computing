import static java.lang.Thread.sleep;

class Counter {
    int val =0;

    synchronized void add(){
        val ++;
    }

    synchronized void sub(){
        val --;
    }
}




public class Race{
    public static void main(String []args) throws InterruptedException {
        int N = 100000;
        Counter c = new Counter();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<N;i++){
                    c.add();
                }
                System.out.println("add koncze prace");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<N;i++){
                    c.sub();
                }
                System.out.println("sub koncze prace");
            }
        });

        thread1.start();
        thread2.start();


        Thread.sleep(4000);
        System.out.println(c.val);
    }


}
