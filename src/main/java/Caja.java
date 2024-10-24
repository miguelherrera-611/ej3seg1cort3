import java.util.Random;

public class Caja implements Runnable {
    private int id;
    private DatabaseManager dbManager;
    private int clientesAtendidos = 0;

    public Caja(int id, DatabaseManager dbManager) {
        this.id = id;
        this.dbManager = dbManager;
    }

    @Override
    public void run() {
        while (true) {
            Cliente cliente = new Cliente();
            double totalVenta = procesarCliente(cliente);
            dbManager.guardarVenta(totalVenta);
            clientesAtendidos++;
            System.out.println("Caja " + id + " ha atendido a " + clientesAtendidos + " clientes.");
            try {
                Thread.sleep(2000); // Tiempo entre clientes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private double procesarCliente(Cliente cliente) {
        // Simulación del procesamiento de un cliente
        double total = cliente.getTotalCompra();
        System.out.println("Caja " + id + " procesó cliente con total de: $" + total);
        return total;
    }
}
