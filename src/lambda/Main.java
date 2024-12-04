package lambda;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el numero de virus que quieres mandar: ");
        int numVirus = sc.nextInt();

        Thread[] hilos = new Thread[numVirus];

        for (int i = 0; i <numVirus; i++){
            int id = i + 1;
            hilos[i] = new Thread(() -> {

                System.out.print("Virus " + id + ": ");

                Random random = new Random();
                int progreso = 0;

                while (progreso < 100){
                    int incremento = random.nextBoolean() ? 5 : 10;
                    progreso += incremento;

                    if (progreso > 100){
                        progreso = 100;
                    }

                    if (incremento == 5){
                        System.out.print("X");
                    } else {
                        System.out.print("XX");
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(" 100%");
            });
        }

        for (Thread hilo : hilos){
            hilo.start();
            hilo.join();
        }

        System.out.println("HAS SIDO INFECTADO");
        sc.close();
    }
}
