package Lavavajillas;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        int totalPlatos = 20;
        int maximoPila = 5;

        PilaPlatos pila = new PilaPlatos(maximoPila);
        Thread friega = new Friega(totalPlatos, pila);
        Thread seca = new Seca(totalPlatos, pila);

        friega.start();
        seca.start();

        friega.join();
        seca.join();
    }
}
