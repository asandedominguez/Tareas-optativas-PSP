public class Tarea11 {

    public static void main(String[] args) {

        HiloConPrioridad hiloBaja = new HiloConPrioridad("Hilo PRIORIDAD BAJA", Thread.MIN_PRIORITY);
        HiloConPrioridad hiloNormal1 = new HiloConPrioridad("Hilo NORMAL 1", Thread.NORM_PRIORITY);
        HiloConPrioridad hiloNormal2 = new HiloConPrioridad("Hilo NORMAL 2", Thread.NORM_PRIORITY);
        HiloConPrioridad hiloAlta = new HiloConPrioridad("Hilo PRIORIDAD ALTA", Thread.MAX_PRIORITY);


        hiloBaja.start();
        hiloNormal1.start();
        hiloNormal2.start();
        hiloAlta.start();
    }
}


class HiloConPrioridad extends Thread {
    private String nombre;

    public HiloConPrioridad(String nombre, int prioridad) {
        super(nombre);
        this.nombre = nombre;
        setPriority(prioridad);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {

            System.out.println(nombre + " - Iteración: " + i + ", Prioridad: " + getPriority());

            // Dormir un tiempo aleatorio entre 1 y 3 segundos para ver el efecto más rápido
            int tiempoEspera = 1000 + (int)(Math.random() * 2000); // ms
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpido.");
                break;
            }
        }
        System.out.println(nombre + " ha terminado.");
    }
}