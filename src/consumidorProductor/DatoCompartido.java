package consumidorProductor;

import java.util.ArrayList;
import java.util.List;

public class DatoCompartido {
    private List<Integer> datos = new ArrayList<>();
    private int limite;

    public DatoCompartido(int limite){
        this.limite = limite;
    }

    public synchronized void poner(int nuevoDato) throws InterruptedException {
        while (datos.size() == limite){
            wait();
        }

        datos.add(nuevoDato);
        System.out.println("Productor - " + nuevoDato);
        notifyAll();
    }

    public synchronized int obtener() throws InterruptedException {
        while (datos.isEmpty()) {
            wait();
        }

        int dato = datos.remove(0);
        System.out.println("Consumidor - " + dato);
        notifyAll();

        return dato;
    }
}
