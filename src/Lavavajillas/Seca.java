package Lavavajillas;

public class Seca extends Thread{
    private int numPlatos;
    private PilaPlatos pila;

    public Seca(int numPlatos, PilaPlatos pila){
        this.numPlatos = numPlatos;
        this.pila = pila;
    }

    @Override
    public void run(){
        try {
            for (int i = 0; i < numPlatos; i++){
                pila.secar();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
