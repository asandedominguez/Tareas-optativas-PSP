public class main10 {
    public static void main(String[] args) {
        Tarea10 hilo1 = new Tarea10("alan");
        hilo1.getNumeroPar();
        hilo1.start();

        Tarea10 hilo2 = new Tarea10("Carlos");
        hilo2.getNumeroImpar();
        hilo2.start();
    }
}
