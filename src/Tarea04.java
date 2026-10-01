
import java.io.File;
import java.io.IOException;

public class Tarea04 {
    public static void main(String[] args) throws IOException {

        String comando;
        String nuevoDirectorio;

        //Obtenemos el nombre del sistema operativo, y comprobamos con que comienza, en función de eso las variables tendrán un valor diferente
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            comando = "cmd /c dir";
            nuevoDirectorio = "c:/temp";
        } else {
            comando = "sh -c ls";
            nuevoDirectorio = "/tmp";
        }
        // Separa los comando para que el gestor de los mismos pueda entenderlo bien (["cmd", "/c", "dir"])
        ProcessBuilder listar = new ProcessBuilder(comando.split("\\s"));

// 1. Directorio inicial
        System.out.println("=== 1. Inicial ===");
        System.out.println("Directorio de trabajo (ProcessBuilder): " + listar.directory());

        // Mostrar ubicación del proyecto
        System.out.println("Valor de user.dir: " + System.getProperty("user.dir"));

// 2. Cambiamos user.dir
        //Asignamos otra ruta, en este caso "home"
        System.setProperty("user.dir", System.getProperty("user.home"));
        System.out.println("\n=== 2. Después de cambiar user.dir a home ===");
        System.out.println("Directorio de trabajo (ProcessBuilder): " + listar.directory());
        System.out.println("Valor de user.dir: " + System.getProperty("user.dir"));

// 3. Cambiamos directorio de trabajo de ProcessBuilder
        listar.directory(new File(nuevoDirectorio));
        System.out.println("\n=== 3. Después de cambiar a temp ===");
        System.out.println("Directorio de trabajo (ProcessBuilder): " + listar.directory());
        System.out.println("Valor de user.dir: " + System.getProperty("user.dir"));

// Ejecutar (no mostrará la salida del comando)
        try {
            listar.start();
            System.out.println("Comando lanzado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al ejecutar el comando: " + e.getMessage());
            e.printStackTrace(); // opcional, para depuración
        }
    }
}
