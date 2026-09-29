public class Tarea06 extends Thread {

    public Tarea06 (String str) {
        super(str);
    }

    @Override

    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Cabreo nivel: " + i + " " + getName());
            if (i == 3 && getName().equalsIgnoreCase("Damian")) {
                System.out.println("... ¡He llegado a mi limite!");
                break;
            }
            if (i == 4 && getName().equalsIgnoreCase("Diego") ) {
                System.out.println("... ¡He llegado a mi limite!");
                break;
            }
            if (i == 5 && (getName().equalsIgnoreCase("Araujo") || getName().equalsIgnoreCase("Manuel"))) {
                System.out.println("... ¡He llegado a mi limite!");
                break;
            }
        }

    }

    public static void main(String [] args) {
        new Tarea06("Diego").start();
        new Tarea06("Manuel").start();
        new Tarea06("Araujo").start();
        new Tarea06("Damian").start();
    }

}
