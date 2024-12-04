package Lavavajillas;

import java.util.ArrayList;
import java.util.List;

public class PilaPlatos {
    private List<Plato> pila = new ArrayList<>();
    private int capacidadMaxima;

    public PilaPlatos(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public synchronized void lavar(Plato plato) throws InterruptedException {
        while (pila.size() == capacidadMaxima){
            wait();
        }

        pila.add(plato);
        System.out.println("Plato " + plato.getNumero() + " lavado, total en pila: " + pila.size());
        notifyAll();
    }

    public synchronized Plato secar() throws InterruptedException {
        while (pila.isEmpty()){
            wait();
        }

        Plato plato = pila.remove(pila.size() -1);
        System.out.println("Plato " + plato.getNumero() + " secado, total en pila: " + pila.size());
        notifyAll();
        return plato;
    }
}
