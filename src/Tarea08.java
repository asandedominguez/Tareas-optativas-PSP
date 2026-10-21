import java.util.Random;

public class Tarea08 {

    static class Dormilon implements Runnable {
        private final Random random = new Random();

        @Override
        public void run() {
            String nombre = Thread.currentThread().getName();
            for (int i = 1; i <= 10; i++) {
                System.out.println("Iteración " + i + " - " + nombre);
                try {
                    Thread.sleep(500 + random.nextInt(1501));   // entre 500 y 2000 ms
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println(nombre + " ha terminado");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();

        Thread[] hilos = new Thread[4];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new Dormilon(), "Hilo-" + (i + 1));
            hilos[i].start();                     // 1º: arrancar TODOS
        }
        for (Thread h : hilos) {
            h.join();                             // 2º: esperar a TODOS
        }

        long total = System.currentTimeMillis() - inicio;
        System.out.println("Han terminado todos en " + total / 1000.0 + " s");
    }
}