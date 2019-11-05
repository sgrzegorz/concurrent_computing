package ex2;

public class Buffer {
    int size;
    int array[];
    int nelem;



    public Buffer(int size){
        if(size%2 ==1) throw new Error("Size must be even number");
        this.size = size;
        array = new int[size];

        for(int i=0;i<size;i++){
            array[i] =0;
        }
        this.nelem = 0;
    }

    public void consume(Consumer c,int quantity){

        synchronized ()
        nelem-=quantity;


        int counter=0;
        for(int i=0;i<size;i++){
            if(array[i]==1){
                array[i] =0;
                counter++;
                if(counter==quantity) return;
            }

        }
        throw new Error("Consumption error!");

    }

    public void produce(Producer p, int quantity){
        nelem+=quantity;


        int counter=0;
        for(int i=0;i<size;i++){
            if(array[i]==0){
                array[i] =1;
                counter++;
                if(counter==quantity) return;
            }

        }
        throw new Error("Production error!");
    }


    synchronized void print(){
        for(int i : array){
            System.out.print(i+ ", ");
        }
        System.out.println();
    }

}
