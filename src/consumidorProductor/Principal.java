package consumidorProductor;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        int limite = 5;

        DatoCompartido buffer = new DatoCompartido(limite);

        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();

        System.out.println("Fin");
    }
}
