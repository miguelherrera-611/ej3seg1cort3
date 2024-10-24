import java.util.Random;

public class Cliente {
    private double totalCompra;

    public Cliente() {
        this.totalCompra = generarTotalCompra();
    }

    private double generarTotalCompra() {
        Random random = new Random();
        return random.nextDouble() * 100; // Total aleatorio entre 0 y 100
    }

    public double getTotalCompra() {
        return totalCompra;
    }
}


