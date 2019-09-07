class Runner extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("hello "+i);

            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Runner1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("hello "+i);

            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class StartingThreads{
    public static void main(String [] args){
        Runner runner = new Runner();
        runner.start();

        Runner1 runner1 = new Runner1();
        runner1.run();

        Thread runner2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("hello "+i);

                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });


        runner2.start();
    }

}