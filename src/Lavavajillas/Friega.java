package Lavavajillas;

public class Friega extends Thread{
    private int numPlatos;
    private PilaPlatos pila;

    public Friega(int numPlatos, PilaPlatos pila){
        this.numPlatos = numPlatos;
        this.pila = pila;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numPlatos; i++){
                Plato plato = new Plato(i + 1);
                pila.lavar(plato);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
