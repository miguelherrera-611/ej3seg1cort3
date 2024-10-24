import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.initDatabase();

        System.out.println("Bienvenido al supermercado. Elija una opción:");
        System.out.println("1. Iniciar cajas");
        System.out.println("2. Salir");

        int opcion = scanner.nextInt();
        if (opcion == 1) {
            iniciarCajas(dbManager);
        } else {
            System.out.println("Saliendo...");
        }
        scanner.close();
    }

    private static void iniciarCajas(DatabaseManager dbManager) {
        // Crear y iniciar hilos para las cajas
        for (int i = 0; i < 3; i++) { // Supongamos que hay 3 cajas
            Caja caja = new Caja(i + 1, dbManager);
            new Thread(caja).start();
        }
    }
}
