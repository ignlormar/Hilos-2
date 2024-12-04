package consumidorProductor;

public class Consumidor extends Thread{
    private DatoCompartido buffer;

    public Consumidor(DatoCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run(){
        try {
            for (int i = 0; i < 10; i++){
                buffer.obtener();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
