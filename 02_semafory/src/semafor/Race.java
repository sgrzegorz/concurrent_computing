package semafor;



public class Race{
    public static void main(String []args) throws InterruptedException {
        int N = 20000000;
        Counter c = new Counter();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<N;i++){
                    c.add();
                }
//                System.out.println("add koncze prace");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<N;i++){
                    c.sub();
                }
//                System.out.println("sub koncze prace");
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


//        Thread.sleep(4000);
        System.out.println(c.val);
    }


}
