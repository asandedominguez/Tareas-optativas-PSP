public class Tarea10 extends Thread {
    int numero_par;
    int numero_impar;
    int numero_fin;

    public Tarea10(String hilos) {
        super(hilos);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                numero_par += i;
                System.out.println(numero_par);
            }

            if (i % 3 == 0) {
                numero_impar += i;
                System.out.println(numero_impar);
            }

            if (i % 10 == 3 || i % 10 == 4) {
                numero_fin += i;
            }
        }
    }

    public int getNumeroPar() {
        return numero_par;
    }

    public int getNumeroImpar() {
        return numero_impar;
    }

    public int getNumero_fin() {
        return numero_fin;
    }

}


