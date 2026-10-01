public class Tarea06 extends Thread {

    int paciencia;

    public Tarea06(String str, int paciencia) {
        super(str);
        this.paciencia = paciencia;
    }

    @Override
    public void run() {
        for (int i = 1; i <= paciencia; i++) {
            if (i == paciencia) {
                System.out.println("[" + getName() + "] Cabreo nivel: " + i + "... ¡He llegado a mi límite!");
            } else {
                System.out.println("[" + getName() + "] Cabreo nivel: " + i);
            }
        }
    }

    // Clase interna Runnable con su constructor y su run() DENTRO
    static class runnable implements Runnable {
        int paciencia;

        public runnable(int paciencia) {
            this.paciencia = paciencia;
        }

        @Override
        public void run() {
            String nombre = Thread.currentThread().getName();
            for (int i = 1; i <= paciencia; i++) {
                if (i == paciencia) {
                    System.out.println("[" + nombre + "] Cabreo nivel: " + i + "... ¡He llegado a mi límite!");
                } else {
                    System.out.println("[" + nombre + "] Cabreo nivel: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 2 Hilos heredando de Thread
        Tarea06 diego = new Tarea06("Diego", 4);
        Tarea06 manuel = new Tarea06("Manuel", 5);

        // 2 Hilos implementando Runnable
        Thread araujo = new Thread(new runnable(5), "Araujo");
        Thread damian = new Thread(new runnable(3), "Damian");

        // Ejecutar los 4 hilos simultáneamente
        diego.start();
        manuel.start();
        araujo.start();
        damian.start();

        System.out.println("Programa principal terminado.");
    }
}