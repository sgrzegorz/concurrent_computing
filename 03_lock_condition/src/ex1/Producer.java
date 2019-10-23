package ex1;



class Producer extends Thread {
    static int message_id=0;
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for(int i = 0;  i < 10;   i++) {
            try {
                synchronized (Producer.class)
                {

                    buffer.put("message_"+message_id);
                    message_id++;


                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}



