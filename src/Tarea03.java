import java.io.IOException;
import java.util.Scanner;

public class Tarea03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {


            String editor = "gnome-text-editor";

// Solicitar el nombre del archivo o la ruta
            // el ".trim" hará que no influya si ponem os un espacio al principio o al final. Sin el si pusieramos un espacio y no escribimos nada crearía un fichero igualmente (o en su contraparte un espacio y una x)
            System.out.print("Introduce el nombre del archivo a crear o editar (incluyendo la ruta si es necesario) o 'x' para salir: ");
            String input = scanner.nextLine().trim();

// Opción de salida
            if (input.equalsIgnoreCase("x")) {
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                return;
            }

// Validar entrada vacía
            if (input.isEmpty()) {
                System.out.println("No ingresaste un nombre de archivo. Saliendo...");
                return;
            }

// Mostrar el comando a ejecutar
            System.out.println("Ejecutando: [" + editor + ", " + input + "]");

// Preparar el proceso
            ProcessBuilder processBuilder = new ProcessBuilder(editor, input);

// Ejecutar el comando
            try {
                processBuilder.start();
                System.out.println("Se ha abierto el editor de texto.");
            } catch (IOException e) {
                System.out.println("Error al ejecutar el comando: " + e.getMessage());
            }
        }
    }
}