package ex2;

public class Drukarka {
    int number;
    Drukarka(int i){
        number =i;
    }
    public void drukuj(String zadanieDoWydruku){
        System.out.println(Thread.currentThread().getName()+" drukarka nr:"+this.number +" drukuje" + zadanieDoWydruku);
    }
}
