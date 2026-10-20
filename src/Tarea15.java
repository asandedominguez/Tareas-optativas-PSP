public class Tarea15 extends Thread {

    public String hilo;
    public Thread numero;

    public Tarea15 (String hilo, Thread numero) {
        super(hilo);
        this.hilo = hilo;
        this.numero = numero;

    }

    @Override
    public void run() {
        try {
            if (numero != null) {
                numero.join();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        for (int i = 1; i < 9; i++) {
            System.out.println(hilo + " " + i);
            try {
                Thread.sleep(2000);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void main (String[] args) {
        Tarea15[] t = new Tarea15[3];

        t[2] = new Tarea15("hola2", null);
        t[1] = new Tarea15("hola1", t[2]);
        t[0] = new Tarea15("hola", t[1]);

        for (int e = 2; e >= 0; e--) {
            try {
                t[e].start();
            }
            catch (Exception u) {
                System.out.println(u.getMessage());
            }
        }

        for (int h = 2; h >= 0; h--) {
            try {
                t[h].join();
                System.out.println(h + " A terminado");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
