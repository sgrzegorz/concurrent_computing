package ex11;

public class Buffer {
    int size;
    int array[];


    public Buffer(int size){
        this.size = size;
        array = new int[size];

        for(int i=0;i<size;i++){
            array[i] =0;
        }
    }

    public void consume(Consumer c){

        array[c.buf_pos] = c.getMyId()+1;

        c.buf_pos = (c.buf_pos+1)%size;
        c.doSomething();

        print();


    }


     synchronized void print(){
        for(int i : array){
            System.out.print(i+ ", ");
        }
        System.out.println();
    }

}
