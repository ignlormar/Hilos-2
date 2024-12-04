package elJefe;

public class Saludo {
    private boolean jefeHaEntrado = false;

    public synchronized void saludoEmpleado(String nombre)  {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(nombre + " dice buenos dias jefe.");
    }

    public synchronized void saludoJefe(String nombre){
        System.out.println("El jefe " + nombre + " dice buenos dias equipo.");

        jefeHaEntrado = true;
        notifyAll();
    }
}
