package sincronizar;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador(100);

        Thread hiloIcremento = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        Thread hiloDecremento = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                contador.decrementar();
            }
        });

        hiloIcremento.start();
        hiloDecremento.start();
        hiloIcremento.join();
        hiloDecremento.join();

        System.out.println("El valor del contador es de: " + contador.getValor());
    }
}
