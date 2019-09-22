public class Pies {
    int num=0;

    public void live(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    add();
                }

            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    sub();
                }
            }
        });

        t1.start();
        t.start();

//        try{
//            wait();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }


        try{
            t1.join();
            t.join();
        }catch(InterruptedException e){
            System.out.println("DNFFDF");
        }
        System.out.println(num);

    }

    synchronized void  add(){
        num++;
    }

    synchronized void  sub(){
        num--;
    }

    public static void main(String [] args){
        System.out.println("hejoooo");
        Pies p = new Pies();
        p.live();


    }
}
