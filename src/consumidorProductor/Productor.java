package consumidorProductor;

public class Productor extends Thread{
    private DatoCompartido buffer;

    public Productor(DatoCompartido buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++){
                buffer.poner(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
