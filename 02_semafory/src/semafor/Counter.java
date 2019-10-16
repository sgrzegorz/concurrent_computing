package semafor;

class Counter {
    Semafor s = new Semafor();
    int val =0;

    void add(){
        s.opuść();
        this.val ++;
        s.podnieś();
    }

    void sub(){
        s.opuść();
        this.val --;
        s.podnieś();

    }
}

